package com.student.journalapp.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL_GET = "http://private-ff77a1-deeplinkdispatcher.apiary-mock.com/"

object NetworkModule {
    fun get() = module {
        fun provideHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()
        }


        fun provideConverterFactory(): GsonConverterFactory =
            GsonConverterFactory.create()

        fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_GET)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
        }

        single { provideLoggingInterceptor() }
        single { provideHttpClient(get()) }
        single { provideConverterFactory() }
        single { provideRetrofit(get(), get()) }
    }
}