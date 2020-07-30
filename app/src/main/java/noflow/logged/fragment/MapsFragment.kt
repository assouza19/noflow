package noflow.logged.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.br.noflow.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var lastLocation: Location
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setUpMap()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        lateinit var currentLatLng: LatLng

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return null
        } else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                currentLatLng = LatLng(location.latitude, location.longitude)
            }

            val rootView = inflater.inflate(R.layout.activity_maps, container, false)
            val mapFragment =
                childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

            mapFragment?.getMapAsync { mMap ->

                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                mMap.clear()

                val googlePlex = CameraPosition.builder()
                    .target(LatLng(-23.528700, -46.903381))
                    .zoom(15f)
                    .bearing(0f)
                    .build()
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 100, null)
            }
            return rootView
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            0 -> {

            }
            else -> {

            }
        }
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(): MapsFragment = MapsFragment()
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}
