package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ReferenciaConsultarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editReferencia,editIdEmpleado,editIdEmpresa,editNombreReferencia,editTelefonoReferencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referencia_consultar);
        helper=new ControlBD(this);
        editReferencia=(EditText)findViewById(R.id.editReferencia);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
        editNombreReferencia=(EditText)findViewById(R.id.editNombreReferencia);
        editTelefonoReferencia=(EditText)findViewById(R.id.editTelefonoReferencia);
    }

    public void consultarReferenciaAct(View view){
        helper.abrir();
        Referencia referencia=helper.consultarReferencia(String.valueOf(editReferencia.getText().toString()),editIdEmpleado.getText().toString());//aqui puede haber un error porque envio un string en vez de un Int

        helper.cerrar();
        if(referencia==null){
            Toast.makeText(this,"Referencia no encontrada.",Toast.LENGTH_SHORT).show();
        }
        else{
            editIdEmpleado.setText(String.valueOf(referencia.getId_empleado()));
            editIdEmpresa.setText(String.valueOf(referencia.getId_empresa()));
            editNombreReferencia.setText(String.valueOf(referencia.getNombre_referencia()));
            editTelefonoReferencia.setText(String.valueOf(referencia.getTelefono_referencia()));
        }

    }
    public void limpiarTexto(View view){
        editIdEmpleado.setText("");
        editReferencia.setText("");
        editIdEmpresa.setText("");
        editNombreReferencia.setText("");
        editTelefonoReferencia.setText("");

    }

}
