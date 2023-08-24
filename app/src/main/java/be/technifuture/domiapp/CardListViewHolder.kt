package be.technifuture.domiapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.databinding.ListCellBinding
import be.technifuture.domiapp.jsonService.CardModel
import be.technifuture.domiapp.jsonService.CardType

class CardListViewHolder(private var viewBinding: ListCellBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(card: CardModel) {
        viewBinding.coin.text = card.cout
        viewBinding.fragList.text = card.name
        viewBinding.fragListExt.text = card.extension

        viewBinding.type1.setBackgroundColor(
            ResourcesCompat.getColor(
                itemView.resources,
                when (card.cardType(0)) {
                    CardType.ACTION -> R.color.white
                    CardType.REACTION -> R.color.blue_attack
                    CardType.TRESOR -> R.color.yellow_treasure
                    CardType.DUREE -> R.color.orange_duree
                    CardType.VICTOIRE -> R.color.green_victory
                }, null
            )
        )

        if(card.type?.size!! > 1){
            viewBinding.type2.setBackgroundColor(
                ResourcesCompat.getColor(
                    itemView.resources,
                    when (card.cardType(1)) {
                        CardType.ACTION -> R.color.white
                        CardType.REACTION -> R.color.blue_attack
                        CardType.TRESOR -> R.color.yellow_treasure
                        CardType.DUREE -> R.color.orange_duree
                        CardType.VICTOIRE -> R.color.green_victory
                    }, null
                )
            )
        }else{
            viewBinding.type2.visibility = View.INVISIBLE
        }



    }
}

class CardListAdapter(private var card: MutableList<CardModel>) :
    RecyclerView.Adapter<CardListViewHolder>() {
    private lateinit var binding: ListCellBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardListViewHolder {
        //charge le layout de la cellule
        binding = ListCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CardListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        holder.bind(card[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return card.size
    }
}