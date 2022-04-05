package com.example.bobi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bobi.data.DogsApiClient
import com.example.bobi.data.callback.DataRetriever
import com.example.bobi.data.modal.Breed

private const val TAG= "ListActivity"
class ListActivity : AppCompatActivity(), DataRetriever{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        
        DogsApiClient.getBreedList(this)
    }

    override fun onDataFetchedSuccess(breed: List<Breed>) {
        Log.d(TAG,"onDataFetchedSuccess")
    }

    override fun onDataFetchedFailed() {
        Log.d(TAG,"onDataFetchedFailed")
    }
}