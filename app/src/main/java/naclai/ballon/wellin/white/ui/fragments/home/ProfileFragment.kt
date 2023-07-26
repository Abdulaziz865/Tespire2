package naclai.ballon.wellin.white.ui.fragments.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentProfileBinding
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
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
        binding.dialog.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun showCustomDialog() {
        if (cheakDialog) {
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog2, null)

            val txtNotification = dialogView.findViewById<TextView>(R.id.txt_notifications)
            val data = dialogView.findViewById<TextView>(R.id.data)
            val close = dialogView.findViewById<ImageView>(R.id.close)
            val time = dialogView.findViewById<TextView>(R.id.time)

            val dialogBuilder = AlertDialog.Builder(requireContext())
                .setView(dialogView)

            val customDialog = dialogBuilder.create()
            customDialog.show()

            txtNotification.text = txtNotifications
            data.text = dataE
            time.text = timeE
            close.setOnClickListener {
                customDialog.dismiss()
            }
        } else {
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
            val close = dialogView.findViewById<ImageView>(R.id.close)
            val dialogBuilder = AlertDialog.Builder(requireContext())
                .setView(dialogView)

            val customDialog = dialogBuilder.create()
            customDialog.show()

            close.setOnClickListener {
                customDialog.dismiss()
            }
        }
    }
}