package com.finder.di

import com.finder.MainActivity
import com.finder.MyApp
import com.finder.networking.PlacesManager
import com.finder.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [PlacesManagerModule::class])
interface PlacesComponent {
    fun inject(mainViewModel: MainViewModel)

    fun inject(placesManager: PlacesManager)
}