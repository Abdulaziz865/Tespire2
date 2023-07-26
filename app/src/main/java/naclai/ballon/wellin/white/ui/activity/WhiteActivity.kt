package naclai.ballon.wellin.white.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.ActivityWhiteBinding
import naclai.ballon.wellin.white.utils.PreferenceHelper

@AndroidEntryPoint
class WhiteActivity : AppCompatActivity(R.layout.activity_white) {

    private val binding by viewBinding(ActivityWhiteBinding::bind)
    private lateinit var controllerNav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
        initialize()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        controllerNav = navHostFragment.navController

        when (PreferenceHelper.isStartApp) {
            true -> {
                controllerNav.navigate(R.id.homeFragment)
                controllerNav.popBackStack()
                binding.bottomNavigation.visibility = View.GONE
            }

            else -> {
                controllerNav.navigate(R.id.onBoardFragment)
                binding.bottomNavigation.visibility = View.GONE
            }
        }
    }

    private fun initialize() {
        binding.bottomNavigation.setOnItemSelectedListener {
            it.itemId
            when (it.itemId) {
                R.id.home -> {
                    controllerNav.navigate(R.id.homeFragment)
                }

                R.id.profile -> {
                    controllerNav.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }
}