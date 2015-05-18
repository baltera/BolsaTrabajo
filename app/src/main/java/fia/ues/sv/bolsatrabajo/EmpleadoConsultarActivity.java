package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EmpleadoConsultarActivity extends Activity {

    ControlBD helper;
    EditText editIdEmpleado;
    EditText editNombreEmpleado;
    EditText editDuiEmpleado;
    EditText editSexoEmpleado;
    EditText editEdadEmpleado;
    EditText editDireccionEmpleado;
    EditText editTelefonoEmpleado;
    EditText editCantApEmpleado;
    EditText editCantRefEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_consultar);
        helper = new ControlBD(this);
        editIdEmpleado= (EditText)findViewById(R.id.editConsultarIdEmp);
        editNombreEmpleado=(EditText)findViewById(R.id.editConsultarNomEmp);
        editDuiEmpleado=(EditText)findViewById(R.id.editConsultarDuiEmp);
        editSexoEmpleado=(EditText)findViewById(R.id.editConsultarSexEmp);
        editEdadEmpleado=(EditText)findViewById(R.id.editConsultarEdadEmp);
        editDireccionEmpleado=(EditText)findViewById(R.id.editConsultarDirecEmp);
        editTelefonoEmpleado=(EditText)findViewById(R.id.editConsultarTelEmp);
        editCantApEmpleado=(EditText)findViewById(R.id.editConsultarCantApEmp);
        editCantRefEmpleado=(EditText)findViewById(R.id.editConsultarCantRefEmp);
    }


    public void consultarEmpleado(View v) {
        helper.abrir();
        Empleado empleado = helper.consultarEmpleado(editIdEmpleado.getText().toString());
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
            editCantRefEmpleado.setText(String.valueOf(empleado.getCantAplicaciones_empleado()));
            editCantRefEmpleado.setText(String.valueOf(empleado.getCantReferencias_empleado()));
        }
    }
        public void limpiarConsulta(View v){
            editIdEmpleado.setText("");
            editNombreEmpleado.setText("");
            editDuiEmpleado.setText("");
            editEdadEmpleado.setText("");
            editSexoEmpleado.setText("");
            editDireccionEmpleado.setText("");
            editTelefonoEmpleado.setText("");
            editCantRefEmpleado.setText("");
            editCantRefEmpleado.setText("");

        }

    }