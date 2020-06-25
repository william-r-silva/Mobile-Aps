package e.vivi.home.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.vivi.home.Adapters.EmpresaAdapter;
import e.vivi.home.Models.Empresa;
import e.vivi.home.EmpresaMenu;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitEmpresa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcurarEmpresas extends Fragment {

    private List<Empresa> list;
    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_empresas, container, false);

        lv = view.findViewById(R.id.List_Empesa);

        RetrofitEmpresa service = Configs.retrofit.create(RetrofitEmpresa.class);
        service.listarEmpresa().enqueue(new Callback<List<Empresa>>() {
            @Override
            public void onResponse(Call<List<Empresa>> call, Response<List<Empresa>> response) {
                list = response.body();
                ArrayAdapter<Empresa> adapter = new EmpresaAdapter(getActivity(), list);
                lv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Empresa>> call, Throwable t) {
                Toast.makeText(getContext(), "erro", Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), EmpresaMenu.class);
                intent.putExtra("ID_Empresa", list.get(i).getId());
                startActivity(intent);
            }
        });

        return view;
    }
}
