package be.technifuture.domiapp

import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import be.technifuture.domiapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolBarCustom
        setSupportActionBar(toolbar.mainToolbar)

    }

    fun showPopup(v: View) {
        PopupMenu(this, v).apply {
            // MainActivity implements OnMenuItemClickListener
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.language -> {
                        Log.d("DEBUG", "1er Choix")
                        true
                    }
                    R.id.filter -> {
                        Log.d("DEBUG", "2e Choix")
                        true
                    }
                    else -> false
                }
            }
            inflate(R.menu.action)
            show()
        }
    }

}