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

import java.util.ArrayList;
import java.util.List;

public class ControlBD {

    private final Context context;
    private SQLiteDatabase db;
    private DatabaseHelper DBHelper;
    //vector con los campos de cargo
    private static final String[] camposCargo = new String[]{"ID_CARGO","NOMBRE_CARGO","DESCRIPCION_CARGO"};
    private static final String[] camposAplicacion = new String[]{"ID_APLICACION","ID_EMPLEADO","ID_OFERTALABORAL","ID_EMPRESA","FECHA_APLICACION","ESTADO_APLICACION"};

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        private static final String BD_BOLSATRABAJO="bolsatrabajo.s3db";
        private static final int vers = 1;

        //SCRIPT SQLite CREACION BD DIVIDIDO POR INSTRUCCIONES
      /*  private static final String sqlCreateApl="create table APLICACION(ID_APLICACION integer not null, ID_EMPLEADO integer not null, ID_OFERTALABORAL integer not null, ID_EMPRESA integer, FECHA_APLICACION  varchar(30), ESTADO_APLICACION varchar(20), primary key (ID_APLICACION,ID_EMPLEADO,ID_OFERTALABORAL,ID_EMPRESA));";
        private static final String sqlCreateCar="create table CARGO(ID_CARGO integer autoincrement, NOMBRE_CARGO varchar(60) not null, DESCRIPCION_CARGO varchar(140) not null, primary key (ID_CARGO));";
        private static final String sqlCreateDetEst="create table DETALLEESTUDIO(ID_DETALLEEST integer not null, ID_EMPLEADO integer, ID_ESPECIALIZACION integer, ID_INSTITUTOESTUDIO integer, ANYOGRADUACION_DETALLEEST integer, primary key (ID_DETALLEEST,ID_EMPLEADO));";
        private static final String sqlCreateEmpl="create table EMPLEADO(ID_EMPLEADO integer not null, NOMBRE_EMPLEADO varchar(50) not null, DUI_EMPLEADO integer not null, SEXO_EMPLEADO varchar(1) not null, EDAD_EMPLEADO integer not null, DIRECCION_EMPLEADO varchar(100) not null, TELEFONO_EMPLEADO integer not null, CANTAPLICACIONES_EMPLEADO integer, CANTREFERENCIAS_EMPLEADO integer,primary key (ID_EMPLEADO));";
        private static final String sqlCreateEmp="create table EMPRESA(ID_EMPRESA integer not null, NOMBRE_EMPRESA varchar(50) not null, NIT_EMPRESA varchar(25) not null, DIR_EMPRESA varchar(50) not null, TEL_EMPRESA varchar(10), CANTOFERTAS_EMPRESA  integer NOT NULL, primary key (ID_EMPRESA));";
        private static final String sqlCreateExpLab="create table EXPERIENCIALABORAL(ID_EXPERIENCIALABORAL integer not null, ID_EMPLEADO  integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, DURACION_EXPERIENCIALABORAL integer not null, primary key (ID_EXPERIENCIALABORAL,ID_EMPLEADO));";
        private static final String sqlCreateGraEsp="create table GRADOESPECIALIZACION(ID_ESPECIALIZACION integer not null, ID_INSTITUTOESTUDIO  integer, NOMBRE_ESPECIALIZACION varchar(50) not null, DURACION_ESPECIALIZACION integer,primary key (ID_ESPECIALIZACION,ID_INSTITUTOESTUDIO));";
        private static final String sqlCreateInsEst="create table INSTITUTOESTUDIO(ID_INSTITUTOESTUDIO integer not null, NOMBRE_INSTITUTOESTUDIO varchar(100) not null, MUNICIPIO_INSTITUTOESTUDIO varchar(30) not null, DEPARTAMENTO_INSTITUTOESTUDIO varchar(30) not null, primary key (ID_INSTITUTOESTUDIO));";
        private static final String sqlCreateOfeLab="create table OFERTALABORAL(ID_OFERTALABORAL integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, FECHAPUBLICACION_OFERTALABORAL varchar(30) not null, FECHAEXPIRACION_OFERTALABORAL varchar(30) not null, primary key (ID_OFERTALABORAL,ID_EMPRESA));";
        private static final String sqlCreateRef="create table REFERENCIA(ID_REFERENCIA integer not null, ID_EMPLEADO integer, ID_EMPRESA integer, NOMBRE_REFERENCIA varchar(50) not null, TELEFONO_REFERENCIA varchar(10) not null, primary key (ID_REFERENCIA,ID_EMPLEADO));";
        */
        public DatabaseHelper(Context context){
            super(context,BD_BOLSATRABAJO,null,vers);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sqlCreateApl="create table APLICACION(ID_APLICACION integer not null primary key autoincrement, ID_EMPLEADO integer not null, ID_OFERTALABORAL integer not null, ID_EMPRESA integer not null, FECHA_APLICACION  varchar(30)not null, ESTADO_APLICACION varchar(20)not null);";
            String sqlCreateCar="create table CARGO(ID_CARGO integer not null primary key autoincrement, NOMBRE_CARGO varchar(60) not null, DESCRIPCION_CARGO varchar(140) not null);";
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
    //                 CRUD DE CARGO
    public String insertar(Cargo cargo){
        String registrosInser="Registro insertado N°= ";
        long contador;
        ContentValues c=new ContentValues();
        //c.put("ID_CARGO",cargo.getIdCargo());
        c.put("NOMBRE_CARGO",cargo.getNombreCargo());
        c.put("DESCRIPCION_CARGO",cargo.getDescripcionCargo());
        contador=db.insert("CARGO",null,c);
        if(contador==-1||contador==0){
            registrosInser="Error al insertar";
        }
        else{
            registrosInser=registrosInser+contador;
        }
       /* String registrosInser="Registro insertado N°= ";
         long contador= 0;
         ContentValues carg = new ContentValues();
         //carg.put("ID_CARGO",cargo.getIdCargo());
         carg.put("NOMBRE_CARGO",cargo.getNombreCargo());
         carg.put("DESCRIPCION_CARGO",cargo.getDescripcionCargo());
         contador=db.insert("CARGO",null,carg);
         if(contador==-1||contador==0){
             registrosInser="error al insertar";
         }
         else{
             registrosInser=registrosInser+contador;
         }
         return registrosInser;*/
        return registrosInser;

     }

    public String actualizar(Cargo cargo){
        //if(verificarIntegridad(cargo, 5)){
        String[] id = {String.valueOf(cargo.getIdCargo())};
        ContentValues cv = new ContentValues();
        // cv.put("", alumno.getNombre());
        cv.put("NOMBRE_CARGO", cargo.getNombreCargo());
        cv.put("DESCRIPCION_CARGO", cargo.getDescripcionCargo());
        db.update("cargo", cv, "ID_CARGO = ?", id);
        return "Registro Actualizado Correctamente";
        //}else{
        //return "Registro con carnet " + cargo.getIdCargo + " no existe";
        //}
    }

    public Cargo consultarCargo(int idCargo){
        String idc=String.valueOf(idCargo);
        String[] id = {idc};
        Cursor cursor= db.query("cargo",camposCargo,"ID_CARGO= ?",id,null,null,null); //"ID_CARGO= ?" CARGO??
        if(cursor.moveToFirst()){
            Cargo cargo= new Cargo();
            cargo.setIdCargo(Integer.parseInt(cursor.getString(0)));
            cargo.setNombreCargo(cursor.getString(1));
            cargo.setDescripcionCargo(cursor.getString(2));
            return cargo;
        }else{
            return null;
        }
    }
    public String eliminar(Cargo cargo){
        String regAfectados="filas afectadas= ";
        int contador=0;
        /*if (true //verificarIntegridad(cargo,3)) { //solo para probar

            contador+=db.delete("ID_CARGO", "ID_CARGO='"+cargo.getIdCargo()+"'", null);
        }*/
        contador+=db.delete("CARGO", "ID_CARGO='"+cargo.getIdCargo()+"'", null);
        regAfectados+=contador;
        return regAfectados;

    }
    public  String insertar(Aplicacion aplicacion){
        //esta insercion debe cumplir que existan los id de empleado, empresa y ofertalaboral
        String registrosInser="Registro insertado N°= ";
        long contador=0;
        ContentValues apli = new ContentValues();
        //apli.put("ID_APLICACION",aplicacion.getIdAplicacion());
        apli.put("ID_EMPLEADO",aplicacion.getIdEmpleado());
        apli.put("ID_EMPRESA",aplicacion.getIdEmpresa());
        apli.put("ID_OFERTALABORAL",aplicacion.getIdOfertaLaboral());
        apli.put("FECHA_APLICACION",aplicacion.getFechaAplicacion());
        apli.put("ESTADO_APLICACION",aplicacion.getEstadoAplicacion());
        contador=db.insert("APLICACION",null,apli);
        if(contador==-1||contador==0){
            registrosInser="error al insertar";
        }
        else{
            registrosInser=registrosInser+contador;
        }
        return registrosInser;
    }
    public Aplicacion consultarAplicacion( int idAplicacionf,int idEmleado,int idOferta,int idEmpresa){
        //String ida= String.valueOf(idAplicacion);
        String[] ids={String.valueOf(idAplicacionf),String.valueOf(idEmleado),String.valueOf(idOferta),String.valueOf(idEmpresa)};
        Cursor cursor=db.rawQuery("SELECT FECHA_APLICACION,ESTADO_APLICACION FROM APLICACION WHERE ID_APLICACION= ? AND ID_EMPLEADO= ? AND ID_OFERTALABORAL= ? AND ID_EMPRESA= ? ",ids);
       // Cursor cursor=db.query("APLICACION",camposCargo,"ID_APLICACION= ?",id,null,null,null);

        if(cursor.moveToFirst()){
            //Aplicacion aplicacion = new Aplicacion();
            //aplicacion.setIdAplicacion(Integer.parseInt(cursor.getString(0)));
            //aplicacion.setIdEmpleado(Integer.parseInt(cursor.getString(1)));
            //aplicacion.setIdOfertaLaboral(Integer.parseInt(cursor.getString(2)));
            //aplicacion.setIdEmpresa(Integer.parseInt(cursor.getString(3)));
            Aplicacion aplicacion = new Aplicacion();
            aplicacion.setFechaAplicacion(cursor.getString(0));
            aplicacion.setEstadoAplicacion(cursor.getString(1));
            return aplicacion;
        }
        return null;
    }
    public String actualizar(Aplicacion aplicacion){
        //if(verificarIntegridad(cargo, 5)){
        String[] ids={String.valueOf(aplicacion.getIdAplicacion()),String.valueOf(aplicacion.getIdEmpleado()),String.valueOf(aplicacion.getIdOfertaLaboral()),String.valueOf(aplicacion.getIdEmpresa())};
        ContentValues cv= new ContentValues();
        cv.put("FECHA_APLICACION",aplicacion.getFechaAplicacion());
        cv.put("ESTADO_APLICACION",aplicacion.getEstadoAplicacion());
        db.update("APLICACION",cv,"ID_APLICACION= ? AND ID_EMPLEADO= ? AND ID_OFERTALABORAL= ? AND ID_EMPRESA= ?",ids);
        return "Registro actualizado correctamente";
        //}else{
        //return "Registro con carnet " + cargo.getIdCargo + " no existe";
        //}
    }
    public String eliminar(Aplicacion aplicacion){
        //falta revisar integridad
        String regAfectados="filas Afectadas =  ";
        int contador=0;
        contador+=db.delete("APLICACION","ID_APLICACION='"+aplicacion.getIdAplicacion()+"'"+"AND ID_EMPLEADO='"+aplicacion.getIdEmpleado()+"'"+
                "AND ID_OFERTALABORAL='"+aplicacion.getIdOfertaLaboral()+"'"+"AND ID_EMPRESA='"+aplicacion.getIdEmpresa()+"'", null);
        regAfectados+=contador;
        return regAfectados;


    }

    public List<String> recuperarEmpleado(){
        List<String> ids=new ArrayList<String>();
        //Cursor cursor=db.rawQuery("Select ID_CARGO from CARGO",null);//ID_EMPLEADO  EMPLEADO
        Cursor cursor =db.query("cargo",camposCargo,null,null,null,null,null);//para probar esta con la tabla cargo , cambiar a la tabla Empleado despues
        if(cursor.moveToFirst()){
            do{
                ids.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        else{
            ids.add("nohay");
            return ids;
        }

        return ids;
    }
    public List<String> recuperarEmpresa(){
        List<String> idem=new ArrayList<String>();
        Cursor cursor =db.query("cargo",camposCargo,null,null,null,null,null);//para probar esta con la tabla cargo , cambiar a la tabla Empresa despues
        if(cursor.moveToFirst()){
            do{
                idem.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        else{
            idem.add("nohay");
            return idem;
        }

        return idem;

    }

    public List<String> recuperarOferta(){
        List<String> idem=new ArrayList<String>();
        Cursor cursor =db.query("cargo",camposCargo,null,null,null,null,null);//para probar esta con la tabla cargo , cambiar a la tabla ofertalaboraL  despues
        if(cursor.moveToFirst()){
            do{
                idem.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        else{
            idem.add("nohay");
            return idem;
        }

        return idem;
    }



}
