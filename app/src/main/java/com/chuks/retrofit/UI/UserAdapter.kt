package com.chuks.retrofit.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chuks.retrofit.databinding.UserItemBinding
import com.chuks.retrofit.model.User

class UserAdapter (var users: List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    class UserViewHolder(private val binding : UserItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind (user:User){
                 binding.apply {
                     NameText.text = user.name
                     EmailText.text = user.email
                     StreetText.text = user.address.street
                 }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder((binding))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val show = users[position]
     holder.bind(show)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}