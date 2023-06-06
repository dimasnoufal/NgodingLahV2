package com.dimasnoufal.ngodinglahv2.di

import com.dimasnoufal.ngodinglahv2.data.BahasaRepository

object Injection {
    fun provideRepository(): BahasaRepository {
        return BahasaRepository.getInstance()
    }
}