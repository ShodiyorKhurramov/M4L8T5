package com.example.m4l8t5.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l8t5.R
import com.example.m4l8t5.model.User


class UserAdapter(private val userList: List<User>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.iv_user)
        val name: TextView = view.findViewById(R.id.tv_user_name)
        val username: TextView = view.findViewById(R.id.tv_user_username)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]

        if (holder is UserViewHolder) {
            holder.apply {
                photo.setImageResource(user.photo)
                name.text = user.name
                username.text = user.username
            }
        }

    }

    override fun getItemCount() = userList.size
}