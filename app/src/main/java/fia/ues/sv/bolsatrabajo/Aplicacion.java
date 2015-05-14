package fia.ues.sv.bolsatrabajo;

/**
 * Created by Mónica on 13/05/2015.
 */
public class Aplicacion {
    private Integer idAplicacion;
    private Integer idEmpleado;
    private Integer  idOfertaLaboral;
    private Integer idEmpresa;
    private String fechaAplicacion;
    private String estadoAplicacion;

    public Aplicacion(){

    }

    public Aplicacion(Integer idAplicacion, Integer idEmpleado, Integer idOfertaLaboral, Integer idEmpresa, String fechaAplicacion, String estadoAplicacion) {
        this.idAplicacion = idAplicacion;
        this.idEmpleado = idEmpleado;
        this.idOfertaLaboral = idOfertaLaboral;
        this.idEmpresa = idEmpresa;
        this.fechaAplicacion = fechaAplicacion;
        this.estadoAplicacion = estadoAplicacion;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdOfertaLaboral() {
        return idOfertaLaboral;
    }

    public void setIdOfertaLaboral(Integer idOfertaLaboral) {
        this.idOfertaLaboral = idOfertaLaboral;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
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
