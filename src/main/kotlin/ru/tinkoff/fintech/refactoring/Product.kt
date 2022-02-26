package ru.tinkoff.fintech.refactoring

interface Product {
    val name: String
    val price: Double
}

abstract class ProductList<P: Product> {
    private val list = mutableMapOf<String, P>()

    protected fun getProductByName(name: String, message: String): P {
        return list.getOrElse(name) {error(message)}
    }

    fun add(product: P) = list.put(product.name, product)

    fun add(productList: Set<P>) = list.putAll(productList.associateBy { it.name })

    fun remove(name: String) = list.remove(name)

    fun remove(product: P) = remove(product.name)
}