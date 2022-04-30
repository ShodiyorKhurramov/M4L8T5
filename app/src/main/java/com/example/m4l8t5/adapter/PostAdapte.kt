package com.example.m4l8t5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l8t5.R
import com.example.m4l8t5.model.Post


class PostAdapter(private val posts: List<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile: ImageView = view.findViewById(R.id.iv_poster_photo)
        val name: TextView = view.findViewById(R.id.tv_poster_name)
        val location: TextView = view.findViewById(R.id.tv_poster_location)
        val post: ImageView = view.findViewById(R.id.posters_post)
        val like: ImageView = view.findViewById(R.id.post_like)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentPost = posts[position]

        if (holder is PostViewHolder) {
            holder.apply {
                var isLiked = false
                profile.setImageResource(currentPost.posterPhoto)
                name.text = currentPost.posterName
                location.text = currentPost.posterLocation
                post.setImageResource(currentPost.posterPost)
                like.setOnClickListener {
                    if (!isLiked) {
                        isLiked = true
                        like.setImageResource(R.drawable.like_pressed)
                    } else {
                        isLiked = true
                        like.setImageResource(R.drawable.like)
                    }
                }
            }
        }

    }

    override fun getItemCount() = posts.size
}