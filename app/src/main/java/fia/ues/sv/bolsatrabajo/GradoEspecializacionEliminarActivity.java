package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class GradoEspecializacionEliminarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editIdEspecializacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_especializacion_eliminar);
        helper=new ControlBD(this);
        editIdEspecializacion=(EditText)findViewById(R.id.editEspecializacion);


    }

    public void eliminarGradoEspecAct(View view){
        String regDelete;
        String id=editIdEspecializacion.getText().toString();
        GradoEspecializacion especializacion=new GradoEspecializacion();
        especializacion.setId_especializacion(Integer.parseInt(id));
        helper.abrir();
        regDelete=helper.eliminar(especializacion);
        helper.cerrar();
        Toast.makeText(this, regDelete, Toast.LENGTH_SHORT).show();
    }
}
