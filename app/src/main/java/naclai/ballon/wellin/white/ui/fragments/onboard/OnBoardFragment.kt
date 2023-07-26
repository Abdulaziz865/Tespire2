package naclai.ballon.wellin.white.ui.fragments.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentOnBoardBinding
import naclai.ballon.wellin.white.utils.PreferenceHelper

@AndroidEntryPoint
class OnBoardFragment : Fragment(R.layout.fragment_on_board) {

    private val binding by viewBinding(FragmentOnBoardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
        checkPreference()
        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.GONE
    }

    private fun setupListener() {
        binding.btnStart.setOnClickListener {
            PreferenceHelper.isStartApp = true
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment)
        }
    }

    private fun checkPreference() {
        if (PreferenceHelper.isStartApp) {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}