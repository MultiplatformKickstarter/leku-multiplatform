package com.multiplatformkickstarter.leku.geocoder.adapters.type

import android.location.Address
import com.multiplatformkickstarter.leku.LekuViewHolder
import com.multiplatformkickstarter.leku.geocoder.adapters.base.LekuSearchAdapter

abstract class AddressSearchAdapter<T : LekuViewHolder> : LekuSearchAdapter<T, Address>()
