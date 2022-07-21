package com.acs.ahadumonitor.feature_users.presentation.home

import com.acs.ahadumonitor.feature_users.domain.model.User

sealed class HomeEvent {
    data class DeleteUser(val user: User): HomeEvent()
    data class PingHosts(val hosts: List<String>): HomeEvent()
}
