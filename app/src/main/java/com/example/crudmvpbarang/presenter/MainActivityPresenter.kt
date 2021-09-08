package com.example.crudmvpbarang.presenter

import android.util.Log
import com.example.crudmvpbarang.contracts.MainActivityContract
import com.example.crudmvpbarang.models.Barang
import com.example.crudmvpbarang.utilities.APIClient
import com.example.crudmvpbarang.webservices.ListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter(v : MainActivityContract.MainActivityView?) :  MainActivityContract.MainActivityPresenter {

    private var view : MainActivityContract.MainActivityView? = v
    private var apiServices = APIClient.APIService()

    override fun getAllBarang() {
        val request = apiServices.getAllbarang()
//        view?.showLoading()
        request.enqueue(object :Callback<ListResponse<Barang>>{
            override fun onResponse(
                call: Call<ListResponse<Barang>>,
                response: Response<ListResponse<Barang>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.attachToRecycler(body.data)

                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
//                view?.hideLoading()
            }

            override fun onFailure(call: Call<ListResponse<Barang>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
//                view?.hideLoading()
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}