package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.employee.Barista
import ru.tinkoff.fintech.refactoring.employee.BaristaImpl
import ru.tinkoff.fintech.refactoring.employee.PizzaMaker
import ru.tinkoff.fintech.refactoring.employee.PizzaMakerImpl
import ru.tinkoff.fintech.refactoring.menu.*

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double
)

data class CoffeeOrder(
    val number: Int,
    val pizza: Coffee,
)

class PizzaStore {

    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMakerImpl()
    private val barista: Barista = BaristaImpl()
    private val coffeeDAO: CoffeeDAO = CoffeeDAOImpl()
    private val pizzaDAO: PizzaDAO = PizzaDAOImpl()
    private val ingredientDAO: IngredientDAO = IngredientDAOImpl()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeDAO.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            pizza = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {

        val pizza = pizzaDAO.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")
        val ingredients = pizzaDAO.getIngredientsOfPizza(name)
            ?: error("Неизвестный вид пиццы!")
        var pizzaPrice = 0.0
        ingredients.forEach { ingredientNameAndCount ->

            val ingredient = ingredientDAO.getIngredientByName(ingredientNameAndCount.first)
                ?: error("Неизвестный вид ингридиента!")
            val ingredientCount = ingredientNameAndCount.second

            pizzaPrice += ingredient.price * ingredientCount
        }

        return PizzaOrder(

            number = ++orderNumber,
            pizza = pizza,
            price = pizzaPrice
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {

        if (pizzaOrder != null && pizzaDAO.getIngredientsOfPizza(pizzaOrder.pizza.name) != null) {

            pizzaMaker.makePizza(
                pizzaOrder.number,
                pizzaOrder.pizza,
                pizzaDAO.getIngredientsOfPizza(pizzaOrder.pizza.name)!!
            )
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder.number, coffeeOrder.pizza)
        }
    }
}