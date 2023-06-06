package com.dimasnoufal.ngodinglahv2.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dimasnoufal.ngodinglahv2.di.Injection
import com.dimasnoufal.ngodinglahv2.model.ListBahasa
import com.dimasnoufal.ngodinglahv2.ui.common.UIState
import com.dimasnoufal.ngodinglahv2.ui.components.BahasaItem
import com.dimasnoufal.ngodinglahv2.ui.viewmodelvactory.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UIState.Loading).value.let { uiState ->
        when (uiState) {
            is UIState.Loading -> {
                viewModel.getAllBahasa()
            }

            is UIState.Success -> {
                HomeContent(
                    listBahasa = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                )
            }

            is UIState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    listBahasa: List<ListBahasa>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(listBahasa) { data ->
            BahasaItem(
                image = data.bahasaPemrograman.image,
                title = data.bahasaPemrograman.tittle,
                year = data.bahasaPemrograman.year,
                modifier = Modifier.clickable {
                    navigateToDetail(data.bahasaPemrograman.id)
                })
        }
    }
}