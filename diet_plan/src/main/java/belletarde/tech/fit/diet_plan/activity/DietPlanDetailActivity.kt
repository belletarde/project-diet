package belletarde.tech.fit.diet_plan.activity

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.tech.fit.diet_plan.R
import belletarde.tech.fit.diet_plan.Utils.GlideHelper
import belletarde.tech.fit.diet_plan.Utils.PostThreadExecutor
import belletarde.tech.fit.diet_plan.Utils.ThreadExecutor
import belletarde.tech.fit.diet_plan.model.DietPlanDetail
import belletarde.tech.fit.diet_plan.model.ErrorViewModel
import belletarde.tech.fit.diet_plan.presenter.DietPlanDetailPresenter
import belletarde.tech.fit.diet_plan.repository.DietPlansRepository
import belletarde.tech.fit.diet_plan.service.DietPlanApi
import belletarde.tech.fit.diet_plan.view.DietPlanDetailView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_diet_plan_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.diet_header.*
import kotlinx.android.synthetic.main.diet_header.view.*
import kotlinx.android.synthetic.main.toolbar.*

class DietPlanDetailActivity : AppCompatActivity(), DietPlanDetailView {
    private lateinit var presenter: DietPlanDetailPresenter

    override fun setDietDetail(dietDetail: DietPlanDetail) {
        dietDetailHeader.btnRecommendedDiet.visibility = GONE
        dietDetailHeader.txtRecommendedDietDescription.visibility = GONE
        dietDetailHeader.txtRecommendedDietTitle.text = dietDetail.title
        dietDetailHeader.btnRecommendedDietSeeMore.text = dietDetail.buttonName
        txtDietDetailDescription.text = dietDetail.text
        btnDietDetailStartDiet.text = dietDetail.buttonName

        val dietAdvantagesAdapter = DietAdvantagesAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerDietDetailAdvantages.setHasFixedSize(true)
        recyclerDietDetailAdvantages.layoutManager = layoutManager
        recyclerDietDetailAdvantages.adapter = dietAdvantagesAdapter
        dietAdvantagesAdapter.setListView(dietDetail.features!!)
        GlideHelper.setBackgroundImage(this, dietDetail.imageUrl, dietDetailHeader.linearDietHeader)
        dismissLoading()
    }

    override fun displayLoading() {
        defaultLoadingDieDetail.visibility = VISIBLE
    }

    override fun dismissLoading() {
        defaultLoadingDieDetail.visibility = GONE
    }

    override fun displayError(errorViewModel: ErrorViewModel?) {

    }

    companion object {
        private const val DIET_ID = "diet_id"

        fun newIntent(context: Context, dietId: Long): Intent {
            val intent = Intent(context, DietPlanDetailActivity::class.java)
            intent.putExtra(DIET_ID, dietId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan_detail)
        displayLoading()
        setSupportActionBar(toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.navigationIcon?.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
        }
        presenter = DietPlanDetailPresenter(
            ThreadExecutor(Schedulers.io()),
            PostThreadExecutor(AndroidSchedulers.mainThread()),
            view = this,
            dietPlansRepository = DietPlansRepository(DietPlanApi())
        )

    }

    private fun getIntentExtras(): Long {
       return intent.getLongExtra(DIET_ID, 0L)
    }

    override fun onResume() {
        super.onResume()
        presenter.findDietDetail(getIntentExtras())
    }
}
