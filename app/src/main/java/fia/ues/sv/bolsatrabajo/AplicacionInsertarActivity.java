package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AplicacionInsertarActivity extends Activity {
    ControlBD helper;
    EditText editEstadoAplicacionf;
    EditText editFechaAplicacionf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_insertar);
        helper = new ControlBD(this);
        editFechaAplicacionf = (EditText)findViewById(R.id.editFechaAplicacionf);
        editEstadoAplicacionf= (EditText)findViewById(R.id.editEstadoAplicacionf);
    }
    public void insertarAplicacion(){

        String estadoAplicacionf=editEstadoAplicacionf.getText().toString();
        String fechaAplicacionf=editFechaAplicacionf.getText().toString();
        String registrosInser;
        Aplicacion aplicacion= new Aplicacion();
        aplicacion.setFechaAplicacion(fechaAplicacionf);
        aplicacion.setEstadoAplicacion(estadoAplicacionf);
        helper.abrir();
        registrosInser=helper.insertar(aplicacion);
        helper.cerrar();
        Toast.makeText(this,registrosInser,Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editFechaAplicacionf.setText("");
        editEstadoAplicacionf.setText("");
    }


}
