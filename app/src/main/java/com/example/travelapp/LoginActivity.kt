package com.example.travelapp

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.LoginActivityBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private var scaleFactor = 1.0f
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.imageView8

        // settingsButton 초기화 및 클릭 리스너 설정
        val settingsButton: ImageButton = binding.settingsButton
        settingsButton.setOnClickListener {
            // 설정 페이지로 이동
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        // ScaleGestureDetector 초기화
        scaleGestureDetector = ScaleGestureDetector(this, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                scaleFactor *= detector.scaleFactor

                // 최소 및 최대 확대/축소 값 설정
                scaleFactor = scaleFactor.coerceIn(0.5f, 5.0f)

                imageView.scaleX = scaleFactor
                imageView.scaleY = scaleFactor
                return true
            }
        })

        // 클릭 이벤트 설정
        imageView.setOnClickListener {
            showBottomSheetDialog()
        }

        // 터치 이벤트 처리 (확대/축소와 클릭 이벤트 공존)
        imageView.setOnTouchListener { view, event ->
            var handled = false

            // ScaleGestureDetector로 확대/축소 이벤트 처리
            if (scaleGestureDetector.onTouchEvent(event)) {
                handled = true
            }

            // 클릭 이벤트 감지 (ACTION_UP에서 처리)
            if (event.action == MotionEvent.ACTION_UP) {
                view.performClick() // 클릭 동작 실행
            }

            handled
        }
    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.aftermaptouch, null)
        dialog.setContentView(view)

        // 요소 클릭 이벤트 구현
        val photoAdd = view.findViewById<View>(R.id.photo_add_area)
        val blogWrite = view.findViewById<View>(R.id.blog_write_area)
        val findRestaurant = view.findViewById<View>(R.id.find_restaurant_area)

        photoAdd.setOnClickListener {
            dialog.dismiss()
            showPopUpDialog("사진 추가", "사진을 추가하는 기능입니다.")
        }

        blogWrite.setOnClickListener {
            dialog.dismiss()
            showPopUpDialog("블로그 작성", "블로그 작성 기능입니다.")
        }

        findRestaurant.setOnClickListener {
            dialog.dismiss()
            showPopUpDialog("맛집 검색", "맛집 검색 기능입니다.")
        }

        dialog.show()
    }

    private fun showPopUpDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("확인") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("취소") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
