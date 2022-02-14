package com.example.month6_homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.month6_homework1.databinding.ActivityTextBinding

class TextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextBinding

    companion object {
        const val editName: String = "edit_text"
        const val editResult: String = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEnterText.setText(intent.getStringExtra(editName))

        binding.btnGo.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    editResult,
                    binding.etEnterText.text.toString()
                )
            )
            finish()
        }
    }
}