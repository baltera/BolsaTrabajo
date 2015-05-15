package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EmpleadoActivity extends ListActivity {

    String[] menu={"Insertar Empleado","Consultar Empleado","Actualizar Empleado","Eliminar Empleado"};
    String[] activities={"EmpleadoInsertarActivity","EmpleadoConsultarActivity","EmpleadoActualizarActivity","EmpleadoEliminarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_empleado);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menu));
        ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#CC9999"));
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue= activities[position];
        try {
            Class<?> clase = Class.forName("fia.ues.sv.bolsatrabajo."+nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
