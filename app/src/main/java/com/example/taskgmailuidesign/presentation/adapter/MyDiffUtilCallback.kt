package com.example.taskgmailuidesign.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.entity.module.User

class MyDiffUtilCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}