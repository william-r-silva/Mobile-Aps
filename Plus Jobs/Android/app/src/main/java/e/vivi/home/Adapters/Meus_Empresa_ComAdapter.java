package e.vivi.home.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import e.vivi.home.Models.Comentario;
import e.vivi.home.R;

public class Meus_Empresa_ComAdapter extends ArrayAdapter<Comentario> {

    private final Context context;
    private final List<Comentario> elemento;

    public Meus_Empresa_ComAdapter(Context context, List<Comentario> elemento){
        super (context, R.layout.list_meus_comentarios, elemento);
        this.context=context;
        this.elemento=elemento;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView =  inflater.inflate(R.layout.list_meus_comentarios, parent, false);

        TextView empresa = rowView.findViewById(R.id.List_MC_Empresa);
        TextView comentario = rowView.findViewById(R.id.List_MC_Comentario);
        LinearLayout list_fundo = rowView.findViewById(R.id.List_Fundo);

        empresa.setText(elemento.get(position).getEmpresa().getNomeMarca());
        comentario.setText(elemento.get(position).getConteudo());
        if(elemento.get(position).isComenPositivo()) {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.redondo_verde);
            list_fundo.setBackground(drawable);
        }
        return rowView;
    }

}