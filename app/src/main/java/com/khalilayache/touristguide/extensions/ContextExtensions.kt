package com.khalilayache.touristguide.extensions

import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat


fun Context.getCompatColor(backgroundColor: Int): Int {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    this.getColor(backgroundColor)
  } else {
    ContextCompat.getColor(this, backgroundColor)
  }
}
