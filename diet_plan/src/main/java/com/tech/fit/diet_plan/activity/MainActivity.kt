package com.tech.fit.diet_plan.activity

import android.content.DialogInterface
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.tech.fit.diet_plan.R
import com.tech.fit.diet_plan.Utils.GlideHelper
import com.tech.fit.diet_plan.Utils.PostThreadExecutor
import com.tech.fit.diet_plan.Utils.ThreadExecutor
import com.tech.fit.diet_plan.model.DietHighLight
import com.tech.fit.diet_plan.model.DietPlanList
import com.tech.fit.diet_plan.model.ErrorViewModel
import com.tech.fit.diet_plan.presenter.DietPlansPresenter
import com.tech.fit.diet_plan.repository.DietPlansRepository
import com.tech.fit.diet_plan.service.DietPlanApi
import com.tech.fit.diet_plan.view.DietPlansView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.default_loading.view.*
import kotlinx.android.synthetic.main.diet_header.view.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity(), DietPlansView {

    private lateinit var presenter: DietPlansPresenter
    private var dietAdapter = DietPlanAdapter()

    override fun setDietList(dietList: DietPlanList) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutManager?.isSmoothScrollbarEnabled = true
        recyclerDiet.layoutManager = layoutManager
        recyclerDiet.adapter = dietAdapter
        recyclerDiet.setHasFixedSize(false)
        dietAdapter.setListView(dietList.collections, this)
        setHighLightDiet(dietList.highLight)
        dismissLoading()
        setupToolbar(true)
    }

    private fun setHighLightDiet(highLight: DietHighLight) {
        dietHeader.txtRecommendedDietDescription.text = highLight.text
        dietHeader.txtRecommendedDietTitle.text = highLight.title
        dietHeader.btnRecommendedDietSeeMore.text = highLight.buttonName
        dietHeader.btnRecommendedDiet.text = highLight.label
        GlideHelper.setBackgroundImage(this, highLight.imageUrl, dietHeader.linearDietHeader)
        dietHeader.btnRecommendedDietSeeMore.setOnClickListener {
            val toDietDetail = DietPlanDetailActivity.newIntent(this, highLight.id)
            startActivity(toDietDetail)
        }
    }

    private fun fetchDiet() {
        displayLoading()
        presenter.findAllDiets()
    }

    override fun displayLoading() {
        defaultLoadingDietList.visibility = VISIBLE
    }

    override fun dismissLoading() {
        defaultLoadingDietList.visibility = GONE
    }

    override fun displayError(errorViewModel: ErrorViewModel?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = DietPlansPresenter(ThreadExecutor(Schedulers.io()), PostThreadExecutor(AndroidSchedulers.mainThread()), view = this, dietPlansRepository = DietPlansRepository(DietPlanApi()))
        fetchDiet()
    }

    private fun setupToolbar(enable: Boolean) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.navigationIcon?.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)
        val actionBar = supportActionBar
        if (actionBar != null) {
            if (enable) {
                actionBar.setHomeButtonEnabled(true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
