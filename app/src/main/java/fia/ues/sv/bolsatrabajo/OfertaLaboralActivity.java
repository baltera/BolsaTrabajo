package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OfertaLaboralActivity extends ListActivity {
    String[] opc = {"Crear oferta","Consultar oferta","Actualizar oferta","Eliminar oferta"};
    String[] act = {"OLInsertarActivity","OLConsultarActivity","OLActualizarActivity","OLEliminarActivity"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, opc));
    }

    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=act[position];
        try{
            Class<?> clase=Class.forName("fia.ues.sv.bolsatrabajo."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();

        }
    }
}