package be.technifuture.domiapp.viewHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.databinding.ChooseCellBinding
import be.technifuture.domiapp.jsonService.ExtensionModel


class ExtListViewHolder(private var viewBinding: ChooseCellBinding, val onClick: (ExtensionModel, Boolean) -> Unit) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(ext: ExtensionModel) {
        viewBinding.checkBox.text = ext.name
        viewBinding.checkBox.isChecked = ext.isSelected
        viewBinding.checkBox.setOnClickListener{
            onClick(ext, viewBinding.checkBox.isChecked)
        }

        val context: Context = viewBinding.checkBox.context
        val id = context.resources.getIdentifier(ext.icon, "drawable", context.packageName)
        viewBinding.iconExtension.setImageResource(id)
    }
}

class ExtListAdapter(private var ext: MutableList<ExtensionModel>, private val onClick: (ExtensionModel, Boolean) -> Unit) :
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