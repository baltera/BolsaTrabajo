package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FR12001Activity extends ListActivity {


    String[] menu = {"Empleado", "Experiencia Laboral"};
    String[] activities = {"EmpleadoActivity", "ExperienciaLaboralActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fr12001);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#CC6699"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];
        l.getChildAt(position).setBackgroundColor(Color.parseColor("#CC9999"));
        try {
            Class<?> clase = Class.forName("fia.ues.sv.bolsatrabajo." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}