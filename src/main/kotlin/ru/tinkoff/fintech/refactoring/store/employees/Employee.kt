package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.ContainerForWork

interface Employee<T : ContainerForWork> {
    val name: String
    val area: Area
        get() = Area.OTHER

    fun work(container: T) {
        start(container)
        finish(container)
    }

    fun start(container: T)

    fun finish(container: T)
}