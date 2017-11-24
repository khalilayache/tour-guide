package com.khalilayache.touristguide.models

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class Category(@StringRes val title: Int, @DrawableRes val image: Int, val backgroundColor: Int, val statusBarColor: Int, val type: CategoryType) : Parcelable {
  constructor(source: Parcel) : this(
      source.readInt(),
      source.readInt(),
      source.readInt(),
      source.readInt(),
      CategoryType.values()[source.readInt()]
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeInt(title)
    writeInt(image)
    writeInt(backgroundColor)
    writeInt(statusBarColor)
    writeInt(type.ordinal)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<Category> = object : Parcelable.Creator<Category> {
      override fun createFromParcel(source: Parcel): Category = Category(source)
      override fun newArray(size: Int): Array<Category?> = arrayOfNulls(size)
    }
  }
}

enum class CategoryType {
  MUSEUM, NIGHT_CLUBS, RESTAURANTS, ATTRACTIONS
}
