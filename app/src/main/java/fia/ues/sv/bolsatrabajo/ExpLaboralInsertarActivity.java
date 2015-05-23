package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ExpLaboralInsertarActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerIdEmpresaEL;
    Spinner spinnerIdCargoEL;
    Button buttonInsertarEL;
    ControlBD helper;
    String resultadoEmpresa;
    String resultadoCargo;
    EditText idEmpleadoEL;
    EditText duracionExpLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_laboral_insertar);
        helper= new ControlBD(this);
        spinnerIdEmpresaEL=(Spinner)findViewById(R.id.spinnerIdEmpresa);
        spinnerIdCargoEL=(Spinner)findViewById(R.id.spinnerIdCargo);
        buttonInsertarEL=(Button) findViewById(R.id.buttonInsertarEL);
        idEmpleadoEL = (EditText)findViewById(R.id.idEmpleadoEL);
        duracionExpLab=(EditText)findViewById(R.id.duracionExpLab);
        List<String> idEmpresas =  new ArrayList<String>();
        List<String> idCargo= new ArrayList<String>();
        helper.abrir();
        helper.insertarEmpresa();
        helper.insertarCargo();
        idEmpresas = helper.obtenerIdEmpresas();
        idCargo=helper.obtenerIdCargo();
        helper.cerrar();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idEmpresas);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdEmpresaEL.setAdapter(arrayAdapter);
        spinnerIdEmpresaEL.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,idCargo);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdCargoEL.setAdapter(arrayAdapter2);
        spinnerIdCargoEL.setOnItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exp_laboral_insertar, menu);
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



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId())
        {
            case R.id.spinnerIdEmpresa:

                resultadoEmpresa=adapterView.getItemAtPosition(i).toString();
               // Toast.makeText(this, "Seleccionado " + resultadoEmpresa, Toast.LENGTH_LONG).show();

                break;

            case R.id.spinnerIdCargo:

                resultadoCargo=adapterView.getItemAtPosition(i).toString();
                 //Toast.makeText(this,"Seleccionado "+ resultadoCargo, Toast.LENGTH_LONG).show();

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    resultadoEmpresa=adapterView.getItemAtPosition(0).toString();
    resultadoCargo=adapterView.getItemAtPosition(0).toString();

    }

    public void insertarExpLab(View v){
        String res;
        helper.abrir();
        Empleado empleado=helper.consultarEmpleado(idEmpleadoEL.getText().toString());
        if(empleado==null)
        {Toast.makeText(this,"EL EMPLEADO "+idEmpleadoEL.getText().toString()+" NO EXISTE",Toast.LENGTH_LONG).show();

        }
        else{
            if(duracionExpLab.getText().toString()==null)
            {Toast.makeText(this,"INGRESE TODOS LOS DATOS",Toast.LENGTH_LONG).show();}
            else
            { res=helper.insertarExpLab(idEmpleadoEL.getText().toString(),resultadoEmpresa,resultadoCargo,duracionExpLab.getText().toString());
            Toast.makeText(this,res,Toast.LENGTH_LONG).show();}
        }

    }
}
