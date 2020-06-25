package e.isadora.telainicial.Fragments.Voluntario;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.isadora.telainicial.Adapters.AdapterCampanha;
import e.isadora.telainicial.AuxGlobal;
import e.isadora.telainicial.Models.Campanha;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitCampanha;
import e.isadora.telainicial.Retrofit.RetrofitUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarCampanhas extends Fragment {

    private List<Campanha> lista;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_campanhas, container, false);

        lista = new ArrayList<>();
        lv = view.findViewById(R.id.campanhas_lista);

        RetrofitUser service = Configs.retrofit.create(RetrofitUser.class);
        service.buscarSemRelacao(AuxGlobal.user.getId()).enqueue(new Callback<List<Campanha>>() {
            @Override
            public void onResponse(Call<List<Campanha>> call, Response<List<Campanha>> response) {
                if(response.isSuccessful()){
                    lista.addAll(response.body());
                    AdapterCampanha adapterCampanha = new AdapterCampanha(getContext(), lista, 0);
                    lv.setAdapter(adapterCampanha);
                }else{
                    Toast.makeText(getContext(), "Erro", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Campanha>> call, Throwable t) {
                Toast.makeText(getContext(), "Servidor erro", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private ArrayList<Campanha> Teste(){
        ArrayList<Campanha> ar = new ArrayList<>();
        Campanha campanha = new Campanha();
        campanha.setUser(AuxGlobal.user);
        campanha.setDescricao("Comida");
        campanha.setNome("Mata fome");
        campanha.setLocal("");
        ar.add(campanha);
        return  ar;
    }
}
