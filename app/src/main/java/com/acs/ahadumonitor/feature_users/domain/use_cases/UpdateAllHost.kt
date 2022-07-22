package com.acs.ahadumonitor.feature_users.domain.use_cases

import com.acs.ahadumonitor.feature_users.domain.repository.UserRepository
import javax.inject.Inject

class UpdateAllHost @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(status: String) {
        repository.updateAllHost(status)
    }
}