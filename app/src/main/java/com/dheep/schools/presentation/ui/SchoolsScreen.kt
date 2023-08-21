package com.dheep.schools.presentation.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dheep.schools.data.dto.SchoolDto
import com.dheep.schools.presentation.state.SchoolsUIState

@Composable
fun SchoolsScreen(state: SchoolsUIState) {
    when (state) {
        is SchoolsUIState.Loading -> {

        }

        is SchoolsUIState.Success -> {
            ShowSchoolsList(state.data)
        }

        is SchoolsUIState.Empty -> {

        }

        is SchoolsUIState.Error -> {

        }
    }
}


@Composable
private fun ShowSchoolsList(schools: List<SchoolDto>) {
    LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
        items(schools) { school ->
            SchoolRow(school)
        }
    }
}

@Composable
private fun SchoolRow(school: SchoolDto) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .animateContentSize()
                .padding(8.dp)
        ) {
            Text(
                text = school.schoolName.orEmpty(),
                color = Color.Black, maxLines = 2, overflow = TextOverflow.Ellipsis
            )

            ExpandableContentIcon()
        }
    }
}

@Composable
private fun ExpandableContentIcon() {
    Icon(
        imageVector =
        Icons.Filled.KeyboardArrowRight,
        contentDescription = "Expand row icon",
        modifier = Modifier
            .padding(all = 16.dp)
    )
}