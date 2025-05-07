package com.student.journalapp.main.data.api

import com.student.journalapp.main.data.model.GetAllDeepLinksResponse
import retrofit2.Response
import retrofit2.http.GET

interface RecoveryDeepLinksService {
    @GET("api/recovery/deeplinks")
    suspend fun getAllDeepLinks() : Response<GetAllDeepLinksResponse>
}