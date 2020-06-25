package e.vivi.home.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import e.vivi.home.Models.Empresa;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitEmpresa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class addEmpresa extends Fragment {

    private EditText nome;
    private EditText estado;
    private EditText cidade;
    private EditText bairro;
    private EditText rua;
    private EditText numero;
    private CheckBox r1;
    private CheckBox r2;
    private CheckBox r3;
    private CheckBox r4;
    private Button Atualizar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_empresa, container, false);

        start(view);

        Atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regime="";
                if(r1.isChecked()){
                    regime+=r1.getText().toString();
                }if(r2.isChecked()){
                    regime+=r2.getText().toString();
                }if(r3.isChecked()){
                    regime+=r3.getText().toString();
                }if(r4.isChecked()){
                    regime+=r4.getText().toString();
                }
                Empresa empresa = new Empresa(nome.getText().toString(), cidade.getText().toString(),
                        estado.getText().toString(), rua.getText().toString(), Integer.parseInt(numero.getText().toString()),
                        bairro.getText().toString(), (regime+";"));

                RetrofitEmpresa retrofitEmpresa = Configs.retrofit.create(RetrofitEmpresa.class);
                retrofitEmpresa.adicionarEmpresa(empresa).enqueue(new Callback<Empresa>() {
                    @Override
                    public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                        nome.setText("");
                        estado.setText("");
                        cidade.setText("");
                        rua.setText("");
                        numero.setText("");
                        bairro.setText("");
                        r1.setChecked(false);
                        r2.setChecked(false);
                        r3.setChecked(false);
                        r4.setChecked(false);
                        Toast.makeText(getContext(), "Cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Empresa> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }

    private void start(View view){
        nome = view.findViewById(R.id.Ad_E_Nome);
        estado = view.findViewById(R.id.Ad_E_Estado);
        cidade = view.findViewById(R.id.Ad_E_Cidade);
        bairro = view.findViewById(R.id.Ad_E_Bairro);
        rua = view.findViewById(R.id.Ad_E_Rua);
        numero = view.findViewById(R.id.Ad_E_Numero);
        r1 = view.findViewById(R.id.Ad_E_R1);
        r2 = view.findViewById(R.id.Ad_E_R2);
        r3 = view.findViewById(R.id.Ad_E_R3);
        r4 = view.findViewById(R.id.Ad_E_R4);
        Atualizar = view.findViewById(R.id.Ad_E_Atualiza);

    }
}
