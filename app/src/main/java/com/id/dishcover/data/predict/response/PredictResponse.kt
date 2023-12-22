package com.id.dishcover.data.predict.response

import com.google.gson.annotations.SerializedName


 

data class PredictResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: String,
    @SerializedName("score")
    val score: Float
)