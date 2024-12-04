package com.example.tela_inicial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.tela_inicial.model.User;
import com.example.tela_inicial.retrofit.RetrofitService;
import com.example.tela_inicial.services.UserService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CriarContaView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta_view);

        initializeComponents();

        // Configurar o clique no ícone de voltar
        ImageView iconVoltar = findViewById(R.id.imageView2);
        iconVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(CriarContaView.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void initializeComponents() {
        EditText inserirUsername = findViewById(R.id.editTextText3);
        EditText inserirSenha = findViewById(R.id.inputSenha_CriarConta);
        EditText inserirConfirmarSenha = findViewById(R.id.inputConfirmarSenha_CriarConta);
        Button btnCriarConta = findViewById(R.id.BtnCriarConta);


        RetrofitService retrofitService = new RetrofitService();
        UserService userService = retrofitService.getRetrofit().create(UserService.class);

        btnCriarConta.setOnClickListener(v -> {
            // Capturar os valores dos campos de entrada
            String nome = inserirUsername.getText().toString();
            String senha = inserirSenha.getText().toString();
            String confirmarSenha = inserirConfirmarSenha.getText().toString();

            // Validar os campos
            if (nome.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                inserirUsername.setError("Preencha todos os campos!");
                return;
            }

            if (!senha.equals(confirmarSenha)) {
                inserirConfirmarSenha.setError("As senhas não coincidem!");
                return;
            }

            // Criar o objeto User
            User user = new User();
            user.setNome(nome);
            user.setSenha(senha);
            user.setPontos(0); // Inicializar os pontos como 0
            user.setLocation("Indefinido"); // Localização padrão
            userService.inserir(user)
                    .enqueue((new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(CriarContaView.this,"Inserção Feita",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(CriarContaView.this,"Inserção Falhou",Toast.LENGTH_SHORT).show();
                            Logger.getLogger(CriarContaView.class.getName()).log(Level.SEVERE,  "Erro");
                        }
                    }));

            // Aqui você pode salvar o usuário no banco de dados ou backend

            // Após criar a conta, redirecionar para a MainActivity
            Intent intent = new Intent(CriarContaView.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
