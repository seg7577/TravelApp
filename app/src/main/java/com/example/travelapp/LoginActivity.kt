package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView // 이미지 뷰를 나중에 초기화하기 위한 선언.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        val binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ImageView 초기화
        imageView = binding.imageView8

        // settingsButton 초기화 및 클릭 리스너 설정
        val settingsButton: ImageButton = binding.settingsButton
        settingsButton.setOnClickListener {
            // 설정 페이지로 이동
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
