package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.RegisterActivityBinding

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dbHelper = DataBase(this)

        val binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            val name = binding.nameText.text.toString()
            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()


            var result = dbHelper.addUser(name, email, password)

            if (result != -1L) {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                // 추가로 필요한 동작 (예: 로그인 화면으로 이동)
            } else {
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}