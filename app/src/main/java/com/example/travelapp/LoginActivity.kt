package com.example.travelapp

import android.graphics.Matrix // 이미지를 변환(확대, 축소, 회전 등)하기 위한 클래스.
import android.os.Bundle // 액티비티에서 상태 저장 및 복원을 위해 사용.
import android.util.Log // 디버깅 목적으로 로그를 출력하기 위해 사용.
import android.view.MotionEvent // 터치 이벤트 처리에 사용.
import android.view.ScaleGestureDetector // 제스처를 통해 확대/축소 동작을 감지하기 위해 사용.
import android.widget.ImageView // 이미지를 표시하는 뷰.
import androidx.appcompat.app.AppCompatActivity // AppCompatActivity를 확장하여 호환성을 유지.
import com.example.travelapp.databinding.LoginActivityBinding // ViewBinding을 사용해 XML 레이아웃을 바인딩.

class LoginActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView // 이미지 뷰를 나중에 초기화하기 위한 선언.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 부모 클래스의 onCreate 메서드 호출.

        val binding = LoginActivityBinding.inflate(layoutInflater) // ViewBinding 객체 초기화.
        setContentView(binding.root) // 레이아웃 뷰를 설정.

        imageView = binding.imageView8 // 레이아웃의 ImageView를 초기화.
    }

}
