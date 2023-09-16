package be.technifuture.domiapp.db

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.lifecycle.LiveData
import be.technifuture.domiapp.model.Card
import be.technifuture.domiapp.model.ExtWithCard
import be.technifuture.domiapp.model.Extension
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DominionRepository {
    companion object {
        private var database: DominionDatabase? = null

        private fun initializeDB(context: Context): DominionDatabase {
            val db = DominionDatabase.getDB(context)
            val sharedPref: SharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(context)

            var isFirst = sharedPref.getBoolean("FIRST_LAUNCH", true)

            if (isFirst){

            }else{
                isFirst = false
            }

            /*CoroutineScope(Dispatchers.IO).launch {
                val type = database!!.cardDao().getCount()
                if (type == 0) {
                    expDatabase!!.expenseTypeDao().insert(ExpenseType(name = "RESTAURANT"))
                    expDatabase!!.expenseTypeDao().insert(ExpenseType(name = "CLOTHE"))
                    expDatabase!!.expenseTypeDao().insert(ExpenseType(name = "BILL"))
                    expDatabase!!.expenseTypeDao().insert(ExpenseType(name = "SHOP"))
                }
            }*/
            return db
        }

        /// MARK : Extension

        fun getAllExtension(context: Context): LiveData<List<Extension>> {
            if (database == null) {
                database = initializeDB(context)
            }
            return database!!.extDao().getAll()
        }

        fun getAllExtensionNotBlacklist(context: Context): LiveData<List<Extension>> {
            if (database == null) {
                database = initializeDB(context)
            }
            return database!!.extDao().getAllNotBlacklist()
        }

        fun setBlacklistExtension(context: Context, ext: List<Extension>) {
            if (database == null) {
                database = initializeDB(context)
            }
            ext.forEach {
                it.isBlackList = true
            }
            CoroutineScope(Dispatchers.IO).launch {
                database!!.extDao().updateExtension(ext)
            }
        }


        /// MARK : Extension With Card

        fun getExtWithCard(context: Context): LiveData<List<ExtWithCard>> {
            if (database == null) {
                database = initializeDB(context)
            }
            return database!!.extDao().getExtWithCard()
        }

        /// MARK : Card

        fun setBlacklistCard(context: Context, ext: List<Card>) {
            if (database == null) {
                database = initializeDB(context)
            }
            ext.forEach {
                it.isBlackList = true
            }
            CoroutineScope(Dispatchers.IO).launch {
                database!!.cardDao().updateCard(ext)
            }
        }
    }
}