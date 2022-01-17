package com.example.calc

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calc.dao.HistoryDao
import com.example.calc.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun historyDao() :HistoryDao
}