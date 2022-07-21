package com.acs.ahadumonitor.feature_users.network.response

import com.acs.ahadumonitor.feature_users.network.model.HostNetworkEntity
import com.google.gson.annotations.SerializedName

class HostPingResult (
    @SerializedName("result")
    var result: List<HostNetworkEntity>
        )