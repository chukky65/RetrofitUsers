package com.chuks.retrofit.Api

import com.chuks.retrofit.model.User
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {
    @GET("users")
    //call is a wrapper
    fun getUsers(): Call<List<User>>
}