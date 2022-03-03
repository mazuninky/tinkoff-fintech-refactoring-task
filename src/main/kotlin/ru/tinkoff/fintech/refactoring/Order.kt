package ru.tinkoff.fintech.refactoring

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