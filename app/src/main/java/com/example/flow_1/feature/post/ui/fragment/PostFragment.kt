package com.example.flow_1.feature.post.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flow_1.R
import com.example.flow_1.core.common.DaggerApp
import com.example.flow_1.core.di.component.DaggerContextComponent
import com.example.flow_1.core.di.component.DaggerNetworkComponent
import com.example.flow_1.core.di.component.DaggerRoomComponent
import com.example.flow_1.databinding.FragmentPostBinding
import com.example.flow_1.feature.post.di.DaggerPostComponent
import com.example.flow_1.feature.post.ui.adapter.PostAdapter
import com.example.flow_1.feature.post.ui.viewModel.PostViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PostFragment"

class PostFragment : Fragment() {
    @Inject
    lateinit var postViewModel: PostViewModel

    private lateinit var binding: FragmentPostBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val contextComponent = DaggerContextComponent.factory().create(
            app =
            (requireActivity().application as DaggerApp)
        )
        val roomComponent =
            DaggerRoomComponent.factory().create(contextComponent = contextComponent)
        val networkComponent = DaggerNetworkComponent.factory().create()
        DaggerPostComponent.factory().create(
            networkComponent = networkComponent,
            roomComponent = roomComponent
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_post,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postAdapter = PostAdapter()

        lifecycleScope.launch {
            postViewModel.postFlow.collect { posts ->
                postAdapter.submitList(
                    posts
                )
            }
        }
        binding.apply {
            rvPostsPostFragment.layoutManager = LinearLayoutManager(requireContext())
            rvPostsPostFragment.adapter = postAdapter
        }
    }

}