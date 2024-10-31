package com.example.tela_inicial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFazerLogin = findViewById(R.id.btnFazerLogin);
        Button btnCriarConta = findViewById(R.id.btnCriarConta);


        btnFazerLogin.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a nova Activity
                Intent intent = new Intent(MainActivity.this, LoginView.class);
                startActivity(intent);
            }
        });


        btnCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,CriarContaView.class);
                startActivity(intent);
            }
        });

    } 
}