package com.finder.ui.map

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.finder.R
import com.finder.SuggestionLite
import com.finder.toSuggestion
import com.finder.ui.detail.DetailFragment
import com.finder.ui.main.MainFragment

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Marker


private const val KEY_SUGGESTION_LIST = "key.suggestion_list"

class MapFragment : Fragment(), GoogleMap.OnInfoWindowClickListener {

  companion object {
    fun newInstance(
      suggestionList: List<SuggestionLite>
    ): MapFragment {
      // Update to add params - dictionary of placeId -> lat/long?
      return MapFragment().apply {
        arguments = Bundle().apply {
          putParcelableArrayList(KEY_SUGGESTION_LIST, ArrayList(suggestionList))
        }
      }
    }

    val TAG = "MapFragmentTag"
  }

  private val callback = OnMapReadyCallback { googleMap ->
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to
     * install it inside the SupportMapFragment. This method will only be triggered once the
     * user has installed Google Play services and returned to the app.
     */
    val suggestionList = arguments?.getParcelableArrayList<SuggestionLite>(KEY_SUGGESTION_LIST)
    suggestionList?.mapIndexed { index, suggestionLite ->
      // If we don't have valid fields for position, we can't put a pin on the map.
      // FUTURE IMPROVEMENT - Force the `toSuggestionLite` method to enfore this and not allow
      // nullable fields here
      if (suggestionLite.lat != null && suggestionLite.lng != null) {
        // FUTURE IMPROVEMENT - Use the [Marker] class with a tag == placeId for InfoWindow ID?
        val position = LatLng(suggestionLite.lat.toDouble(), suggestionLite.lng.toDouble())
        // Using the existing Iconography from Google Maps (following standard android designs) will
        // allow for consistency here -- just a name and an address!
        val marker = MarkerOptions().position(position).title(suggestionLite.name)
          .snippet(suggestionLite.address)
        // To highlight any potential favorites on the list, we'll update the color of the icon to
        // be as close to the green theme we use in this app
        if (suggestionLite.isFavorite) {
          marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        }
        googleMap.addMarker(marker)
        // Let this view handle the info click so we can redirect to the DetailFragment
        googleMap.setOnInfoWindowClickListener(this)

        if (index == 0) {
          // We'll set the camera focus to be centered on the first result in the list. It's the
          // "best" suggestion according to the service! We'll also zoom the camera to an
          // appropriate level. According to the docs, 10 is appropriate for "City" identification
          // and 15 is good for "Street" id -- let's split the difference
          // FUTURE IMPROVEMENT - pass the user's Lat/Long here and center on that position
          googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 12.5f))
        }
      }
    }


    // General map settings
    // FUTURE IMPROVEMENT - Check for permissions and enable blue dot location for the user
    //googleMap.setMyLocationEnabled(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_map, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
    mapFragment?.getMapAsync(callback)
  }

  override fun onInfoWindowClick(marker: Marker) {
    // This is some of the hackier code I've written recently. There's no way to know which marker
    // is tied to which suggestion...However, we know the title is equivalent to the name since we
    // set it up that way above. We can try and string match to find a match and move on should we
    // find one. Since we're string matching if there are multiple results with the same name,
    // regardless of which marker is clicked, we'll use the first match to launch the DetailFragment
    val suggestionFromMarker =
      arguments?.getParcelableArrayList<SuggestionLite>(KEY_SUGGESTION_LIST)
        ?.first { it.name == marker.title }
    if (suggestionFromMarker != null) {
      parentFragmentManager.commit {
        replace(
          ((view as ViewGroup).parent as View).id,
          DetailFragment.newInstance(suggestionFromMarker.toSuggestion())
        )
        setReorderingAllowed(true)
        addToBackStack(MainFragment.TAG)
      }
    }
  }
}