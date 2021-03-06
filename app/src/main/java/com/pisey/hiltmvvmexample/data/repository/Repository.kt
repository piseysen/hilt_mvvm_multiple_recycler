package com.pisey.hiltmvvmexample.data.repository

import com.pisey.hiltmvvmexample.data.network.Api
import com.pisey.hiltmvvmexample.data.network.SafeApiCall
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) : SafeApiCall {
    suspend fun getMovies() = safeApiCall {
        api.getMovies()
    }

    suspend fun getDirectors() = safeApiCall {
        api.getDirectors()
    }

}