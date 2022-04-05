package com.example.bobi.data

import com.example.bobi.data.modal.Breed
import retrofit2.http.GET
import retrofit2.http.Headers

interface DogsApi{

    @Headers("x-api-key:$API_KEY")
    @GET(BREEDS)
    fun getBreedList(): retrofit2.Call<List<Breed>>

}