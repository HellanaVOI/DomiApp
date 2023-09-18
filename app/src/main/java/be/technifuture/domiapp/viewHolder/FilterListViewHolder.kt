package be.technifuture.domiapp.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.databinding.FilterCellBinding
import be.technifuture.domiapp.model.ExtensionModel

class FilterListViewHolder {

    class FilterListViewHolder(private var viewBinding: FilterCellBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(ext: ExtensionModel) {

        }
    }

    class FilterListAdapter(private var ext: MutableList<ExtensionModel>) :
        RecyclerView.Adapter<FilterListViewHolder>() {
        private lateinit var binding: FilterCellBinding

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): FilterListViewHolder {
            //charge le layout de la cellule
            binding = FilterCellBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return FilterListViewHolder(binding)
        }

        override fun onBindViewHolder(holder: FilterListViewHolder, position: Int) {
            holder.bind(ext[position])
        }

        //retourne le nbr d'élément à afficher
        override fun getItemCount(): Int {
            return ext.size
        }
    }
}