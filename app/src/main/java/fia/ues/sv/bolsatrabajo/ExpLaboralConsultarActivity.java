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


public class ExpLaboralConsultarActivity extends Activity {
    EditText idExpLab;
    EditText idEmpleadoELConsultar;
    EditText idEmpresaELConsultar;
    EditText idCargoELConsultar;
    EditText duracionELConsultar;
    Button buttonConsultarEL;
    Button buttonLimpiarEL;
    ControlBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_laboral_consultar);
        idExpLab=(EditText)findViewById(R.id.idExpLab);
        idEmpleadoELConsultar=(EditText)findViewById(R.id.idEmpleadoELConsultar);
        idEmpresaELConsultar=(EditText)findViewById(R.id.idEmpresaELConsultar);
        idCargoELConsultar=(EditText)findViewById(R.id.idCargoELConsultar);
        duracionELConsultar=(EditText)findViewById(R.id.duracionELConsultar);
        buttonConsultarEL=(Button)findViewById(R.id.buttonConsultarEL);
        buttonLimpiarEL=(Button)findViewById(R.id.buttonLimpiarEL);
        helper=new ControlBD(this);
        /*helper.abrir();
        String rs=helper.insertarELPrueba();
        Toast.makeText(this,rs,Toast.LENGTH_LONG).show();
        helper.cerrar();*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exp_laboral_consultar, menu);
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
    public void consultarEL(View v) {
        String id1= idExpLab.getText().toString();
        String id2=idEmpleadoELConsultar.getText().toString();

        ExperienciaLaboral el = new ExperienciaLaboral();
        if(id2== null || id1==null)
        {Toast.makeText(this,"INGRESE EL ID EXPERIENCIA LABORAL Y ID DE EMPLEADO",Toast.LENGTH_LONG).show();}
       else {
            helper.abrir();
            el = helper.verificarIntegridadConsultar(idExpLab.getText().toString(), idEmpleadoELConsultar.getText().toString());
            helper.cerrar();
            if (el == null) {
                Toast.makeText(this, "Empleado no coincide con la Experiencia Laboral", Toast.LENGTH_LONG).show();
            } else {
                idEmpresaELConsultar.setText(String.valueOf(el.getIdEmpresa()));
                idCargoELConsultar.setText(String.valueOf(el.getIdCargo()));
                duracionELConsultar.setText(String.valueOf(el.getDuracionExpLaboral()));

            }
        }//fin del primer else

    }
    public void limpiarEL(View v){
        idExpLab.setText("");
        idEmpleadoELConsultar.setText("");
        idEmpresaELConsultar.setText("");
        idCargoELConsultar.setText("");
        duracionELConsultar.setText("");

    }
}
