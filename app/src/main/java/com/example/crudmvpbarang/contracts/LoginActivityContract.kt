package com.example.crudmvpbarang.contracts

interface LoginActivityContract {
    interface LoginActivityView{
        fun showToast(message : String)
        fun successLogin()
        fun showLoading()
        fun hideLoading()
    }

    interface LoginActivityPresenter{
        fun login(username : String, password : String)

        fun destroy()
    }
}