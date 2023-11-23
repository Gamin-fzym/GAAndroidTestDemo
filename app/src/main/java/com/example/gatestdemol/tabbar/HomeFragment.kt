package com.example.gatestdemol.tabbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gatestdemol.databinding.FragmentHomeBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null
    private var dataArr: List<CityModel> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestCityList()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun requestCityList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.lnktools.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)
        val call = service.getCities(PageRequest(1, 20))

        call.enqueue(object : Callback<CityResponse> {
            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                if (response.isSuccessful) {
                    val res = response.body()
                    var info = res?.data
                    var list = info?.data
                    dataArr += list ?: listOf()
                    // 处理响应
                    println("dataArr count = ${dataArr.count()}")
                } else {
                    // 处理错误
                }
            }

            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                // 处理失败
                println("dataArr count = 处理失败")
            }
        })
    }

}


