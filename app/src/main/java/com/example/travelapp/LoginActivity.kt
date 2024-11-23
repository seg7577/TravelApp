package com.example.travelapp

import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
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


        // 터치이벤트랑 확대 축소하는 이벤트랑 동시 적용이 안돼서 일단 주석처리
        // 일단 확대 축소 이벤트만 구현
        // 확대하려면 ctrl누른 상태에서 지도 더블클릭+드래그
        /*imageView.setOnClickListener {
            showBottomSheetDialog()
        }*/
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // ScaleGestureDetector에 이벤트 전달
        scaleGestureDetector.onTouchEvent(event)
        return true
    }


    /*// BottomSheetDialog = 지도 이미지 클릭 시 팝업창 뜨게 하는 메서드
    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.aftermaptouch, null)
        dialog.setContentView(view)

        // 요소 클릭이벤트 구현
        val photoAdd = view.findViewById<View>(R.id.photo_add_area)
        val blogWrite = view.findViewById<View>(R.id.blog_write_area)
        val findrestaurant = view.findViewById<View>(R.id.find_restaurant_area)

        // "사진 추가" 클릭 이벤트
        photoAdd.setOnClickListener {
            dialog.dismiss() // BottomSheetDialog 닫기
            showPopUpDialog("사진 추가", "사진을 추가하는 기능입니다.")
        }

        // "블로그 작성" 클릭 이벤트
        blogWrite.setOnClickListener {
            dialog.dismiss()
            showPopUpDialog("블로그 작성", "블로그 작성 기능입니다.")
        }

        // "맛집 검색" 클릭 이벤트
        findrestaurant.setOnClickListener {
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
                dialog.dismiss() // 팝업 닫기
            }
            .setNegativeButton("취소") { dialog, _ ->
                dialog.dismiss() // 팝업 닫기
            }
            .create()
            .show()

    }*/

}
