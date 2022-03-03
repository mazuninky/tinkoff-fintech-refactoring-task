package ru.tinkoff.fintech.refactoring

class CoffeeDepartment()
{
    private val coffeeList = listOf(
        Coffee("эспрессо", 5.0, 5),
        Coffee("капучино", 3.48, 6)
    )
    fun getCoffeeByName(name: String): Coffee? {
        return coffeeList.find { it.name == name }
    }
}
data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    var pizzaMaker: PizzaMaker
)
{
    fun execute()
    {
        pizzaMaker.makePizza(number, pizza)
    }
}

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
    var barista: Barista
)
{
    fun execute()
    {
        barista.makeCoffee(number, coffee)
    }
}
class PizzaDepartment()
{
    private val ingredientList = listOf(
        Ingredient("яйца", 3.48),               //0
        Ingredient("бекон", 6.48),              //1
        Ingredient("тесто", 1.00),              //2
        Ingredient("томат", 1.53),              //3
        Ingredient("оливки", 1.53),             //4
        Ingredient("сыр", 0.98),                //5
        Ingredient("пармезан", 3.98),           //6
        Ingredient("грибы", 3.34),              //7
        Ingredient("спаржа", 3.34),             //8
        Ingredient("мясное ассорти", 9.38),     //9
        Ingredient("вяленая говядина", 12.24),  //10
        Ingredient("салями", 14.24),            //11
        Ingredient("зелень", 2.17),             //12
    )
    private val pizzaList = listOf(
        Pizza("карбонара", listOf(
            ingredientList[0] to 1,
            ingredientList[1] to 2,
            ingredientList[2] to 1,
            ingredientList[5] to 2,
        )),
        Pizza("маринара", listOf(
            ingredientList[3] to 2,
            ingredientList[4] to 3,
            ingredientList[2] to 1,
        )),
        Pizza("сардиния", listOf(
            ingredientList[1] to 3,
            ingredientList[4] to 1,
            ingredientList[2] to 1,
            ingredientList[5] to 3,
        )),
        Pizza("вальтеллина", listOf(
            ingredientList[10] to 1,
            ingredientList[12] to 1,
            ingredientList[2] to 1,
            ingredientList[6] to 2,
        )),
        Pizza("вальтеллина", listOf(
            ingredientList[7] to 3,
            ingredientList[3] to 1,
            ingredientList[2] to 1,
            ingredientList[8] to 1,
            ingredientList[9] to 1,
        )),
    )
    fun getPizzaByName(name: String): Pizza? {
        return pizzaList.find { it.name == name }
    }
}

class PizzaStore {
    var lastOrderNumber = 0

    private val coffeeDepartment = CoffeeDepartment()
    private val pizzaDepartment = PizzaDepartment()

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeDepartment.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(++lastOrderNumber, coffee, barista)
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = pizzaDepartment.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")

        return PizzaOrder(++lastOrderNumber, pizza, pizzaMaker)
    }
}