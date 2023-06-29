package com.example.taskgmailuidesign.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.module.User
import com.example.taskgmailuidesign.R
import com.example.taskgmailuidesign.databinding.ItemRecBinding

class MassageAdapter : ListAdapter<User, MassageAdapter.ViewHolder>(MyDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))

    }

    inner class ViewHolder(itemView: ItemRecBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bindData(data: User) {
            itemView.findViewById<AppCompatTextView>(R.id.name).text = data.username
            itemView.findViewById<AppCompatTextView>(R.id.massage).text = data.token
        }
    }
}