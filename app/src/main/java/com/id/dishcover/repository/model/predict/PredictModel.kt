package com.id.dishcover.repository.model.predict

import com.google.gson.annotations.SerializedName


 

data class PredictModel(
    val message: String,
    val result: String,
    val score: Float
)