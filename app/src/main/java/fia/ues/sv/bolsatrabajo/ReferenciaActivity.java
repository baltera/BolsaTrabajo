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


    public void insertarReferencia(View view) {
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
