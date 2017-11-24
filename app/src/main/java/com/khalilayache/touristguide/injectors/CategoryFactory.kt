package com.khalilayache.touristguide.injectors

import android.content.Context
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.adapters.CategoryRecyclerDecoration
import com.khalilayache.touristguide.repositories.CategoryRepository

class CategoryFactory {

  companion object {
    fun getCategoryRepository() = CategoryRepository()
    fun getCategoryViewDecorator(context: Context) = CategoryRecyclerDecoration(context.resources.getDimensionPixelOffset(R.dimen.recycler_categories_spacing))
  }

}
