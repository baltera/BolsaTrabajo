package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class EmpleadoActualizarActivity extends Activity {

    ControlBD helper;
    EditText editIdEmpleado;
    EditText editNombreEmpleado;
    EditText editDuiEmpleado;
    EditText editSexoEmpleado;
    EditText editEdadEmpleado;
    EditText editDireccionEmpleado;
    EditText editTelefonoEmpleado;
    Button  botonActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_actualizar);
        helper= new ControlBD(this);
        editIdEmpleado =(EditText)findViewById(R.id.editIdEmpleado);
        editNombreEmpleado= (EditText)findViewById(R.id.editNombreEmpleado);
        editDuiEmpleado=(EditText)findViewById(R.id.editDuiEmpleado);
        editSexoEmpleado=(EditText)findViewById(R.id.editSexoEmpleado);
        editEdadEmpleado=(EditText)findViewById(R.id.editEdadEmpleado);
        editDireccionEmpleado=(EditText)findViewById(R.id.editDireccionEmpleado);
        editTelefonoEmpleado=(EditText)findViewById(R.id.editTelefonoEmpleado);
        botonActualizar=(Button)findViewById(R.id.botonActualizar);

    }

    public void verificarEmpleado(View v) {
        helper.abrir();
        Empleado empleado= helper.consultarEmpleado(editIdEmpleado.getText().toString());
        helper.cerrar();
        if (empleado == null) {
            Toast.makeText(this, "Empleado " + editIdEmpleado.getText().toString() + " Inexistente", Toast.LENGTH_LONG).show();
        } else {
            editNombreEmpleado.setText(empleado.getNombre_empleado());
            editDuiEmpleado.setText(String.valueOf(empleado.getDui_empleado()));
            editSexoEmpleado.setText(empleado.getSexo_empleado());
            editEdadEmpleado.setText(String.valueOf(empleado.getEdad_empleado()));
            editDireccionEmpleado.setText(empleado.getDireccion_empleado());
            editTelefonoEmpleado.setText(String.valueOf(empleado.getTelefono_empleado()));
            botonActualizar.setEnabled(true);
        }
    }
    public void actualizarEmpleado(View v) {

            Empleado empleado = new Empleado();
            empleado.setId(Integer.parseInt(editIdEmpleado.getText().toString()));
            empleado.setNombre_empleado(editNombreEmpleado.getText().toString());
            empleado.setDui_empleado(Integer.parseInt(editDuiEmpleado.getText().toString()));
            empleado.setSexo_empleado(editSexoEmpleado.getText().toString());
            empleado.setEdad_empleado(Integer.parseInt(editEdadEmpleado.getText().toString()));
            empleado.setDireccion_empleado(editDireccionEmpleado.getText().toString());
            empleado.setTelefono_empleado(Integer.parseInt(editTelefonoEmpleado.getText().toString()));
            helper.abrir();
            String estado = helper.actualizarEmpleado(empleado);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_LONG).show();


        }



    public void limpiarActualizar(View v){
        editIdEmpleado.setText("");
        editNombreEmpleado.setText("");
        editDuiEmpleado.setText("");
        editEdadEmpleado.setText("");
        editSexoEmpleado.setText("");
        editDireccionEmpleado.setText("");
        editTelefonoEmpleado.setText("");
        botonActualizar.setEnabled(false);

    }

}
