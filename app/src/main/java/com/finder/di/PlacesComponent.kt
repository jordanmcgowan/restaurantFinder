package com.finder.di

import com.finder.networking.PlacesManager
import com.finder.ui.detail.DetailViewModel
import com.finder.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PlacesManagerModule::class])
interface PlacesComponent {
    fun inject(mainViewModel: MainViewModel)

    fun inject(detailViewModel: DetailViewModel)

    fun inject(placesManager: PlacesManager)
}