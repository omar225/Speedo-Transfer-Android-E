package com.example.speedotransfer.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.model.AddFavouriteResponse
import com.example.speedotransfer.model.AddFavourites
import com.example.speedotransfer.model.AppAPIService
import com.example.speedotransfer.model.DeleteFavouriteResponse
import com.example.speedotransfer.model.FavouriteResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class FavouritesViewModel: ViewModel() {
    private val _favourites = MutableStateFlow<List<FavouriteResponse>>(emptyList())
    val favourites = _favourites

    private val _addToFavouritesResponse = MutableStateFlow<AddFavouriteResponse?>(null)
    val addToFavouritesResponse = _addToFavouritesResponse

    private val _deleteFavouriteResponse = MutableStateFlow<DeleteFavouriteResponse?>(null)
    val deleteFavouriteResponse = _deleteFavouriteResponse

    private val _addfavourite = MutableStateFlow<AddFavouriteResponse?>(null)
    val addfavourite = _addfavourite

    fun addToFavourites(addFavouritesRequest: AddFavourites) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _addToFavouritesResponse.value = AppAPIService.callable.addToFavorites(addFavouritesRequest)

            } catch (e: Exception) {
                Log.d("trace", "Error in adding favourite: ${e.message}")

            }
        }

    }

    fun getFavourite(accountNumber : String) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _favourites.value = AppAPIService.callable.getFavorites(accountNumber)

            } catch (e: Exception) {
                Log.d("trace", "Error in getting favourites list: ${e.message}")

            }
        }
    }

    fun deleteFavourite(id: Long) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _deleteFavouriteResponse.value = AppAPIService.callable.deleteFavorites(id)

            } catch (e: Exception) {
                Log.d("trace", "Error in deleting favourite: ${e.message}")

            }
        }


    }


}