package be.technifuture.domiapp

import android.content.res.Resources
import be.technifuture.domiapp.jsonService.CardModel
import be.technifuture.domiapp.jsonService.ExtensionModel
import be.technifuture.domiapp.jsonService.JSONReader

class Builder(res: Resources) {

    private val extension: MutableList<ExtensionModel> = JSONReader().getExt(res.openRawResource(R.raw.extension_fr))
    private val card: MutableList<CardModel> = JSONReader().getCard(res.openRawResource(R.raw.card_fr))
    private var nbrCard: Int = 10

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

        extensionSelected.forEach { ext ->
            tempList.addAll(card.filter { card ->
              ext.id == card.extension
            })
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
}