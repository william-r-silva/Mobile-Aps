package e.vivi.home.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import e.vivi.home.Models.Empresa;
import e.vivi.home.R;

public class EmpresaAdapter extends ArrayAdapter<Empresa> {

    private final Context context;
    private final List<Empresa> elemento;

    public EmpresaAdapter(Context context, List<Empresa> elemento){
        super (context, R.layout.list_empresas, elemento);
        this.context=context;
        this.elemento=elemento;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView =  inflater.inflate(R.layout.list_empresas, parent, false);

        TextView empresa = rowView.findViewById(R.id.List_E_Nome);
        TextView nivel = rowView.findViewById(R.id.List_E_Bom);

        DecimalFormat df = new DecimalFormat("0.00");
        empresa.setText(elemento.get(position).getNomeMarca());
        nivel.setText("" + df.format(elemento.get(position).getNvTotal()));

        return rowView;
    }

}