package fia.ues.sv.bolsatrabajo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AplicacionConsultarActivity extends Activity {
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
        setContentView(R.layout.activity_aplicacion_consultar);
        helper= new ControlBD(this);
        editIdAplicacionf= (EditText)findViewById(R.id.editIdAplicacionf);
        editIdEmpleado=(EditText)findViewById(R.id.editIdEmpleado);
        editIdOfertaLaboralf=(EditText)findViewById(R.id.editIdOfertaLaboralf);
        editIdEmpresa=(EditText)findViewById(R.id.editIdEmpresa);
        editFechaAplicacionf = (EditText)findViewById(R.id.editFechaAplicacionf);
        editEstadoAplicacionf= (EditText)findViewById(R.id.editEstadoAplicacionf);

    }
    // ya consulta aplicaciones
    public void consultarAplicacion(View v){
        int  idAplicacionf = Integer.valueOf(editIdAplicacionf.getText().toString());
        int idEmleado= Integer.valueOf(editIdEmpleado.getText().toString());
        int idOferta= Integer.valueOf(editIdOfertaLaboralf.getText().toString());
        int idEmpresa= Integer.valueOf(editIdEmpresa.getText().toString());

        helper.abrir();
        Aplicacion apli=helper.consultarAplicacion(idAplicacionf,idEmleado,idOferta,idEmpresa);
        helper.cerrar();
        if (apli==null){
            Toast.makeText(this,"La aplicacion con id:"+idAplicacionf+"no fue encontrada",Toast.LENGTH_LONG).show();
        }
        else{
            editFechaAplicacionf.setText(apli.getFechaAplicacion());
            editEstadoAplicacionf.setText(apli.getEstadoAplicacion());
        }


    }// fin consultar
    public void limpiarTexto(View v){
        editIdAplicacionf.setText("");
        editIdEmpleado.setText("");
        editIdOfertaLaboralf.setText("");
        editIdEmpresa.setText("");
        editFechaAplicacionf.setText("");
        editEstadoAplicacionf.setText("");
    }


}
