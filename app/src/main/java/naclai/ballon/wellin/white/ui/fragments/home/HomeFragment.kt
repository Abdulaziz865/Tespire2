package naclai.ballon.wellin.white.ui.fragments.home

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentHomeBinding
import naclai.ballon.wellin.white.ui.adapters.RecyclerAdapter
import naclai.ballon.wellin.white.utils.OnItemClickListener
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
import naclai.ballon.wellin.white.utils.list
import naclai.ballon.wellin.white.utils.timeE
import naclai.ballon.wellin.white.utils.txtNotifications

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), OnItemClickListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val adapter = RecyclerAdapter(this)
    private lateinit var bottomNavigationView: BottomNavigationView
    private val navArgs by navArgs<HomeFragmentArgs>()
    private var positionItem: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        if (navArgs.position == "1") {
            list[positionItem].many = navArgs.summa
            list[positionItem].date = navArgs.data
            list[positionItem].time = navArgs.time
            list[positionItem].type = navArgs.type
            list[positionItem].comment = navArgs.comment
            list[positionItem].many2 = navArgs.summa2
            list[positionItem].date2 = navArgs.data2
            list[positionItem].type2 = navArgs.type2
            list[positionItem].time2 = navArgs.time2
            list[positionItem].comment2 = navArgs.comment2
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }
//
        binding.rvList.adapter = adapter
        adapter.submitList(list)
        adapter.notifyDataSetChanged()

        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation)
        bottomNavigationView.visibility = View.VISIBLE

        binding.progressBar.apply {
            progress = 100f
            setProgressWithAnimation(0F, 9120)
            progressBarWidth = 12f
            backgroundProgressBarWidth = 9f
            progressBarColor = Color.parseColor("#FFCA43")
        }
    }

    private fun setupListener() {
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
            bottomNavigationView.visibility = View.GONE
        }
        binding.txtMore.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
            bottomNavigationView.visibility = View.GONE
        }
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

    override fun onItemClick(position: Int) {
        val clickedItem = list[position]
        positionItem = position

        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToChangeFragment(
                clickedItem.many,
                clickedItem.date,
                clickedItem.type,
                clickedItem.time,
                clickedItem.comment,
                clickedItem.many2,
                clickedItem.date2,
                clickedItem.type2,
                clickedItem.time2,
                clickedItem.comment2
            )
        )
        adapter.notifyDataSetChanged()
        bottomNavigationView.visibility = View.GONE
    }
}