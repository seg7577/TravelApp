package com.example.travelapp

import android.graphics.Matrix
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.LoginActivityBinding
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

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.aftermaptouch, null)
        dialog.setContentView(view)

        dialog.show()
    }

}
