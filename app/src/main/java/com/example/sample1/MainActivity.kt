package com.example.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.sample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.editText.addTextChangedListener { text ->
            viewModel.updateButton(text.isNullOrBlank())
        }
        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.submitText(text)
        }
    }
}