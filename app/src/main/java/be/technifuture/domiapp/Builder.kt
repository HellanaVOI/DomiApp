package be.technifuture.domiapp

import android.content.res.Resources
import be.technifuture.domiapp.jsonService.CardModel
import be.technifuture.domiapp.jsonService.ExtensionModel
import be.technifuture.domiapp.jsonService.JSONReader

class Builder(res: Resources) {

    private val extension: MutableList<ExtensionModel> = JSONReader().getExt(res.openRawResource(R.raw.extension_fr))
    private val card: MutableList<CardModel> = JSONReader().getCard(res.openRawResource(R.raw.card_fr))


    private fun initDeck(): MutableList<Carte> {
        val listCarte = mutableListOf<Carte>()

        //region Ext : Rivage
        listCarte.add(Carte("Ambassadeur", "3", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bateau Pirate", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bazar", "5", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Carte aux Trésors", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Contrebandiers", "3", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Coupeur de bourses", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Embargo", "2", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Entropôt", "3", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Explorateur", "5", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Navigateur", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Plongeur de perles", "2", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Sauveteur", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Sorcière de Mer", "4", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Trèsorie", "5", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Vaisseau Fantôme", "5", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Vigie", "3", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Village indigène", "2", extension[2], listOf(CardType.ACTION)))
        listCarte.add(Carte("Avant-Poste", "5", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Caravane", "4", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Havre", "2", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Navire marchand", "5", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Phare", "2", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Quai", "5", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Tacticien", "5", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Village de Pêcheurs", "3", extension[2], listOf(CardType.DUREE)))
        listCarte.add(Carte("Île", "4", extension[2], listOf(CardType.ACTION, CardType.VICTOIRE)))
        //endregion

        //region Ext : Alchimie
        listCarte.add(Carte("Alchimiste", "3f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Apothicaire", "2f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Apprenti", "5", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bassin divinatoire", "2f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Familier", "3f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Golem", "4f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Herboriste", "2", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Pierre philosophale", "3f", extension[3], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Possession", "6f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Transmutation", "0f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Université", "2f", extension[3], listOf(CardType.ACTION)))
        listCarte.add(Carte("Vignoble", "0f", extension[3], listOf(CardType.VICTOIRE)))
        //endregion

        //region Ext : Prosprité
        listCarte.add(Carte("Mirador", "3", extension[4], listOf(CardType.REACTION)))
        listCarte.add(Carte("Agrandissement", "7", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Banque", "7", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Bureau de comptabilité", "5", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Carrière", "4", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Chambre forte", "5", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Charlatant", "5", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Colporteur", "8*", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Contrebande", "5", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Cour du roi", "7", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Entreprise Risquée", "5", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Evêque", "4", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Fiers-à-bras", "6", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Forge", "7", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Foule", "5", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Grand Marché", "6", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Hôtel de la monnaie", "5", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Magot", "6", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Monument", "6", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Prêt", "3", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Route Commerciale", "3", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Sceau Royal", "5", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Talisman", "4", extension[4], listOf(CardType.TRESOR)))
        listCarte.add(Carte("Village Ouvrier", "4", extension[4], listOf(CardType.ACTION)))
        listCarte.add(Carte("Ville", "5", extension[4], listOf(CardType.ACTION)))
        //endregion

        return listCarte
    }

    fun filterList(ext: Extension, selected: Boolean) {
        extension.first {
            it.id == ext.id
        }.isSelected = selected
    }

    fun getPoolOfCarte(): Array<Carte> {
        val choose = mutableListOf<Carte>()
        val extensionSelected = extension.filter { itExt ->
            itExt.isSelected
        }

        var tempList = card.filter { itCarte ->
            extensionSelected.contains(itCarte.ext)
        }.toMutableList()

        if (tempList.isEmpty())
            tempList = deck

        for(i in 1..10){
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