package com.khalilayache.touristguide.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.adapters.CategoryListAdapter
import com.khalilayache.touristguide.injectors.CategoryFactory
import com.khalilayache.touristguide.models.Category


class CategoriesActivity : AppCompatActivity(), CategoryListAdapter.CategoryClick {

  private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_activity_main) }
  private val categoryRepository by lazy { CategoryFactory.getCategoryRepository() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_category)

    initViews()
  }

  override fun categoryOnClick(category: Category) {
    startActivity(PlacesListActivity.createIntentWithCategory(this, category))
  }

  private fun initViews() {
    val categories: ArrayList<Category> = categoryRepository.getCategories()
    recyclerView.run {
      adapter = CategoryListAdapter(categories, context as CategoryListAdapter.CategoryClick, context)
      layoutManager = GridLayoutManager(context , 2)
      addItemDecoration(CategoryFactory.getCategoryViewDecorator(context))
    }
  }

}
