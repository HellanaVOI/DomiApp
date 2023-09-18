package be.technifuture.domiapp.jsonService

import android.content.res.Resources
import be.technifuture.domiapp.R
import be.technifuture.domiapp.dao.DbBuilder
import be.technifuture.domiapp.model.CardModel
import be.technifuture.domiapp.model.ExtensionModel

object Builder{

    private var extension =  mutableListOf <ExtensionModel>()
    private var card = mutableListOf<CardModel>()
    private var nbrCard: Int = 10

    fun filterList(ext: ExtensionModel, selected: Boolean) {
        if(selected){
            extension.add(ext)
        }else
            extension.remove(ext)
    }

    fun getPoolOfCarte(): Array<CardModel> {
        val choose = mutableListOf<CardModel>()
        val tempList = mutableListOf<CardModel>()


        // Trie des carte vis à vis des Ext selectionner
        extension.forEach { ext ->
            tempList.addAll(card.filter { card ->
                DbBuilder.db
            })
        }

        //TODO: Si pas assez de carte on renvoie un pool de toutes les cartes
        if (tempList.count() < 10){
            tempList.addAll(card)
        }

        for(i in 1..nbrCard){
            val rand = (tempList.indices).random()

            choose.add(tempList[rand])
            tempList.removeAt(rand)
        }
        return choose.sortedBy { it.name }.toTypedArray()
    }

    fun getExtension(): List<ExtensionModel> {
        return extension.filter {
            !it.isBlackList
        }
    }
    fun getAllExtension(): List<ExtensionModel> {
        return extension
    }

    fun getExtensionName(idExtension: String): String? {
        return extension.first {
            it.id == idExtension
        }.name
    }
}