package com.khalilayache.touristguide.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.models.Places

class PlacesListAdapter(
    private val placesList: ArrayList<Places>,
    private val placeItemClick: PlaceItemClick) : RecyclerView.Adapter<PlacesListAdapter.CategoryItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_places, parent, false)

    return CategoryItemViewHolder(view)
  }

  override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
    val place = placesList[position]
    val placeName = holder.itemView.resources.getString(place.name)
    val placeAddress = holder.itemView.resources.getString(place.address)

    holder.image.setImageResource(place.imageSmall)
    holder.name.text = placeName
    holder.address.text = placeAddress

    holder.container.setOnClickListener { placeItemClick.placeItemOnClick(place, ActionType.DETAILS) }
    holder.directions.setOnClickListener { placeItemClick.placeItemOnClick(place, ActionType.DIRECTION) }

  }

  override fun getItemCount() = placesList.size

  open inner class CategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val container: RelativeLayout = itemView.findViewById(R.id.item_container)
    val image: ImageView = itemView.findViewById(R.id.item_image)
    val name: TextView = itemView.findViewById(R.id.item_name)
    val address: TextView = itemView.findViewById(R.id.item_address)
    val directions: ImageView = itemView.findViewById(R.id.item_direction)

  }

  interface PlaceItemClick {
    fun placeItemOnClick(place: Places, action: ActionType)
  }

  enum class ActionType {
    DETAILS, DIRECTION
  }
}
