package fia.ues.sv.bolsatrabajo;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;


public class EmpleadoInsertarActivity extends Activity {

    EditText editNombreEmpleado;
    EditText editDuiEmpleado;
    RadioButton radio_femenino;
    RadioButton radio_masculino;
    EditText editEdadEmpleado;
    EditText editDireccionEmpleado;
    EditText editTelefonoEmpleado;
    EditText editCantApEmpleado;
    EditText editCantRefEmpleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado_insertar);
        editNombreEmpleado= (EditText)findViewById(R.id.editNombreEmpleado);
        editDuiEmpleado=(EditText)findViewById(R.id.editDuiEmpleado);
        radio_femenino=(RadioButton)findViewById(R.id.radio_femenino);
        radio_masculino=(RadioButton)findViewById(R.id.radio_masculino);
        editEdadEmpleado=(EditText)findViewById(R.id.editEdadEmpleado);
        editDireccionEmpleado=(EditText)findViewById(R.id.editDireccionEmpleado);
        editTelefonoEmpleado=(EditText)findViewById(R.id.editTelefonoEmpleado);
        editCantApEmpleado=(EditText)findViewById(R.id.editCantApEmpleado);
        editCantRefEmpleado=(EditText)findViewById(R.id.editCantRefEmpleado);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_empleado_insertar, menu);
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
}
