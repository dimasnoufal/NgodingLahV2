package com.dimasnoufal.ngodinglahv2.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimasnoufal.ngodinglahv2.data.BahasaRepository
import com.dimasnoufal.ngodinglahv2.model.ListBahasa
import com.dimasnoufal.ngodinglahv2.ui.common.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: BahasaRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UIState<List<ListBahasa>>> =
        MutableStateFlow(UIState.Loading)

    val uiState: StateFlow<UIState<List<ListBahasa>>>
        get() = _uiState

    fun getAllBahasa() {
        viewModelScope.launch {
            repository.getAllBahasas()
                .catch {
                    _uiState.value = UIState.Error(it.message.toString())
                }
                .collect { listBahasas ->
                    _uiState.value = UIState.Success(listBahasas)
                }
        }
    }
}