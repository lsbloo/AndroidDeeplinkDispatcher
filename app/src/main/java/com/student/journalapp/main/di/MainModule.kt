package com.student.journalapp.main.di

import com.student.core.di.JournalAppModuleIntegration
import com.student.journalapp.main.data.api.RecoveryDeepLinksService
import com.student.journalapp.main.data.repository.MainRepositoryImpl
import com.student.journalapp.main.data.source.RecoveryAllDeepLinkSource
import com.student.journalapp.main.domain.repository.MainRepository
import com.student.journalapp.main.domain.usecase.RecoveryAllDeepLinksUseCase
import com.student.journalapp.main.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule : JournalAppModuleIntegration {
    override fun getPresentation(): Module = module {
        viewModel {
            MainActivityViewModel(
                recoveryAllDeepLinksUseCase = get()
            )
        }
    }

    override fun getDomain() = module {
        factory { RecoveryAllDeepLinksUseCase(mainRepository = get()) }
    }

    override fun getData() = module {
        factory<MainRepository> {
            MainRepositoryImpl(
                source = RecoveryAllDeepLinkSource(
                    service = get<Retrofit>().create(
                        RecoveryDeepLinksService::class.java
                    )
                )
            )
        }
    }

    override fun getExtras() = module { }


    fun get() = listOf(getPresentation(), getDomain(), getData(), getExtras())
}