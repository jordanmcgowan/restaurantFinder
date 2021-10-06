package com.finder

import android.app.Application
import com.finder.di.DaggerPlacesComponent
import com.finder.di.PlacesComponent
import com.finder.di.PlacesManagerModule

class MyApp : Application() {
    companion object {
        lateinit var placesComponent: PlacesComponent
    }


    override fun onCreate() {
        super.onCreate()
        placesComponent =
            DaggerPlacesComponent.builder().placesManagerModule(PlacesManagerModule(this)).build()
    }
}