package naclai.ballon.wellin.white.ui.fragments.item

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentHistoryBinding
import naclai.ballon.wellin.white.data.model.Model
import naclai.ballon.wellin.white.ui.adapters.RecyclerAdapter
import naclai.ballon.wellin.white.ui.adapters.RecyclerAdapter2
import naclai.ballon.wellin.white.ui.adapters.RecyclerAdapter3
import naclai.ballon.wellin.white.ui.adapters.RecyclerAdapter4
import naclai.ballon.wellin.white.ui.fragments.home.HomeFragmentDirections
import naclai.ballon.wellin.white.utils.OnItemClickListener
import naclai.ballon.wellin.white.utils.cheakDialog
import naclai.ballon.wellin.white.utils.dataE
import naclai.ballon.wellin.white.utils.list
import naclai.ballon.wellin.white.utils.timeE
import naclai.ballon.wellin.white.utils.txtNotifications

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history), OnItemClickListener {

    private val binding by viewBinding(FragmentHistoryBinding::bind)
    private val navArgs by navArgs<HistoryFragmentArgs>()
    private val list2 = mutableListOf<Model>()
    private val list3 = mutableListOf<Model>()
    private val adapter = RecyclerAdapter4(this)
    private val adapter2 = RecyclerAdapter2(this)
    private val adapter3 = RecyclerAdapter3(this)
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
            adapter2.submitList(list)
            adapter2.notifyDataSetChanged()
            adapter3.submitList(list)
            adapter3.notifyDataSetChanged()
        }

        binding.rvList.adapter = adapter
        adapter.submitList(list)
        adapter.notifyDataSetChanged()

        binding.rvList2.adapter = adapter2
        list.forEach { item ->
            if (item.valuable) {
                list2.add(item)
            }
        }
        adapter2.submitList(list2)
        adapter2.notifyDataSetChanged()

        binding.rvList3.adapter = adapter3
        list.forEach { item ->
            if (!item.valuable) {
                list3.add(item)
            }
        }
        adapter3.submitList(list3)
        adapter3.notifyDataSetChanged()
    }

    private fun setupListener() {
        binding.btnR.setOnClickListener {
            binding.con2.visibility = View.VISIBLE
            binding.con1.visibility = View.INVISIBLE
            binding.con3.visibility = View.INVISIBLE
        }
        binding.btnD.setOnClickListener {
            binding.con2.visibility = View.INVISIBLE
            binding.con1.visibility = View.INVISIBLE
            binding.con3.visibility = View.VISIBLE
        }
        binding.btnAll2.setOnClickListener {
            binding.con2.visibility = View.INVISIBLE
            binding.con1.visibility = View.VISIBLE
            binding.con3.visibility = View.INVISIBLE
        }
        binding.btnD2.setOnClickListener {
            binding.con2.visibility = View.INVISIBLE
            binding.con1.visibility = View.INVISIBLE
            binding.con3.visibility = View.VISIBLE
        }
        binding.btnR3.setOnClickListener {
            binding.con2.visibility = View.VISIBLE
            binding.con1.visibility = View.INVISIBLE
            binding.con3.visibility = View.INVISIBLE
        }
        binding.btnAll3.setOnClickListener {
            binding.con2.visibility = View.INVISIBLE
            binding.con1.visibility = View.VISIBLE
            binding.con3.visibility = View.INVISIBLE
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    override fun onItemClick(position: Int) {
        val clickedItem = list[position]
        positionItem = position

        findNavController().navigate(
            HistoryFragmentDirections.actionHistoryFragmentToChangeFragment(
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
        adapter2.notifyDataSetChanged()
        adapter3.notifyDataSetChanged()
    }
}