package be.technifuture.domiapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import be.technifuture.domiapp.model.Card
import be.technifuture.domiapp.model.Extension

@Dao
interface CardDao {
    @Query("SELECT * FROM Card")
    fun getAll(): LiveData<List<Card>>

    @Query("SELECT * FROM Card WHERE isBlackList = 0")
    fun getAllNotBlacklist(): LiveData<List<Card>>

    @Update
    suspend fun updateCard(users: List<Card>): Long
}