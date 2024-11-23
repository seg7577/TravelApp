package com.example.travelapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity) // 스플래시 화면 레이아웃 설정

        // 로고 ImageView를 가져오기asdasdasdsa
        val logoImageView = findViewById<ImageView>(R.id.logoImageView)

        // 초기 크기를 작게 설정 (시작 크기: 0.5배)
        logoImageView.scaleX = 0.5f
        logoImageView.scaleY = 0.5f

        // 애니메이션 총 지속 시간
        val totalDuration = 3000L // 전체 애니메이션 시간: 3초
        val singleRotationDuration = totalDuration / 4 // 한 번 회전할 때의 시간: 3초를 4단계로 나눔

        // 왼쪽으로 360도 회전 (반시계 방향)
        val rotateLeft = ObjectAnimator.ofFloat(logoImageView, "rotation", 0f, -360f).apply {
            duration = singleRotationDuration // 애니메이션 지속 시간 설정
        }

        // 오른쪽으로 360도 회전 (시계 방향)
        val rotateRight = ObjectAnimator.ofFloat(logoImageView, "rotation", 0f, 360f).apply {
            duration = singleRotationDuration // 애니메이션 지속 시간 설정
        }

        // 로고 크기를 점차 키우는 애니메이션 (X축)
        val scaleUpX = ObjectAnimator.ofFloat(logoImageView, "scaleX", 0.5f, 1.5f).apply {
            duration = totalDuration // 전체 지속 시간 동안 크기 변화
        }

        // 로고 크기를 점차 키우는 애니메이션 (Y축)
        val scaleUpY = ObjectAnimator.ofFloat(logoImageView, "scaleY", 0.5f, 1.5f).apply {
            duration = totalDuration // 전체 지속 시간 동안 크기 변화
        }

        // 첫 번째 세트: 왼쪽 회전과 크기 변경 동시 실행
        val rotateAndScaleSet1 = AnimatorSet().apply {
            playTogether(rotateLeft, scaleUpX, scaleUpY) // 크기와 왼쪽 회전을 동시에 실행
        }

        // 두 번째 세트: 오른쪽으로 부드럽게 돌아오는 회전
        val rotateAndScaleSet2 = ObjectAnimator.ofFloat(logoImageView, "rotation", -360f, 0f).apply {
            duration = totalDuration / 2 // 오른쪽 회전 지속 시간 설정 (전체의 절반)
        }

        // 두 개의 애니메이션 세트를 순차적으로 실행
        val combinedSet = AnimatorSet().apply {
            playSequentially(rotateAndScaleSet1, rotateAndScaleSet2) // 순서대로 실행
        }

        // 애니메이션 시작
        combinedSet.start()

        // Handler를 사용해 애니메이션 종료 후 다음 화면으로 이동
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoadingActivity::class.java) // LoadingActivity로 이동
            startActivity(intent)
            finish() // 스플래시 화면 종료
        }, totalDuration) // 전체 애니메이션 시간과 동일한 딜레이 설정
    }
}
