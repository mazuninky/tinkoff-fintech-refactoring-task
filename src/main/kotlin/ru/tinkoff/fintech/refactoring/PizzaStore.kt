package ru.tinkoff.fintech.refactoring

// В данной ситуации не совсем понятно, как поступить с одной стороны в интерфейс можно сразу вставить исполнителя
// заказа и метод, который будет выполнять этот заказ ( в данной ситуации смогу избавится от switch в executeOrder),
// с другой стороны - это сильно связывает классы


class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()
    private val coffeeStore = CoffeeStore()
    private var receipt = Receipt(orderNumber)

    fun makeNewOrder() {
        receipt = Receipt(orderNumber)
        receipt.makeNewOrder()
        orderNumber += 1
    }

    fun orderCoffee(name: String) {
        val coffee = coffeeStore.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        receipt.addPoint2Receipt(Order(
            number = orderNumber,
            product = coffee
        ))
    }

    fun orderPizza(pizza : Pizza) {
        pizza.getIngredient().forEach { ingredient ->

            val price = PizzaIngredients.getIngredientPrice(ingredient.name)
            pizza.price += price * ingredient.amount
        }

        receipt.addPoint2Receipt(Order(
            number = orderNumber,
            product = pizza
        ))
    }

    fun executeOrder() {
        val orderList = receipt.getPoints()
        for (order in orderList) {
            when (order.product) {
                is Pizza -> pizzaMaker.makePizza(order.number, order.product)
                is Coffee -> barista.makeCoffee(order.number, order.product)
            }
        }
        receipt.printReceipt()
        println("Заказ $orderNumber готов")
    }
}