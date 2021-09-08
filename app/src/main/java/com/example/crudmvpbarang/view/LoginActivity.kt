package com.example.crudmvpbarang.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.crudmvpbarang.R
import com.example.crudmvpbarang.contracts.LoginActivityContract
import com.example.crudmvpbarang.databinding.ActivityLoginBinding
import com.example.crudmvpbarang.presenter.LoginActivityPresenter

class LoginActivity : AppCompatActivity(), LoginActivityContract.LoginActivityView {
    private lateinit var binding: ActivityLoginBinding
    private var presenter : LoginActivityContract.LoginActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = LoginActivityPresenter(this)
        doLogin()
    }

    private fun doLogin(){
        binding.btnLogin.setOnClickListener {
            val userName = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            if (userName.isNotEmpty() && password.isNotEmpty()){
                presenter?.login(userName, password)
            }else{
                showToast("Isi Semua form")
            }
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun successLogin() {
        startActivity(Intent(this, MainActivity::class.java).also {
            finish()
        })
    }

    override fun showLoading() {
        binding.loadingLogin.apply {
            isIndeterminate = true
        }
    }

    override fun hideLoading() {
        binding.loadingLogin.apply {
            isIndeterminate = false
            progress = 0
            visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroy()
    }
}