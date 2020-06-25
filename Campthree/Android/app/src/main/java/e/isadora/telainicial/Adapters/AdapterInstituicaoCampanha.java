package e.isadora.telainicial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import e.isadora.telainicial.AuxGlobal;
import e.isadora.telainicial.Models.Campanha;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitCampanha;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdapterInstituicaoCampanha extends ArrayAdapter<Campanha> {


    private Context context;
    private List<Campanha> elemento;
    private Button acompanhar;

    public AdapterInstituicaoCampanha(Context context, List<Campanha> elemento){
        super (context, R.layout.adapter_campanhas_dois_bt, elemento);
        this.context=context;
        this.elemento=elemento;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView =  inflater.inflate(R.layout.adapter_campanhas_um_bt, parent, false);

        TextView voluntario = rowView.findViewById(R.id.listI_voluntario);
        TextView email = rowView.findViewById(R.id.listI_email);
        TextView titulo = rowView.findViewById(R.id.listI_titulo);
        TextView conteudo = rowView.findViewById(R.id.listI_conteudo);
        TextView endereco = rowView.findViewById(R.id.listI_enderco);

        Button bloquear = rowView.findViewById(R.id.listI_um_bt);

        voluntario.setText(elemento.get(position).getUser().getNome());
        email.setText(elemento.get(position).getUser().getEmail());
        titulo.setText(elemento.get(position).getNome());
        conteudo.setText(elemento.get(position).getDescricao());
        String local = elemento.get(position).getLocal();
        if(local.contains("a") || local.contains("e") || local.contains("o") || local.contains("i") || local.contains("u")){
            endereco.setText(elemento.get(position).getLocal());
        }

        bloquear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elemento.get(position).setAutorizada(false);
                RetrofitCampanha service = Configs.retrofit.create(RetrofitCampanha.class);
                service.editar(elemento.get(position)).enqueue(new Callback<Campanha>() {
                    @Override
                    public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "Estará na sua lista de validação", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "Erro", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Campanha> call, Throwable t) {
                        Toast.makeText(getContext(), "Servidor erro", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return rowView;
    }


}
