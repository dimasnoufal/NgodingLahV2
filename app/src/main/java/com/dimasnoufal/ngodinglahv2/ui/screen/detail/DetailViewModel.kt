package com.dimasnoufal.ngodinglahv2.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimasnoufal.ngodinglahv2.data.BahasaRepository
import com.dimasnoufal.ngodinglahv2.model.ListBahasa
import com.dimasnoufal.ngodinglahv2.ui.common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: BahasaRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UIState<ListBahasa>> =
        MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<ListBahasa>>
        get() = _uiState

    fun getBahasaById(bahasaId: Long) {
        viewModelScope.launch {
            _uiState.value = UIState.Loading
            _uiState.value = UIState.Success(repository.getListBahasaById(bahasaId))
        }
    }
}