package com.student.journalapp.main.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAllDeepLinksResponse(
    @SerialName("data")
    val data: List<DeepLinkData>? = null,
)


@Serializable
data class DeepLinkData(
    @SerialName("deeplink")
    val deepLink: String? = null,
)

