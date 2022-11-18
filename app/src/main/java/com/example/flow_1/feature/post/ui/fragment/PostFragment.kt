package com.example.flow_1.feature.post.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.flow_1.R
import com.example.flow_1.feature.post.ui.adapter.PostAdapter

class PostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postAdapter = PostAdapter()
        val rvPostsPostFragment = view.findViewById<RecyclerView>(R.id.rv_posts_postFragment)
        rvPostsPostFragment.adapter = postAdapter

        //TODO : submit list
    }

}