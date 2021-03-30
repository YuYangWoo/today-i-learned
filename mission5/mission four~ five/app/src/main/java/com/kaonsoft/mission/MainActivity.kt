package com.kaonsoft.mission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.kaonsoft.mission.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        btnOnClick()
        btnUrlClick()
        btnJsonHashClick()
        btnGetClick()
    }

    private fun btnOnClick() {
        binding.setOnclick {
            var infoRequest = InformationRequest(
                binding.edtId.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtName.text.toString(),
                binding.edtAge.text.toString().toInt(),
                binding.edtSchool.text.toString()
            )
            RetrofitBuilder.api.infoRequest(infoRequest)
                .enqueue(object : Callback<InformationResponse> {
                    override fun onResponse(
                        call: Call<InformationResponse>,
                        response: Response<InformationResponse>
                    ) {
                        var response = response.body()!!
                        Log.d("TAG", response.toString())
                    }

                    override fun onFailure(call: Call<InformationResponse>, t: Throwable) {
                        Log.d("Error", "Error $t")
                    }

                })



        }
    }

    private fun btnUrlClick() {
        binding.setOnUrlClick {
            var input = HashMap<String, Any>()
            input["id"] = binding.edtId.text.toString()
            input["pw"] = binding.edtPassword.text.toString()
            input["name"] = binding.edtName.text.toString()
            input["age"] = binding.edtAge.text.toString().toInt()
            input["school"] = binding.edtSchool.text.toString()
            RetrofitBuilder.api.infoUrlRequest(input).enqueue(object :
                Callback<InformationResponse> {
                override fun onResponse(
                    call: Call<InformationResponse>,
                    response: Response<InformationResponse>
                ) {
                   Log.d("TAG", response.body().toString()!!)
                }

                override fun onFailure(call: Call<InformationResponse>, t: Throwable) {
                  Log.d("Error", "error $t")
                }

            })



        }
    }

    private fun btnJsonHashClick() {
        binding.setOnJsonHashClick {
            var input = HashMap<String, Any>()
            input["id"] = binding.edtId.text.toString()
            input["pw"] = binding.edtPassword.text.toString()
            input["name"] = binding.edtName.text.toString()
            input["age"] = binding.edtAge.text.toString().toInt()
            input["school"] = binding.edtSchool.text.toString()
            RetrofitBuilder.api.infoHashRequest(input).enqueue(object :
                Callback<InformationResponse> {
                override fun onResponse(
                    call: Call<InformationResponse>,
                    response: Response<InformationResponse>
                ) {
                    Log.d("TAG", response.body().toString()!!)
                }

                override fun onFailure(call: Call<InformationResponse>, t: Throwable) {
                    Log.d("Error", "error $t")
                }

            })
        }
    }

    private fun btnGetClick() {
        binding.setOnGetClick {


        var input = HashMap<String, Any>()
        input["id"] = binding.edtId.text.toString()
        input["pw"] = binding.edtPassword.text.toString()
        input["name"] = binding.edtName.text.toString()
        input["age"] = binding.edtAge.text.toString().toInt()
        input["school"] = binding.edtSchool.text.toString()

        RetrofitBuilder.api.get(input).enqueue(object : Callback<InformationResponse>{
            override fun onResponse(call: Call<InformationResponse>, response: Response<InformationResponse>) {
                Log.d("TAG", response.body()!!.toString())
            }

            override fun onFailure(call: Call<InformationResponse>, t: Throwable) {
                Log.d("Error", "Error $t")

            }

        })
        }
    }
}