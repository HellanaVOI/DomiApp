package be.technifuture.domiapp

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

class SelectFragment : Fragment() {

    val builder = Createur()
    lateinit var binding: FragmentSelectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView(builder.extension)

        binding.buttonSelect.setOnClickListener {

            val direction = SelectFragmentDirections.actionSelectFragmentToListFragment(builder.getPoolOfCarte())
            findNavController().navigate(direction)
        }
    }




    private fun setupRecyclerView(cardList: List<Extension>) {
        val recyclerView = binding.extRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        recyclerView.adapter = ExtListAdapter(cardList.toMutableList()){ext, selected ->
            builder.filterList(ext, selected)

            //val direction = SelectFragmentDirections.actionSelectFragmentToListFragment(builder.getPoolOfCarte())
            //findNavController().navigate(direction)
        }
    }
}

