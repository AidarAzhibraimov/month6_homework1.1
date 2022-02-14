package com.example.month6_homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.month6_homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener{
            if (binding.etEnterText.text.toString().isEmpty()){
                Toast.makeText(this, getString(R.string.noSimvol), Toast.LENGTH_SHORT).show()
            }else{
                Intent (this@MainActivity,TextActivity::class.java).apply {
                    putExtra("edit_text", binding.etEnterText.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            result ->
            binding.etEnterText.setText(result.data?.getStringExtra("result"))
        }
    }
}