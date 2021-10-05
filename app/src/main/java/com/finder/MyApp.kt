package com.finder

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
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

        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            val descriptorMapping = DescriptorMapping.withDefaults()
            client.addPlugin(InspectorFlipperPlugin(this, descriptorMapping))
            client.addPlugin(DatabasesFlipperPlugin(this))

            client.start()
        }
    }
}