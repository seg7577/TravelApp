package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity) // 스플래시 화면 레이아웃 설정

        // 일정 시간 후 로딩 화면으로 이동
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
            finish() // 스플래시 화면 종료
        }, 3000) // 3초 딜레이
    }
}
