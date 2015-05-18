package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EmpleadoEliminarActivity extends Activity {

    ControlBD helper;
    EditText editEliminarIdEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_eliminar);
        editEliminarIdEmp=(EditText)findViewById(R.id.editEliminarIdEmp);
        helper= new ControlBD(this);
    }


    public void eliminarEmpleado(View v)
    {
        String regEliminadas;
        Empleado empleado= new Empleado();
        String  idEmpleado=(editEliminarIdEmp.getText().toString());
        helper.abrir();
        empleado=helper.consultarEmpleado(idEmpleado);
        if (empleado==null){
            Toast.makeText(this,"Empleado "+idEmpleado+" inexistente",Toast.LENGTH_LONG).show();
        }else{
            empleado.setId(Integer.parseInt(idEmpleado));
            regEliminadas=helper.eliminarEmpleado(empleado);
            Toast.makeText(this,"Empleado "+idEmpleado+ " Eliminado Exitosamente",Toast.LENGTH_LONG).show();
        }
        helper.cerrar();
    }
}
