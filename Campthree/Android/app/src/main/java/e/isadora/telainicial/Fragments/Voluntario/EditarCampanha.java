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

public class EditarCampanha extends Fragment {

    private Switch colaMon;

    private EditText titulo;
    private EditText descricao;
    private EditText genero;
    private EditText dataIni;
    private EditText dataFim;

    private String localidade[];
    private EditText estado;
    private EditText cidade;
    private EditText rua;
    private EditText bairro;
    private EditText numero;

    private Button editar;
    private Button excluir;

    private Spinner inst;

    private Campanha campanha;
    private Instituicao auxInst;

    private ArrayList<String> nomes = new ArrayList<String>();

    private Instituicao instSelected;
    private List<Instituicao> instituicoes;

    private RetrofitCampanha serviceCampanha = Configs.retrofit.create(RetrofitCampanha.class);
    private RetrofitInstituicao serviceInstituicao = Configs.retrofit.create(RetrofitInstituicao.class);


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_campanha, container, false);
        start(view);

        campanha = AuxGlobal.campanha;

        colaMon.setChecked(campanha.isColaboracaoMonetaria());
        titulo.setHint(campanha.getNome());
        descricao.setHint(campanha.getDescricao());
        genero.setHint(campanha.getGenero());
        dataIni.setHint(campanha.getDataInicio());
        dataFim.setHint(campanha.getDataFim());
        String local = campanha.getLocal();
        if(local.contains("a") || local.contains("e") || local.contains("o") || local.contains("i") || local.contains("u")){
            localidade = campanha.getLocal().split(", ");
            estado.setHint(localidade[0]);
            cidade.setHint(localidade[1]);
            bairro.setHint(localidade[2]);
            rua.setHint(localidade[3]);
            numero.setHint(localidade[4]);
        }

        serviceCampanha.instCampanha(campanha.getId()).enqueue(new Callback<Instituicao>() {
            @Override
            public void onResponse(Call<Instituicao> call, Response<Instituicao> response) {
                if (response.isSuccessful()){
                    nomes.add(response.body().getNome());
                }else{
                    nomes.add("Selecione uma instituição");
                }
                serviceInstituicao.buscarTodas().enqueue(new Callback<List<Instituicao>>() {
                    @Override
                    public void onResponse(Call<List<Instituicao>> call, Response<List<Instituicao>> response) {
                        if(response.isSuccessful()){
                            instituicoes = response.body();

                            for(int i=1; i < instituicoes.size()+1; i++){
                                if(!instituicoes.get(i - 1).getNome().equals(nomes.get(0))) {
                                    nomes.add(instituicoes.get(i - 1).getNome());
                                }
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
            }

            @Override
            public void onFailure(Call<Instituicao> call, Throwable t) {
                Toast.makeText(getContext(), "Servidor erro", Toast.LENGTH_SHORT).show();
            }
        });


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campanha.setColaboracaoMonetaria(colaMon.isChecked());
                if(!titulo.getText().toString().equals("")){
                    campanha.setNome(titulo.getText().toString());
                }
                if (!descricao.getText().toString().equals("")) {
                    campanha.setDescricao(descricao.getText().toString());
                }
                if (!genero.getText().toString().equals("")) {
                    campanha.setGenero(genero.getText().toString());
                }
                String local = "";
                if (!estado.getText().toString().equals("")) {
                    local += estado.getText().toString() + ", ";
                } else {
                    local += localidade[0]+ ", ";
                }
                if (!cidade.getText().toString().equals("")) {
                    local += cidade.getText().toString() + ", ";
                } else {
                    local += localidade[1]+ ", ";
                }
                if (!bairro.getText().toString().equals("")) {
                    local += bairro.getText().toString() + ", ";
                } else {
                    local += localidade[2]+ ", ";
                }
                if (!rua.getText().toString().equals("")) {
                    local += rua.getText().toString() + ", ";
                } else {
                    local += localidade[3]+ ", ";
                }
                if (!numero.getText().toString().equals("")) {
                    local += numero.getText().toString();
                } else {
                    local += localidade[4]+ ", ";
                }
                campanha.setLocal(local);

                campanha.setUser(AuxGlobal.user);

                if (!dataIni.getText().toString().equals("")) {
                    campanha.setDataInicio(dataIni.getText().toString());
                    Toast.makeText(getContext(), dataIni.getText().toString(), Toast.LENGTH_SHORT).show();
                }

                if (!dataFim.getText().toString().equals("")) {
                    campanha.setDataFim(dataFim.getText().toString());
                    Toast.makeText(getContext(), dataFim.getText().toString(), Toast.LENGTH_SHORT).show();
                }

                serviceCampanha.editar(campanha).enqueue(new Callback<Campanha>() {
                    @Override
                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                        if(response.isSuccessful()){
                            if(inst.getSelectedItemPosition() != 0) {
                                serviceCampanha.addInstituicao(instituicoes.get(inst.getSelectedItemPosition() - 1), response.body().getId()).enqueue(new Callback<Campanha>() {
                                    @Override
                                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {

                                    }

                                    @Override
                                    public void onFailure(Call<Campanha> call, Throwable t) {

                                    }
                                });
                            }
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.Menu_Frag, new ListarMinhasCampanhas()).addToBackStack(null).commit();
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

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitCampanha service = Configs.retrofit.create(RetrofitCampanha.class);
                service.excluir(campanha.getId()).enqueue(new Callback<Campanha>() {
                    @Override
                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                        if(response.isSuccessful()){
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
        colaMon = view.findViewById(R.id.EdC_Dinheiro);
        titulo = view.findViewById(R.id.EdC_Titulo);
        descricao = view.findViewById(R.id.EdC_Descricao);
        genero = view.findViewById(R.id.EdC_Genero);
        dataIni = view.findViewById(R.id.EdC_DataIni);
        dataFim = view.findViewById(R.id.EdC_DataFim);
        inst = view.findViewById(R.id.EdC_Instituicao);
        estado = view.findViewById(R.id.EdC_Estado);
        cidade = view.findViewById(R.id.EdC_Cidade);
        rua = view.findViewById(R.id.EdC_Rua);
        bairro = view.findViewById(R.id.EdC_Bairro);
        numero = view.findViewById(R.id.EdC_Numero);
        editar = view.findViewById(R.id.EdC_Editar);
        excluir = view.findViewById(R.id.EdC_Excluir);
    }
}
