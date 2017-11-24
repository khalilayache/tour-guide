package com.khalilayache.touristguide.repositories

import com.khalilayache.touristguide.R
import com.khalilayache.touristguide.models.CategoryType
import com.khalilayache.touristguide.models.CategoryType.ATTRACTIONS
import com.khalilayache.touristguide.models.CategoryType.MUSEUM
import com.khalilayache.touristguide.models.CategoryType.NIGHT_CLUBS
import com.khalilayache.touristguide.models.CategoryType.RESTAURANTS
import com.khalilayache.touristguide.models.Places

class PlacesRepository {

  fun getPlaces(categoryType: CategoryType): ArrayList<Places> = when (categoryType) {
    ATTRACTIONS -> getAttractionsPlaces()
    MUSEUM -> getMuseumsPlaces()
    NIGHT_CLUBS -> getNightClubsPlaces()
    RESTAURANTS -> getRestaurantsPlaces()
  }

  private fun getAttractionsPlaces(): ArrayList<Places> {
    val places: ArrayList<Places> = ArrayList()

    places.add(Places(R.string.ibira_name, R.drawable.ibira_big, R.drawable.ibira_small, R.string.ibira_address, R.string.ibira_about, R.string.ibira_rate))
    places.add(Places(R.string.independencia_name, R.drawable.independencia_big, R.drawable.independencia_small, R.string.independencia_address, R.string.independencia_about, R.string.independencia_rate))
    places.add(Places(R.string.villa_lobos_name, R.drawable.villa_lobos_big, R.drawable.villa_lobos_small, R.string.villa_lobos_address, R.string.villa_lobos_about, R.string.villa_lobos_rate))
    places.add(Places(R.string.luz_name, R.drawable.luz_big, R.drawable.luz_small, R.string.luz_address, R.string.luz_about, R.string.luz_rate))
    places.add(Places(R.string.povo_name, R.drawable.povo_big, R.drawable.povo_small, R.string.povo_address, R.string.povo_about, R.string.povo_rate))

    return places
  }

  private fun getMuseumsPlaces(): ArrayList<Places> {
    val places: ArrayList<Places> = ArrayList()

    places.add(Places(R.string.mis_name, R.drawable.mis_big, R.drawable.mis_small, R.string.imigracao_address, R.string.mis_about, R.string.mis_rate))
    places.add(Places(R.string.imigracao_name, R.drawable.imigracao_big, R.drawable.imigracao_small, R.string.imigracao_address, R.string.imigracao_about, R.string.imigracao_rate))
    places.add(Places(R.string.masp_name, R.drawable.masp_big, R.drawable.masp_small, R.string.masp_address, R.string.masp_about, R.string.masp_rate))
    places.add(Places(R.string.mam_name, R.drawable.mam_big, R.drawable.mam_small, R.string.mam_address, R.string.mam_about, R.string.mam_rate))
    places.add(Places(R.string.pinacoteca_name, R.drawable.pinacoteca_big, R.drawable.pinacoteca_small, R.string.pinacoteca_address, R.string.pinacoteca_about, R.string.pinacoteca_rate))

    return places

  }

  private fun getNightClubsPlaces(): ArrayList<Places> {
    val places: ArrayList<Places> = ArrayList()

    places.add(Places(R.string.villa_country_name, R.drawable.villa_country_big, R.drawable.villa_country_small, R.string.villa_country_address, R.string.villa_country_about, R.string.villa_country_rate))
    places.add(Places(R.string.blitz_name, R.drawable.blitz_big, R.drawable.blitz_small, R.string.blitz_address, R.string.blitz_about, R.string.blitz_rate))
    places.add(Places(R.string.dedge_name, R.drawable.dedge_big, R.drawable.dedge_small, R.string.dedge_address, R.string.dedge_about, R.string.dedge_rate))
    places.add(Places(R.string.madame_name, R.drawable.madame_big, R.drawable.madame_small, R.string.madame_address, R.string.madame_about, R.string.madame_rate))
    places.add(Places(R.string.cluba_name, R.drawable.cluba_big, R.drawable.cluba_small, R.string.cluba_address, R.string.cluba_about, R.string.cluba_rate))

    return places
  }

  private fun getRestaurantsPlaces(): ArrayList<Places> {
    val places: ArrayList<Places> = ArrayList()

    places.add(Places(R.string.croc_name, R.drawable.croc_big, R.drawable.crock_small, R.string.croc_address, R.string.croc_about, R.string.croc_rate))
    places.add(Places(R.string.urbe_name, R.drawable.urbe_big, R.drawable.urbe_small, R.string.urbe_address, R.string.urbe_about, R.string.urbe_rate))
    places.add(Places(R.string.mercadao_name, R.drawable.mercadao_big, R.drawable.mercadao_small, R.string.mercadao_address, R.string.mercadao_about, R.string.mercadao_rate))
    places.add(Places(R.string.estadao_name, R.drawable.estadao_big, R.drawable.estadao_small, R.string.estadao_address, R.string.estadao_about, R.string.estadao_rate))
    places.add(Places(R.string.fogo_name, R.drawable.fogo_big, R.drawable.fogo_small, R.string.fogo_address, R.string.fogo_about, R.string.fogo_rate))

    return places

  }

}



