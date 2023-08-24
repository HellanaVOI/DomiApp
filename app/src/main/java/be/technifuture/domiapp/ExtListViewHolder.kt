package be.technifuture.domiapp

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.databinding.ChooseCellBinding
import be.technifuture.domiapp.jsonService.ExtensionModel

class ExtListViewHolder(private var viewBinding: ChooseCellBinding, val onClick: (ExtensionModel, Boolean) -> Unit) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(ext: ExtensionModel) {
        viewBinding.checkBox.text = ext.name
        viewBinding.checkBox.setOnClickListener{
            onClick(ext, viewBinding.checkBox.isChecked)
        }
        //TODO:PICASSO
            viewBinding.iconExtension.setImageResource(R.drawable.alchemy_set)
    }
}

class ExtListAdapter(private var ext: MutableList<ExtensionModel>,private val onClick: (ExtensionModel, Boolean) -> Unit) :
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