package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CargoActualizarActivity extends Activity {
    ControlBD helper;
    EditText editIdCargof;
    EditText editNombreCargof;
    EditText editDescripcionCargof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_actualizar);
        helper = new ControlBD(this);
        editIdCargof=(EditText)findViewById(R.id.editIdCargof);
        editNombreCargof=(EditText)findViewById(R.id.editNombreCargof);
        editDescripcionCargof=(EditText)findViewById(R.id.editDescripcionCargof);

    }
    public void actualizarCargo(){
        Cargo cargo= new Cargo();
        cargo.setIdCargo(Integer.parseInt(editIdCargof.getText().toString()));
        cargo.setNombreCargo(editNombreCargof.getText().toString());
        cargo.setDescripcionCargo(editDescripcionCargof.getText().toString());
        helper.abrir();
        String estado =helper.actualizar(cargo);
        helper.cerrar();
        Toast.makeText(this,estado,Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v){
        editIdCargof.setText("");
        editNombreCargof.setText("");
        editDescripcionCargof.setText("");
    }



}
