package com.id.dishcover.repository.model.receipt

import com.id.dishcover.repository.model.ingridients.IngredientsModel


 

data class ReceiptModel(
    val name: String,
    val description: String,
    val imageUrl: String
) {
    companion object {
        fun emptyData(): ReceiptModel = ReceiptModel(name = "", description = "", imageUrl = "")
        fun dummyList(): List<ReceiptModel> {
            val list = mutableListOf<ReceiptModel>()

            (1..10).forEach {
                list.add(
                    ReceiptModel(
                        name = "Name $it",
                        description = "Description $it",
                        imageUrl = "ImageURL $it"
                    )
                )
            }
            return list.toList()
        }
    }
}
