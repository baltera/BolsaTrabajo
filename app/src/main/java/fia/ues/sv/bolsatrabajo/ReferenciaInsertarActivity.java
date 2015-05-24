package fia.ues.sv.bolsatrabajo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ReferenciaInsertarActivity extends ActionBarActivity {

    ControlBD helper;
    EditText editReferencia,editIdEmpleado,editIdEmpresa,editNombreReferencia,editTelefonoReferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referencia_insertar);
        helper=new ControlBD(this);
        editReferencia=(EditText)findViewById(R.id.editReferencia);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
        editNombreReferencia=(EditText)findViewById(R.id.editNombreReferencia);
        editTelefonoReferencia=(EditText)findViewById(R.id.editTelefonoReferencia);

    }

    public void insertarReferenciaAct(View view){
        int idReferencia=Integer.parseInt(editReferencia.getText().toString());
        int idEmpleado=Integer.parseInt(editIdEmpleado.getText().toString());
        int idEmpresa=Integer.parseInt(editIdEmpresa.getText().toString());
        String nomReferencia=editNombreReferencia.getText().toString();
        String telReferencia=editTelefonoReferencia.getText().toString();
        if(editReferencia.getText()==null || editIdEmpleado.getText()==null){
            Toast.makeText(this,"Debe ingresar El Id de la referencia y el Id del empleado",Toast.LENGTH_SHORT).show();
        }else{
            Referencia referencia=new Referencia(idReferencia,idEmpleado,idEmpresa,nomReferencia,telReferencia);
            helper.abrir();
            String regInsert=helper.insertar(referencia);
            Toast.makeText(this,regInsert,Toast.LENGTH_SHORT).show();
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
