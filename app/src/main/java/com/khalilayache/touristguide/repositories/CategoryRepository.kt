package com.khalilayache.touristguide.repositories

import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.models.Category
import com.khalilayache.touristguide.models.CategoryType

class CategoryRepository {

  fun getCategories(): ArrayList<Category> {
    val categories: ArrayList<Category> = ArrayList()

    categories.add(Category(R.string.museum_br, R.drawable.museum, R.color.museum_background, R.color.museum_status, CategoryType.MUSEUM))
    categories.add(Category(R.string.night_clubs, R.drawable.night_clubs, R.color.night_clubs_background, R.color.night_clubs_status, CategoryType.NIGHT_CLUBS))
    categories.add(Category(R.string.restaurants, R.drawable.restaurants, R.color.restaurants_background, R.color.restaurants_status, CategoryType.RESTAURANTS))
    categories.add(Category(R.string.attractions, R.drawable.attractions, R.color.attractions_background, R.color.attractions_status, CategoryType.ATTRACTIONS))

    return categories
  }

}
