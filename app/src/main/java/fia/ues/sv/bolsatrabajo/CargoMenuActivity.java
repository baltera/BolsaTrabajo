package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
//import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class CargoMenuActivity extends ListActivity {
    String[] submenu={"Insertar Registro","Eliminar Registro","Consultar Registro","Actualizar Registro"};
    String[] activities={"CargoInsertarActivity","CargoEliminarActivity","CargoConsultarActivity","CargoConsultarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,submenu);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick (ListView l,View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
        //l.getChildAt(position).setBackgroundColor(Color.rgb(128,128,255));
        try{
            Class<?> clase=Class.forName("fia.ues.sv.bolsatrabajo."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }



}
