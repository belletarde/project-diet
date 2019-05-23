package com.tech.fit.diet_plan.activity

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.tech.fit.diet_plan.R
import com.tech.fit.diet_plan.Utils.GlideHelper
import com.tech.fit.diet_plan.model.DietPlanDetail
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.diet_recycler_item.*

class DietAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var context: Context? = null
    private var dietList: MutableList<DietPlanDetail> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DietItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.diet_recycler_item, parent, false), context!!)
    }

    fun setListView(dietList: ArrayList<DietPlanDetail>, context: Context) {
        this.dietList.addAll(dietList)
        this.context = context
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dietList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DietItemViewHolder).bind(dietList[position])
    }

    class DietItemViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView = itemView
        private val adapterContext = context

        fun bind(items: DietPlanDetail) {
            with(items) {
                txtDietTitle.text = title
                txtDietDescription.text = text
                linearDietItem.setOnClickListener {
                    val toDietDetail: Intent = DietPlanDetailActivity.newIntent(adapterContext, id)
                    startActivity(adapterContext, toDietDetail, null)
                }

                GlideHelper.setBackgroundImage(adapterContext, imageUrl, linearDietItem, cornerRadius = 18)
            }
        }
    }

}