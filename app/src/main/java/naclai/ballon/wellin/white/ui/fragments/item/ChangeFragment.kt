package naclai.ballon.wellin.white.ui.fragments.item

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentChangeBinding
import naclai.ballon.wellin.white.ui.adapters.CustomArrayAdapter
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
import naclai.ballon.wellin.white.utils.timeE
import naclai.ballon.wellin.white.utils.txtNotifications

@AndroidEntryPoint
class ChangeFragment : Fragment(R.layout.fragment_change) {

    private val binding by viewBinding(FragmentChangeBinding::bind)
    private val navArgs by navArgs<ChangeFragmentArgs>()
    private var consumptionCheck = false
    private var selectedItem = "Другие"
    private var selectedItem2 = "Другие"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() = with(binding) {
        val adapter = context?.let {
            CustomArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.spinner_values)
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner2.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem = binding.spinner.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem2 = binding.spinner2.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        etSumma.setText(navArgs.summa.toString())
        etDate.setText(navArgs.data)
        etTime.setText(navArgs.time)
        spinner.setSelection(2)
        etComment.setText(navArgs.comment)
        etSumma2.setText(navArgs.summa2.toString())
        etDate2.setText(navArgs.data2)
        spinner2.setSelection(3)
        etTime2.setText(navArgs.time2)
        etComment2.setText(navArgs.comment2)
    }

    private fun setupListener() {
        binding.dialog.setOnClickListener {
            showCustomDialog()
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        binding.btnConsumption.setOnClickListener {
            consumptionCheck = true
            binding.constraint1.visibility = View.INVISIBLE
            binding.constraint2.visibility = View.VISIBLE
        }
        binding.btnConsumption2.setOnClickListener {
            consumptionCheck = false
            binding.constraint1.visibility = View.VISIBLE
            binding.constraint2.visibility = View.INVISIBLE
        }
        binding.btnSaveItem.setOnClickListener {
            val t1 = binding.etSumma.text.toString().toInt()
            val t2 = binding.etDate.text.toString()
            val t3 = binding.etTime.text.toString()
            val t4 = selectedItem
            val t5 = binding.etComment.text.toString()
            val t6 = binding.etSumma2.text.toString().toInt()
            val t7 = binding.etDate2.text.toString()
            val t8 = selectedItem2
            val t9 = binding.etTime2.text.toString()
            val t10 = binding.etComment2.text.toString()

            findNavController().navigate(
                ChangeFragmentDirections.actionChangeFragmentToHomeFragment(
                    summa = t1,
                    data = t2,
                    time = t3,
                    type = t4,
                    comment = t5,
                    summa2 = t6,
                    data2 = t7,
                    type2 = t8,
                    time2 = t9,
                    comment2 = t10,
                    position = "1"
                )
            )
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