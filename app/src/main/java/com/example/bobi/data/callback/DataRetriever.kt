package com.example.bobi.data.callback

import com.example.bobi.data.modal.Breed

interface DataRetriever{

    fun onDataFetchedSuccess(breed: List<Breed>)
    fun onDataFetchedFailed()
}