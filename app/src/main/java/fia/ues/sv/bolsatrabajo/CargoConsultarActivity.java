package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CargoConsultarActivity extends Activity {
    ControlBD helper;
    EditText editIdCargof;
    EditText editNombreCargof;
    EditText editDescripcionCargof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_consultar);
        helper = new ControlBD(this);
        editIdCargof=(EditText)findViewById(R.id.editIdCargof);
        editNombreCargof=(EditText)findViewById(R.id.editNombreCargof);
        editDescripcionCargof=(EditText)findViewById(R.id.editDescripcionCargof);

    }
    public void consultarCargo(View v){
        helper.abrir();
        Cargo cargo = helper.consultarCargo(Integer.parseInt(editIdCargof.getText().toString()));
        helper.cerrar();
        if(cargo==null){
            Toast.makeText(this,"El cargo con id:"+editIdCargof.getText().toString()+"no fue encontrado",Toast.LENGTH_LONG).show();
      }
        else{
            editNombreCargof.setText(cargo.getNombreCargo());
            editDescripcionCargof.setText(cargo.getDescripcionCargo());
        }
    }
    public void limpiarTexto(View v){
        editIdCargof.setText("");
        editNombreCargof.setText("");
        editDescripcionCargof.setText("");
    }



}
