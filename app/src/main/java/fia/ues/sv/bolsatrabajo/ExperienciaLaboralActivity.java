package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ExperienciaLaboralActivity extends ListActivity {

    String[] menu={"Agregar Exp.Laboral","Consular Exp.Laboral","Modificar Exp. Laboral","Eliminar Exp.Laboral"};
    String[] activities={"ExpLaboralInsertarActivity","ExpLaboralConsultarActivity","ExpLaboralModificarActivity","ExpLaboralEliminarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_experiencia_laboral);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#CC9999"));
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

    }

    @Override
    protected void onListItemClick(ListView l, View v,int position,long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
        try{
            Class<?> clase= Class.forName("fia.ues.sv.bolsatrabajo."+nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        }catch (ClassNotFoundException e)
        {e.printStackTrace();}
    }


}
