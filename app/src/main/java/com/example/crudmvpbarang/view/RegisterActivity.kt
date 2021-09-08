package com.example.crudmvpbarang.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudmvpbarang.R
import com.example.crudmvpbarang.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}