package com.finder

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.finder.ui.main.MainFragment
import com.google.android.gms.location.*

class MainActivity : AppCompatActivity() {

    private var fusedLocationProvider: FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        this.supportActionBar?.hide()

        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(this)

        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                AlertDialog.Builder(this)
                    .setTitle("Location Permission Needed")
                    .setMessage("This app needs the Location permission, please accept to use location functionality")
                    .setPositiveButton(
                        "OK"
                    ) { _, _ ->
                        //Prompt the user once explanation has been shown
                        requestLocationPermission()
                    }
                    .create()
                    .show()
            } else {
                // No explanation needed, we can request the permission.
                requestLocationPermission()
            }
        } else {
            launchMainFragment()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,), MY_PERMISSIONS_REQUEST_LOCATION)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission granted, launch the app
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        launchMainFragment()
                    }

                } else {

                    Toast.makeText(this, "This app needs your location in order to operate. A random location will be chosen to demonstrate the app's ability!", Toast.LENGTH_LONG).show()
                    // Check if we are in a state where the user has denied the permission and
                    // selected "Don't ask again"
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    ) {
                        startActivity(
                            Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", this.packageName, null),
                            ),
                        )
                    } else {
                        // If the user denied location permissions, we'll show them suggestions in
                        // the great city of St Paul, MN
                        launchMainFragment(
                            lat = 44.9537,
                            long = -93.0900
                        )
                    }
                }
                return
            }
        }
    }

    // This is isolated to a method since it's duplicated. Both call sites are protected by a
    // permission check at the time of writing, hence the supression
    @SuppressLint("MissingPermission")
    private fun launchMainFragment(
        lat: Double? = null,
        long: Double? = null
    ) {
        // When we're got hardcoded lat/long values, we'll try and launch the app with those
        // straight away
        if (lat != null && long != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(
                    lat = lat,
                    long = long
                ))
                .commitNow()
        } else {
            (fusedLocationProvider as FusedLocationProviderClient).lastLocation.addOnSuccessListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance(
                        lat = it.latitude,
                        long = it.longitude
                    ))
                    .commitNow()
            }
        }
    }

    companion object {
        private const val MY_PERMISSIONS_REQUEST_LOCATION = 99
    }
}