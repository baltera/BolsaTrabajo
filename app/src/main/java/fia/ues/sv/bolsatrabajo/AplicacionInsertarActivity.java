package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class AplicacionInsertarActivity extends Activity implements AdapterView.OnItemSelectedListener{
    ControlBD helper;
    EditText editEstadoAplicacionf;
    EditText editFechaAplicacionf;
    Spinner editSpinnerEmpleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_insertar);
        helper = new ControlBD(this);
        editFechaAplicacionf = (EditText)findViewById(R.id.editFechaAplicacionf);
        editEstadoAplicacionf= (EditText)findViewById(R.id.editEstadoAplicacionf);
        editSpinnerEmpleado=(Spinner)findViewById(R.id.editSpinnerEmpleado);
        editSpinnerEmpleado.setOnItemSelectedListener(this);
        cargarSpinner();
    }
    public void insertarAplicacion(View v){

        String estadoAplicacionf=editEstadoAplicacionf.getText().toString();
        String fechaAplicacionf=editFechaAplicacionf.getText().toString();
        String registrosInser;
        Aplicacion aplicacion= new Aplicacion();
        aplicacion.setIdAplicacion(2);
        aplicacion.setIdEmpleado(2);
        aplicacion.setIdEmpresa(3);
        aplicacion.setIdOfertaLaboral(2);
        aplicacion.setFechaAplicacion(fechaAplicacionf);
        aplicacion.setEstadoAplicacion(estadoAplicacionf);
        helper.abrir();
        registrosInser=helper.insertar(aplicacion);
        helper.cerrar();
        Toast.makeText(this,registrosInser,Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v){
        editFechaAplicacionf.setText("");
        editEstadoAplicacionf.setText("");
    }
    public void cargarSpinner(){
        helper.abrir();
        List<String> ids=helper.recuperarEmpleado();
        helper.cerrar();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ids);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editSpinnerEmpleado.setAdapter(adapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String selecionado = parent.getItemAtPosition(position).toString();
       Toast.makeText(this,"posicion seleccionada"+selecionado,Toast.LENGTH_SHORT).show();
       // / ConsultarUsuario()
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
