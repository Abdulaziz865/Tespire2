package naclai.ballon.wellin.white.ui.fragments.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentProfileBinding
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
import naclai.ballon.wellin.white.utils.list
import naclai.ballon.wellin.white.utils.timeE
import naclai.ballon.wellin.white.utils.txtNotifications

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnClear.setOnClickListener {
            list.clear()
            Snackbar.make(binding.root, "Данные успешно очищены.", Snackbar.LENGTH_SHORT).show()
        }
    }
}