//package ru.tinkoff.fintech.refactoring.factories
//
//import ru.tinkoff.fintech.refactoring.products.productsImpl.Pizza
//
//class PizzaStore(
//    private val ingredientStore: IngredientStore = IngredientStore()
//) : Store<Pizza>(
//    mutableMapOf(
//        "карбонара" to Pizza("карбонара",
//            mapOf(
//                StoreFactory.Companion.get("ingredient") as ("яйца") to 1,
//            )
//        )
//    )
//) {
//}