package com.id.dishcover.data.predict.source

import com.id.dishcover.data.predict.response.PredictResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


 

interface PredictApiService {
    @POST("predict")
    @Multipart
    suspend fun predict(
        @Part data: MultipartBody.Part
    ): PredictResponse
}