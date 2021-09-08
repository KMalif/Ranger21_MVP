package com.example.crudmvpbarang.presenter

import com.example.crudmvpbarang.contracts.RegisterActivityContract
import com.example.crudmvpbarang.models.User
import com.example.crudmvpbarang.utilities.APIClient
import com.example.crudmvpbarang.webservices.SingleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivityPresenter(v : RegisterActivityContract.RegisterActivityView?): RegisterActivityContract.RegisterActivityPresenter {

    private var view : RegisterActivityContract.RegisterActivityView? = v
    private var apiServices = APIClient.APIService()

    override fun register(name: String, username: String, email: String, password: String) {
        val request = apiServices.signup(name, username, email, password)
        view?.showLoading()
        request.enqueue(object : Callback<SingleResponse<User>>{
            override fun onResponse(
                call: Call<SingleResponse<User>>,
                response: Response<SingleResponse<User>>
            ) {
                if (response.isSuccessful){
                    val body = response.body()
                    if (body != null && body.status.equals(200)){
                        view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                        view?.successRegister()
                    }
                }else{
                    view?.showToast("Terjadi kesalahan, silahkan coba lagi lain waktu")
                }
                view?.hideLoading()
            }

            override fun onFailure(call: Call<SingleResponse<User>>, t: Throwable) {
                view?.showToast("Tidak bisa koneksi ke server")
                view?.hideLoading()
            }
        })
    }

    override fun destroy() {
        view = null
    }
}