package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class GradoEspecializacionModificarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editEspecializacion,editNombreEspecializacion,editIdInstituto,editDuracionEspec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_especializacion_modificar);
        helper=new ControlBD(this);
        editEspecializacion=(EditText)findViewById(R.id.editEspecializacion);
        editNombreEspecializacion=(EditText)findViewById(R.id.editNombreEspecializacion);
        editIdInstituto=(EditText)findViewById(R.id.editIdInstituto);
        editDuracionEspec=(EditText)findViewById(R.id.editDuracionEspec);
    }

    public void modificarGradoEspecAct(View view){
        GradoEspecializacion especializacion =new GradoEspecializacion();

        especializacion.setId_especializacion(Integer.parseInt(editEspecializacion.getText().toString()));
        especializacion.setId_institutoEstudio(Integer.parseInt(editIdInstituto.getText().toString()));
        especializacion.setDuracion_especializacion(Integer.parseInt(editDuracionEspec.getText().toString()));
        especializacion.setNombre_especializacion(editNombreEspecializacion.getText().toString());

        helper.abrir();
        String estate=helper.modificar(especializacion);
        helper.cerrar();
        Toast.makeText(this, estate, Toast.LENGTH_SHORT);
    }

   public void limpiarModificarGrado(View view){
       editEspecializacion.setText("");
       editNombreEspecializacion.setText("");
       editIdInstituto.setText("");
       editDuracionEspec.setText("");
   }
}
