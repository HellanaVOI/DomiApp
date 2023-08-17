package be.technifuture.domiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import be.technifuture.domiapp.viewHolder.CardListAdapter
import be.technifuture.domiapp.databinding.FragmentListBinding

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

    private fun setupRecyclerView(cardList: Array<Carte>){
        val recyclerView = binding.cardRecyclerView

        //recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = CardListAdapter(
            cardList.sortedBy {
                it.name
            }.toMutableList()
        )
    }
}