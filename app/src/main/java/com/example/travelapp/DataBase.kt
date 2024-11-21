package com.example.travelapp

import android.content.ContentValues // ContentValues 클래스를 가져옵니다 (데이터베이스에 데이터를 삽입하기 위해 사용).
import android.content.Context // Context 클래스를 가져옵니다 (데이터베이스 초기화 시 필요).
import android.database.sqlite.SQLiteDatabase // SQLite 데이터베이스 작업을 위한 클래스.
import android.database.sqlite.SQLiteOpenHelper // SQLite 데이터베이스 헬퍼 클래스.

class DataBase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "user_database.db"  // 데이터베이스 이름을 정의.
        private const val DATABASE_VERSION = 1                // 데이터베이스 버전을 정의.
        private const val TABLE_USERS = "users"               // 사용자 정보를 저장할 테이블 이름.

        // 테이블 컬럼 이름
        private const val COLUMN_ID = "id" // 고유 식별자 컬럼.
        private const val COLUMN_NAME = "name" // 사용자 이름 컬럼.
        private const val COLUMN_EMAIL = "email" // 사용자 이메일 컬럼.
        private const val COLUMN_PASSWORD = "password" // 사용자 비밀번호 컬럼.
    }

    override fun onCreate(db: SQLiteDatabase) {
        // 사용자 테이블 생성 쿼리
        val createTable = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, // id 컬럼: 자동 증가되는 기본 키.
                $COLUMN_NAME TEXT, // name 컬럼: 텍스트 형식.
                $COLUMN_EMAIL TEXT, // email 컬럼: 텍스트 형식.
                $COLUMN_PASSWORD TEXT // password 컬럼: 텍스트 형식.
            )
        """
        db.execSQL(createTable) // 테이블 생성 쿼리를 실행.
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 데이터베이스 업그레이드 시 기존 테이블 삭제 후 다시 생성
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS") // 기존 테이블을 삭제.
        onCreate(db) // 새로운 테이블 생성.
    }

    // 데이터 삽입 메서드
    fun addUser(name: String, email: String, password: String): Long {
        val db = this.writableDatabase // 쓰기 가능한 데이터베이스 가져오기.
        val values = ContentValues().apply {
            put(COLUMN_NAME, name) // 사용자 이름 추가.
            put(COLUMN_EMAIL, email) // 사용자 이메일 추가.
            put(COLUMN_PASSWORD, password) // 사용자 비밀번호 추가.
        }
        return db.insert(TABLE_USERS, null, values) // 데이터베이스에 데이터 삽입 후 결과 반환.
    }

    // 사용자 조회 메서드 (이메일과 비밀번호로 로그인 확인)
    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase // 읽기 가능한 데이터베이스 가져오기.
        val cursor = db.query(
            TABLE_USERS, // 조회할 테이블 이름.
            arrayOf(COLUMN_ID), // 반환할 컬럼 (여기서는 id만).
            "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?", // 조건문 (이메일과 비밀번호가 일치하는 데이터).
            arrayOf(email, password), // 조건에 사용할 값.
            null, null, null // 그룹화, 정렬 없음.
        )
        val exists = cursor.count > 0 // 일치하는 데이터가 있는지 확인.
        cursor.close() // 커서 닫기.
        return exists // 결과 반환.
    }

    // 이메일 중복 확인 메서드
    fun checkEmailExists(email: String): Boolean {
        val db = this.readableDatabase // 읽기 가능한 데이터베이스 가져오기.
        val cursor = db.query(
            TABLE_USERS, // 확인할 테이블 이름.
            arrayOf(COLUMN_EMAIL), // 반환할 컬럼 (이메일).
            "$COLUMN_EMAIL = ?", // 조건문 (이메일이 일치하는 데이터).
            arrayOf(email), // 조건에 사용할 값.
            null, null, null // 그룹화, 정렬 없음.
        )
        val exists = cursor.count > 0 // 데이터가 존재하는지 확인.
        cursor.close() // 커서 닫기.
        return exists // 결과 반환.
    }
}
