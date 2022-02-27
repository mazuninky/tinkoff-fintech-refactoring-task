package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.ContainerForWork

interface Employee <CONTAINER_T : ContainerForWork> {
    val name: String
    fun work(container: CONTAINER_T) {
        start(container)
        finish(container)
    }

    fun start(container: CONTAINER_T)

    fun finish(container: CONTAINER_T)
}