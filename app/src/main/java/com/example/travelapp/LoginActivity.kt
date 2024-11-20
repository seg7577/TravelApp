package com.example.travelapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.LoginActivityBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class LoginActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageView = binding.imageView8



        imageView.setOnClickListener {
            showBottomSheetDialog()
        }
    }


    // BottomSheetDialog = 지도 이미지 클릭 시 팝업창 뜨게 하는 메서드
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

    }

}
