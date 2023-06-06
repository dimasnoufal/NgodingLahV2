package com.dimasnoufal.ngodinglahv2.data

import com.dimasnoufal.ngodinglahv2.model.DataDumyBahasa
import com.dimasnoufal.ngodinglahv2.model.ListBahasa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BahasaRepository {

    private val listBahasas = mutableListOf<ListBahasa>()

    init {
        if (listBahasas.isEmpty()) {
            DataDumyBahasa.dumyBahasa.forEach {
                listBahasas.add(ListBahasa(it, 0))
            }
        }
    }

    fun getAllBahasas(): Flow<List<ListBahasa>> {
        return flowOf(listBahasas)
    }

    fun getListBahasaById(bahasaId: Long): ListBahasa {
        return listBahasas.first {
            it.bahasaPemrograman.id == bahasaId
        }
    }

    companion object {
        @Volatile
        private var instance: BahasaRepository? = null

        fun getInstance(): BahasaRepository =
            instance ?: synchronized(this) {
                BahasaRepository().apply {
                    instance = this
                }
            }
    }
}