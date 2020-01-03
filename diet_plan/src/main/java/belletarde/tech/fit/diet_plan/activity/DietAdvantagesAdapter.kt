package belletarde.tech.fit.diet_plan.activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech.fit.diet_plan.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.diet_advantages_recycler_item.*

class DietAdvantagesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dietList: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DietItemViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.diet_advantages_recycler_item, parent, false)
        )
    }

    fun setListView(dietList: List<String>) {
        this.dietList = dietList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dietList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DietItemViewHolder).bind(dietList.get(position))
    }

    class DietItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView = itemView
        fun bind(advantage: String) {
            txtAdvantageItem.text = advantage
        }
    }

}