package be.technifuture.domiapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import be.technifuture.domiapp.databinding.ActivityMainBinding
import be.technifuture.domiapp.fragment.SelectFragmentDirections


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findNavController(R.id.nav_host_fragment_container).addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.selectFragment -> menuInflater.inflate(R.menu.setting_home, binding)
                R.id.listFragment -> menuInflater.inflate(R.menu.setting_home, binding)
                else -> menuInflater.inflate(R.menu.setting_home, binding)
            }
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.filter) {
            findNavController(R.id.nav_host_fragment_container).navigate(SelectFragmentDirections.actionSelectFragmentToSettingFragment())
        }
        return super.onOptionsItemSelected(item)
    }
}