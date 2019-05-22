package com.tech.fit.diet_plan.activity

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.tech.fit.diet_plan.R
import com.tech.fit.diet_plan.model.DietCollections
import com.tech.fit.diet_plan.model.DietPlanDetail
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.diet_type_recycler_item.*

class DietPlanAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: Context? = null
    private var dietList: ArrayList<DietCollections> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DietListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diet_type_recycler_item, parent, false), context)
    }

    override fun getItemCount(): Int {
        return dietList.size
    }

    fun setListView(modelTest: ArrayList<DietCollections>, context: Context) {
        this.dietList.addAll(modelTest)
        this.context = context
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DietListViewHolder).bind(dietList[position])
    }

    class DietListViewHolder(itemView: View, context: Context?) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView = itemView
        private val adapterContext = context

        fun bind(item: DietCollections) {
            with(item) {
                if (premium) {
                    imgDietPremiumLabel.visibility = VISIBLE
                } else {
                    imgDietPremiumLabel.visibility = GONE
                }
                txtDietTypeTitle.text = title
                setDietList(dietList = diets)
            }
        }

        private fun setDietList(dietList: ArrayList<DietPlanDetail>) {
            val dietAdapter = DietAdapter()
            val layoutManager = LinearLayoutManager(adapterContext, LinearLayoutManager.HORIZONTAL, false)
            layoutManager.isSmoothScrollbarEnabled = true
            recyclerDietFromType.layoutManager = layoutManager
            recyclerDietFromType.adapter = dietAdapter
            recyclerDietFromType.setHasFixedSize(false)
            dietAdapter.setListView(dietList, context = adapterContext!!)
        }
    }

}