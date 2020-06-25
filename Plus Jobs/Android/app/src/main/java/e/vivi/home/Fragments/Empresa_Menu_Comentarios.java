package e.vivi.home.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import e.vivi.home.Adapters.Meus_Empresa_ComAdapter;
import e.vivi.home.Models.Comentario;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitComentarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Empresa_Menu_Comentarios extends Fragment {

    private ListView lv;
    private ArrayList<Comentario> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_comentarios_empresa, container, false);

        lv = view.findViewById(R.id.List_EmpresMenu);
        list = new ArrayList<Comentario>();

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        int id = (int)bundle.get("ID_Empresa");



        RetrofitComentarios service = Configs.retrofit.create(RetrofitComentarios.class);
        service.comentariosDaEmpresa(id).enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                list.addAll(response.body());
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {

            }
        });

        ArrayAdapter<Comentario> adapter = new Meus_Empresa_ComAdapter(getActivity(), list);
        lv.setAdapter(adapter);

        return view;
    }
}
