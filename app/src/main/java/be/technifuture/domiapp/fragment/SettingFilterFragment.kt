package be.technifuture.domiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import be.technifuture.domiapp.databinding.FragmentSettingFiltreBinding

class SettingFilterFragment : Fragment() {

    private lateinit var binding: FragmentSettingFiltreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingFiltreBinding.inflate(layoutInflater)
        return binding.root
    }




}