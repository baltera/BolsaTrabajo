package fia.ues.sv.bolsatrabajo;

/**
 * Created by Eduardo on 16/05/2015.
 */
public class Referencia {

    private int id_referencia;
    private int id_empleado;
    private int id_empresa;
    private String nombre_referencia;
    private String telefono_referencia;

    public Referencia() {
    }

    public Referencia(int id_referencia, int id_empleado, int id_empresa, String nombre_referencia, String telefono_referencia) {
        this.id_referencia = id_referencia;
        this.id_empleado = id_empleado;
        this.id_empresa = id_empresa;
        this.nombre_referencia = nombre_referencia;
        this.telefono_referencia = telefono_referencia;
    }

    public int getId_referencia() {
        return id_referencia;
    }

    public void setId_referencia(int id_referencia) {
        this.id_referencia = id_referencia;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_referencia() {
        return nombre_referencia;
    }

    public void setNombre_referencia(String nombre_referencia) {
        this.nombre_referencia = nombre_referencia;
    }

    public String getTelefono_referencia() {
        return telefono_referencia;
    }

    public void setTelefono_referencia(String telefono_referencia) {
        this.telefono_referencia = telefono_referencia;
    }
}
