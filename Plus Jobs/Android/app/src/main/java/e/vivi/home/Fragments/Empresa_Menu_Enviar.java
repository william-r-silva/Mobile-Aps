package e.vivi.home.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import e.vivi.home.Models.Comentario;
import e.vivi.home.Models.Empresa;
import e.vivi.home.Models.User;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitComentarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Empresa_Menu_Enviar extends Fragment {

    private Switch comenPos;
    private EditText coment;

    private ImageButton E_L_1;
    private ImageButton E_D_1;

    private ImageButton E_L_2;
    private ImageButton E_D_2;

    private ImageButton E_L_3;
    private ImageButton E_D_3;

    private ImageButton E_L_4;
    private ImageButton E_D_4;

    private ImageButton E_L_5;
    private ImageButton E_D_5;

    private ImageButton E_L_6;
    private ImageButton E_D_6;

    private ImageButton E_L_7;
    private ImageButton E_D_7;

    private ImageButton E_L_8;
    private ImageButton E_D_8;

    private ImageButton E_L_9;
    private ImageButton E_D_9;

    private ImageButton E_L_10;
    private ImageButton E_D_10;

    private ImageButton E_L_11;
    private ImageButton E_D_11;

    private ImageButton E_L_12;
    private ImageButton E_D_12;

    private ImageButton E_L_13;
    private ImageButton E_D_13;

    private ImageButton E_L_14;
    private ImageButton E_D_14;

    private ImageButton E_L_15;
    private ImageButton E_D_15;

    private ImageButton E_L_16;
    private ImageButton E_D_16;

    private Button enviar;

    private Comentario comentario = new Comentario();

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_enviar_empresa, container, false);

            start();

            E_L_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_1.setImageResource(R.drawable.like_verde);
                    E_D_1.setImageResource(R.drawable.deslike);
                    comentario.setNvComunicacaoInterna((short) 1);
                }
            });
            E_D_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_1.setImageResource(R.drawable.like);
                    E_D_1.setImageResource(R.drawable.deslike_red);
                    comentario.setNvComunicacaoInterna((short) 0);
                }
            });

            E_L_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_2.setImageResource(R.drawable.like_verde);
                    E_D_2.setImageResource(R.drawable.deslike);
                    comentario.setNvEsforcoFisico((short) 1);
                }
            });
            E_D_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_2.setImageResource(R.drawable.like);
                    E_D_2.setImageResource(R.drawable.deslike_red);
                    comentario.setNvEsforcoFisico((short) 0);
                }
            });

            E_L_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_3.setImageResource(R.drawable.like_verde);
                    E_D_3.setImageResource(R.drawable.deslike);
                    comentario.setNvEstresse((short) 1);
                }
            });
            E_D_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_3.setImageResource(R.drawable.like);
                    E_D_3.setImageResource(R.drawable.deslike_red);
                    comentario.setNvEstresse((short) 0);
                }
            });

            E_L_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_4.setImageResource(R.drawable.like_verde);
                    E_D_4.setImageResource(R.drawable.deslike);
                    comentario.setNvFacilidadeAcessoSuperiores((short) 1);
                }
            });
            E_D_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_4.setImageResource(R.drawable.like);
                    E_D_4.setImageResource(R.drawable.deslike_red);
                    comentario.setNvFacilidadeAcessoSuperiores((short) 0);
                }
            });

            E_L_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_5.setImageResource(R.drawable.like_verde);
                    E_D_5.setImageResource(R.drawable.deslike);
                    comentario.setNvEsforcoItelectual((short) 1);
                }
            });
            E_D_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_5.setImageResource(R.drawable.like);
                    E_D_5.setImageResource(R.drawable.deslike_red);
                    comentario.setNvEsforcoItelectual((short) 0);
                }
            });

            E_L_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_6.setImageResource(R.drawable.like_verde);
                    E_D_6.setImageResource(R.drawable.deslike);
                    comentario.setNvRelacionamentoColaboradores((short) 1);
                }
            });
            E_D_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_6.setImageResource(R.drawable.like);
                    E_D_6.setImageResource(R.drawable.deslike_red);
                    comentario.setNvRelacionamentoColaboradores((short) 0);
                }
            });

            E_L_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_7.setImageResource(R.drawable.like_verde);
                    E_D_7.setImageResource(R.drawable.deslike);
                    comentario.setNvCobranca((short) 1);
                }
            });
            E_D_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_7.setImageResource(R.drawable.like);
                    E_D_7.setImageResource(R.drawable.deslike_red);
                    comentario.setNvCobranca((short) 0);
                }
            });

            E_L_8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_8.setImageResource(R.drawable.like_verde);
                    E_D_8.setImageResource(R.drawable.deslike);
                    comentario.setNvValorizacaoTrabalho((short) 1);
                }
            });
            E_D_8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_8.setImageResource(R.drawable.like);
                    E_D_8.setImageResource(R.drawable.deslike_red);
                    comentario.setNvValorizacaoTrabalho((short) 0);
                }
            });

            E_L_9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_9.setImageResource(R.drawable.like_verde);
                    E_D_9.setImageResource(R.drawable.deslike);
                    comentario.setNvPossibilidadeCresimento((short) 1);
                }
            });
            E_D_9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_9.setImageResource(R.drawable.like);
                    E_D_9.setImageResource(R.drawable.deslike_red);
                    comentario.setNvPossibilidadeCresimento((short) 0);
                }
            });

            E_L_10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_10.setImageResource(R.drawable.like_verde);
                    E_D_10.setImageResource(R.drawable.deslike);
                    comentario.setNvNogociacaoDeSalarioBeneficio((short) 1);
                }
            });
            E_D_10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_10.setImageResource(R.drawable.like);
                    E_D_10.setImageResource(R.drawable.deslike_red);
                    comentario.setNvNogociacaoDeSalarioBeneficio((short) 0);
                }
            });

            E_L_11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_11.setImageResource(R.drawable.like_verde);
                    E_D_11.setImageResource(R.drawable.deslike);
                    comentario.setNvAcessoTerreno((short) 1);
                }
            });
            E_D_11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_11.setImageResource(R.drawable.like);
                    E_D_11.setImageResource(R.drawable.deslike_red);
                    comentario.setNvAcessoTerreno((short) 0);
                }
            });

            E_L_12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_12.setImageResource(R.drawable.like_verde);
                    E_D_12.setImageResource(R.drawable.deslike);
                    comentario.setNvAcessibilidade((short) 1);
                }
            });
            E_D_12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_12.setImageResource(R.drawable.like);
                    E_D_12.setImageResource(R.drawable.deslike_red);
                    comentario.setNvAcessibilidade((short) 0);
                }
            });

            E_L_13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_13.setImageResource(R.drawable.like_verde);
                    E_D_13.setImageResource(R.drawable.deslike);
                    comentario.setNvPlanoSaude((short) 1);
                }
            });
            E_D_13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_13.setImageResource(R.drawable.like);
                    E_D_13.setImageResource(R.drawable.deslike_red);
                    comentario.setNvPlanoSaude((short) 0);
                }
            });

            E_L_14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_14.setImageResource(R.drawable.like_verde);
                    E_D_14.setImageResource(R.drawable.deslike);
                    comentario.setNvValeRefeicao((short) 1);
                }
            });
            E_D_14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_14.setImageResource(R.drawable.like);
                    E_D_14.setImageResource(R.drawable.deslike_red);
                    comentario.setNvValeRefeicao((short) 0);
                }
            });

            E_L_15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_15.setImageResource(R.drawable.like_verde);
                    E_D_15.setImageResource(R.drawable.deslike);
                    comentario.setNvValeAlimentacao((short) 1);
                }
            });
            E_D_15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_15.setImageResource(R.drawable.like);
                    E_D_15.setImageResource(R.drawable.deslike_red);
                    comentario.setNvValeAlimentacao((short) 0);
                }
            });

            E_L_16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_16.setImageResource(R.drawable.like_verde);
                    E_D_16.setImageResource(R.drawable.deslike);
                    comentario.setNvValeTransporte((short) 1);
                }
            });
            E_D_16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    E_L_16.setImageResource(R.drawable.like);
                    E_D_16.setImageResource(R.drawable.deslike_red);
                    comentario.setNvValeTransporte((short) 0);
                }
            });

            enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comentario.setConteudo(coment.getText().toString());
                    comentario.setComenPositivo(comenPos.isChecked());
                    Intent intent = getActivity().getIntent();
                    Bundle bundle = intent.getExtras();
                    User user = new User();
                    SharedPreferences shared = getActivity().getSharedPreferences("PlusJobs", getContext().MODE_PRIVATE);
                    user.setId(shared.getInt("ID_User", 0));
                    comentario.setUser(user);
                    Empresa empresa = new Empresa();
                    if(intent.hasExtra("ID_Empresa"))
                    empresa.setId((Integer) bundle.get("ID_Empresa"));
                    comentario.setEmpresa(empresa);
                    RetrofitComentarios retrofitComentarios = Configs.retrofit.create(RetrofitComentarios.class);
                    retrofitComentarios.cadastrar(comentario).enqueue(new Callback<Comentario>() {
                        @Override
                        public void onResponse(Call<Comentario> call, Response<Comentario> response) {
                            Intent intent = getActivity().getIntent();
                            getActivity().finish();
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Comentario> call, Throwable t) {
                            Toast.makeText(getContext(),"Falhou",Toast.LENGTH_SHORT).show();
                        }
                    });

                    //Colocar aqui
                }
            });

        return view;
    }

    private void start(){
        comenPos = view.findViewById(R.id.E_ComenPos);
        coment = view.findViewById(R.id.E_Comentario);
        enviar = view.findViewById(R.id.E_Enviar);

        E_L_1 = view.findViewById(R.id.E_L_1);
        E_D_1 = view.findViewById(R.id.E_D_1);

        E_L_2 = view.findViewById(R.id.E_L_2);
        E_D_2 = view.findViewById(R.id.E_D_2);

        E_L_3 = view.findViewById(R.id.E_L_3);
        E_D_3 = view.findViewById(R.id.E_D_3);

        E_L_4 = view.findViewById(R.id.E_L_4);
        E_D_4 = view.findViewById(R.id.E_D_4);

        E_L_5 = view.findViewById(R.id.E_L_5);
        E_D_5 = view.findViewById(R.id.E_D_5);

        E_L_6 = view.findViewById(R.id.E_L_6);
        E_D_6 = view.findViewById(R.id.E_D_6);

        E_L_7 = view.findViewById(R.id.E_L_7);
        E_D_7 = view.findViewById(R.id.E_D_7);

        E_L_8 = view.findViewById(R.id.E_L_8);
        E_D_8 = view.findViewById(R.id.E_D_8);

        E_L_9 = view.findViewById(R.id.E_L_9);
        E_D_9 = view.findViewById(R.id.E_D_9);

        E_L_10 = view.findViewById(R.id.E_L_10);
        E_D_10 = view.findViewById(R.id.E_D_10);

        E_L_11 = view.findViewById(R.id.E_L_11);
        E_D_11 = view.findViewById(R.id.E_D_11);

        E_L_12 = view.findViewById(R.id.E_L_12);
        E_D_12 = view.findViewById(R.id.E_D_12);

        E_L_13 = view.findViewById(R.id.E_L_13);
        E_D_13 = view.findViewById(R.id.E_D_13);

        E_L_14 = view.findViewById(R.id.E_L_14);
        E_D_14 = view.findViewById(R.id.E_D_14);

        E_L_15 = view.findViewById(R.id.E_L_15);
        E_D_15 = view.findViewById(R.id.E_D_15);

        E_L_16 = view.findViewById(R.id.E_L_16);
        E_D_16 = view.findViewById(R.id.E_D_16);

    }
}
