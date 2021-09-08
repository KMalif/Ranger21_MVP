package com.example.crudmvpbarang.webservices

import com.example.crudmvpbarang.models.Barang
import com.example.crudmvpbarang.models.User
import retrofit2.Call
import retrofit2.http.*

interface APIServices {
    @FormUrlEncoded
    @POST("auth/sign-up")
    fun signup(
        @Field("name") name : String,
        @Field("username") username : String,
        @Field("email") email : String,
        @Field("password") password : String
    ):Call<SingleResponse<User>>

    @FormUrlEncoded
    @POST("auth/sign-in ")
    fun login(
        @Field("username") username: String,
        @Field("password")password: String
    ): Call<SingleResponse<User>>

    @GET("barang")
    fun getAllbarang():Call<ListResponse<Barang>>

    @GET("barang/{id}")
    fun getBarangById(
        @Path("id")id : Int
    ):Call<ListResponse<Barang>>
}

data class ListResponse<T>(
    var msg : String,
    var status : Int,
    var data : List<T>
)

data class SingleResponse<T>(
    var msg : String,
    var status : Int,
    var data : T
)