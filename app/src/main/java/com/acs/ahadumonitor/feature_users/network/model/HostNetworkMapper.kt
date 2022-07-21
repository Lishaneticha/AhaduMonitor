package com.acs.ahadumonitor.feature_users.network.model

import com.acs.ahadumonitor.feature_users.domain.model.User
import com.acs.ahadumonitor.utils.EntityMapper

class HostNetworkMapper: EntityMapper<HostNetworkEntity, User>{
    override fun mapFromEntity(entity: HostNetworkEntity): User {
        return User(
            name = entity.name!!,
            ip = entity.ip!!,
            status = entity.status!!
        )
    }

    override fun mapToEntity(domainModel: User): HostNetworkEntity {
        return HostNetworkEntity(
            name = domainModel.name,
            ip = domainModel.ip,
            status = domainModel.status
        )
    }

    fun fromEntityList(initial: List<HostNetworkEntity>): List<User>{
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<User>): List<HostNetworkEntity>{
        return initial.map {mapToEntity(it)}
    }

}