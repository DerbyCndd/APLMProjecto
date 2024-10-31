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

public class LoginView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);


        Button btnEntrar = findViewById(R.id.btnEntrar);


        btnEntrar.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a nova Activity
                Intent intent = new Intent(LoginView.this, UserLogadoView.class);
                startActivity(intent);
            }
        });


    }
}