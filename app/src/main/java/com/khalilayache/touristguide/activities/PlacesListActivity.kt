package com.khalilayache.touristguide.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.adapters.PlacesListAdapter
import com.khalilayache.touristguide.adapters.PlacesListAdapter.ActionType
import com.khalilayache.touristguide.adapters.PlacesListAdapter.ActionType.DETAILS
import com.khalilayache.touristguide.adapters.PlacesListAdapter.ActionType.DIRECTION
import com.khalilayache.touristguide.extensions.getCompatColor
import com.khalilayache.touristguide.extensions.setCompatStatusBarColor
import com.khalilayache.touristguide.injectors.PlacesFactory
import com.khalilayache.touristguide.models.Category
import com.khalilayache.touristguide.models.Places

class PlacesListActivity : AppCompatActivity(), PlacesListAdapter.PlaceItemClick {

  private val recyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_activity_itens) }
  private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
  private val category by lazy { intent?.extras?.get(CATEGORY_ITEM) as Category }

  private val placesRepository by lazy { PlacesFactory.getPlacesRepository() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_places_list)

    initViews()
  }

  override fun placeItemOnClick(place: Places, action: ActionType) {

    when (action) {
      DETAILS -> startActivity(DetailsActivity.createIntentWithPlace(
          this,
          place,
          category.backgroundColor,
          category.statusBarColor
      ))
      DIRECTION -> openNavigation(place)
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {
      android.R.id.home -> finish()
    }

    return super.onOptionsItemSelected(item)
  }

  private fun initViews() {
    initRecycler()
    initTheme()
    initToolbar()
  }

  private fun openNavigation(place: Places) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("http://maps.google.co.in/maps?q=" + getString(place.address))
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    }
  }

  private fun initTheme() {
    setCompatStatusBarColor(category.statusBarColor)
  }

  private fun initToolbar() {
    toolbar.title = getString(category.title)
    setSupportActionBar(toolbar)
    toolbar.setBackgroundColor(getCompatColor(category.backgroundColor))

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
  }

  private fun initRecycler() {

    val placesList: ArrayList<Places> = placesRepository.getPlaces(category.type)

    recyclerView.run {
      adapter = PlacesListAdapter(placesList, this@PlacesListActivity)
      layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
      addItemDecoration(PlacesFactory.getPlacesViewDecorator(context))
    }
  }

  companion object {

    private val CATEGORY_ITEM = "extra_category"

    fun createIntentWithCategory(
        context: Context,
        categoryName: Category
    ): Intent = Intent(context, PlacesListActivity::class.java)
        .putExtra(CATEGORY_ITEM, categoryName)
  }

}

