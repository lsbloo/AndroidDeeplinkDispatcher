package com.student.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<UIState, UIAction>(private val initialUIState: com.student.core.UIState) :
    ViewModel() {
    private val _mutableState = MutableLiveData<com.student.core.UIState>()
    var action: com.student.core.UIAction? = null
    private val mAction = MutableLiveData<com.student.core.UIAction>()

    init {
        action = mAction.value
        _mutableState.value = initialUIState
    }

    fun setState(state: () -> com.student.core.UIState) {
        _mutableState.value = state.invoke()
    }

    fun sendAction(action: () -> com.student.core.UIAction) {
        mAction.value = action.invoke()
    }

    var state: LiveData<com.student.core.UIState> = _mutableState
}