package be.technifuture.domiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import be.technifuture.domiapp.databinding.FragmentListBinding
import be.technifuture.domiapp.model.CardModel
import be.technifuture.domiapp.viewHolder.CardListAdapter

class ListFragment : Fragment() {

    private val args: ListFragmentArgs by navArgs()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val carteToGame = args.listCard
        setupRecyclerView(carteToGame)
    }

    private fun setupRecyclerView(cardList: Array<CardModel>){
        val recyclerView = binding.cardRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = CardListAdapter(
            cardList.sortedBy {
                it.name
            }.toMutableList()
        )
    }
}