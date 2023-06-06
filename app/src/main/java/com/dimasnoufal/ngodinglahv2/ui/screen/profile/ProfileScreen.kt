package com.dimasnoufal.ngodinglahv2.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dimasnoufal.ngodinglahv2.R
import com.dimasnoufal.ngodinglahv2.ui.theme.NgodingLahV2Theme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(id = R.string.nama), style = MaterialTheme.typography.h6)
            Text(text = stringResource(id = R.string.email), color = Color.Gray)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePreview() {
    NgodingLahV2Theme {
       ProfileScreen()
    }
}