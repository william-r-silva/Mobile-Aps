package e.isadora.telainicial.Fragments.Voluntario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.isadora.telainicial.AuxGlobal;
import e.isadora.telainicial.Models.Campanha;
import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitCampanha;
import e.isadora.telainicial.Retrofit.RetrofitInstituicao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdicionaCampanha extends Fragment {

    private Switch colaMon;

    private EditText titulo;
    private EditText descricao;
    private EditText genero;
    private EditText dataIni;
    private EditText dataFim;
    private EditText estado;
    private EditText cidade;
    private EditText rua;
    private EditText bairro;
    private EditText numero;

    private Spinner  inst;

    private Button cadastrar;
    private List<Instituicao> instituicoes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_campanha, container, false);
        start(view);

        RetrofitInstituicao service = Configs.retrofit.create(RetrofitInstituicao.class);
        service.buscarTodas().enqueue(new Callback<List<Instituicao>>() {
            @Override
            public void onResponse(Call<List<Instituicao>> call, Response<List<Instituicao>> response) {
                if(response.isSuccessful()){
                    instituicoes = response.body();
                    String nomes[] = new String[instituicoes.size()+1];
                    nomes[0] = "Selecione uma instituição";
                    for(int i=1; i < instituicoes.size()+1; i++){
                        nomes[i]=instituicoes.get(i-1).getNome();
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,  nomes);
                    inst.setAdapter(adapter);

                }else{
                    Toast.makeText(getContext(),"Erro", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Instituicao>> call, Throwable t) {
                Toast.makeText(getContext(),"Serrvidor erro", Toast.LENGTH_SHORT).show();
            }
        });


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Campanha campanha = new Campanha();
                campanha.setColaboracaoMonetaria(colaMon.isChecked());
                campanha.setNome(titulo.getText().toString());
                campanha.setDescricao(descricao.getText().toString());
                campanha.setGenero(genero.getText().toString());
                campanha.setDataInicio(dataIni.getText().toString());
                campanha.setDataFim(dataFim.getText().toString());
                String local = "";
                local += estado.getText().toString()+", ";
                local += cidade.getText().toString()+", ";
                local += bairro.getText().toString()+", ";
                local += rua.getText().toString()+", ";
                local += numero.getText().toString();
                campanha.setLocal(local);
                campanha.setUser(AuxGlobal.user);

                final RetrofitCampanha service = Configs.retrofit.create(RetrofitCampanha.class);
                service.cadastrar(campanha).enqueue(new Callback<Campanha>() {
                    @Override
                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                        if(response.isSuccessful()){
                            if(inst.getSelectedItemPosition() != 0) {
                                service.addInstituicao(instituicoes.get(inst.getSelectedItemPosition() - 1), response.body().getId()).enqueue(new Callback<Campanha>() {
                                    @Override
                                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<Campanha> call, Throwable t) {

                                    }
                                });
                            }
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.Menu_Frag, new ListarCampanhas()).addToBackStack(null).commit();
                        }else{
                            Toast.makeText(getContext(),"Erro", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Campanha> call, Throwable t) {
                        Toast.makeText(getContext(),"Servidor erro", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

    private void start(View view){
        colaMon = view.findViewById(R.id.AddC_Dinheiro);
        titulo = view.findViewById(R.id.AddC_Titulo);
        descricao = view.findViewById(R.id.AddC_Descricao);
        genero = view.findViewById(R.id.AddC_Genero);
        dataIni = view.findViewById(R.id.AddC_DataIni);
        dataFim = view.findViewById(R.id.AddC_DataFim);
        inst = view.findViewById(R.id.AddC_Instituicao);
        estado = view.findViewById(R.id.AddC_Estado);
        cidade = view.findViewById(R.id.AddC_Cidade);
        rua = view.findViewById(R.id.AddC_Rua);
        bairro = view.findViewById(R.id.AddC_Bairro);
        numero = view.findViewById(R.id.AddC_Numero);
        cadastrar = view.findViewById(R.id.AddC_Cadastrar);
    }
}
