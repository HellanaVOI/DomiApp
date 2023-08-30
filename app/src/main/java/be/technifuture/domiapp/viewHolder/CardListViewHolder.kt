package be.technifuture.domiapp.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.Builder
import be.technifuture.domiapp.R
import be.technifuture.domiapp.databinding.ListCellBinding
import be.technifuture.domiapp.jsonService.CardModel
import be.technifuture.domiapp.jsonService.CardType

class CardListViewHolder(private var viewBinding: ListCellBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(card: CardModel) {
        viewBinding.coin.text = card.cout
        viewBinding.fragList.text = card.name
        viewBinding.fragListExt.text = Builder.getExtensionName(card.extension!!)

        if(card.cout?.get(1)  == 'f')
        viewBinding.coin.background = ResourcesCompat.getDrawable(itemView.resources, R.drawable.potion, null)

        viewBinding.type1.setBackgroundColor(cardType(card.type!![0]))
        if(card.type?.size!! > 1){
            viewBinding.type2.setBackgroundColor(cardType(card.type!![1]))
        }else{
            viewBinding.type2.visibility = View.INVISIBLE
        }
    }


    private fun cardType(id: String): Int{
        return when(id){
            "ACTION" ->
                ResourcesCompat.getColor(itemView.resources, R.color.white, null)
            "REACT" ->
                ResourcesCompat.getColor(itemView.resources, R.color.blue_attack, null)
            "TREASURE" ->
                ResourcesCompat.getColor(itemView.resources, R.color.yellow_treasure, null)
            "DURATION" ->
                ResourcesCompat.getColor(itemView.resources, R.color.orange_duree, null)
            "VICTORY" ->
                ResourcesCompat.getColor(itemView.resources, R.color.green_victory, null)
            "NIGHT" ->
                ResourcesCompat.getColor(itemView.resources, R.color.black, null)
            else ->
                ResourcesCompat.getColor(itemView.resources, R.color.purple_700, null)
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