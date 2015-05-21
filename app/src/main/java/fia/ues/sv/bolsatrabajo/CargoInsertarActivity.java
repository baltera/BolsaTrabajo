package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CargoInsertarActivity extends Activity {
    ControlBD helper;
    EditText editNombreCargof; //los id definidos en el layout de insertar
    EditText editDescripcionCargof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_insertar);
        helper = new ControlBD(this);
        editNombreCargof=(EditText)findViewById(R.id.editNombreCargof);
        editDescripcionCargof=(EditText)findViewById(R.id.editDescripcionCargof);
    }
    public void insertarCargo(View v){
        String nombreCargo=editNombreCargof.getText().toString();
        String descripcionCargo=editDescripcionCargof.getText().toString();
        String registrosInser;
       // Toast.makeText(this,nombreCargo,Toast.LENGTH_LONG).show();
        Cargo cargo=new Cargo();
        cargo.setNombreCargo(nombreCargo);
        cargo.setDescripcionCargo(descripcionCargo);
        helper.abrir();
        registrosInser=helper.insertar(cargo);
        helper.cerrar();

        Toast.makeText(this,registrosInser,Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v){
        editNombreCargof.setText("");
        editDescripcionCargof.setText("");
    }


}
