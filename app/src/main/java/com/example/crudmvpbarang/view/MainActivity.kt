package com.example.crudmvpbarang.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.crudmvpbarang.R
import com.example.crudmvpbarang.contracts.MainActivityContract
import com.example.crudmvpbarang.databinding.ActivityMainBinding
import com.example.crudmvpbarang.models.Barang
import com.example.crudmvpbarang.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView {
    private lateinit var binding : ActivityMainBinding
    private var presenter : MainActivityContract.MainActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivityPresenter(this)
    }


    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun attachToRecycler(allBarang: List<Barang>) {
        Log.d("AllBarang", "attachToRecycler: $allBarang")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        presenter?.getAllBarang()
    }

}