package be.technifuture.domiapp.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import be.technifuture.domiapp.model.CardAndExtension
import be.technifuture.domiapp.model.ExtensionModel

@Dao
interface CardDao {
    @Transaction
    @Query("SELECT * FROM ExtensionModel WHERE extId = :id")
    suspend fun getCardByExt(id: ExtensionModel): List<CardAndExtension>
}