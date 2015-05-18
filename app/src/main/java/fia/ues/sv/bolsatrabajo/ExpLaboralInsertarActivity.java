package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class ExpLaboralInsertarActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerIdEmpleadoEL;
    Spinner spinnerIdEmpresaEL;
    Spinner spinnerIdCargoEL;
    Button buttonInsertarEL;
    ControlBD helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_laboral_insertar);
        helper= new ControlBD(this);
        spinnerIdEmpleadoEL=(Spinner)findViewById(R.id.spinnerIdEmpleado);
        spinnerIdEmpresaEL=(Spinner)findViewById(R.id.spinnerIdEmpresa);
        spinnerIdCargoEL=(Spinner)findViewById(R.id.spinnerIdCargo);
        buttonInsertarEL=(Button) findViewById(R.id.buttonInsertarEL);


        helper.abrir();
        List<String> idEmpresas =  new ArrayList<String>();
        List<String> idEmpleado = new ArrayList<String>();
        List<String> idCargo= new ArrayList<String>();
        idEmpresas = helper.obtenerIdEmpresas();
        idEmpleado=helper.obtenerIdEmpleado();
        idCargo=helper.obtenerIdCargo();
        helper.cerrar();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, idEmpresas);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdEmpresaEL.setAdapter(arrayAdapter);
        spinnerIdEmpresaEL.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,idEmpleado);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdEmpleadoEL.setAdapter(arrayAdapter1);
        spinnerIdEmpleadoEL.setOnItemSelectedListener(this);
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
