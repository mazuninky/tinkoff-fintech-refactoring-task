package ru.tinkoff.fintech.refactoring

class Pizza(
    name: String,
    val ingredients: List<Pair<String, Int>>) : Product(name, 0.0)
{
    companion object {
        private val pizzaList = listOf(
            Pizza("карбонара", listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)),
            Pizza("маринара", listOf("томат" to 2, "оливки" to 3, "тесто" to 1)),
            Pizza("сардиния", listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)),
            Pizza("вальтеллина", listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)),
            Pizza("крестьянская", listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1)),
        )

        fun getPizzaByName(name: String): Pizza? {
            return pizzaList.find { it.name == name }
        }
    }
}

data class Order(
    val number: Int,
    val product: Product,
){
    private val pizzaMaker: Employee = PizzaMaker()
    private val barista: Employee = Barista()
    fun executeOrder() {
        when(this.product){
            is Pizza -> pizzaMaker.makePizza(this.number, this.product)
            is Coffee -> barista.makeCoffee(this.number, this.product)
        }
    }
}

abstract class Product(
    val name: String,
    var price: Double
)