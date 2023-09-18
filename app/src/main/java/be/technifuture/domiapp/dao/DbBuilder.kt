package be.technifuture.domiapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.technifuture.domiapp.model.CardModel
import be.technifuture.domiapp.model.CardTypeModel
import be.technifuture.domiapp.model.ExtensionModel
import be.technifuture.domiapp.model.TypeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object  DbBuilder {

    private lateinit var db: DomiDatabase

    fun initializeDB(context: Context) : DomiDatabase {
        val db = Room.databaseBuilder(context, DomiDatabase::class.java, "Sample.db")
            .build()

        CoroutineScope(Dispatchers.IO).launch {
            val extension = db.extDao().getAllExt()
            if(extension.isNullOrEmpty()) {
                db.extDao().insertExt(ExtensionModel(name = "base", icon = "dominion1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "base_2", icon = "dominion2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "intrigue", icon = "intrigue1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "intrigue_2", icon = "intrigue2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "seaside", icon = "seaside1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "seaside_2", icon = "seaside2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "alchemy", icon = "alchemy_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "prosperity", icon = "prosperity1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "prosperity_2", icon = "prosperity2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "cornucopia", icon = "cornucopia_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "hinterlands", icon = "hinterlands1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "hinterlands_2", icon = "hinterlands2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "dark_age", icon = "dark_ages_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "guilds", icon = "guilds_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "adventures", icon = "adventures_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "empires", icon = "empires_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "nocturne", icon = "nocturne_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "renaissance", icon = "renaissance_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "menagerie", icon = "menagerie_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "allies", icon = "allies_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "plunder", icon = "plunder", isBlackList = false))
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val card = db.extDao().getAllCard()
            if(extension.isNullOrEmpty()) {
                db.extDao().insertExt(ExtensionModel(name = "base", icon = "dominion1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "base_2", icon = "dominion2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "intrigue", icon = "intrigue1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "intrigue_2", icon = "intrigue2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "seaside", icon = "seaside1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "seaside_2", icon = "seaside2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "alchemy", icon = "alchemy_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "prosperity", icon = "prosperity1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "prosperity_2", icon = "prosperity2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "cornucopia", icon = "cornucopia_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "hinterlands", icon = "hinterlands1stedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "hinterlands_2", icon = "hinterlands2ndedition_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "dark_age", icon = "dark_ages_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "guilds", icon = "guilds_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "adventures", icon = "adventures_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "empires", icon = "empires_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "nocturne", icon = "nocturne_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "renaissance", icon = "renaissance_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "menagerie", icon = "menagerie_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "allies", icon = "allies_set", isBlackList = false))
                db.extDao().insertExt(ExtensionModel(name = "plunder", icon = "plunder", isBlackList = false))
            }
        }
        return db
    }
}

@Database(entities = arrayOf(CardModel::class, ExtensionModel::class, CardTypeModel::class, TypeModel::class), version = 1)
abstract class DomiDatabase : RoomDatabase() {
        abstract fun cardDao(): CardDao
        abstract fun extDao(): ExtensionDao
    }
