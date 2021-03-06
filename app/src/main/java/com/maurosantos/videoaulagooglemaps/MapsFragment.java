package com.maurosantos.videoaulagooglemaps;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(this);

        UiSettings mMapUiSettings = mMap.getUiSettings();
        mMapUiSettings.setZoomControlsEnabled(true);
        mMapUiSettings.setMyLocationButtonEnabled(true);

        // Add a marker in SES/TO and move the camera
        LatLng sesTO = new LatLng(-10.1868996, -48.336322);

        mMap.addMarker(new MarkerOptions().position(sesTO).title("SES/TO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sesTO));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(getActivity(), "Coordenadas: " + latLng.toString(), Toast.LENGTH_SHORT).show();
    }
}
