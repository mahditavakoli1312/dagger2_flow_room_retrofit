package com.example.flow_1.feature.post.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flow_1.databinding.PostPostfragmentItemBinding
import com.example.flow_1.feature.post.ui.model.PostView

class PostAdapter :
    ListAdapter<PostView, PostAdapter.PostHolder>(PostDiffCallback) {

    class PostHolder(val itemBinding: PostPostfragmentItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        // without data binding

        /*     private val postTitle: TextView =
                 itemView.findViewById(R.id.tv_postTitle_post_postFragment_item)
             private val postBody: TextView =
                 itemView.findViewById(R.id.tv_postBody_post_postFragment_item)*/
        // by data binding
        fun bind(postView: PostView) {
            itemBinding.post = postView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        // with data binding
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostPostfragmentItemBinding.inflate(inflater, parent, false)
        return PostHolder(binding)

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

object PostDiffCallback : DiffUtil.ItemCallback<PostView>() {
    override fun areItemsTheSame(oldItem: PostView, newItem: PostView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostView, newItem: PostView): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}

