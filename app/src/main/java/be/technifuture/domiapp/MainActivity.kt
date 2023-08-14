package be.technifuture.domiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import be.technifuture.domiapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        //tool bar
        val toolbar = findViewById<Toolbar>(R.id.toolbar_)
        val navController = findNavController(R.id.nav_host_fragment_container)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(
            this, navController, AppBarConfiguration(
                setOf(
                    R.id.selectFragment
                )
            )
        )

        navController.addOnDestinationChangedListener{ controller, destination, arguments ->
            when(destination.id){
                R.id.selectFragment -> {
                    binding.toolbarTitle.setText("Choix de l'extension")
                }
                R.id.listFragment -> {
                    binding.toolbarTitle.setText("Mélange de carte")
                }
                else -> binding.toolbarTitle.setText("")
            }

        }

        NavigationUI.setupActionBarWithNavController(this, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }
}