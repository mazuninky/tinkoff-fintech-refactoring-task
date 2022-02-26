package ru.tinkoff.fintech.refactoring.factories

class StoreFactory {
    companion object {
        private val stores: Map<String, Store<*>> = mapOf(
            "ingredients" to IngredientStore(),
        )

        fun <STORE_T : Store<*>> getStore(key: String, clazz: Class<STORE_T>): STORE_T {
            return stores[key] as? STORE_T
                ?: throw IllegalArgumentException("Невозможно привести найденное хранилище к данном классу")
        }
    }
}