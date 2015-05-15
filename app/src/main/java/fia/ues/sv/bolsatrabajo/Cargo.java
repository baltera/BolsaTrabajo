package fia.ues.sv.bolsatrabajo;

/**
 * Created by Mónica on 13/05/2015.
 */
public class Cargo {
    private Integer idCargo;
    private String  nombreCargo;
    private  String descripcionCargo;

    public Cargo(){

    }

    public Cargo(Integer idCargo, String nombreCargo, String descripcionCargo) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.descripcionCargo = descripcionCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }
}
