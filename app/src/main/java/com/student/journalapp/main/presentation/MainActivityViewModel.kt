package com.student.journalapp.main.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.student.core.presentation.BaseViewModel
import com.student.journalapp.core.navigation.RouterNavigation
import com.student.journalapp.main.domain.RecoveryDeepLinkResult
import com.student.journalapp.main.domain.usecase.RecoveryAllDeepLinksUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val recoveryAllDeepLinksUseCase: RecoveryAllDeepLinksUseCase,
    private val routerNavigation: RouterNavigation,
) : BaseViewModel<MainUIState, MainUIAction>(MainUIState()) {

    override fun onViewCreated() {
        viewModelScope.launch {
            runCatching {
                recoveryAllDeepLinksUseCase()
            }.onSuccess { it ->
                handleResult(it)
            }.onFailure {
                sendAction { MainUIAction.ShowGenericError }
            }
        }
    }

    private fun handleResult(result: RecoveryDeepLinkResult) {
        when (result) {
            is RecoveryDeepLinkResult.Success -> {
                Log.d("RecoveryDeepLinkResult", "Success")
            }

            is RecoveryDeepLinkResult.Error -> {
                Log.d("RecoveryDeepLinkResult", "Error")
                sendAction { MainUIAction.ShowGenericError }
            }
        }
    }

    override fun onViewDestroy() {

    }

    override fun onBackClick() {

    }

}