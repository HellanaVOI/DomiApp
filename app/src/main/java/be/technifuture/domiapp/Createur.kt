package be.technifuture.domiapp

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

class Createur {

    val extension: MutableList<Extension> = initExt().filter {
        !it.isBlackList
    }.toMutableList()
    private val allExtension: MutableList<Extension> = initExt()
    private val deck: MutableList<Carte> = initDeck()

    private fun initExt(): MutableList<Extension> {
        val listExt = mutableListOf<Extension>()
        listExt.add(Extension(0, "Base", R.drawable.dominion1stedition_set, false))
        listExt.add(Extension(1, "Intrigue", R.drawable.intrigue1stedition_set, false))
        listExt.add(Extension(2, "Rivages", R.drawable.seaside1stedition_set, false))
        listExt.add(Extension(3, "Alchimie", R.drawable.alchemy_set, false))
        listExt.add(Extension(4, "Prospérité", R.drawable.prosperity1stedition_set, false))
        listExt.add(Extension(5, "Abondance",  R.drawable.alchemy_set, false))
        listExt.add(Extension(6, "Arrière Pays", R.drawable.hinterlands1stedition_set, false))
        listExt.add(Extension(7, "L'Âge des ténèbres", R.drawable.dark_ages_set, false))
        listExt.add(Extension(8, "Guildes", R.drawable.guilds_set, false))
        listExt.add(Extension(9, "Aventures", R.drawable.adventures_set, false))
        listExt.add(Extension(10, "Empires", R.drawable.empires_set, false))
        listExt.add(Extension(11, "Nocturne", R.drawable.nocturne_set, false))
        listExt.add(Extension(12, "Renaissance", R.drawable.renaissance_set, false))
        listExt.add(Extension(13, "Ménagerie", R.drawable.menagerie_set, false))

        return listExt
    }

    private fun initDeck(): MutableList<Carte> {
        val listCarte = mutableListOf<Carte>()

        //region Jeu de Base
        listCarte.add(Carte("Douves", "2", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Atelier", "3", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Aventurier", "6", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bibliothéque", "5", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bucheron", "3", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Bureaucrate", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Cave", "2", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Chambre du conseil", "5", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Chancelier", "3", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Chapelle", "2", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Espion", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Festin", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Festival", "5", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Forgeron", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Laboratoire", "5", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Maché", "5", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Milice", "4", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Mine", "5", extension[0], listOf(CardType.REACTION)))
        listCarte.add(Carte("Preteur sur Gages", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Rénovation", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Salle du Throne", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Sorcière", "5", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Village", "3", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Voleur", "4", extension[0], listOf(CardType.ACTION)))
        listCarte.add(Carte("Jardin", "4", extension[0], listOf(CardType.VICTOIRE)))
        //endregion

        //region Ext : Intrigue
        listCarte.add(Carte("Baron", "4", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Bourreau", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Chambre secrète", "2", extension[1], listOf(CardType.REACTION)))
        listCarte.add(Carte("Chaudronnier", "4", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Comptoir ", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Conspirateur", "4", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Cour", "2", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Duc", "5", extension[1], listOf(CardType.VICTOIRE)))
        listCarte.add(Carte("Eclaireur", "4", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Escroc", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Fonderie", "4", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Grand hall", "3", extension[1], listOf(CardType.ACTION, CardType.VICTOIRE)))
        listCarte.add(Carte("Harem", "6", extension[1], listOf(CardType.TRESOR, CardType.VICTOIRE)))
        listCarte.add(Carte("Hommage", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Intendant", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Larbin", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Mascarade", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Mise à niveau", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Nobles", "6", extension[1], listOf(CardType.ACTION, CardType.VICTOIRE)))
        listCarte.add(Carte("Pion", "2", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Pont", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Saboteur", "5", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Puits aux souhaits", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Taudis", "3", extension[1], listOf(CardType.ACTION)))
        listCarte.add(Carte("Village minier", "4", extension[1], listOf(CardType.ACTION)))
        //endregion

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

        var tempList = deck.filter { itCarte ->
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

        /*
        while (choose.size < 10) {
            val carte = tempList.random()

            if (!choose.contains(carte)) {
                choose.add(carte)
                Log.d("SELECTED_CARD", carte.name)
            }
        }
        return choose.sortedBy { it.name }.toTypedArray()
        */



    }
}