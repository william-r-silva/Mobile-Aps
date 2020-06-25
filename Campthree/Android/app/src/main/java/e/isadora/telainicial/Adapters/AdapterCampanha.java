package e.isadora.telainicial.Adapters;

import android.content.Context;
import android.content.Intent;
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
import e.isadora.telainicial.PaypallActivity;
import e.isadora.telainicial.R;
import e.isadora.telainicial.Retrofit.Configs;
import e.isadora.telainicial.Retrofit.RetrofitCampanha;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdapterCampanha extends ArrayAdapter<Campanha> {


    private Context context;
    private List<Campanha> elemento;
    private Button acompanhar;
    private Button compartilhar;
    private Button doar;
    private int tela;

    public AdapterCampanha(Context context, List<Campanha> elemento, int tela){
        super (context, 0, elemento);
        this.context=context;
        this.elemento=elemento;
        this.tela = tela;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        if(tela == 0 || tela == 1){
            if(elemento.get(position).isColaboracaoMonetaria()){
                rowView = inflater.inflate(R.layout.adapter_campanhas_treis_bt, parent, false);

                doar = rowView.findViewById(R.id.list_dois_bt3);
                doar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), PaypallActivity.class);
                        getContext().startActivity(intent);
                    }
                });

            }else{
                rowView = inflater.inflate(R.layout.adapter_campanhas_dois_bt, parent, false);
            }
            acompanhar = rowView.findViewById(R.id.list_dois_bt2);
            compartilhar = rowView.findViewById(R.id.list_dois_bt1);
            if(tela == 1){
                acompanhar.setText("Desistir");
            }else{
                acompanhar.setText("Acompanhar");
            }
            acompanhar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(acompanhar.getText().toString().equals("Acompanhar") && tela == 0){
                        RetrofitCampanha service = Configs.retrofit.create(RetrofitCampanha.class);
                        service.acompanhar(elemento.get(position),AuxGlobal.user.getId()).enqueue(new Callback<Campanha>() {
                            @Override
                            public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(getContext(), "Você agora está acompanhando essa campanha!",Toast.LENGTH_SHORT).show();
                                    acompanhar.setText("Desistir");
                                }else{
                                    Toast.makeText(getContext(), "Erro",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Campanha> call, Throwable t) {
                                Toast.makeText(getContext(), "Servidor erro",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        RetrofitCampanha service = Configs.retrofit.create(RetrofitCampanha.class);
                        service.desistir(elemento.get(position),AuxGlobal.user.getId()).enqueue(new Callback<Campanha>() {
                            @Override
                            public void onResponse(Call<Campanha> call, Response<Campanha> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(getContext(), "Você desistiu dessa campanha!",Toast.LENGTH_SHORT).show();
                                    acompanhar.setText("Acompanhar");
                                }else{
                                    Toast.makeText(getContext(), "Erro",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Campanha> call, Throwable t) {
                                Toast.makeText(getContext(), "Servidor erro",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });
            compartilhar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent=new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plan");
                    myIntent.putExtra(Intent.EXTRA_TEXT, elemento.get(position).getNome()+"\n"+elemento.get(position).getDescricao()+"\nNome do responsável: "+elemento.get(position).getUser().getNome()+"\nPara mais informações: "+elemento.get(position).getUser().getEmail());
                    getContext().startActivity(Intent.createChooser(myIntent, "Escolha um meio de compartilhamento."));
                }
            });
        }else{
            rowView =  inflater.inflate(R.layout.adapter_campanhas_zero_bt, parent, false);
        }

        TextView voluntario = rowView.findViewById(R.id.list_voluntario);
        TextView email = rowView.findViewById(R.id.list_email);
        TextView titulo = rowView.findViewById(R.id.list_titulo);
        TextView conteudo = rowView.findViewById(R.id.list_conteudo);
        TextView endereco = rowView.findViewById(R.id.list_enderco);
        voluntario.setText(elemento.get(position).getUser().getNome());
        email.setText(elemento.get(position).getUser().getEmail());
        titulo.setText(elemento.get(position).getNome());
        conteudo.setText(elemento.get(position).getDescricao());
        String local = elemento.get(position).getLocal();
        if(local.contains("a") || local.contains("e") || local.contains("o") || local.contains("i") || local.contains("u")){
            endereco.setText(elemento.get(position).getLocal());
        }

        return rowView;
    }


}
