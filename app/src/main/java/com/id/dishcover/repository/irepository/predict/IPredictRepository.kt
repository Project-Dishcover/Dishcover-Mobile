package com.id.dishcover.repository.irepository.predict

import com.id.dishcover.data.Resource
import com.id.dishcover.repository.model.predict.PredictModel
import kotlinx.coroutines.flow.Flow


 

interface IPredictRepository {
    fun predict(path: String): Flow<Resource<PredictModel>>
}