package com.example.travelapp


import android.content.Intent // Intent 클래스를 가져옵니다 (액티비티 간 전환에 사용).
import android.os.Bundle // 액티비티에서 상태 저장 및 복원을 위해 사용.
import android.widget.Toast // 간단한 메시지를 사용자에게 보여주기 위해 사용.
import androidx.appcompat.app.AppCompatActivity // AppCompatActivity를 확장하여 호환성을 유지.
import com.example.travelapp.databinding.ActivityMainBinding // ViewBinding을 사용해 XML 레이아웃을 바인딩.
import java.io.File // 파일 및 디렉토리 작업을 위해 사용.

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 부모 클래스의 onCreate 메서드 호출.
        val binding = ActivityMainBinding.inflate(layoutInflater) // ViewBinding 객체 초기화.
        setContentView(binding.root) // 레이아웃 뷰를 설정.

        // recents 디렉토리 생성 코드
        val recentDir = File(getExternalFilesDir(null), "recents") // 외부 파일 디렉토리에 "recents" 폴더 경로 생성.
        if (!recentDir.exists()) { // "recents" 디렉토리가 존재하지 않으면
            recentDir.mkdirs() // 디렉토리를 생성.
        }

        // 데이터베이스 선언 - SQLite 사용
        val dbHelper = DataBase(this) // 사용자 데이터베이스 헬퍼 객체 생성.

        // 로그인 버튼 클릭 이벤트
        binding.button.setOnClickListener { // 로그인 버튼 클릭 시 동작 설정.
            val intent = Intent(this, LoginActivity::class.java) // 로그인 화면으로 이동할 인텐트 생성.
            val email = binding.EmailAddress.text.toString() // 입력된 이메일 가져오기.
            val password = binding.Password.text.toString() // 입력된 비밀번호 가져오기.

            // 이메일과 비밀번호 확인
            if (dbHelper.checkUser(email, password)) { // 사용자 데이터베이스에서 사용자 확인.
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show() // 성공 메시지 표시.

                // 로그인이 성공하면 다음 화면으로 이동
                val intent = Intent(this, LoginActivity::class.java) // 로그인 성공 후 이동할 화면 설정.
                startActivity(intent) // 로그인 화면 시작.
                finish() // 현재 액티비티 종료.

            } else { // 로그인 실패한 경우.
                // 오류 메시지 출력하고 메인 화면 유지
                Toast.makeText(this, "로그인 실패: 이메일 또는 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 회원가입 버튼 클릭 이벤트
        binding.button2.setOnClickListener { // 회원가입 버튼 클릭 시 동작 설정.
            val intent = Intent(this, RegisterActivity::class.java) // 회원가입 화면으로 이동할 인텐트 생성.
            startActivity(intent) // 회원가입 화면 시작.
        }

        // 카카오맵 테스트 버튼 클릭 이벤트
        binding.button4.setOnClickListener { // 카카오맵 테스트 버튼 클릭 시 동작 설정.
            val intent = Intent(this, KakaomapActivity::class.java) // 카카오맵 화면으로 이동할 인텐트 생성.
            startActivity(intent) // 카카오맵 화면 시작.
        }
    }
}
