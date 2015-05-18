package fia.ues.sv.bolsatrabajo;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class EmpleadoInsertarActivity extends Activity {

    ControlBD helper;
    EditText editNombreEmpleado;
    EditText editDuiEmpleado;
    RadioButton radio_femenino;
    RadioButton radio_masculino;
    EditText editEdadEmpleado;
    EditText editDireccionEmpleado;
    EditText editTelefonoEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_insertar);
        helper= new ControlBD(this);
        editNombreEmpleado= (EditText)findViewById(R.id.editNombreEmpleado);
        editDuiEmpleado=(EditText)findViewById(R.id.editDuiEmpleado);
        radio_femenino=(RadioButton)findViewById(R.id.radio_femenino);
        radio_masculino=(RadioButton)findViewById(R.id.radio_masculino);
        editEdadEmpleado=(EditText)findViewById(R.id.editEdadEmpleado);
        editDireccionEmpleado=(EditText)findViewById(R.id.editDireccionEmpleado);
        editTelefonoEmpleado=(EditText)findViewById(R.id.editTelefonoEmpleado);

    }

    public void insertarEmpleado(View v){
        String nombre=editNombreEmpleado.getText().toString();
        String dui=editDuiEmpleado.getText().toString();
        String edad=editEdadEmpleado.getText().toString();

        String direccion=editDireccionEmpleado.getText().toString();
        String telefono=editTelefonoEmpleado.getText().toString();
        String regInsertado;
         if(nombre ==null || dui==null || edad ==null || direccion ==null || telefono ==null
                 || (radio_femenino.isChecked()== false && radio_masculino.isChecked()==false))

         { Toast.makeText(this,"INGRESE TODOS LOS DATOS",Toast.LENGTH_SHORT).show();}
        else {
             Empleado empleado = new Empleado();
             helper.abrir();
             int idL = helper.buscarId() + 1;
             empleado.setId(idL);
             empleado.setNombre_empleado(nombre);
             empleado.setDui_empleado(Integer.parseInt(dui));
             if (radio_femenino.isChecked()) {
                 empleado.setSexo_empleado("F");
             } else {
                 empleado.setSexo_empleado("M");
             }
             empleado.setEdad_empleado(Integer.parseInt(edad));
             empleado.setDireccion_empleado(direccion);
             empleado.setTelefono_empleado(Integer.parseInt(telefono));
             empleado.setCantAplicaciones_empleado(0);
             empleado.setCantReferencias_empleado(0);
             //helper.abrir();
             regInsertado = helper.insertar(empleado);
             helper.cerrar();
             Toast.makeText(this, regInsertado, Toast.LENGTH_LONG).show();
         }//fin del else

    }

    public void limpiarEmpleado(View v){
        editNombreEmpleado.setText("");
        editDuiEmpleado.setText("");
        editEdadEmpleado.setText("");
        radio_femenino.setChecked(false);
        radio_masculino.setChecked(false);
        editDireccionEmpleado.setText("");
        editTelefonoEmpleado.setText("");

    }



}
