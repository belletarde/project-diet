package com.tech.fit.diet_plan.activity

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import com.tech.fit.diet_plan.R
import kotlinx.android.synthetic.main.activity_diet_plan_detail.*
import kotlinx.android.synthetic.main.diet_header.view.*
import kotlinx.android.synthetic.main.toolbar.*

class DietPlanDetailActivity : AppCompatActivity() {

    companion object {
        private const val DIET_ID = "diet_id"

        fun newIntent(context: Context, dietId: Int): Intent {
            val intent = Intent(context, DietPlanDetailActivity::class.java)
            intent.putExtra(DIET_ID, dietId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan_detail)
        dietDetailHeader.btnRecommendedDiet.visibility = GONE
        dietDetailHeader.txtRecommendedDietDescription.visibility = GONE
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
    }
}
