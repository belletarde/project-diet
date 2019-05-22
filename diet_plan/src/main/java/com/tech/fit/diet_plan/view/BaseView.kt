package com.tech.fit.diet_plan.view

import android.content.DialogInterface
import com.tech.fit.diet_plan.model.ErrorViewModel

/**
 * Base view any view must implement.
 */
interface BaseView {
    fun displayCustomLoading()
    fun hideCustomLoading()
    fun displayLoading()
    fun dismissLoading()
    fun displayError(errorViewModel: ErrorViewModel? = null)
    fun displayToast(message: String?)
    fun displayDialog(message: String?, onPositiveClickListener: ((DialogInterface, Int) -> Unit)?)
    fun displayDialogAndNavigateBack(message: String?)
    fun displayCustomError(errorViewModel: ErrorViewModel? = null)
    fun showCustomError(errorViewModel: ErrorViewModel)
}