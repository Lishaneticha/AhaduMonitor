package com.acs.ahadumonitor.feature_users.presentation.home

import com.acs.ahadumonitor.feature_users.domain.model.User

data class HomeState(
    val users: List<User> = emptyList()
)
