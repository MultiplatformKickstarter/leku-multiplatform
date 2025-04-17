package com.multiplatformkickstarter.leku.geocoder.adapters.type

import com.multiplatformkickstarter.leku.LekuViewHolder
import com.multiplatformkickstarter.leku.geocoder.PlaceSuggestion
import com.multiplatformkickstarter.leku.geocoder.adapters.base.LekuSearchAdapter

abstract class SuggestSearchAdapter<T : LekuViewHolder> : LekuSearchAdapter<T, PlaceSuggestion>()
