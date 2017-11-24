package com.khalilayache.touristguide.models

import android.os.Parcel
import android.os.Parcelable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class Places(
    @StringRes val name: Int,
    @DrawableRes val imageBig: Int,
    @DrawableRes val imageSmall: Int,
    val address: Int,
    val about: Int,
    val rate: Int
) : Parcelable {
  constructor(source: Parcel) : this(
      source.readInt(),
      source.readInt(),
      source.readInt(),
      source.readInt(),
      source.readInt(),
      source.readInt()
  )

  override fun describeContents() = 0

  override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
    writeInt(name)
    writeInt(imageBig)
    writeInt(imageSmall)
    writeInt(address)
    writeInt(about)
    writeInt(rate)
  }

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<Places> = object : Parcelable.Creator<Places> {
      override fun createFromParcel(source: Parcel): Places = Places(source)
      override fun newArray(size: Int): Array<Places?> = arrayOfNulls(size)
    }
  }
}


