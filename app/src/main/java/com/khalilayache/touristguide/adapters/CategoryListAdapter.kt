package com.khalilayache.touristguide.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.extensions.getCompatColor
import com.khalilayache.touristguide.models.Category

class CategoryListAdapter(
    private val categories: ArrayList<Category>,
    private val categoryClick: CategoryClick,
    private val context: Context) : RecyclerView.Adapter<CategoryListAdapter.CategoriesViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_category, parent, false)

    return CategoriesViewHolder(view)
  }

  override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
    val category = categories[position]
    val categoryTitle = holder.itemView.resources.getString(category.title)

    holder.categoryImage.setImageResource(category.image)
    holder.categoryTitle.text = categoryTitle
    holder.backgroundView.setBackgroundColor(context.getCompatColor(category.backgroundColor))
    holder.backgroundView.minimumHeight = holder.backgroundView.width
    holder.backgroundView.setOnClickListener{ categoryClick.categoryOnClick(category) }

  }

  override fun getItemCount() = categories.size

  open inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val backgroundView: RelativeLayout = itemView.findViewById(R.id.category_container)
    val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
    val categoryTitle: TextView = itemView.findViewById(R.id.category_title)
  }

  interface CategoryClick {
    fun categoryOnClick(category: Category)
  }

}
