package com.example.travelapp


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전체화면 모드 활성화
        enableFullScreenMode()


        // recents 디렉토리 생성 코드
        val recentDir = File(getExternalFilesDir(null), "recents")
        if (!recentDir.exists()) {
            recentDir.mkdirs() // 디렉토리가 없으면 생성
        }

        // 데이터베이스 선언 - SQLite 사용
        val dbHelper = DataBase(this)



        binding.button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()

            // 이메일과 비밀번호 확인
            if (dbHelper.checkUser(email, password)) {
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()

                // 로그인이 성공하면 다음 화면으로 이동
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()

            } else {

                // 아니면 오류 메시지 출력하고 메인 화면 유지
                Toast.makeText(this, "로그인 실패: 이메일 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()

            }
        }

        // 회원가입 버튼 클릭 이벤트
        binding.button2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // 카카오맵 테스트 버튼 클릭 이벤트
        binding.button4.setOnClickListener {
            val intent = Intent(this, KakaomapActivity::class.java)
            startActivity(intent)
        }
    }

    private fun enableFullScreenMode() {
        // 최신 API(R 이상)에서 WindowInsetsController 사용
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.apply {
                // 상태바와 네비게이션 바 숨기기
                hide(WindowInsets.Type.systemBars())
                // 사용자 동작 후 다시 숨김
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // R 미만의 기기에서는 기존 방식 사용
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    )
        }
    }

}
