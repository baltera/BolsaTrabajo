package fia.ues.sv.bolsatrabajo;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FB12001Activity extends ListActivity {
     String[] menu={"Aplicación","Cargo"};
     String[] activities={"AplicacionMenuActivity","CargoMenuActivity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.parseColor("#FF3BE2FF"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick (ListView l,View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
        l.getChildAt(position).setBackgroundColor(Color.parseColor("#ff76c4ff"));

        try{
            Class<?> clase=Class.forName("fia.ues.sv.bolsatrabajo."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }



}
