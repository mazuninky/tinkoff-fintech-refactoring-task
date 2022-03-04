package ru.tinkoff.fintech.refactoring

data class Order(
    val type: OrderType,
    val name: String,
    val orderId: Int,
)

enum class OrderType {
    PIZZA,
    COFFEE,
}

class PizzaCafe {
    private val cooker = Cooker()
    private val barista = Barista()
    private var curOrderId = 0

    fun executeOrders(orders: Set<Pair<OrderType, String>>) {
        orders.map { (type, name) -> Order(type, name, curOrderId++) }.forEach { order -> executeOrder(order) }
    }

    private fun executeOrder(order: Order) {
        try {
            when (order.type) {
                OrderType.PIZZA -> cooker.cook(order)
                OrderType.COFFEE -> barista.makeCoffee(order)
            }
        } catch (e: IllegalStateException) {
            printLine()
            println(e.message)
            println("Невозможно продолжить выполнение заказа ${order.orderId}")
            printLine()
        }
    }
}


private fun printLine() = print("\n\n---------------------------------------------------------\n\n")