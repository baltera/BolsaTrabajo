package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ReferenciaModificarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editReferencia,editIdEmpleado,editIdEmpresa,editNombreReferencia,editTelefonoReferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referencia_modificar);
        helper=new ControlBD(this);
        editReferencia=(EditText)findViewById(R.id.editReferencia);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
        editNombreReferencia=(EditText)findViewById(R.id.editNombreReferencia);
        editTelefonoReferencia=(EditText)findViewById(R.id.editTelefonoReferencia);
    }

    public void modificarReferenciaAct(View view){
        Referencia referencia = new Referencia();
        referencia.setId_referencia(Integer.parseInt(editReferencia.getText().toString()));
        referencia.setId_empleado(Integer.parseInt(editIdEmpleado.getText().toString()));
        referencia.setId_empresa(Integer.parseInt(editIdEmpresa.getText().toString()));
        referencia.setNombre_referencia(editNombreReferencia.getText().toString());
        referencia.setTelefono_referencia(editTelefonoReferencia.getText().toString());
        helper.abrir();
        String estate=helper.modificar(referencia);
        helper.cerrar();
        Toast.makeText(this,estate,Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View view){
        editIdEmpleado.setText("");
        editReferencia.setText("");
        editIdEmpresa.setText("");
        editNombreReferencia.setText("");
        editTelefonoReferencia.setText("");

    }

}
