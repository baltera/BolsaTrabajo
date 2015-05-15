package fia.ues.sv.bolsatrabajo;

/**
 * Created by Maria Jose on 14/05/2015.
 */
public class Empleado {
    private int id;
    private String nombre_empleado;
    private int dui_empleado;
    private String sexo_empleado;
    private int edad_empleado;
    private String direccion_empleado;
    private int telefono_empleado;
    private int cantAplicaciones_empleado;
    private int cantReferencias_empleado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Empleado(){}
    public Empleado(int id, String nombre_empleado, int dui_empleado, String sexo_empleado,
                    int edad_empleado, String direccion_empleado, int telefono_empleado,
                    int cantAplicaciones_empleado,int cantReferencias_empleado){
        this.id= id;
        this.nombre_empleado= nombre_empleado;
        this.dui_empleado=  dui_empleado;
        this.sexo_empleado= sexo_empleado;
        this.edad_empleado=edad_empleado;
        this.direccion_empleado=direccion_empleado;
        this.telefono_empleado=telefono_empleado;
        this.cantAplicaciones_empleado=cantAplicaciones_empleado;
        this.cantReferencias_empleado=cantReferencias_empleado;


    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public int getDui_empleado() {
        return dui_empleado;
    }

    public void setDui_empleado(int dui_empleado) {
        this.dui_empleado = dui_empleado;
    }

    public String getSexo_empleado() {
        return sexo_empleado;
    }

    public void setSexo_empleado(String sexo_empleado) {
        this.sexo_empleado = sexo_empleado;
    }

    public int getEdad_empleado() {
        return edad_empleado;
    }

    public void setEdad_empleado(int edad_empleado) {
        this.edad_empleado = edad_empleado;
    }

    public String getDireccion_empleado() {
        return direccion_empleado;
    }

    public void setDireccion_empleado(String direccion_empleado) {
        this.direccion_empleado = direccion_empleado;
    }

    public int getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(int telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public int getCantAplicaciones_empleado() {
        return cantAplicaciones_empleado;
    }

    public void setCantAplicaciones_empleado(int cantAplicaciones_empleado) {
        this.cantAplicaciones_empleado = cantAplicaciones_empleado;
    }

    public int getCantReferencias_empleado() {
        return cantReferencias_empleado;
    }

    public void setCantReferencias_empleado(int cantReferencias_empleado) {
        this.cantReferencias_empleado = cantReferencias_empleado;
    }
}
