package be.technifuture.domiapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.technifuture.domiapp.dao.CardDao
import be.technifuture.domiapp.dao.ExtensionDao
import be.technifuture.domiapp.model.Extension
import be.technifuture.domiapp.model.Card

@Database(entities = [Extension::class, Card::class], version = 1)
abstract class DominionDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun extDao(): ExtensionDao

    companion object {

        @Volatile
        private var sharedInstance: DominionDatabase? = null

        fun getDB(context: Context): DominionDatabase {
            if (sharedInstance != null) return sharedInstance!!
            synchronized(this) {
                sharedInstance = Room
                    .databaseBuilder(context, DominionDatabase::class.java, "local.db")
                    .fallbackToDestructiveMigration()
                    .build()
                return sharedInstance!!
            }
        }
    }
}
