package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] menu={"FB12001","FR12001","RG12001","RS07003","SB12002","LLENAR BASE DE DATOS"};
    String[] menu2={"FB12001","FR12001","RG12001","RS07003","SB12002"};

    //Cada uno debe crear sus activities con el numero de carnet para ahí poner los CRUD de sus tablas
    String[] activities={"FB12001Activity","FR12001Activity","RG12001Activity","RS07003Activity","SB12002Activity","LlenarBaseActivity"};
    ControlBD controlBD;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controlBD=new ControlBD(this);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));}


    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);


        if(position!=5) {
            String nombreValue = activities[position];
            try {
                Class<?>
                        clase = Class.forName("fia.ues.sv.bolsatrabajo." + nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }//fin if
        else {
            controlBD.abrir();
            String resp = controlBD.llenarBase();
            controlBD.cerrar();
            Toast.makeText(this, resp, Toast.LENGTH_LONG).show();
            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu2));

        }//fin del else
    }
}