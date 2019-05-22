package com.tech.fit.diet_plan.model

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes


enum class ErrorAction {
    NONE,
    DISPLAY_TOAST,
    DISPLAY_DIALOG,
    DISPLAY_DIALOG_AND_NAVIGATE_BACK,
    CUSTOM_ERROR_HANDLE
}

data class ErrorViewModel(
        var code: Int = 0,
        @StringRes var message: Int? = 0,
        var messageStr: String? = "",
        @StringRes var title: Int? = null,
        var action: ErrorAction = ErrorAction.NONE,
        var showRetry: Boolean = false,
        @DrawableRes var errorIcon: Int? = null
)