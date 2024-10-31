package com.example.tela_inicial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class UserLogadoView extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logado_view);

        // Encontre o ImageView
        ImageView iconChat = findViewById(R.id.IconChat);

        // Defina o OnClickListener para o ImageView
        iconChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicie a HomeActivity
                Intent intent = new Intent(UserLogadoView.this, Chat.class);
                startActivity(intent);
            }
        });



        ImageView iconUser = findViewById(R.id.imageView9);
        iconUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogadoView.this, userProfile.class);
                startActivity(intent);
            }
        });



        ImageView iconBike = findViewById(R.id.IconBicicleta);
        iconBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogadoView.this, Trajetoria.class);
                startActivity(intent);
            }
        });





        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        // Add this line before line 62
        if (gmap == null) {
            Log.e("UserLogadoView", "Map is not ready yet!");
        }

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(-8.839988,13.289437);
        googleMap.addMarker(new MarkerOptions().position(location).title("Luanda"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,12));
    }
}
