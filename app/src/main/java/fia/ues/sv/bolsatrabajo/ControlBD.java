package fia.ues.sv.bolsatrabajo;

/**
 * Created by Eduardo on 15/05/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ControlBD {
/*CAMPOS DE FR12001*/
   private static final String[] camposEmpleado= new String[]{"NOMBRE_EMPLEADO","DUI_EMPLEADO","SEXO_EMPLEADO","EDAD_EMPLEADO","DIRECCION_EMPLEADO","TELEFONO_EMPLEADO","CANTAPLICACIONES_EMPLEADO","CANTREFERENCIAS_EMPLEADO"};
    /*FIN FR12001*/

    private final Context context;
    private SQLiteDatabase db;
    private DatabaseHelper DBHelper;

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        private static final String BD_BOLSATRABAJO="bolsatrabajo.s3db";
        private static final int vers = 1;

        public DatabaseHelper(Context context){
            super(context,BD_BOLSATRABAJO,null,vers);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
        //SCRIPT SQLite CREACION BD DIVIDIDO POR INSTRUCCIONES
        String sqlCreateApl="create table APLICACION(ID_APLICACION integer not null, ID_EMPLEADO integer not null, ID_OFERTALABORAL integer not null, ID_EMPRESA integer, FECHA_APLICACION  varchar(30), ESTADO_APLICACION varchar(20), primary key (ID_APLICACION,ID_EMPLEADO,ID_OFERTALABORAL,ID_EMPRESA));";
        String sqlCreateCar="create table CARGO(ID_CARGO integer not null, NOMBRE_CARGO varchar(60) not null, DESCRIPCION_CARGO varchar(140) not null, primary key (ID_CARGO));";
        String sqlCreateDetEst="create table DETALLEESTUDIO(ID_DETALLEEST integer not null, ID_EMPLEADO integer, ID_ESPECIALIZACION integer, ID_INSTITUTOESTUDIO integer, ANYOGRADUACION_DETALLEEST integer, primary key (ID_DETALLEEST,ID_EMPLEADO));";
        String sqlCreateEmpl="create table EMPLEADO(ID_EMPLEADO integer not null, NOMBRE_EMPLEADO varchar(50) not null, DUI_EMPLEADO integer not null, SEXO_EMPLEADO varchar(1) not null, EDAD_EMPLEADO integer not null, DIRECCION_EMPLEADO varchar(100) not null, TELEFONO_EMPLEADO integer not null, CANTAPLICACIONES_EMPLEADO integer, CANTREFERENCIAS_EMPLEADO integer,primary key (ID_EMPLEADO));";
        String sqlCreateEmp="create table EMPRESA(ID_EMPRESA integer not null, NOMBRE_EMPRESA varchar(50) not null, NIT_EMPRESA varchar(25) not null, DIR_EMPRESA varchar(50) not null, TEL_EMPRESA varchar(10), CANTOFERTAS_EMPRESA  integer NOT NULL, primary key (ID_EMPRESA));";
        String sqlCreateExpLab="create table EXPERIENCIALABORAL(ID_EXPERIENCIALABORAL integer not null, ID_EMPLEADO  integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, DURACION_EXPERIENCIALABORAL integer not null, primary key (ID_EXPERIENCIALABORAL,ID_EMPLEADO));";
        String sqlCreateGraEsp="create table GRADOESPECIALIZACION(ID_ESPECIALIZACION integer not null, ID_INSTITUTOESTUDIO  integer, NOMBRE_ESPECIALIZACION varchar(50) not null, DURACION_ESPECIALIZACION integer,primary key (ID_ESPECIALIZACION,ID_INSTITUTOESTUDIO));";
        String sqlCreateInsEst="create table INSTITUTOESTUDIO(ID_INSTITUTOESTUDIO integer not null, NOMBRE_INSTITUTOESTUDIO varchar(100) not null, MUNICIPIO_INSTITUTOESTUDIO varchar(30) not null, DEPARTAMENTO_INSTITUTOESTUDIO varchar(30) not null, primary key (ID_INSTITUTOESTUDIO));";
        String sqlCreateOfeLab="create table OFERTALABORAL(ID_OFERTALABORAL integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, FECHAPUBLICACION_OFERTALABORAL varchar(30) not null, FECHAEXPIRACION_OFERTALABORAL varchar(30) not null, primary key (ID_OFERTALABORAL,ID_EMPRESA));";
        String sqlCreateRef="create table REFERENCIA(ID_REFERENCIA integer not null, ID_EMPLEADO integer, ID_EMPRESA integer, NOMBRE_REFERENCIA varchar(50) not null, TELEFONO_REFERENCIA varchar(10) not null, primary key (ID_REFERENCIA,ID_EMPLEADO));";

            try{
                db.execSQL(sqlCreateApl);
                db.execSQL(sqlCreateCar);
                db.execSQL(sqlCreateDetEst);
                db.execSQL(sqlCreateEmpl);
                db.execSQL(sqlCreateEmp);
                db.execSQL(sqlCreateExpLab);
                db.execSQL(sqlCreateGraEsp);
                db.execSQL(sqlCreateInsEst);
                db.execSQL(sqlCreateOfeLab);
                db.execSQL(sqlCreateRef);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Para cuando se quiera actualizar la BD
        }
    }

    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;

    }
    public void cerrar(){
        DBHelper.close();
    }
    /*******************************************METODOS DE CRUD PARA CADA TABLA***************************************************************/
    //Aqui cada uno se divierte :)

    /*****************************************************************************************************************************************/
/*METODOS CRUD FR120001*/
    public String insertar(Empleado empleado){
        String regInsertados="¡ATENCION! Su numero de Empleado es = ";
        long contador;

        ContentValues emple = new ContentValues();
        emple.put("ID_EMPLEADO",empleado.getId());
        emple.put("NOMBRE_EMPLEADO",empleado.getNombre_empleado());
        emple.put("DUI_EMPLEADO",empleado.getDui_empleado());
        emple.put("SEXO_EMPLEADO",empleado.getSexo_empleado());
        emple.put("EDAD_EMPLEADO", empleado.getEdad_empleado());
        emple.put("DIRECCION_EMPLEADO",empleado.getDireccion_empleado());
        emple.put("TELEFONO_EMPLEADO",empleado.getTelefono_empleado());
        emple.put("CANTAPLICACIONES_EMPLEADO",empleado.getCantAplicaciones_empleado());
        emple.put("CANTREFERENCIAS_EMPLEADO",empleado.getCantReferencias_empleado());
        contador= db.insert("EMPLEADO",null,emple);
        if(contador == -1 || contador==0)
        { regInsertados="Error al insertar Registro,Verificar insercion";}
        else{ regInsertados=regInsertados+contador;}
        return regInsertados;
    }
     public Empleado consultarEmpleado(String idE){
         String[] id={idE};
         /*query (String table,String[] columns,String selection,String[] selectionArgs,String groupBy,
       String having, String orderBy)*/
         Cursor cursor= db.query("EMPLEADO",camposEmpleado,"ID_EMPLEADO = ?",id,null,null,null);
         if (cursor.moveToFirst()){

        Empleado empleado = new Empleado();
        empleado.setNombre_empleado(cursor.getString(0));
        empleado.setDui_empleado(Integer.parseInt(cursor.getString(1)));
        empleado.setSexo_empleado(cursor.getString(2));
        empleado.setEdad_empleado(cursor.getInt(3));
        empleado.setDireccion_empleado(cursor.getString(4));
        empleado.setTelefono_empleado(cursor.getInt(5));
        empleado.setCantAplicaciones_empleado(cursor.getInt(6));
        empleado.setCantReferencias_empleado(cursor.getInt(7));
        return empleado;
 }
         else{return null;}
     }

    public int buscarId(){

        Cursor cursor =db.rawQuery("SELECT ID_EMPLEADO FROM EMPLEADO",null);

         return cursor.getCount();

        }
    public String actualizarEmpleado(Empleado empleado) {


        String[] idEmpleado = {Integer.toString(empleado.getId())};

            ContentValues emple = new ContentValues();

            emple.put("NOMBRE_EMPLEADO", empleado.getNombre_empleado());
            emple.put("DUI_EMPLEADO", empleado.getDui_empleado());
            emple.put("SEXO_EMPLEADO", empleado.getSexo_empleado());
            emple.put("EDAD_EMPLEADO", empleado.getEdad_empleado());
            emple.put("DIRECCION_EMPLEADO", empleado.getDireccion_empleado());
            emple.put("TELEFONO_EMPLEADO", empleado.getTelefono_empleado());
           int resp= db.update("EMPLEADO", emple, "ID_EMPLEADO = ?", idEmpleado);
            if (resp == 0 || resp == -1) {
                return "Error al Actualizar Empleado";
            } else {
                return "Empleado Actualizado Correctamente";
            }
        }



    public String eliminarEmpleado(Empleado empleado)
    {
        String[] id={String.valueOf(empleado.getId())};
        String regAfectados="Empleados Afectados = ";
        int contador=0;
        contador+=db.delete("EMPLEADO","ID_EMPLEADO = ?",id);
        regAfectados+=contador;
        return regAfectados;
  }
    public List<String> obtenerIdEmpresas(){
       List<String> lista = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT ID_EMPRESA FROM EMPRESA", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(0));
            } while (cursor.moveToNext());
        } else{
            lista.add("NO HAY DATOS DISPONBLES");
        }
        return lista;

    }
    public List<String> obtenerIdEmpleado(){
        List<String> lista = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT ID_EMPLEADO FROM EMPLEADO", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(0));
            } while (cursor.moveToNext());
        } else{
            lista.add("NO HAY DATOS DISPONBLES");
        }
        return lista;

    }
    public List<String> obtenerIdCargo(){
        List<String> lista = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT ID_CARGO FROM CARGO", null);
        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(0));
            } while (cursor.moveToNext());
        } else{
            lista.add("NO HAY DATOS DISPONBLES");
        }
        return lista;

    }


    /*FIN FR12001*/
    }





