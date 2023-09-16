package be.technifuture.domiapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import be.technifuture.domiapp.model.ExtWithCard
import be.technifuture.domiapp.model.Extension

@Dao
interface ExtensionDao {
    @Query("SELECT * FROM Extension")
    fun getAll(): LiveData<List<Extension>>

    @Query("SELECT * FROM Extension WHERE isBlackList = 0")
    fun getAllNotBlacklist(): LiveData<List<Extension>>

    @Update
    suspend fun updateExtension(users: List<Extension>): Long

    @Query("SELECT * FROM Extension WHERE isBlackList = 0")
    fun getExtWithCard(): LiveData<List<ExtWithCard>>
}
