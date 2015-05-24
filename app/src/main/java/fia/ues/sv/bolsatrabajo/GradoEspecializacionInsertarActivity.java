package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class GradoEspecializacionInsertarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editEspecializacion,editNombreEspecializacion,editIdInstituto,editDuracionEspec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_especializacion_insertar);
        helper=new ControlBD(this);
        editEspecializacion=(EditText)findViewById(R.id.editEspecializacion);
        editNombreEspecializacion=(EditText)findViewById(R.id.editNombreEspecializacion);
        editIdInstituto=(EditText)findViewById(R.id.editIdInstituto);
        editDuracionEspec=(EditText)findViewById(R.id.editDuracionEspec);
    }

    public void insertarGradoEspecAct(View view){
        int idEspec=Integer.parseInt(editEspecializacion.getText().toString());
        int idInstituto=Integer.parseInt(editIdInstituto.getText().toString());
        String NomEspec=editNombreEspecializacion.getText().toString();
        int idDuracion=Integer.parseInt(editDuracionEspec.getText().toString());

        if(editEspecializacion.getText()==null ){
            Toast.makeText(this, "Debe ingresar El Id de la Especializacion", Toast.LENGTH_SHORT).show();
        }else{
            GradoEspecializacion especializacion=new GradoEspecializacion(idEspec,idInstituto,idDuracion,NomEspec);
            helper.abrir();
            String regInsert=helper.insertar(especializacion);
            Toast.makeText(this,regInsert,Toast.LENGTH_SHORT).show();
        }

    }

    public void limpiarTexto(View view){

        editEspecializacion.setText("");
        editNombreEspecializacion.setText("");
        editIdInstituto.setText("");
        editDuracionEspec.setText("");

    }
}
