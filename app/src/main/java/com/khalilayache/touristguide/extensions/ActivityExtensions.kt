package com.khalilayache.touristguide.extensions

import android.app.Activity
import android.os.Build


fun Activity.setCompatStatusBarColor(backgroundColor: Int) {

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    this.window.statusBarColor = getCompatColor(backgroundColor)
  }

}
