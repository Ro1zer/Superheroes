package com.example.superheroes.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.R
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroesScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(HeroesRepository.heroes) {
            HeroCard(
                hero = it,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_large),
                    end = dimensionResource(R.dimen.padding_large),
                    bottom = dimensionResource(R.dimen.padding_medium)
                )
            )
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_large))
                .height(dimensionResource(R.dimen.size_large)),
        ) {
            HeroInformation(
                name = hero.nameId,
                description = hero.descriptionId,
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.padding_medium)))
            HeroImage(
                image = hero.imageId,
            )
        }
    }
}

@Composable
fun HeroImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.size_large))
                .clip(shape = MaterialTheme.shapes.small)
        )
    }
}

@Composable
fun HeroInformation(
    @StringRes name: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small)),
        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HeroCard(
            hero = HeroesRepository.heroes[0]
        )
    }
}