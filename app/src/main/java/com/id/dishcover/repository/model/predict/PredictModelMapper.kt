package com.id.dishcover.repository.model.predict

import com.id.dishcover.data.predict.response.PredictResponse


 

object PredictModelMapper {
    fun mapPredictResponseToModel(data: PredictResponse): PredictModel = PredictModel(
        message = data.message, result = data.result, score = data.score
    )
}