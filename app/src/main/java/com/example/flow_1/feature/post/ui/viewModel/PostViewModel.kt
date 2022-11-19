package com.example.flow_1.feature.post.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_with_room_retrofit_base_on_reqres.core.networkUtils.ResultWrapper
import com.example.dagger_with_room_retrofit_base_on_reqres.core.ui.NetworkState
import com.example.flow_1.feature.post.data.repository.PostRepository
import com.example.flow_1.feature.post.ui.model.PostView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "PostViewModel"

class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _postFlow = MutableStateFlow<List<PostView>>(
        value = listOf()
    )
    val postFlow = _postFlow.asStateFlow()

    private val _loadSate = MutableLiveData(NetworkState.INITIAL_STATE)
    val loadSate: LiveData<NetworkState> = _loadSate

    private val _loadSateMessage = MutableLiveData<String>()
    val loadStateMessate: LiveData<String> = _loadSateMessage

    init {
        fetch()
    }

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            val repositoryResponse = postRepository.getPostsWithStrategy()

            withContext(Dispatchers.Main) {
                when (repositoryResponse) {
                    is ResultWrapper.AppError -> {
                        /*_postFlow.update { postViews ->
                            return@update repositoryResponse.data!!
                        }*/
                        repositoryResponse.data.collect { reponsePosts ->
                            _postFlow.update { postViews ->
                                return@update reponsePosts!!
                            }
                        }
                        _loadSateMessage.value = repositoryResponse.appMessage
                        _loadSate.value = NetworkState.APPERROR
                    }

                    is ResultWrapper.Failure -> {
                        repositoryResponse.data.collect { reponsePosts ->
                            _postFlow.update { postViews ->
                                return@update reponsePosts!!
                            }
                        }
                        _loadSateMessage.value =
                            "${repositoryResponse.code} : ${repositoryResponse.severMessage}"
                        _loadSate.value = NetworkState.FAILURE
                    }

                    is ResultWrapper.Success -> {
                        repositoryResponse.data.collect { reponsePosts ->
                            _postFlow.update { postViews ->
                                return@update reponsePosts!!
                            }
                        }
                        _loadSate.value = NetworkState.SUCCESS
                    }
                }
            }
        }
    }
}
