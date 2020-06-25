package e.vivi.home.Fragments;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import e.vivi.home.Adapters.Meus_Empresa_ComAdapter;
import e.vivi.home.Models.Comentario;
import e.vivi.home.Models.Empresa;
import e.vivi.home.R;
import e.vivi.home.Retrofit.RetrofitComentarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import e.vivi.home.Retrofit.Configs;

public class UltimosComentarios extends Fragment {

    private List<Comentario> lista;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ultimos_comentarios, container, false);

        lv = view.findViewById(R.id.Lista_UltimosComentarios);

        RetrofitComentarios service = Configs.retrofit.create(RetrofitComentarios.class);
        service.comentarios().enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                lista = response.body();
                ArrayAdapter<Comentario> adapter = new Meus_Empresa_ComAdapter(getActivity(), lista);
                lv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {


            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        return view;
    }
}
