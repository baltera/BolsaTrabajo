package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AplicacionEliminarActivity extends Activity {
    ControlBD helper;
    EditText editIdAplicacionf;
    EditText editIdEmpleado;
    EditText editIdOfertaLaboralf;
    EditText editIdEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_eliminar);
        helper= new ControlBD(this);
        editIdAplicacionf= (EditText)findViewById(R.id.editIdAplicacionf);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdOfertaLaboralf=(EditText)findViewById(R.id.editIdOfertaLaboralf);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
    }
    public void eliminarAplicacion(View v){
        String regEliminados;
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setIdAplicacion(Integer.valueOf(editIdAplicacionf.getText().toString()));
        aplicacion.setIdEmpleado(Integer.valueOf(editIdEmpleado.getText().toString()));
        aplicacion.setIdOfertaLaboral(Integer.valueOf(editIdOfertaLaboralf.getText().toString()));
        aplicacion.setIdEmpresa(Integer.valueOf(editIdEmpresa.getText().toString()));
        helper.abrir();
        regEliminados=helper.eliminar(aplicacion);
        Toast.makeText(this,regEliminados,Toast.LENGTH_SHORT).show();

    }



}
