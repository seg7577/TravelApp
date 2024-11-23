package com.example.travelapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.SettingsActivityBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: SettingsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = SettingsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 이벤트 추가
        binding.usersLayout.setOnClickListener {
            Toast.makeText(this, "사용자 정보 변경화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

        binding.authLayout.setOnClickListener {
            Toast.makeText(this, "비밀번호 변경 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

        binding.galleryLayout.setOnClickListener {
            Toast.makeText(this, "갤러리로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

        binding.inquiryLayout.setOnClickListener {
            Toast.makeText(this, "문의 화면으로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }
}