package ru.tinkoff.fintech.refactoring

// В данной ситуации не совсем понятно, как поступить с одной стороны в интерфейс можно сразу вставить исполнителя
// заказа и метод, который будет выполнять этот заказ ( в данной ситуации смогу избавится от switch в executeOrder),
// с другой стороны - это сильно связывает классы


interface Order {
    val number: Int
    val product : Product
}

class PizzaOrder(override val number: Int, override val product: Product) : Order

class CoffeeOrder(override val number: Int, override val product: Product) : Order


class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            product = coffee
        )
    }

    fun orderPizza(pizza : Pizza): PizzaOrder {
        pizza.getIngredient().forEach { ingredient ->

            val price = PizzaIngredients.getIngredients(ingredient.name)
            pizza.price += price * ingredient.amount
        }

        return PizzaOrder(
            number = ++orderNumber,
            product = pizza
        )
    }

    fun executeOrder(order: Order?= null) {
        if (order != null) {
            when (order.product) {
                is Pizza -> pizzaMaker.makePizza(order.number, order.product as Pizza)
                is Coffee -> barista.makeCoffee(order.number, order.product as Coffee)
            }
        }
    }
}