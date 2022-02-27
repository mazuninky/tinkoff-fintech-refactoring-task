package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.CafeContainer

abstract class CafeWorker<CONTAINER_T : CafeContainer>(
    final override val name: String
) : Employee<CONTAINER_T> {
    final override fun finish(container: CONTAINER_T) {
        print("[$name] заказ ${container.orderId} готов")
    }
}