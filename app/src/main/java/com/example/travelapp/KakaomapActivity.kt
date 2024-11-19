package com.example.travelapp
//커밋용도
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.travelapp.databinding.KakaomapActivityBinding
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.KakaoMapSdk
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView

class KakaomapActivity : AppCompatActivity() {

    private lateinit var binding: KakaomapActivityBinding
    private lateinit var mapView: MapView
    private var kakaoMap: KakaoMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding 설정
        binding = KakaomapActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // KakaoMap SDK 초기화 및 로그로 확인
        try {
            KakaoMapSdk.init(this, BuildConfig.KAKAO_MAP_KEY)
            Log.d("KakaoMapInit", "KakaoMap SDK initialized successfully")
        } catch (e: Exception) {
            Log.e("KakaoMapInit", "Failed to initialize KakaoMap SDK", e)
        }

        // MapView 설정 및 로드
        showMapView()
    }

    private fun showMapView() {
        // XML에서 MapView를 가져오기
        mapView = binding.mapView

        mapView.start(object : MapLifeCycleCallback() {
            override fun onMapDestroy() {
                // 지도 API가 정상적으로 종료될 때 호출
                Log.d("KakaoMap", "onMapDestroy")
            }

            override fun onMapError(e: Exception?) {
                // 인증 실패 및 지도 사용 중 에러가 발생할 때 호출
                Log.e("KakaoMap", "onMapError", e)
            }
        }, object : KakaoMapReadyCallback() {
            override fun onMapReady(map: KakaoMap) {
                // 정상적으로 인증이 완료되었을 때 호출
                kakaoMap = map


            }
            override fun getPosition(): LatLng {
                // 지도 시작 시 위치 좌표를 설정
                return LatLng.from(35.8460286, 127.1344631)
            }
        })
    }



}
