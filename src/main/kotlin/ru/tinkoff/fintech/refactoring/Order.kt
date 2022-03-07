package ru.tinkoff.fintech.refactoring

class Receipt (val orderNumber: Int) {
    private val orderList : MutableList<Order> = mutableListOf()
    private var price = 0.0

    fun makeNewOrder() {
        if (orderList.isNotEmpty()) {
            orderList.clear()
            price = 0.0
        }
    }

    fun addPoint2Receipt(order : Order){
        orderList.add(order)
    }

    fun getPoints() : List<Order> {
        return orderList
    }

    fun printReceipt() {
        for (i in orderList) {
            println("Продукт ${i.product.name} стоит ${i.product.price}")
            price += i.product.price
        }
        println("Конечная стоимость $price")
    }

}

data class Order(
    val number: Int,
    val product : Product
)

//class PizzaOrder(override val number: Int, override val product: Product) : Order
//
//class CoffeeOrder(override val number: Int, override val product: Product) : Order
