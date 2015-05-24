package fia.ues.sv.bolsatrabajo;

/**
 * Created by Maria Jose on 15/05/2015.
 */
public class ExperienciaLaboral {
    private int idExpLaboral;
    private int idEmpleado;
    private int  idEmpresa;
    private int idCargo;
    private int duracionExpLaboral;

    public ExperienciaLaboral(){}

    public ExperienciaLaboral(int idExpLaboral,int idEmpleado, int  idEmpresa, int idCargo, int duracionExpLaboral){
        this.idExpLaboral=idExpLaboral;
        this.idEmpleado=idEmpleado;
        this.idCargo=idCargo;
        this.idEmpresa=idEmpresa;
        this.duracionExpLaboral=duracionExpLaboral;
    }

    public int getIdExpLaboral() {
        return idExpLaboral;
    }

    public void setIdExpLaboral(int idExpLaboral) {
        this.idExpLaboral = idExpLaboral;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getDuracionExpLaboral() {
        return duracionExpLaboral;
    }

    public void setDuracionExpLaboral(int duracionExpLaboral) {
        this.duracionExpLaboral = duracionExpLaboral;
    }
}
