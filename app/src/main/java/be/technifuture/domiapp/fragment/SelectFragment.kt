package be.technifuture.domiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.domiapp.viewHolder.ExtListAdapter
import be.technifuture.domiapp.databinding.FragmentSelectBinding
import be.technifuture.domiapp.jsonService.Builder
import be.technifuture.domiapp.jsonService.ExtensionModel

class SelectFragment : Fragment() {

    private lateinit var binding: FragmentSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Builder.startBuild(resources)
        setupRecyclerView(Builder.getExtension())


        binding.buttonSelect.setOnClickListener {
            val direction = SelectFragmentDirections.actionSelectFragmentToListFragment(Builder.getPoolOfCarte())
            findNavController().navigate(direction)
        }
    }

    private fun setupRecyclerView(cardList: List<ExtensionModel>) {
        val recyclerView = binding.extRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        recyclerView.adapter = ExtListAdapter(cardList.toMutableList()){ext, selected ->
            Builder.filterList(ext, selected)
        }
    }
}

