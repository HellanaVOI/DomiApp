package be.technifuture.domiapp.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.Extension
import be.technifuture.domiapp.databinding.ChooseCellBinding

class ExtListViewHolder(private var viewBinding: ChooseCellBinding, val onClick: (Extension, Boolean) -> Unit) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(ext: Extension) {
        viewBinding.checkBox.text = ext.name
        viewBinding.checkBox.isChecked = ext.isSelected
        viewBinding.checkBox.setOnClickListener{
            onClick(ext, viewBinding.checkBox.isChecked)
        }
        if (ext.icon != 0)
            viewBinding.iconExtension.setImageResource(ext.icon)
    }
}

class ExtListAdapter(private var ext: MutableList<Extension>, private val onClick: (Extension, Boolean) -> Unit) :
    RecyclerView.Adapter<ExtListViewHolder>() {
    private lateinit var binding: ChooseCellBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExtListViewHolder {
        //charge le layout de la cellule
        binding = ChooseCellBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ExtListViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ExtListViewHolder, position: Int) {
        holder.bind(ext[position])
    }

    //retourne le nbr d'élément à afficher
    override fun getItemCount(): Int {
        return ext.size
    }
}