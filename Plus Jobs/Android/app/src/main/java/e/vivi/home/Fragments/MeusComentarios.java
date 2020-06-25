package e.vivi.home.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import e.vivi.home.Adapters.Meus_Empresa_ComAdapter;
import e.vivi.home.AuxClass;
import e.vivi.home.Models.Comentario;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitComentarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeusComentarios extends Fragment {

    private List<Comentario> lista;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_meus_comentarios, container, false);

        lv = view.findViewById(R.id.List_MeusComentarios);

        SharedPreferences shared = getActivity().getSharedPreferences("PlusJobs", getContext().MODE_PRIVATE);

        int id = shared.getInt("ID_User", 0);

        RetrofitComentarios service = Configs.retrofit.create(RetrofitComentarios.class);
        service.comentariosDoUsuario(id).enqueue(new Callback<List<Comentario>>() {
            @Override
            public void onResponse(Call<List<Comentario>> call, Response<List<Comentario>> response) {
                lista = response.body();
                ArrayAdapter<Comentario> adapter = new Meus_Empresa_ComAdapter(getActivity(), lista);
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Fragment frag = new Editar_Comentario();
                        AuxClass.comentario = lista.get(i);
                        FragmentManager transaction = getActivity().getSupportFragmentManager();
                        transaction.beginTransaction().replace(R.id.frame_content, frag, "Editar Comentário").addToBackStack(null).commit();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Comentario>> call, Throwable t) {
                Toast.makeText(getActivity(), "erro", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
