package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.ContainerForWork

class Cleaner(override val name: String = "Уборщик") : Employee<ContainerForWork>() {
    override fun start(container: ContainerForWork) {
        println("Уборщик.............")
    }

    override fun finish(container: ContainerForWork) {
        println("Уборщик.............")
    }
}