package com.acs.ahadumonitor.feature_users.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acs.ahadumonitor.feature_users.domain.use_cases.DeleteUser
import com.acs.ahadumonitor.feature_users.domain.use_cases.GetUsers
import com.acs.ahadumonitor.feature_users.domain.use_cases.UpdateHost
import com.acs.ahadumonitor.feature_users.network.repository.HostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteUser: DeleteUser,
    private val hostRepository: HostRepository,
    private val updateHost: UpdateHost,
    getUsers: GetUsers
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        getUsers().onEach { users ->
            _state.value = state.value.copy(
                users = users
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteUser -> {
                viewModelScope.launch {
                    deleteUser(event.user)
                }
            }
            is HomeEvent.PingHosts -> {
                viewModelScope.launch {
                    _isLoading.value = true
                    val result = hostRepository.postPing(event.hosts)
                    result.forEach {
                        updateHost(it.ip, it.status)
                    }
                    _isLoading.value = false
                }
            }
        }
    }
}