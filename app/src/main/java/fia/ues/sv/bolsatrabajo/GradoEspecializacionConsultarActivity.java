package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class GradoEspecializacionConsultarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editEspecializacion,editNombreEspecializacion,editIdInstituto,editDuracionEspec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_especializacion_consultar);
        helper=new ControlBD(this);
        editEspecializacion=(EditText)findViewById(R.id.editEspecializacion);
        editNombreEspecializacion=(EditText)findViewById(R.id.editNombreEspecializacion);
        editIdInstituto=(EditText)findViewById(R.id.editIdInstituto);
        editDuracionEspec=(EditText)findViewById(R.id.editDuracionEspec);

    }

    public void consultarGradoEspecializacionAct(View  view){
        helper.abrir();
        GradoEspecializacion especializacion=helper.consultarGradoEspecializacion(String.valueOf(editEspecializacion));//aquí puede haber un error porque envio un string en vez de un Int

        helper.cerrar();
        if(especializacion==null){
            Toast.makeText(this, "Grado/Especializacion no encontrada.", Toast.LENGTH_SHORT).show();
        }
        else{
            editIdInstituto.setText(String.valueOf(especializacion.getId_institutoEstudio()));
            editNombreEspecializacion.setText(especializacion.getNombre_especializacion());
            editDuracionEspec.setText(especializacion.getDuracion_especializacion());

        }
    }

}
