package com.dede.coroutinexretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {
    private lateinit var sportAdapter: SportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sportAdapter = SportAdapter()

        rvSport.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sportAdapter
        }

        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getLeagues()
            withContext(Dispatchers.Main){
                try {
                    if(response.isSuccessful){
                        response.body()?.data.let { sportAdapter.setData(it) }
                    }
                }catch (e : HttpException){
                    Toast.makeText(applicationContext,"Exception Error",Toast.LENGTH_SHORT).show()
                }catch (e : Throwable){
                    Toast.makeText(applicationContext,"Throwable Error",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
