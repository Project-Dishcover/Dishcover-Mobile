package com.id.dishcover.repository.model.ingridients


 

data class IngredientsModel(
    val name: String,
    val imageUrl: String
) {
    companion object {
        fun emptyData(): IngredientsModel = IngredientsModel(name = "", imageUrl = "")
        fun dummyList(): List<IngredientsModel> {
            val list = mutableListOf<IngredientsModel>()

            (1..10).forEach {
                list.add(
                    IngredientsModel(
                    name = "Name $it",
                    imageUrl = "ImageURL $it"
                )
                )
            }
            return list.toList()
        }
    }
}
