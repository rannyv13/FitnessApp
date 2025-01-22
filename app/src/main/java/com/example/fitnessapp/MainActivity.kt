package com.example.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp.data.Activities
import com.example.fitnessapp.data.activities
import com.example.fitnessapp.ui.theme.AppTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp(modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            FitnessTopBar(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary)
            )
        }
    ) { it ->
        LazyColumn(contentPadding = it,
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)) {
            items(activities){
                FitnessItem(
                    fitActivity = it,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun FitnessItem(
    fitActivity: Activities,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        var expand by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
            ) {
                DayHeader(fitActivity.dayH)
                VerticalDivider(color = MaterialTheme.colorScheme.tertiary)
                FitnessIcon(fitActivity.fitIcon)
                FitnessTitle(fitActivity.title)
                Spacer(modifier = Modifier.weight(1f))
                FitnessButton(
                    expand = expand,
                    onClick = {
                        expand = !expand
                    }
                )
            }
            if(expand){
                FitnessDetails(
                    fitActivity.desc,
                    fitActivity.routes,
                    fitActivity.fitTime,
                    modifier = Modifier.
                    padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium),

                    )
                )
            }

        }
    }

}

@Composable
fun DayHeader(
    @StringRes dayNum: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(R.string.day,dayNum),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun FitnessIcon(
    @DrawableRes fitnessIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        painterResource(fitnessIcon),
        contentDescription = null,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
fun FitnessTitle(
    @StringRes fitnessTitle: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(fitnessTitle),
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
private fun FitnessButton(
    onClick: () -> Unit,
    expand: Boolean,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if(expand) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun FitnessDetails(
    @StringRes fitDetails: Int,
    @StringRes fitRoute: Int,
    fitDuration: Double,
    modifier: Modifier
){
    Column(modifier = modifier) {
        Text(
            text = stringResource(fitDetails),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        )
        Row {
            Text(
                text = stringResource(R.string.duration),
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
            Text(
                text = fitDuration.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Row {
            Text(
                text = stringResource(R.string.route),
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
            Text(
                text = stringResource(fitRoute),
                style = MaterialTheme.typography.bodyMedium,
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fitness_center),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary),
                    modifier = Modifier.size(dimensionResource(R.dimen.image_size_50))
                )
                Text(
                    text = stringResource(R.string.top_bar),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        },
        modifier = modifier
    )
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun AppPreview(){
    FitnessApp()
}