package e.vivi.home.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import e.vivi.home.Models.Empresa;
import e.vivi.home.R;
import e.vivi.home.Retrofit.Configs;
import e.vivi.home.Retrofit.RetrofitEmpresa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Empresa_Menu_Informacoes extends Fragment {

    private TextView regime;
    private TextView nvTotal;
    private TextView nvEstresse;
    private TextView nvEsforcoFis;
    private TextView nvEsforcoMen;
    private TextView nvRelaCol;
    private TextView nvRelaChef;
    private TextView nvCobranca;
    private TextView nvComunInt;
    private TextView nvValorizacao;
    private TextView nvCrescInt;
    private TextView nvNegSalBen;
    private TextView nvAcesLocal;
    private TextView nvAcesPDC;
    private TextView nvSaude;
    private TextView nvReficao;
    private TextView nvAlimen;
    private TextView nvTrans;

    private TextView estado;
    private TextView cidade;
    private TextView rua;
    private TextView bairro;
    private TextView numero;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_dados_empresa, container, false);
        start(view);

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        int id = (int)bundle.get("ID_Empresa");

        RetrofitEmpresa service = Configs.retrofit.create(RetrofitEmpresa.class);
        service.buscarEmpresa(id).enqueue(new Callback<Empresa>() {
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                Empresa emp = response.body();

                System.out.println(emp.toString());

                DecimalFormat df = new DecimalFormat("0.00");
                nvTotal.setText(""+df.format(emp.getNvTotal()));
                if(emp.getNroComentarios()==0)
                    emp.setNroComentarios(1);

                regime.setText(regime.getText().toString()+emp.getTipoRegimeTrabalho());
                nvEstresse.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvEstresse()));
                nvEsforcoFis.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvEsfocoFisico()));
                nvEsforcoMen.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvEsforcoItelectual()));
                nvValorizacao.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvValorizacaoTrabalho()));
                nvTrans.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvValeTransporte()));
                nvAlimen.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvValeAlimentacao()));
                nvReficao.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvValeRefeicao()));
                nvCrescInt.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvPossibilidadeCresimento()));
                nvRelaCol.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvRelacionamentoColaboradores()));
                nvSaude.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvPlanoSaude()));
                nvAcesPDC.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvAcessibilidade()));
                nvAcesLocal.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvAcessoTerreno()));
                nvNegSalBen.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvNogociacaoDeSalarioBeneficio()));
                nvComunInt.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvComunicacaoInterna()));
                nvCobranca.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvCobranca()));
                nvRelaChef.setText(calculaPorcentagem(emp.getNroComentarios(), emp.getNvFacilidadeAcessoSuperiores()));

                estado.setText(emp.getEstado());
                cidade.setText(emp.getCidade());
                rua.setText(emp.getRua());
                bairro.setText(emp.getBairro());
                numero.setText(""+emp.getNumero());

            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                Toast.makeText(getContext(),"Sem empresa", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void start(View view){
        regime = view.findViewById(R.id.Reg_Emp);

        estado = view.findViewById(R.id.Estado);
        cidade = view.findViewById(R.id.Cidade);
        numero = view.findViewById(R.id.Nro);
        rua = view.findViewById(R.id.Rua);
        bairro = view.findViewById(R.id.Bairro);

        nvTotal = view.findViewById(R.id.NVT_Emp);
        nvEstresse = view.findViewById(R.id.R_Emp1);
        nvEsforcoFis = view.findViewById(R.id.R_Emp2);
        nvEsforcoMen = view.findViewById(R.id.R_Emp3);
        nvRelaCol = view.findViewById(R.id.R_Emp4);
        nvRelaChef = view.findViewById(R.id.R_Emp5);
        nvCobranca = view.findViewById(R.id.R_Emp6);
        nvComunInt = view.findViewById(R.id.R_Emp7);
        nvValorizacao = view.findViewById(R.id.R_Emp8);
        nvCrescInt = view.findViewById(R.id.R_Emp9);
        nvNegSalBen = view.findViewById(R.id.R_Emp10);
        nvAcesLocal = view.findViewById(R.id.R_Emp11);
        nvAcesPDC = view.findViewById(R.id.R_Emp12);
        nvSaude = view.findViewById(R.id.R_Emp13);
        nvReficao = view.findViewById(R.id.R_Emp14);
        nvAlimen = view.findViewById(R.id.R_Emp15);
        nvTrans = view.findViewById(R.id.R_Emp16);
    }

    private String calculaPorcentagem(double n, double pessoas){

        double Res = (pessoas*10)/n;
        DecimalFormat df = new DecimalFormat("0.00");

        return ""+df.format(Res);
    }
}
