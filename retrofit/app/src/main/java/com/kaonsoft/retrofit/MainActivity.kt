package com.kaonsoft.retrofit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import com.cookandroid.gachon_study_room.data.room.RoomsData
import com.kaonsoft.mobidoo_sdk_test.response.InitializeResponse
import com.kaonsoft.retrofit.request.InitializeRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<ProgressBar>(R.id.progressBar).progress = 480
//        // jsonPost
        val initializeRequest = InitializeRequest(
            "INDONESIA_HIGO_EXAMPLE",
            "${Build.MODEL} - ${Build.VERSION.RELEASE}(${Build.VERSION.SDK_INT})",
            Build.MANUFACTURER,
            "100.100.100.100", // 서버 코드에서 추가 바랍니다.
            "Android",
            "100")
        RetrofitTwoBuilder.api.initRequest(initializeRequest).enqueue(object :Callback<InitializeResponse>{
            override fun onResponse(
                call: Call<InitializeResponse>,
                response: Response<InitializeResponse>
            ) {
                if(response.isSuccessful) {
                    var data = response.body()
                    Log.d("test", data!!.securityKey)
                }
            }

            override fun onFailure(call: Call<InitializeResponse>, t: Throwable) {
           Log.d("test", "실패$t")
            }

        })
      //   x-www-urlencode로 보낸 데이터.
//        var input = HashMap<String, String>()
//        input["college"] = "TEST"
//        RetrofitBuilder.api.post(input).enqueue(object: Callback<RoomsData> {
//            override fun onResponse(call: Call<RoomsData>, response: Response<RoomsData>) {
//                if(response.isSuccessful) {
//                    Log.d("test", "연결성공")
//                    var a: RoomsData = response.body()!!
//                    Log.d("test", a.rooms[0].seat[0][0].toString())
//                }
//            }
//
//            override fun onFailure(call: Call<RoomsData>, t: Throwable) {
//               Log.d("test", "연결실패")
//            }
//
//        })
//

    }
}