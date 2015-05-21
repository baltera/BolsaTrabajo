package fia.ues.sv.bolsatrabajo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AplicacionActualizarActivity extends Activity {
    ControlBD helper;
    EditText editIdAplicacionf;
    EditText editIdEmpleado;
    EditText editIdOfertaLaboralf;
    EditText editIdEmpresa;
    EditText editEstadoAplicacionf;
    EditText editFechaAplicacionf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion_actualizar);
        helper= new ControlBD(this);
        editIdAplicacionf= (EditText)findViewById(R.id.editIdAplicacionf);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdOfertaLaboralf=(EditText)findViewById(R.id.editIdOfertaLaboralf);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
        editFechaAplicacionf = (EditText)findViewById(R.id.editFechaAplicacionf);
        editEstadoAplicacionf= (EditText)findViewById(R.id.editEstadoAplicacionf);
    }
    public void consultarAplicacion(View v){
        int  idAplicacionf = Integer.valueOf(editIdAplicacionf.getText().toString());
        int idEmleado= Integer.valueOf(editIdEmpleado.getText().toString());
        int idOferta= Integer.valueOf(editIdOfertaLaboralf.getText().toString());
        int idEmpresa= Integer.valueOf(editIdEmpresa.getText().toString());

        helper.abrir();
        Aplicacion aplicacion=helper.consultarAplicacion(idAplicacionf,idEmleado,idOferta,idEmpresa);
        helper.cerrar();
        if (aplicacion==null){
            Toast.makeText(this,"La aplicacion con id:"+idAplicacionf+"no fue encontrada",Toast.LENGTH_LONG).show();
        }
        else{
            editFechaAplicacionf.setText(aplicacion.getFechaAplicacion());
            editEstadoAplicacionf.setText(aplicacion.getEstadoAplicacion());
        }

    }// fin consultar
    public void actualizarAplicacion(View v){
        Aplicacion aplicacion=new Aplicacion();
        aplicacion.setIdAplicacion(Integer.valueOf(editIdAplicacionf.getText().toString()));
        aplicacion.setIdEmpleado(Integer.valueOf(editIdEmpleado.getText().toString()));
        aplicacion.setIdOfertaLaboral(Integer.valueOf(editIdOfertaLaboralf.getText().toString()));
        aplicacion.setIdEmpresa(Integer.valueOf(editIdEmpresa.getText().toString()));
        helper.abrir();
        String resultado= helper.actualizar(aplicacion);
        helper.cerrar();
        Toast.makeText(this,resultado,Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v){
        editIdAplicacionf.setText("");
        editIdEmpleado.setText("");
        editIdOfertaLaboralf.setText("");
        editIdEmpresa.setText("");
        editFechaAplicacionf.setText("");
        editEstadoAplicacionf.setText("");
    }

}
