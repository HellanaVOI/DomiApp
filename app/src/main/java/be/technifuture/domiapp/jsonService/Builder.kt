package be.technifuture.domiapp.jsonService

import android.content.res.Resources
import be.technifuture.domiapp.R

object Builder{

    private var extension =  mutableListOf <ExtensionModel>()
    private var card = mutableListOf<CardModel>()
    private var nbrCard: Int = 10

    fun startBuild(res: Resources){
        extension = JSONReader.getExt(res.openRawResource(R.raw.extension_fr))
        card = JSONReader.getCard(res.openRawResource(R.raw.card_fr))
    }

    fun filterList(ext: ExtensionModel, selected: Boolean) {
        extension.first {
            it.id == ext.id
        }.isSelected = selected
    }

    fun getPoolOfCarte(): Array<CardModel> {
        val choose = mutableListOf<CardModel>()
        val tempList = mutableListOf<CardModel>()
        val extensionSelected = extension.filter { itExt ->
            itExt.isSelected
        }

        // Trie des carte vis à vis des Ext selectionner
        extensionSelected.forEach { ext ->
            tempList.addAll(card.filter { card ->
              ext.id == card.extension
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