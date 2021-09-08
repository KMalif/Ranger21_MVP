package com.example.crudmvpbarang.contracts

import com.example.crudmvpbarang.models.Barang

interface MainActivityContract {
    interface MainActivityView{
//        fun showLoading()
//        fun hideLoading()
        fun showToast(message : String)
        fun attachToRecycler(allBarang : List<Barang>)
//        fun emptyData()
    }

    interface MainActivityPresenter{
        fun getAllBarang()
        fun onDestroy()
    }
}