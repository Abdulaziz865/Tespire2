package naclai.ballon.wellin.white.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import naclai.ballon.wellin.databinding.ItemListBinding
import naclai.ballon.wellin.white.data.model.Model
import naclai.ballon.wellin.white.utils.OnItemClickListener

class RecyclerAdapter4(
    private val itemClickListener: OnItemClickListener
) :
    ListAdapter<Model, RecyclerAdapter4.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Model?) = with(binding) {
            if (model!!.valuable) {
                if (model.many2 < 0) {
                    sum2.text = "model.many2"
                    txtDollars.text = "${model.many2}"
                    txtDollars.setTextColor(Color.parseColor("#FF9696"))
                    txtData.text = model.date2
                    txtCategory.text = model.type2
                    type2.text = model.type2
                    data2.text = model.date2
                    time2.text = model.time2
                    comment2.text = model.comment2
                } else {
                    txtDollars.text = "+${model.many2}"
                    type2.text = model.type2
                    data2.text = model.date2
                    txtData.text = model.date2
                    txtCategory.text = model.type2
                    time2.text = model.time2
                    comment2.text = model.comment2
                }
            } else {
                if (model.many < 0) {
                    txtDollars.text = "${model.many}"
                    txtDollars.setTextColor(Color.parseColor("#FF9696"))
                    txtCategory.text = model.type
                    txtData.text = model.date
                    time.text = model.time
                    comment.text = model.comment
                } else {
                    txtDollars.text = "+${model.many}"
                    txtCategory.text = model.type
                    txtData.text = model.date
                    time.text = model.time
                    comment.text = model.comment
                }
            }
        }

        fun bind(position: Int, clickListener: OnItemClickListener) {
            binding.btnChangeItem.setOnClickListener {
                clickListener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.onBind(it)
        }
        holder.bind(position, itemClickListener)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Model>() {
            override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
                return oldItem == newItem
            }
        }
    }
}