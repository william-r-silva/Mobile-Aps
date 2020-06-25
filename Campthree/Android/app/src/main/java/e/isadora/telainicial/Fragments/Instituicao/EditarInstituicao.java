package e.isadora.telainicial.Fragments.Instituicao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import e.isadora.telainicial.AuxGlobal;
import e.isadora.telainicial.MainActivity;
import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitInstituicao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarInstituicao extends Fragment{

    private EditText nome;
    private EditText cnpj;
    private EditText estado;
    private EditText cidade;
    private EditText bairro;
    private EditText rua;
    private EditText numero;
    private EditText telefone;
    private EditText razao;
    private EditText senha;
    private EditText confSenha;
    private Button editar;
    private Button excluir;
    private Instituicao inst;
    private String localidade[];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editar_instituicao, container, false);
        start(view);

        inst = AuxGlobal.instituicao;
        nome.setHint(inst.getNome());
        cnpj.setHint(inst.getCnpj());
        String local = inst.getEndereco();
        if(local.contains("a") || local.contains("e") || local.contains("o") || local.contains("i") || local.contains("u")){
            localidade = inst.getEndereco().split(", ");
            estado.setHint(localidade[0]);
            cidade.setHint(localidade[1]);
            bairro.setHint(localidade[2]);
            rua.setHint(localidade[3]);
            numero.setHint(localidade[4]);
        }
        telefone.setHint(inst.getTelefone());
        razao.setHint(inst.getRazaoSocial());

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Instituicao instituicao = inst;
                if(!nome.getText().toString().equals(""))
                    instituicao.setNome(nome.getText().toString());
                String endereco = "";
                if(!estado.getText().toString().equals(""))
                    endereco += estado.getText().toString()+", ";
                else
                    endereco += localidade[0]+", ";
                if(!cidade.getText().toString().equals(""))
                    endereco += cidade.getText().toString()+", ";
                else
                    endereco += localidade[1]+", ";
                if(!bairro.getText().toString().equals(""))
                    endereco += bairro.getText().toString()+", ";
                else
                    endereco += localidade[2]+", ";
                if(!rua.getText().toString().equals(""))
                    endereco += rua.getText().toString()+", ";
                else
                    endereco += localidade[3]+", ";
                if(!numero.getText().toString().equals(""))
                    endereco += numero.getText().toString();
                else
                    endereco += localidade[4];
                instituicao.setEndereco(endereco);

                if(!cnpj.getText().toString().equals(""))
                instituicao.setCnpj(cnpj.getText().toString());
                if(!razao.getText().toString().equals(""))
                instituicao.setRazaoSocial(razao.getText().toString());
                if(!senha.getText().toString().equals("") && confSenha.getText().toString().equals(senha.getText().toString()))
                    instituicao.setSenha(senha.getText().toString());

                if(confSenha.getText().toString().equals(senha.getText().toString())){
                    RetrofitInstituicao service = Configs.retrofit.create(RetrofitInstituicao.class);
                    service.editar(instituicao).enqueue(new Callback<Instituicao>() {
                        @Override
                        public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                            if (response.isSuccessful()) {
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.Menu_Instituicao_Frag, new ListarCampanhasInstituicao(), "Campanhas").addToBackStack(null).commit();
                            } else {
                                Toast.makeText(getContext(), "Erro indefinido", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Instituicao> call, Throwable t) {
                            Toast.makeText(getContext(), "Servidor erro", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitInstituicao service = Configs.retrofit.create(RetrofitInstituicao.class);
                service.excluir(inst.getId()).enqueue(new Callback<Instituicao>() {
                    @Override
                    public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                        if(response.isSuccessful()) {
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getContext(), "Erro não definido", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Instituicao> call, Throwable t) {
                        Toast.makeText(getContext(), "Servidor offline", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return view;
    }

    private void start(View view){
        nome = view.findViewById(R.id.EdI_nome);
        cnpj = view.findViewById(R.id.EdI_Cnpj);
        estado = view.findViewById(R.id.EdI_estado);
        cidade = view.findViewById(R.id.EdI_Cidade);
        bairro = view.findViewById(R.id.EdI_Bairro);
        rua = view.findViewById(R.id.EdI_Rua);
        numero = view.findViewById(R.id.EdI_Numero);
        telefone = view.findViewById(R.id.EdI_Telefone);
        razao = view.findViewById(R.id.EdI_Razao);
        senha = view.findViewById(R.id.EdI_senha);
        confSenha = view.findViewById(R.id.EdI_confSenha);
        editar = view.findViewById(R.id.EdI_Editar);
        excluir = view.findViewById(R.id.EdI_Excluir);
    }
}
