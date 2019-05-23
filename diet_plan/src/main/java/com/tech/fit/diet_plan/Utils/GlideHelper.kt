package com.tech.fit.diet_plan.Utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget

class GlideHelper {

    companion object {
        fun setBackgroundImage(context: Context, imageUrl: String, viewId: LinearLayout) {
            Glide.with(context)
                .load(imageUrl)
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: com.bumptech.glide.request.transition.Transition<in Drawable>?
                    ) {
                        viewId.setBackgroundDrawable(resource)
                    }

                })
        }

        fun setBackgroundImage(context: Context, imageUrl: String, viewId: LinearLayout, cornerRadius: Int) {
            Glide.with(context)
                .load(imageUrl)
                .apply(setRoundedImageOptions(cornerRadius))
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: com.bumptech.glide.request.transition.Transition<in Drawable>?
                    ) {
                        viewId.setBackgroundDrawable(resource)
                    }

                })
        }

        private fun setRoundedImageOptions(cornerRadius: Int): RequestOptions {
            val requestOptions = RequestOptions()
            return requestOptions.transforms(CenterCrop(), RoundedCorners(cornerRadius))
        }
    }

}