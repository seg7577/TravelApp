package com.example.travelapp


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth // Firebase 인증 인스턴스

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Firebase 인증 초기화
        auth = FirebaseAuth.getInstance()



        binding.button.setOnClickListener {
            val email = binding.EmailAddress.text.toString().trim() // 이메일 입력값
            val password = binding.Password.text.toString().trim() // 비밀번호 입력값
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Firebase Authentication으로 로그인
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // 로그인 성공
                        Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java) // 로그인 성공 후 이동할 화면
                        startActivity(intent)
                        finish() // 현재 액티비티 종료
                    } else {
                        // 로그인 실패
                        Toast.makeText(this, "로그인 실패: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        // 터미널에 오류 메시지 출력
                        Log.e("LoginError", "로그인 실패: $task.exception?.message")
                    }
                }


        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java) // 회원가입 화면으로 이동
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, KakaomapActivity::class.java) // 카카오맵 화면으로 이동
            startActivity(intent)
        }
    }



}
