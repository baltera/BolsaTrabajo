package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ExpLaboralModificarActivity extends Activity {
    EditText idExpLabModificar;
    EditText idEmpleadoELModificar;
    Button  buttonModificarExpLab;
    Button  buttonActualizarELModificar;
    EditText idEmpresaELModificar;
    EditText    idCargoELModificar;
    EditText duracionELModificar;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_laboral_modificar);
        idExpLabModificar=(EditText)findViewById(R.id.idExpLabModificar);
        idEmpleadoELModificar=(EditText)findViewById(R.id.idEmpleadoELModificar);
        idEmpresaELModificar=(EditText)findViewById(R.id.idEmpresaELModificar);
        idCargoELModificar=(EditText)findViewById(R.id.idCargoELModificar);
        duracionELModificar=(EditText)findViewById(R.id.duracionELModificar);
        buttonActualizarELModificar=(Button)findViewById(R.id.buttonActualizarELModificar);
        buttonModificarExpLab=(Button)findViewById(R.id.buttonModificarExpLab);
        helper=new ControlBD(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exp_laboral_modificar, menu);
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

    public void modificarEL(View v){
        helper.abrir();
        ExperienciaLaboral el= helper.verificarIntegridadConsultar(idExpLabModificar.getText().toString(),idEmpleadoELModificar.getText().toString());
        helper.cerrar();
        if (el == null) {
            Toast.makeText(this,"Experiencia Laboral no concuerda con Empleado", Toast.LENGTH_LONG).show();
        } else {
            idEmpresaELModificar.setText(String.valueOf(el.getIdEmpresa()));
            idCargoELModificar.setText(String.valueOf(el.getIdCargo()));
            duracionELModificar.setText(String.valueOf(el.getDuracionExpLaboral()));
            buttonActualizarELModificar.setEnabled(true);
            idExpLabModificar.setEnabled(false);
            idEmpleadoELModificar.setEnabled(false);
        }

    }
    public void actualizarEL(View v){
        ExperienciaLaboral el= new ExperienciaLaboral();
        String idEL=idExpLabModificar.getText().toString();
        String idEmpEL=idEmpleadoELModificar.getText().toString();
        String idEmpresaEL=idEmpresaELModificar.getText().toString();
        String idCarEL=idCargoELModificar.getText().toString();
        String duracEL=duracionELModificar.getText().toString();
        el.setIdExpLaboral(Integer.valueOf(idEL));
        el.setIdEmpleado(Integer.valueOf(idEmpEL));
        el.setIdEmpresa(Integer.valueOf(idEmpresaEL));
        el.setIdCargo(Integer.valueOf(idCarEL));
        el.setDuracionExpLaboral(Integer.valueOf(duracEL));
        helper.abrir();
        String res=helper.actualizarEL(el);
        helper.cerrar();
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

        }


    public void limpiarModificarEL(View v){
        idExpLabModificar.setText("");
        idExpLabModificar.setEnabled(true);
        idEmpleadoELModificar.setText("");
        idEmpleadoELModificar.setEnabled(true);
        buttonActualizarELModificar.setEnabled(false);
        idEmpresaELModificar.setText("");
        idCargoELModificar.setText("");
        duracionELModificar.setText("");

    }


    }

