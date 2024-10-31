package com.example.tela_inicial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CriarContaView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta_view);

        Button btnCriarConta = findViewById(R.id.BtnCriarConta);


        btnCriarConta.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a nova Activity
                Intent intent = new Intent(CriarContaView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Encontre o ImageView
        ImageView iconvOLTAR = findViewById(R.id.imageView2);

        // Defina o OnClickListener para o ImageView
        iconvOLTAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CriarContaView.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}