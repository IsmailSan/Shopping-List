package com.example.shoppinglist.ui.list

import com.example.shoppinglist.database.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)

}