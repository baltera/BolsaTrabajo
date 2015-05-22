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


public class AplicacionEliminarActivity extends Activity implements AdapterView.OnItemSelectedListener{
    ControlBD helper;
    EditText editIdAplicacionf;
    Spinner editSpinnerEmpleado;
    Spinner editSpinnerEmpresa;
    Spinner editSpinnerOferta;
    int idEmpleado,idEmpresa,idOferta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_eliminar);
        helper= new ControlBD(this);
        editIdAplicacionf= (EditText)findViewById(R.id.editIdAplicacionf);
        editSpinnerEmpleado=(Spinner)findViewById(R.id.editSpinnerEmpleado);
        editSpinnerEmpresa= (Spinner)findViewById(R.id.editSpinnerEmpresa);
        editSpinnerOferta= (Spinner)findViewById(R.id.editSpinnerOferta);
        editSpinnerEmpleado.setOnItemSelectedListener(this);
        editSpinnerEmpresa.setOnItemSelectedListener(this);
        editSpinnerOferta.setOnItemSelectedListener(this);
        cargarSpinner();

    }
    public void eliminarAplicacion(View v){
        String regEliminados;
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setIdAplicacion(Integer.valueOf(editIdAplicacionf.getText().toString()));
        aplicacion.setIdEmpleado(idEmpleado);
        aplicacion.setIdOfertaLaboral(idOferta);
        aplicacion.setIdEmpresa(idEmpresa);
        helper.abrir();
        regEliminados=helper.eliminar(aplicacion);
        helper.cerrar();
        Toast.makeText(this,regEliminados,Toast.LENGTH_SHORT).show();

    }
    public void cargarSpinner() {
        helper.abrir();
        List<String> ids = helper.recuperarEmpleado();
        List<String> idem = helper.recuperarEmpresa();
        List<String> idof = helper.recuperarOferta();
        helper.cerrar();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ids);
        ArrayAdapter<String> adapterEm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idem);
        ArrayAdapter<String> adapterOf = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, idof);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterEm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterOf.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        editSpinnerEmpleado.setAdapter(adapter);
        editSpinnerEmpresa.setAdapter(adapterEm);
        editSpinnerOferta.setAdapter(adapterOf);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String resultadoEmpleado;
        //String selecionado = parent.getItemAtPosition(position).toString();
        //Toast.makeText(this,"posicion seleccionada"+selecionado,Toast.LENGTH_SHORT).show();


        switch (parent.getId())
        {
            case R.id.editSpinnerEmpleado:

                resultadoEmpleado=parent.getItemAtPosition(position).toString();
                idEmpleado=Integer.parseInt(resultadoEmpleado);
                //Toast.makeText(this, " empleado " + resultadoEmpleado, Toast.LENGTH_LONG).show();


                break;

            case R.id.editSpinnerEmpresa:

                String resultadoEmpresa=parent.getItemAtPosition(position).toString();
                idEmpresa=Integer.parseInt(resultadoEmpresa);
                //Toast.makeText(this,"empresa "+ resultadoEmpresa,Toast.LENGTH_LONG).show();


                break;
            case R.id.editSpinnerOferta:
                String resultadoOferta=parent.getItemAtPosition(position).toString();
                idOferta=Integer.parseInt(resultadoOferta);
                //Toast.makeText(this,"oferta laboral"+resultadoOferta,Toast.LENGTH_SHORT).show();

        }



    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
