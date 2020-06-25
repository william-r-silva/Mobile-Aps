package e.vivi.home.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.vivi.home.Cadastro;
import e.vivi.home.MainActivity;
import e.vivi.home.Models.User;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editar extends Fragment {

    private EditText Nome;
    private EditText Estado;
    private EditText Cidade;
    private EditText Senha;
    private EditText ConfSenha;
    private Button Cadastrar;
    private RetrofitUser service;
    private User user;
    private View view;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_editar, container, false);
        service = Configs.retrofit.create(RetrofitUser.class);

        start(view);

        SharedPreferences shared = getActivity().getSharedPreferences("PlusJobs", getContext().MODE_PRIVATE);

        id = shared.getInt("ID_User", 0);

        service.buscarPorId(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Nome.getText().toString().equals(""))
                user.setNome(Nome.getText().toString());
                if(!Estado.getText().toString().equals(""))
                user.setEstado(Estado.getText().toString());
                if(!Cidade.getText().toString().equals(""))
                user.setCidade(Cidade.getText().toString());
                boolean aprovado=true;

                if(Senha.getText().toString().equals(ConfSenha.getText().toString()) && !ConfSenha.getText().toString().equals("") ) {
                    user.setSenha(Senha.getText().toString());
                }else{
                    Toast.makeText(getContext(), "Sua senha não coincide!", Toast.LENGTH_SHORT).show();
                }

                service.editar(user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Nome.setText("");
                            Estado.setText("");
                            Cidade.setText("");
                            Senha.setText("");
                            ConfSenha.setText("");
                            Toast.makeText(getContext(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getContext(), "erro", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        });
        return view;
    }

    public void start(View view){
        Nome = view.findViewById(R.id.Ed_U_Nome);
        Estado = view.findViewById(R.id.Ed_U_Estado);
        Cidade = view.findViewById(R.id.Ed_U_Cidade);
        Senha = view.findViewById(R.id.Ed_U_Senha);
        ConfSenha = view.findViewById(R.id.Ed_U_ConfSenha);
        Cadastrar = view.findViewById(R.id.Ed_U_Atualiza);
    }
}
