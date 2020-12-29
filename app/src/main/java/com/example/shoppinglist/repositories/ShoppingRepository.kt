package com.example.shoppinglist.repositories

import com.example.shoppinglist.database.ShoppingDatabase
import com.example.shoppinglist.database.ShoppingItem

class ShoppingRepository (private val db : ShoppingDatabase) {
    suspend fun upsert(item : ShoppingItem) = db.getShoppingDAO().upsert(item)

    suspend fun delete(item: ShoppingItem)= db.getShoppingDAO().delete(item)

    fun getAllShoppingItems() = db.getShoppingDAO().getAllShoppingItems()
}