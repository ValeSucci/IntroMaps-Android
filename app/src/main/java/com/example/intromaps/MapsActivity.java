package com.example.intromaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

        Map<String,LatLng> markers = new HashMap<>();
        markers.put("Mi Casa",new LatLng(-16.544445, -68.076032));
        markers.put("UPB",new LatLng(-16.574988, -68.126765));
        markers.put("UPB Postgrado",new LatLng(-16.524708, -68.110473));
        markers.put("Ñoños",new LatLng(-16.541517, -68.076256));
        markers.put("Casa Vale",new LatLng(-16.538540, -68.046402));
        markers.put("Casa Illi",new LatLng(-16.543410, -68.080144));
        markers.put("Casa Eve - Tia",new LatLng(-16.542468, -68.0695911));

        Iterator it = markers.keySet().iterator();
        while (it.hasNext()){
            String nameLoc = (String) it.next();
            LatLng latLng = markers.get(nameLoc);
            mMap.addMarker(new MarkerOptions().position(latLng).title(nameLoc));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,14));
        }
    }
}
