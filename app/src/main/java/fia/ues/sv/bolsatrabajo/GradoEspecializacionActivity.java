package fia.ues.sv.bolsatrabajo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class GradoEspecializacionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_especializacion);
    }

    public void insertarGradoEspec(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.GradoEspecializacionInsertarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGradoEspec(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.GradoEspecializacionEliminarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void modificarGradoEspec(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.GradoEspecializacionModificarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void consultarGradoEspec(View view) {
        try{
            Class <?> clase=Class.forName("fia.ues.sv.bolsatrabajo.GradoEspecializacionConsultarActivity");
            Intent intento=new Intent(this,clase);
            startActivity(intento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
