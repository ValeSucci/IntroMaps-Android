package com.example.intromaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);


        int n = 7;
        String[] markersNames = {"Mi Casa","UPB","UPB Postgrado","Ñoños","Casa Vale","Casa Illi","Casa Eve - Tia"};
        double[] markersLat = {-16.544445,-16.574988,-16.524708,-16.541517,-16.538540,-16.543410,-16.542468};
        double[] markersLng = {-68.076032,-68.126765,-68.110473,-68.076256,-68.046402,-68.080144,-68.0695911};
        int[] markersIcon = {R.drawable.ic_home_marker,R.drawable.ic_building_marker,R.drawable.ic_building_marker,R.drawable.ic_building_marker,R.drawable.ic_user_marker_pink,R.drawable.ic_user_street_marker,R.drawable.ic_user_marker_blue};

        for(int i=0; i<n; i++) {
            String nameLoc = markersNames[i];
            LatLng latLng = new LatLng(markersLat[i],markersLng[i]);
            int icon = markersIcon[i];
            mMap.addMarker(new MarkerOptions().position(latLng).title(nameLoc).icon(BitmapDescriptorFactory.fromResource(icon)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,14));
        }

    }
}
