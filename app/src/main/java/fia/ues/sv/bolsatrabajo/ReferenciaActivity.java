package fia.ues.sv.bolsatrabajo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ReferenciaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referencia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_referencia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void insertarRef(View view) {

        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.ReferenciaInsertarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void eliminarReferencia(View view) {

        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.ReferenciaEliminarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void modificarReferencia(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.ReferenciaModificarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void consultarReferencia(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.ReferenciaConsultarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
