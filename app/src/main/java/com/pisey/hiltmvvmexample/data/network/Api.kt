package com.pisey.hiltmvvmexample.data.network

import com.pisey.hiltmvvmexample.ui.main.HomeRecyclerViewItem
import retrofit2.http.GET

interface Api {

    @GET("movies")
    suspend fun getMovies(): List<HomeRecyclerViewItem.Movie>

    @GET("directors")
    suspend fun getDirectors(): List<HomeRecyclerViewItem.Director>

}