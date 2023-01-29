package com.example.githubapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.githubapp.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Запуск функции по нажатию
        binding.bGet.setOnClickListener {
            getResultStars()
        }
    }
    //Функция получения дынных по URL пользователя
    private fun getResultStars(){
        val url = "https://api.github.com/users/wt-t/starred"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                    response->
//                val obj = JSONObject(response)
//                val stars = obj.getJSONObject("full_name")    Попытка достать из response часть названия репозитория
                Log.d("MyLog","Respone:$response")
            },
            {
                Log.d("MyLog","Volley error:$it")
            }
        )
        queue.add(stringRequest)
    }

}