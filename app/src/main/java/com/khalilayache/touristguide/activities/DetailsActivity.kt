package com.khalilayache.touristguide.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.extensions.getCompatColor
import com.khalilayache.touristguide.extensions.setCompatStatusBarColor
import com.khalilayache.touristguide.models.Places

class DetailsActivity : AppCompatActivity() {

  private val toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }

  private val image by lazy { findViewById<ImageView>(R.id.place_image) }
  private val address by lazy { findViewById<TextView>(R.id.place_address) }
  private val rate by lazy { findViewById<TextView>(R.id.place_rate) }
  private val about by lazy { findViewById<TextView>(R.id.place_about) }

  private val place by lazy { intent?.extras?.get(DetailsActivity.PLACE) as Places }
  private val toolBarColor by lazy { intent?.extras?.get(DetailsActivity.TOOLBAR_COLOR) as Int }
  private val statusBarColor by lazy { intent?.extras?.get(DetailsActivity.STATUSBAR_COLOR) as Int }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_details)

    initViews()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {
      android.R.id.home -> finish()
    }

    return super.onOptionsItemSelected(item)
  }

  private fun initViews() {
    initTheme()
    initToolbar()
    fillInfos()
    initListeners()
  }

  private fun initListeners() {
    address.setOnClickListener { openNavigation(place) }
  }

  private fun openNavigation(place: Places) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("http://maps.google.co.in/maps?q=" + getString(place.address))
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    }
  }
  private fun fillInfos() {

    about.text = "${getString(R.string.about)}: ${getText(place.about)}"
    rate.text = "${getString(R.string.rate)}: ${getText(place.rate)}"
    address.text = "${getString(R.string.address)}: ${getText(place.address)}"
    image.setImageResource(place.imageBig)
  }

  private fun initTheme() {
    setCompatStatusBarColor(statusBarColor)
  }

  private fun initToolbar() {
    toolbar.title = getString(place.name)
    setSupportActionBar(toolbar)
    toolbar.setBackgroundColor(getCompatColor(toolBarColor))

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
  }

  companion object {

    private val PLACE = "extra_place"
    private val TOOLBAR_COLOR = "extra_toolbar_color"
    private val STATUSBAR_COLOR = "extra_statusbar_color"

    fun createIntentWithPlace(
        context: Context,
        places: Places,
        toolbarColor: Int,
        statusbarColor: Int
    ): Intent = Intent(context, DetailsActivity::class.java)
        .putExtra(PLACE, places)
        .putExtra(TOOLBAR_COLOR, toolbarColor)
        .putExtra(STATUSBAR_COLOR, statusbarColor)
  }
}
