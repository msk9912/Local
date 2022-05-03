package com.duksung.local;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMapClickListener {
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)    {
        getMenuInflater().inflate(R.menu.mypage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mypageButton:
                Intent intent = new Intent(this, MyPageActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(37.65133469153908, 127.01614966828875);
        LatLng cha = new LatLng(37.6533, 127.0162);
        LatLng hak = new LatLng(37.6531, 127.0151);
        LatLng lib = new LatLng(37.652640, 127.016016);


        MarkerOptions markerOptioncha = new MarkerOptions();
        markerOptioncha.title("차미리사기념관");
        markerOptioncha.position(cha);
        googleMap.addMarker(markerOptioncha);

        MarkerOptions markerOptionhak = new MarkerOptions();
        markerOptionhak.title("인문과학대학");
        markerOptionhak.position(hak);
        googleMap.addMarker(markerOptionhak);

        MarkerOptions markerOptionlib = new MarkerOptions();
        markerOptionlib.title("도서관");
        markerOptionlib.position(lib);
        googleMap.addMarker(markerOptionlib);


//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lib, 18));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMapClickListener(this);


    }

    //마커 클릭 리스너-마커 클릭하면 뷰 띄움
    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        LinearLayout cardView = (LinearLayout)findViewById(R.id.card_view);
        cardView.setVisibility(View.VISIBLE);
    return true;
    }


    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        LinearLayout cardView = (LinearLayout)findViewById(R.id.card_view);
        cardView.setVisibility(View.INVISIBLE);
    }
}
