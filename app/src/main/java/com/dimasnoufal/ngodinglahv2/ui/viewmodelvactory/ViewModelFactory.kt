package com.dimasnoufal.ngodinglahv2.ui.viewmodelvactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dimasnoufal.ngodinglahv2.data.BahasaRepository
import com.dimasnoufal.ngodinglahv2.ui.screen.detail.DetailViewModel
import com.dimasnoufal.ngodinglahv2.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: BahasaRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}