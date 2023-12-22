package com.id.dishcover.data.predict.source

import android.util.Log
import com.id.dishcover.data.ApiResponse
import com.id.dishcover.data.predict.response.PredictResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject


 

class PredictDataSource @Inject constructor(
    private val predictApiService: PredictApiService
) {
    fun predict(path: String): Flow<ApiResponse<PredictResponse>> = flow {
        emit(try {
            val file = File(path)
            val requestFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imagePart = MultipartBody.Part.createFormData("file", file.path, requestFile)
            val response = predictApiService.predict(imagePart)
            ApiResponse.Success(response)
        } catch (e: Exception) {
            ApiResponse.Error(e.message.toString())
            }
        )
    }
}