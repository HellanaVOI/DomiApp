package be.technifuture.domiapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import be.technifuture.domiapp.model.ExtensionModel

@Dao
interface ExtensionDao {
    @Transaction
    @Query("SELECT * FROM ExtensionModel")
    suspend fun getAllExt(): List<ExtensionModel>

    @Transaction
    @Query("SELECT * FROM ExtensionModel WHERE isBlackList = 0")
    suspend fun getWhiteExt(): List<ExtensionModel>

    @Transaction
    @Insert(onConflict = OnConflictStrategy .REPLACE)
    fun insertExt(book: ExtensionModel)
}