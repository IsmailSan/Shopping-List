package com.example.shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [ShoppingItem::class],  //array
    version = 1  //version of database
)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun  getShoppingDAO() : ShoppingDao //make sure access the database

    companion object {
        @Volatile  //intance will be made visible to other threads
        private var instance : ShoppingDatabase?= null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {    // This function will be executed whenever we create an instance
              instance
                  ?: createDatabase(context)
                      .also { instance = it }
        }

        private fun createDatabase (context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java,"Shoppingdb").build()
    }
}