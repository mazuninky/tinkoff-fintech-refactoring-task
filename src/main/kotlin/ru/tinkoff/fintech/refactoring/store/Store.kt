//package ru.tinkoff.fintech.refactoring.store
//
//abstract class Store<T>(
//    entities: Map<String, T> = mapOf()
//) {
//    private val entities: MutableMap<String, T> = entities.toMutableMap()
//    fun get(): Map<String, T> {
//        return entities.toMap()
//    }
//
//    fun get(key: String): T? = entities[key]
//}