package es.sarascript.examenandroid

import QuestionsDao
import android.provider.ContactsContract

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ContactsContract.CommonDataKinds.Note::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionsDao(): QuestionsDao
}

object DatabaseFactory {
    fun get(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
            .build()
    }
}
