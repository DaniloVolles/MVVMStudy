package com.example.mvvmstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // binding.txtWelcome.text = "Olá!"
    }

    private fun setObserver(){
        viewModel.welcome().observe(this, Observer {
            binding.txtWelcome.text = it
        })
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_login -> {
                binding.txtWelcome.text = "Olá mundo"
                Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}