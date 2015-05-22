package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CargoEliminarActivity extends Activity {
    ControlBD helper;
    EditText editIdCargof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_eliminar);
        helper = new ControlBD(this);
        editIdCargof = (EditText) findViewById(R.id.editIdCargof);
    }

    public void eliminarCargo(View v) {
        String regEliminadas;
        Cargo cargo = new Cargo();
        cargo.setIdCargo(Integer.parseInt(editIdCargof.getText().toString()));
        helper.abrir();
        regEliminadas = helper.eliminar(cargo);
        helper.cerrar();
        Toast.makeText(this,regEliminadas, Toast.LENGTH_SHORT).show();


    }
}
