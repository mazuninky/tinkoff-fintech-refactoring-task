//package ru.tinkoff.fintech.refactoring.store
//
//import ru.tinkoff.fintech.refactoring.menu.PizzaMenu
//
//class StoreFactory {
//    companion object {
//        private val stores: MutableMap<String, Store<*>> = mutableMapOf(
//            "ingredients" to IngredientStore(),
//            "pizzas" to PizzaStore()
//        )
//
//        fun <STORE_T : Store<*>> getStore(key: String, clazz: Class<STORE_T>): STORE_T {
//            return stores[key] as? STORE_T
//                ?: throw IllegalArgumentException("Невозможно привести найденное хранилище к данном классу")
//        }
//    }
//}