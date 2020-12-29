package com.example.shoppinglist.ui.list

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.database.ShoppingItem
import com.example.shoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository : ShoppingRepository) : ViewModel()  {

    fun upsert (item : ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repository.upsert(item) // We want to start in main thread
    }

    fun delete (item : ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }


    fun getAllShoppingItem() = repository.getAllShoppingItems()


}