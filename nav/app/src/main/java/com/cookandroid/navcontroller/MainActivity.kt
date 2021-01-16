package com.cookandroid.navcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    var a = ArrayList<Book>()

    class Book(var name: String, var price: Int) {
        fun discount() {
            price-=2000
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = arrayListOf(Book("예림",7000),Book("예림",7000),Book("예림",7000))
        Log.d("test",a[0].name)
        Log.d("test","onCreate 상태")
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar)
                .setupWithNavController(navController, appBarConfiguration)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        Log.d("test", "onStart 상태")
    }

    override fun onResume() {
        super.onResume()
        Log.d("test", "onResume 상태")
    }

    override fun onPause() {
        super.onPause()
        Log.d("test", "onPause 상태")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test", "onStop상태")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test", "onstop상태")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("test", "onRestart상태")
    }
}