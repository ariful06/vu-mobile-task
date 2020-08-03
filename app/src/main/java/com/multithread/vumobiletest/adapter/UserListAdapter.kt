package com.multithread.vumobiletest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.multithread.vumobiletest.databinding.ItemUserBinding
import com.multithread.vumobiletest.listener.ItemClickListener
import com.multithread.vumobiletest.model.dto.User
import com.multithread.vumobiletest.model.repository.UserAsync
import com.multithread.vumobiletest.viewmodel.UserViewModel

class UserListAdapter (var items: List<User>, var viewModel: UserViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemClickListener {

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemUserBinding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateWiseHolder(binding)

    }

    override
    fun getItemCount(): Int {
        return items.size
    }

    override
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dateWiseHolder = holder as DateWiseHolder
        dateWiseHolder.binding.item = items[position]
        dateWiseHolder.binding.listener = this
    }



    private fun setList(items: List<User>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun replaceData(items: List<User>) {
        setList(items)
    }


    class DateWiseHolder(var binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onUserClicked(user: User) {
        viewModel.userItemClickSingleLiveEvent?.value = user
    }

}