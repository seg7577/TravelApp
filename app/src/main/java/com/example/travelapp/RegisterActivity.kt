package com.example.travelapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

import com.example.travelapp.databinding.RegisterActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth // Firebase 인증 인스턴스
    private lateinit var firestore: FirebaseFirestore // Firestore 인스턴스

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance() // Firebase 인증 초기화
        firestore = FirebaseFirestore.getInstance() // Firestore 초기화

        val binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 초기 버튼 비활성화
        binding.button3.isEnabled = false

        // 부모 레이아웃 가져오기
        val parentLayout: ConstraintLayout = binding.root.findViewById(R.id.parentLayout)

        // TextView 생성 및 속성 설정
        val errorTextView = TextView(this).apply {
            id = View.generateViewId()
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = 8
            }
            text = "" // 초기에는 비어 있음
            setTextColor(Color.RED)
            textSize = 14f
        }

        // 부모 레이아웃에 추가
        parentLayout.addView(errorTextView)

        // Constraint 연결
        val constraintSet = ConstraintSet()
        constraintSet.clone(parentLayout)
        constraintSet.connect(
            errorTextView.id,
            ConstraintSet.TOP,
            R.id.PasswordConfirm,
            ConstraintSet.BOTTOM
        )
        constraintSet.connect(
            errorTextView.id,
            ConstraintSet.START,
            ConstraintSet.PARENT_ID,
            ConstraintSet.START
        )
        constraintSet.connect(
            errorTextView.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END
        )
        constraintSet.applyTo(parentLayout)

        // 입력값 검증 함수
        fun validateInputs(): Boolean {
            val name = binding.nameText.text.toString()
            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()
            val confirmPassword = binding.PasswordConfirm.text.toString()

            // 비밀번호 일치 여부 확인
            if (password != confirmPassword) {
                errorTextView.text = "비밀번호가 일치하지 않습니다."
                return false
            }

            // 모든 필드 유효성 검사
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                errorTextView.text = "모든 필드를 입력해주세요."
                return false
            }

            errorTextView.text = "" // 오류 메시지 초기화
            return true
        }

        // TextWatcher를 이용하여 입력값 변경 시 검증
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.button3.isEnabled = validateInputs()
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        // 모든 입력 필드에 TextWatcher 추가
        binding.nameText.addTextChangedListener(textWatcher)
        binding.EmailAddress.addTextChangedListener(textWatcher)
        binding.Password.addTextChangedListener(textWatcher)
        binding.PasswordConfirm.addTextChangedListener(textWatcher)

        // 버튼 클릭 이벤트
        binding.button3.setOnClickListener {
            val name = binding.nameText.text.toString()
            val email = binding.EmailAddress.text.toString()
            val password = binding.Password.text.toString()

            // Firebase Authentication으로 사용자 등록
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // 사용자 등록 성공 시 Firestore에 사용자 정보 저장
                        val userId = auth.currentUser?.uid // Firebase가 생성한 사용자 UID
                        val user = hashMapOf(
                            "name" to name,
                            "email" to email,
                            "password" to password,
                            "uid" to userId
                        )

                        firestore.collection("users").document(userId!!)
                            .set(user)
                            .addOnSuccessListener {
                                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                                // 메인 화면으로 이동
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Firestore 저장 실패: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        // 사용자 등록 실패 시 오류 메시지 표시
                        Toast.makeText(this, "회원가입 실패: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
