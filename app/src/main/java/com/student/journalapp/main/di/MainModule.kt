package com.student.journalapp.main.di

import androidx.navigation.NavController
import com.student.core.di.JournalAppModuleIntegration
import com.student.journalapp.core.navigation.RouterNavigation
import com.student.journalapp.core.navigation.RouterNavigationImpl
import com.student.journalapp.main.data.api.RecoveryDeepLinksService
import com.student.journalapp.main.data.repository.MainRepositoryImpl
import com.student.journalapp.main.data.source.RecoveryAllDeepLinkSource
import com.student.journalapp.main.domain.entity.RecoveryDeepLinksMapper
import com.student.journalapp.main.domain.repository.MainRepository
import com.student.journalapp.main.domain.usecase.RecoveryAllDeepLinksUseCase
import com.student.journalapp.main.presentation.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule : JournalAppModuleIntegration {

    override fun getPresentation() = module {
        viewModel { (navController: NavController) ->
            MainActivityViewModel(
                recoveryAllDeepLinksUseCase = get(),
                routerNavigation =
                    RouterNavigationImpl(navController = navController)
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
                ),
                mapper = RecoveryDeepLinksMapper()
            )
        }
    }

    override fun getExtras() = module { }

    override fun get() = listOf(getPresentation(), getDomain(), getData(), getExtras())
}