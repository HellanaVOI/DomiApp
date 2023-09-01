package be.technifuture.domiapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import be.technifuture.domiapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolBarCustom
        binding.toolBarCustom.menuIcon.setOnClickListener {

            val action = R.id.action_selectFragment_to_menuFragment
            //val direction = SelectFragmentDirections.actionSelectFragmentToMenuFragment()
            //findNavController().navigate(action)
        }


        setSupportActionBar(toolbar.mainToolbar)

    }
}