package com.example.general.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.general.data.models.Model
import com.example.general.databinding.RecyclerviewItemBinding
import com.example.general.util.ItemClick

class RecyclerAdapter :
    ListAdapter<Model, RecyclerAdapter.ViewHolder>(DiffUtilCallBack) {

    lateinit var itemClick: ItemClick
    fun onItemClickListener(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Model) {
            binding.tvText1.text = model.name
            binding.tvText2.text = model.surname
            itemView.setOnClickListener {
                itemClick.onItemClickListener(model)
            }
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }
    }
}

