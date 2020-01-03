package belletarde.tech.fit.diet_plan.view

import android.content.DialogInterface
import belletarde.tech.fit.diet_plan.model.ErrorViewModel

/**
 * Base view any view must implement.
 */
interface BaseView {
    fun displayLoading()
    fun dismissLoading()
    fun displayError(errorViewModel: ErrorViewModel? = null)
}