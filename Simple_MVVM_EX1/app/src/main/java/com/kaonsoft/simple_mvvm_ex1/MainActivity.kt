package com.kaonsoft.simple_mvvm_ex1

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.kaonsoft.simple_mvvm_ex1.base.BaseActivity
import com.kaonsoft.simple_mvvm_ex1.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
                setOf(R.id.mainFragment)
        )
    }

    override fun init() {
        super.init()
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
//        initViewModel()
    }

//    private fun initViewModel() {
//        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.getImageObserver().observe(this, Observer<Bitmap> {
//            findViewById<ImageView>(R.id.imageView).setImageBitmap(it)
//        })
//        viewModel.makeApiCall("4")
//    }
