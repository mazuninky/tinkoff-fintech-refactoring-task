package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.ContainerForWork

abstract class Employee<T : ContainerForWork> {
    abstract val name: String
    open val area: Area
        get() = Area.OTHER

    fun work(container: T) {
        start(container)
        finish(container)
    }

    protected abstract fun start(container: T)

    protected abstract fun finish(container: T)
}