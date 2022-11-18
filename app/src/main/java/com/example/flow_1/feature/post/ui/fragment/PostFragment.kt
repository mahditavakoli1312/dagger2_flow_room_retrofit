package com.example.flow_1.feature.post.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.flow_1.R
import com.example.flow_1.databinding.FragmentPostBinding
import com.example.flow_1.feature.post.ui.adapter.PostAdapter

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_post,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postAdapter = PostAdapter()
        binding.apply {
            rvPostsPostFragment.adapter = postAdapter
        }
        //TODO : submit list
    }

}