package com.khalilayache.touristguide.injectors

import android.content.Context
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.adapters.PlacesRecyclerDecoration
import com.khalilayache.touristguide.repositories.PlacesRepository

class PlacesFactory {

  companion object {
    fun getPlacesRepository() = PlacesRepository()
    fun getPlacesViewDecorator(context: Context) = PlacesRecyclerDecoration(context.resources.getDimensionPixelOffset(R.dimen.recycler_places_spacing))
  }

}
