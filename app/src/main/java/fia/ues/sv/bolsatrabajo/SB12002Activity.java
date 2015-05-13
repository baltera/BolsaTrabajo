package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SB12002Activity extends ListActivity {
    String[] menu={"GradoEspecializacion","Referencia"};
    String[] activities={"GradoEspecializacionActivity","ReferenciaActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
        setTitle("Tablas");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String optionValue=activities[position];
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo."+optionValue);
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
