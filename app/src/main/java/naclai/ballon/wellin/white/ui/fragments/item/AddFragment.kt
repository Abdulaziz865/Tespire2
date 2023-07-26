package naclai.ballon.wellin.white.ui.fragments.item

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentAddBinding
import naclai.ballon.wellin.white.data.model.Model
import naclai.ballon.wellin.white.ui.adapters.CustomArrayAdapter
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
import naclai.ballon.wellin.white.utils.list
import naclai.ballon.wellin.white.utils.timeE
import naclai.ballon.wellin.white.utils.txtNotifications

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.fragment_add) {

    private val binding by viewBinding(FragmentAddBinding::bind)
    private var consumptionCheck = false
    private var sum = 0
    private var date = ""
    private var type = ""
    private var time = ""
    private var comment = ""
    private var sum2 = 0
    private var date2 = ""
    private var type2 = ""
    private var time2 = ""
    private var comment2 = ""
    private var selectedItem = "Другие"
    private var selectedItem2 = "Другие"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
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
    }

    private fun setupListener() {
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
        binding.btnAddItem.setOnClickListener {
            if (!consumptionCheck) {
                if (binding.etSumma.text.isEmpty() && binding.etDate.text.isEmpty() && binding.etTime.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etSumma.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etDate.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etTime.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else {
                    sum = if (binding.etSumma.text.toString() == "") {
                        0
                    } else {
                        binding.etSumma.text.toString().toInt()
                    }
                    date = binding.etDate.text.toString()
                    type = selectedItem
                    time = binding.etTime.text.toString()
                    comment = binding.etComment.text.toString()

                    list.add(
                        Model(
                            sum,
                            date,
                            type,
                            time,
                            comment,
                            sum2,
                            date2,
                            type2,
                            time2,
                            comment2,
                            consumptionCheck
                        )
                    )

                    findNavController().navigate(R.id.homeFragment)
                }
            } else {
                if (binding.etSumma2.text.isEmpty() && binding.etDate2.text.isEmpty() && binding.etTime2.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etSumma2.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etDate2.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else if (binding.etTime2.text.isEmpty()) {
                    Snackbar.make(binding.root, "Заполните поле", Snackbar.LENGTH_SHORT).show()
                } else {
                    sum2 = if (binding.etSumma2.text.toString() == "") {
                        0
                    } else {
                        binding.etSumma2.text.toString().toInt()
                    }
                    date2 = binding.etDate2.text.toString()
                    type2 = selectedItem2
                    time2 = binding.etTime2.text.toString()
                    comment2 = binding.etComment2.text.toString()

                    list.add(
                        Model(
                            sum,
                            date,
                            type,
                            time,
                            comment,
                            sum2,
                            date2,
                            type2,
                            time2,
                            comment2,
                            consumptionCheck
                        )
                    )

                    findNavController().navigate(R.id.homeFragment)
                }
            }

            if (date == "" && time == "") {
                txtNotifications = "В прошлом месяце вы \n сэкономили ${sum2}."
                dataE = date2
                timeE = time2
                cheakDialog = true
            } else {
                txtNotifications = "В прошлом месяце вы \n сэкономили ${sum}."
                dataE = date
                timeE = time
                cheakDialog = true
            }
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}