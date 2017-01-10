package com.example.neha.googlemaps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    //key
    // AIzaSyDTdKi-tfGm5qvJyCJofAh9B-g906qfk10

    private TextView txtLat, txtLong;
    private GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLong=(TextView)findViewById(R.id.txtLong);
        txtLat=(TextView)findViewById(R.id.txtLat);



        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.googleMaps);
        mapFragment.getMapAsync(this);

        LocationManager locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener=new LocationListener()
        {
            @Override
            public void onLocationChanged(Location location)
            {
                double lat = location.getLatitude();
                double lng = location.getLongitude();

                txtLat.setText("Lat: " + lat);
                txtLong.setText("Long: " + lng);

                LatLng dynamicLoc = new LatLng(lat, lng);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(dynamicLoc);
                googleMap.addMarker(markerOptions);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
            {

            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {

            }
        };

       locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,0,locationListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        this.googleMap = googleMap;

        LatLng pune = new LatLng(18.515722, 73.842052);

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.setMyLocationEnabled(true);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("Welcome to Pune");
        markerOptions.snippet("This is Snippet");
        markerOptions.position(pune);

        googleMap.addMarker(markerOptions);

        LatLng sydney = new LatLng(-33.86997, 151.2089);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18));
    }
}
