package com.student.core.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<UIState, UIAction>(private val initialUIState: com.student.core.presentation.UIState) :
    ViewModel(), JournalAppViewModel {
    private val _mutableState = MutableLiveData<com.student.core.presentation.UIState>()
    var action: com.student.core.presentation.UIAction? = null
    private val mAction = MutableLiveData<com.student.core.presentation.UIAction>()

    init {
        action = mAction.value
        _mutableState.value = initialUIState
    }

    fun setState(state: () -> com.student.core.presentation.UIState) {
        _mutableState.value = state.invoke()
    }

    fun sendAction(action: () -> com.student.core.presentation.UIAction) {
        mAction.value = action.invoke()
    }

    var state: LiveData<com.student.core.presentation.UIState> = _mutableState
}