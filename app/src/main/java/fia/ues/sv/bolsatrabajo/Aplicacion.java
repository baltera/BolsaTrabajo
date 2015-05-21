package fia.ues.sv.bolsatrabajo;

/**
 * Created by Mónica on 13/05/2015.
 */
public class Aplicacion {
    private int idAplicacion;
    private int idEmpleado;
    private int  idOfertaLaboral;
    private int idEmpresa;
    private String fechaAplicacion;
    private String estadoAplicacion;

    public Aplicacion(){

    }

    public Aplicacion(int idAplicacion, int idEmpleado, int idOfertaLaboral, int idEmpresa, String fechaAplicacion, String estadoAplicacion) {
        this.idAplicacion = idAplicacion;
        this.idEmpleado = idEmpleado;
        this.idOfertaLaboral = idOfertaLaboral;
        this.idEmpresa = idEmpresa;
        this.fechaAplicacion = fechaAplicacion;
        this.estadoAplicacion = estadoAplicacion;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdOfertaLaboral() {
        return idOfertaLaboral;
    }

    public void setIdOfertaLaboral(int idOfertaLaboral) {
        this.idOfertaLaboral = idOfertaLaboral;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getEstadoAplicacion() {
        return estadoAplicacion;
    }

    public void setEstadoAplicacion(String estadoAplicacion) {
        this.estadoAplicacion = estadoAplicacion;
    }
}
