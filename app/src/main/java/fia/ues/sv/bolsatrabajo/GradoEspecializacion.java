package fia.ues.sv.bolsatrabajo;

/**
 * Created by Eduardo on 16/05/2015.
 */
public class GradoEspecializacion {

    private int id_especializacion,id_institutoEstudio,duracion_especializacion;
    private String nombre_especializacion;


    public int getId_especializacion() {
        return id_especializacion;
    }

    public void setId_especializacion(int id_especializacion) {
        this.id_especializacion = id_especializacion;
    }

    public int getId_institutoEstudio() {
        return id_institutoEstudio;
    }

    public void setId_institutoEstudio(int id_institutoEstudio) {
        this.id_institutoEstudio = id_institutoEstudio;
    }

    public int getDuracion_especializacion() {
        return duracion_especializacion;
    }

    public void setDuracion_especializacion(int duracion_especializacion) {
        this.duracion_especializacion = duracion_especializacion;
    }

    public String getNombre_especializacion() {
        return nombre_especializacion;
    }

    public void setNombre_especializacion(String nombre_especializacion) {
        this.nombre_especializacion = nombre_especializacion;
    }

    public GradoEspecializacion(int id_especializacion, int id_institutoEstudio, int duracion_especializacion, String nombre_especializacion) {

        this.id_especializacion = id_especializacion;
        this.id_institutoEstudio = id_institutoEstudio;
        this.duracion_especializacion = duracion_especializacion;
        this.nombre_especializacion = nombre_especializacion;
    }

    public GradoEspecializacion() {

    }
}
