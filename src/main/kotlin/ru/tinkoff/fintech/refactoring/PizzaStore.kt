package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.Order.OrderType

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
                OrderType.PIZZA -> cooker.makePizza(order)
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