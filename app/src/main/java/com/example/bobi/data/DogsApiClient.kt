package com.example.bobi.data

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bobi.data.callback.DataRetriever
import com.example.bobi.data.modal.Breed
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "DogsApiClient"

object DogsApiClient : AppCompatActivity(){

    private val apiDog by lazy{
        setup()
    }

    private fun setup(): DogsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

     fun getBreedList(listener: DataRetriever) {
         apiDog.getBreedList().enqueue(object : Callback<List<Breed>> {
             override fun onResponse(call: Call<List<Breed>>, response: Response<List<Breed>>) {
                 Log.d(TAG, "onResponse: ${response.body()}")
                 if (response.isSuccessful){
                     listener.onDataFetchedSuccess(response.body()!!)
                 }
             }

             override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                 Log.d(TAG, "onFailure: ${t.message}")
                 listener.onDataFetchedFailed()
             }
         })
     }
}