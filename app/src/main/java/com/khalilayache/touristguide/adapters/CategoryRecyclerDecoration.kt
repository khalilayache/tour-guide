package com.khalilayache.touristguide.adapters

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class CategoryRecyclerDecoration(
    private val space: Int
) : RecyclerView.ItemDecoration() {

  override fun getItemOffsets(outRect: Rect, view: View,
      parent: RecyclerView, state: RecyclerView.State) {


    val viewPosition = parent.getChildLayoutPosition(view)

    if (viewPosition % 2 != 0) {
      outRect.left = space / 2
      outRect.right = space
    } else {
      outRect.left = space
      outRect.right = space / 2
    }

    if (viewPosition == 0 || viewPosition == 1) {
      outRect.top = space
    } else {
      outRect.top = 0
    }

    outRect.bottom = space
  }
}
