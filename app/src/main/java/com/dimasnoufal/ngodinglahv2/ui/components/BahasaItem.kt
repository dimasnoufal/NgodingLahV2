package com.dimasnoufal.ngodinglahv2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dimasnoufal.ngodinglahv2.R
import com.dimasnoufal.ngodinglahv2.ui.theme.NgodingLahV2Theme
import com.dimasnoufal.ngodinglahv2.ui.theme.Shape

@Composable
fun BahasaItem(
    image: Int,
    title: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(Shape.small)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = year,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BahasaItemPreview() {
    NgodingLahV2Theme() {
        BahasaItem(
            R.drawable.html, "HTML", "1991",
        )
    }
}