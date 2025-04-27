package com.student.journalapp.main.presentation

import com.student.core.UIState

data class MainUIState(
    val isLoading: Boolean = false,
) : UIState