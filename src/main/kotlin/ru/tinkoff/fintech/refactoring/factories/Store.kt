package ru.tinkoff.fintech.refactoring.factories

abstract class Store<T>(
    protected val data: MutableMap<String, T>
) {
    fun getStore(): Map<String, T> {
        return data.toMap()
    }

    fun get(key: String): T? = data[key]
}