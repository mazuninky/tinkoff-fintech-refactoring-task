package ru.tinkoff.fintech.refactoring.products

interface ProductService<T : Product> {
    fun getByName(name: String): T?
}

abstract class AbstractProductService<T : Product>(private val store: List<T>) : ProductService<T> {
    override fun getByName(name: String): T? {
        return store.find { it.name == name }
    }
}

object PizzaService :
    AbstractProductService<Pizza>(listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant()))

object CoffeeService : AbstractProductService<Coffee>(listOf(Espresso(), Cappuccino()))