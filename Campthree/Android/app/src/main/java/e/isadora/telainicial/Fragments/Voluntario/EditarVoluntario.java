package e.isadora.telainicial.Fragments.Voluntario;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.isadora.telainicial.AuxGlobal;
import e.isadora.telainicial.MainActivity;
import e.isadora.telainicial.Models.User;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarVoluntario extends Fragment{

    private EditText nome;
    private EditText cpf;
    private EditText estado;
    private EditText cidade;
    private EditText bairro;
    private EditText rua;
    private EditText numero;
    private EditText senha;
    private EditText confSenha;
    private Button editar;
    private Button excluir;
    private User user = new User();
    private String localidade[];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_voluntario, container, false);
        start(view);

        user = AuxGlobal.user;
        nome.setHint(user.getNome());
        cpf.setHint(user.getCpf());
        String local = user.getEndereco();
        if(local.contains("a") || local.contains("e") || local.contains("o") || local.contains("i") || local.contains("u")){
            localidade = user.getEndereco().split(", ");
            estado.setHint(localidade[0]);
            cidade.setHint(localidade[1]);
            bairro.setHint(localidade[2]);
            rua.setHint(localidade[3]);
            numero.setHint(localidade[4]);
        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nome.getText().toString().equals(""))
                    user.setNome(nome.getText().toString());
                if (!cpf.getText().toString().equals(""))
                    user.setCpf(cpf.getText().toString());
                String endereco = "";
                if (!estado.getText().toString().equals("")) {
                    endereco += estado.getText().toString() + ", ";
                } else {
                    endereco += localidade[0]+ ", ";
                }
                if (!cidade.getText().toString().equals("")) {
                    endereco += cidade.getText().toString() + ", ";
                } else {
                    endereco += localidade[1]+ ", ";
                }
                if (!bairro.getText().toString().equals("")) {
                    endereco += bairro.getText().toString() + ", ";
                } else {
                    endereco += localidade[2]+ ", ";
                }
                if (!rua.getText().toString().equals("")) {
                    endereco += rua.getText().toString() + ", ";
                } else {
                    endereco += localidade[3]+ ", ";
                }
                if (!numero.getText().toString().equals("")){
                    endereco += numero.getText().toString();
                }else {
                    endereco += localidade[4]+ ", ";
                }
                user.setEndereco(endereco);

                if(!senha.getText().toString().equals("") && confSenha.getText().toString().equals(senha.getText().toString())) {
                    user.setSenha(senha.getText().toString());
                }
                if(confSenha.getText().toString().equals(senha.getText().toString())) {
                    RetrofitUser service = Configs.retrofit.create(RetrofitUser.class);
                    service.editar(user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                Toast.makeText(getContext(), "Editado com secesso!", Toast.LENGTH_SHORT).show();
                                transaction.replace(R.id.Menu_Frag, new ListarCampanhas(), "Campanhas").addToBackStack(null).commit();
                            } else {
                                Toast.makeText(getContext(), "Erro indefinido", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getContext(), "Servidor erro", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitUser service = Configs.retrofit.create(RetrofitUser.class);
                service.excluir(user.getId()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()) {
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getContext(), "Erro não definido", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getContext(), "Servidor offline", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }


    private void start(View view){
        nome = view.findViewById(R.id.E_nome);
        estado = view.findViewById(R.id.E_estado);
        cidade = view.findViewById(R.id.E_Cidade);
        bairro = view.findViewById(R.id.E_Bairro);
        rua = view.findViewById(R.id.E_Rua);
        numero = view.findViewById(R.id.E_Numero);
        cpf= view.findViewById(R.id.E_cpf);
        senha = view.findViewById(R.id.E_senha);
        confSenha = view.findViewById(R.id.E_confSenha);
        editar = view.findViewById(R.id.E_cadastrar);
        excluir = view.findViewById(R.id.E_excluir);
    }
}
