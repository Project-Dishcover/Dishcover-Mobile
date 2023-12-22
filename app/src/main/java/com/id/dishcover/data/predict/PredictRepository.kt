package com.id.dishcover.data.predict

import com.id.dishcover.data.ApiResponse
import com.id.dishcover.data.Resource
import com.id.dishcover.data.predict.source.PredictDataSource
import com.id.dishcover.repository.irepository.predict.IPredictRepository
import com.id.dishcover.repository.model.predict.PredictModel
import com.id.dishcover.repository.model.predict.PredictModelMapper.mapPredictResponseToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PredictRepository @Inject constructor(
    private val dataSource: PredictDataSource
): IPredictRepository {
    override fun predict(path: String): Flow<Resource<PredictModel>> = flow {
        emit(Resource.Loading())
        when (val response = dataSource.predict(path).first()) {
            is ApiResponse.Error -> emit(Resource.Error(response.error))
            is ApiResponse.Success -> emit(Resource.Success(mapPredictResponseToModel(response.data)))
        }
    }
}