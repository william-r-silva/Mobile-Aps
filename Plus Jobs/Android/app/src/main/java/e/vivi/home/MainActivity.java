package e.vivi.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import e.vivi.home.Models.User;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Senha;
    private Button Registrar;
    private Button Entrar;
    private Button EntrarAnonimo;
    private RetrofitUser service;
    private ImageView HackButton;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();


        pref = getSharedPreferences("PlusJobs", MODE_PRIVATE);
        if(pref.getInt("ID_User", 0) != 0) {
            Intent intent = new Intent(MainActivity.this, MainUser.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        editor = pref.edit();



        service = Configs.retrofit.create(RetrofitUser.class);

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.logar(Email.getText().toString(), Senha.getText().toString()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(!response.body().getNome().isEmpty()) {
                            Intent intent = new Intent(MainActivity.this, MainUser.class);
                            editor.putInt("ID_User", response.body().getId());
                            editor.commit();
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"Email ou senha incorretos.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Servidor offline.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        HackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainUser.class);
                startActivity(intent);
            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cadastro.class);
                startActivity(intent);
            }
        });

        EntrarAnonimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainAnonimus.class);
                startActivity(intent);
            }
        });

    }

    public void start(){
        Email = findViewById(R.id.L_Email);
        Senha = findViewById(R.id.L_Senha);
        Entrar = findViewById(R.id.L_Entrar);
        EntrarAnonimo = findViewById(R.id.L_EntrarAnonimo);
        Registrar = findViewById(R.id.L_Register);
        HackButton = findViewById(R.id.L_HackButton);
    }
}
