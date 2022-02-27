package ru.tinkoff.fintech.refactoring.store.employees

enum class Area(val correctWorkerClazz: Class<out Employee<*>>) {
    FOOD(CafeWorker::class.java),
    OTHER(Employee::class.java)
}