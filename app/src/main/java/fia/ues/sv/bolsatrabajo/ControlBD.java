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

import android.provider.ContactsContract;

import java.sql.Ref;
import java.util.Objects;

public class ControlBD {
/*CAMPOS DE FR12001*/
   private static final String[] camposEmpleado= new String[]{"NOMBRE_EMPLEADO","DUI_EMPLEADO","SEXO_EMPLEADO","EDAD_EMPLEADO","DIRECCION_EMPLEADO","TELEFONO_EMPLEADO","CANTAPLICACIONES_EMPLEADO","CANTREFERENCIAS_EMPLEADO"};
   private static final String[] camposConsultaEL= new String[]{"ID_EMPRESA","ID_CARGO","DURACION_EXPERIENCIALABORAL"};
    /*FIN FR12001*/
    /*Campos FB12001*/
    private static final String[] camposCargo = new String[]{"ID_CARGO","NOMBRE_CARGO","DESCRIPCION_CARGO"};
   // private static final String[] camposAplicacion = new String[]{"ID_APLICACION","ID_EMPLEADO","ID_OFERTALABORAL","ID_EMPRESA","FECHA_APLICACION","ESTADO_APLICACION"};
    private static final String[] camposEmpresaCar= new String[]{"ID_EMPRESA","NOMBRE_EMPRESA","NIT_EMPRESA","DIR_EMPRESA","TEL_EMPRESA","CANTOFERTAS_EMPRESA"};

  //fin fb12001

    private final Context context;
    private SQLiteDatabase db;
    private DatabaseHelper DBHelper;

    public static String[] camposReferencia={"ID_REFERENCIA","ID_EMPLEADO","ID_EMPRESA","NOMBRE_REFERENCIA","TELEFONO_REFERENCIA"};
    public static String[] camposGradoEspecializacion={"ID_ESPECIALIZACION","ID_INSTITUTOESTUDIO","NOMBRE_ESPECIALIZACION","DURACION_ESPECIALIZACION"};


    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        private static final String BD_BOLSATRABAJO="bolsatrabajo.s3db";
        private static final int vers = 1;
/*
        //SCRIPT SQLite CREACION BD DIVIDIDO POR INSTRUCCIONES
        private static final String sqlCreateApl="create table APLICACION(ID_APLICACION integer not null, ID_EMPLEADO integer not null, ID_OFERTALABORAL integer not null, ID_EMPRESA integer, FECHA_APLICACION  varchar(30), ESTADO_APLICACION varchar(20), primary key (ID_APLICACION,ID_EMPLEADO,ID_OFERTALABORAL,ID_EMPRESA));";
        private static final String sqlCreateCar="create table CARGO(ID_CARGO integer not null, NOMBRE_CARGO varchar(60) not null, DESCRIPCION_CARGO varchar(140) not null, primary key (ID_CARGO));";
        private static final String sqlCreateDetEst="create table DETALLEESTUDIO(ID_DETALLEEST integer not null, ID_EMPLEADO integer, ID_ESPECIALIZACION integer, ID_INSTITUTOESTUDIO integer, ANYOGRADUACION_DETALLEEST integer, primary key (ID_DETALLEEST,ID_EMPLEADO));";
        private static final String sqlCreateEmpl="create table EMPLEADO(ID_EMPLEADO integer not null, NOMBRE_EMPLEADO varchar(50) not null, DUI_EMPLEADO integer not null, SEXO_EMPLEADO varchar(1) not null, EDAD_EMPLEADO integer not null, DIRECCION_EMPLEADO varchar(100) not null, TELEFONO_EMPLEADO integer not null, CANTAPLICACIONES_EMPLEADO integer, CANTREFERENCIAS_EMPLEADO integer,primary key (ID_EMPLEADO));";
        private static final String sqlCreateEmp="create table EMPRESA(ID_EMPRESA integer not null, NOMBRE_EMPRESA varchar(50) not null, NIT_EMPRESA varchar(25) not null, DIR_EMPRESA varchar(50) not null, TEL_EMPRESA varchar(10), CANTOFERTAS_EMPRESA  integer NOT NULL, primary key (ID_EMPRESA));";
        private static final String sqlCreateExpLab="create table EXPERIENCIALABORAL(ID_EXPERIENCIALABORAL integer not null, ID_EMPLEADO  integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, DURACION_EXPERIENCIALABORAL integer not null, primary key (ID_EXPERIENCIALABORAL,ID_EMPLEADO));";
        private static final String sqlCreateGraEsp="create table GRADOESPECIALIZACION(ID_ESPECIALIZACION integer not null, ID_INSTITUTOESTUDIO  integer, NOMBRE_ESPECIALIZACION varchar(50) not null, DURACION_ESPECIALIZACION integer,primary key (ID_ESPECIALIZACION,ID_INSTITUTOESTUDIO));";
        private static final String sqlCreateInsEst="create table INSTITUTOESTUDIO(ID_INSTITUTOESTUDIO integer not null, NOMBRE_INSTITUTOESTUDIO varchar(100) not null, MUNICIPIO_INSTITUTOESTUDIO varchar(30) not null, DEPARTAMENTO_INSTITUTOESTUDIO varchar(30) not null, primary key (ID_INSTITUTOESTUDIO));";
        private static final String sqlCreateOfeLab="create table OFERTALABORAL(ID_OFERTALABORAL integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, FECHAPUBLICACION_OFERTALABORAL varchar(30) not null, FECHAEXPIRACION_OFERTALABORAL varchar(30) not null, primary key (ID_OFERTALABORAL,ID_EMPRESA));";
        private static final String sqlCreateRef="create table REFERENCIA(ID_REFERENCIA integer not null, ID_EMPLEADO integer, ID_EMPRESA integer, NOMBRE_REFERENCIA varchar(50) not null, TELEFONO_REFERENCIA varchar(10) not null, primary key (ID_REFERENCIA,ID_EMPLEADO));";
    */
        DatabaseHelper(Context context){
            super(context,BD_BOLSATRABAJO,null,vers);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //SCRIPT SQLite CREACION BD DIVIDIDO POR INSTRUCCIONES
            String sqlCreateApl="create table APLICACION(ID_APLICACION integer not null primary key autoincrement, ID_EMPLEADO integer not null, ID_OFERTALABORAL integer not null, ID_EMPRESA integer, FECHA_APLICACION  varchar(30), ESTADO_APLICACION varchar(20));";
            String sqlCreateCar="create table CARGO(ID_CARGO integer not null primary key autoincrement, NOMBRE_CARGO varchar(60) not null, DESCRIPCION_CARGO varchar(140) not null);";
            String sqlCreateDetEst="create table DETALLEESTUDIO(ID_DETALLEEST integer not null primary key autoincrement, ID_EMPLEADO integer, ID_ESPECIALIZACION integer, ID_INSTITUTOESTUDIO integer, ANYOGRADUACION_DETALLEEST integer);";
            String sqlCreateEmpl="create table EMPLEADO(ID_EMPLEADO integer not null primary key autoincrement, NOMBRE_EMPLEADO varchar(50) not null, DUI_EMPLEADO integer not null, SEXO_EMPLEADO varchar(1) not null, EDAD_EMPLEADO integer not null, DIRECCION_EMPLEADO varchar(100) not null, TELEFONO_EMPLEADO integer not null, CANTAPLICACIONES_EMPLEADO integer, CANTREFERENCIAS_EMPLEADO integer);";
            String sqlCreateEmp="create table EMPRESA(ID_EMPRESA integer not null primary key autoincrement, NOMBRE_EMPRESA varchar(50) not null, NIT_EMPRESA varchar(25) not null, DIR_EMPRESA varchar(50) not null, TEL_EMPRESA varchar(10), CANTOFERTAS_EMPRESA  integer not null);";
            String sqlCreateExpLab="create table EXPERIENCIALABORAL(ID_EXPERIENCIALABORAL integer not null primary key autoincrement , ID_EMPLEADO  integer not null, ID_EMPRESA integer not null, ID_CARGO integer not null, DURACION_EXPERIENCIALABORAL integer not null);";
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
    public String llenarBase(){
        String estadoBase="";
    //Vectores para cada uno de los campos de cada tabla
         //vectores empleado
    final String[] nombreEmpleado = {"Jorge Pérez","Maritza Cañas","Sebastian Funes","Carlos Dominguez"};
    final int [] duiEmpleado={050034561,060023567,030034561,0500325677};
    final String[] sexoEmpleado={"M","F","M","M"};
    final int[] edadEmpleado={24,50,32,40};
    final String[] direccionEmpleado={"25 Av.Norte #17H, San Salvador","Res.Los Altos,#5,Mejicanos","Calle Las Flores #5A,Cuscatlan","49 Av. Norte, Res.Los Lirios #6B,San Salvador"};
    final int[] telefonoEmpleado={22563456,22784567,75946754,23564788};
    final int[] cantApEmpleado={1,3,5,2};
    final int[] cantRefEmpleado={3,2,2,3};

     //vectores Experiencia Laboral
    final String[] idTodos={"1","2","3","4"};
    final String[] duracionExpLab={"6","8","12","16"};
        //vectorees Empresa
    final String[] nombreEmpresa={"Pizza Hut","Office Depot","C.E San Antonio","Telefonica"};
    final String[] nitEmpresa={"0614-220605-113-0","0675-330734","0423-220812","0614-345632-551-0"};
    final String[] dirEmpresa={"Blv.Los Proceres, Local 5A,San Salvador","49 Av. Norte,#45, San Salvador","Barrio San Juan,Boque 1A,Sonsonate","Centro Comercial Metrocentro, 2° Nivel,San Salvador"};
    final String[] telEmpresa={"2276-4533","79567843","2233-6755","2256-8977"};
    final int[] canOfertasEmpresa={6,4,1,5};
        //vectores detalleestudio
    final int[] idEmpleadoDE={1,2,3,4};
    final int[] idEspecializacionDE={1,2,3,4};
    final int[] idInstEstudioDE={1,2,3,4};
    final int[] anyoGraducionDE={2008,2014,2010,2012};
        //Vectores tabla Moni
        //para la tabla cargo
        final String[] nombreCargo={"Gerente de Creditos","Jefe de Planta","Jefe de tecnología","Jefe de Reacciones"};
        final String[] descripcionCargo={"gerente para la gestion de creditos","Ingeniero industrial para control de planta","Ingeniero de Sistemas para el area de TI","Ingeniero Quimico encargado de planta de reactivos"};
       // para la tabla aplicacion
        final int[] idsAplicacionTodos={1,2,3,4};
        final String[] fechaAplicacion={"23/05/15","13/05/15","20/05/15","24/05/15"};
        final String[] estadoAplicacion={"Aceptada","Aceptada","En Proceso","En Proceso"};
        //Vectoress tabla Edgardo
        //Vectores tabla Eduardo
       /*------EMPIEZA LA INSERCION ---*/
        for (int i = 0; i < 4; i++) {
            //tabla empresa
            ContentValues values = new ContentValues();
            values.put("NOMBRE_EMPRESA", nombreEmpresa[i]);
            values.put("NIT_EMPRESA",nitEmpresa[i]);
            values.put("DIR_EMPRESA",dirEmpresa[i]);
            values.put("TEL_EMPRESA", telEmpresa[i]);
            values.put("CANTOFERTAS_EMPRESA",canOfertasEmpresa[i]);
            db.insert("EMPRESA", null, values);

            //tabla Empleado, se reutilizara el metodo insertarEmpleado
            Empleado empleado = new Empleado();
            empleado.setNombre_empleado(nombreEmpleado[i]);
            empleado.setDui_empleado(duiEmpleado[i]);
            empleado.setSexo_empleado(sexoEmpleado[i]);
            empleado.setEdad_empleado(edadEmpleado[i]);
            empleado.setDireccion_empleado(direccionEmpleado[i]);
            empleado.setTelefono_empleado(telefonoEmpleado[i]);
            empleado.setCantAplicaciones_empleado(cantApEmpleado[i]);
            empleado.setCantReferencias_empleado(cantRefEmpleado[i]);
            insertarEmpleado(empleado);

            //tabla  ExperienciaLaboral, se reutilizara el metodo insertarExpLab
             insertarExpLab(idTodos[i],idTodos[i],idTodos[i],duracionExpLab[i]);
            //tabla DetalleEstudio
            ContentValues values2 = new ContentValues();
            values2.put("ID_EMPLEADO",idEmpleadoDE[i]);
            values2.put("ID_ESPECIALIZACION",idEspecializacionDE[i]);
            values2.put("ID_INSTITUTOESTUDIO",idInstEstudioDE[i]);
            values2.put("ANYOGRADUACION_DETALLEEST",anyoGraducionDE[i]);
            db.insert("DETALLEESTUDIO", null, values2);

            //Tabla Cargo, se reutiliza el metodo insertar(cargo
            Cargo cargo= new Cargo();
            cargo.setNombreCargo(nombreCargo[i]);
            cargo.setDescripcionCargo(descripcionCargo[i]);
            insertar(cargo);

            //tabla Aplicacion se reutiliza el metodo inserta(aplicacion)
            Aplicacion aplicacion= new Aplicacion();
            aplicacion.setIdEmpleado(idsAplicacionTodos[i]);
            aplicacion.setIdEmpresa(idsAplicacionTodos[i]);
            aplicacion.setIdOfertaLaboral(idsAplicacionTodos[i]);
            aplicacion.setFechaAplicacion(fechaAplicacion[i]);
            aplicacion.setEstadoAplicacion(estadoAplicacion[i]);
            insertar(aplicacion);


        }//fin for

        return estadoBase="El llenado de la Base de Datos se hizo Satisfactoriamente";
    }




/*METODOS CRUD FR120001*/
    public String insertarEmpleado(Empleado empleado){
        String regInsertados="¡ATENCION! Su numero de Empleado es = ";
        long contador;

        ContentValues emple = new ContentValues();
        //emple.put("ID_EMPLEADO",empleado.getId());
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
    //Clases prueba para llenar tabla Cargo
    public void insertarCargo() {
        ContentValues values = new ContentValues();
        for (int i = 0; i <= 3; i++) {
            values.put("NOMBRE_CARGO", "nombre " + i);
            values.put("DESCRIPCION_CARGO", "Descripcion " + i);
            db.insert("CARGO", null, values);
        }
    }
    public void insertarEmpresa() {
        ContentValues values = new ContentValues();
        for (int i = 0; i <= 3; i++) {
            values.put("NOMBRE_EMPRESA", "nombre " + i);
            values.put("NIT_EMPRESA", "NIT " + i);
            values.put("DIR_EMPRESA", "DIRECCION " + i);
            values.put("TEL_EMPRESA", "TEL " + i);
            values.put("CANTOFERTAS_EMPRESA", i + 1);
            db.insert("EMPRESA", null, values);
        }
    }
        public String insertarExpLab(String idEmpleado,String idEmpresa,String idCargo,String duracion){
        String regInsertado;
        long contador;
            ContentValues content= new ContentValues();
            content.put("ID_EMPLEADO",Integer.parseInt(idEmpleado));
            content.put("ID_EMPRESA",Integer.parseInt(idEmpresa));
            content.put("ID_CARGO",Integer.parseInt(idCargo));
            content.put("DURACION_EXPERIENCIALABORAL", Integer.parseInt(duracion));
            contador=db.insert("EXPERIENCIALABORAL",null,content);
            if(contador ==-1 || contador==0)
            {regInsertado="Error de Insercion";}
            else{regInsertado="Se ingreso la Experiencia Laboral ="+contador;}
            return  regInsertado;

    }
    public ExperienciaLaboral verificarIntegridadConsultar(String idExpLab,String idEmpleado){
        String[] id={idExpLab,idEmpleado};
        ExperienciaLaboral el= new ExperienciaLaboral();

        Cursor cursor=db.rawQuery("select * FROM EXPERIENCIALABORAL WHERE ID_EXPERIENCIALABORAL=? AND ID_EMPLEADO=?", id);
        if(cursor.moveToFirst())
        {
            el.setIdEmpresa(cursor.getInt(2));
            el.setIdCargo(cursor.getInt(3));
            el.setDuracionExpLaboral(cursor.getInt(4));
            return el;
        }else {return  null;}

    }
   /* public String insertarELPrueba() {
       long contador=0;
        String regInsertados= "Agrego ";
        ContentValues values = new ContentValues();
       // values.put("ID_EXPERIENCIALABORAL",1);
        values.put("ID_EMPLEADO", 1);
        values.put("ID_EMPRESA",2);
        values.put("ID_CARGO", 3);
        values.put("DURACION_EXPERIENCIALABORAL",4);
         contador=db.insert("EXPERIENCIALABORAL", null, values);
        if(contador == -1 || contador==0)
        { regInsertados="Error al insertar Registro,Verificar insercion";}
        else{ regInsertados=regInsertados+contador;}
        return regInsertados;

    }*/
    public String actualizarEL(ExperienciaLaboral el){
        String regInsertado;
        String id[]={Integer.toString(el.getIdExpLaboral())};
        ContentValues elab=new ContentValues();
        elab.put("ID_EMPRESA",el.getIdEmpresa());
        elab.put("ID_CARGO",el.getIdCargo());
        elab.put("DURACION_EXPERIENCIALABORAL",el.getDuracionExpLaboral());
        long contador=db.update("EXPERIENCIALABORAL",elab,"ID_EXPERIENCIALABORAL=?",id);
        if (contador==0||contador==-1)
        {regInsertado="ERROR DE INSERCION";}
        else
        {regInsertado="Datos actualizados Correctamente";}
        return regInsertado;
    }

    public String eliminarEL(String idExpLab){
        String[] id={idExpLab};
        String regAfectados;
        int contador=0;
        Cursor cursor=db.rawQuery("SELECT * FROM EXPERIENCIALABORAL WHERE ID_EXPERIENCIALABORAL=?", id);
        if (cursor.moveToFirst()==false || idExpLab==null)
        {regAfectados="Imposible Borrar:No se ha encontrado la Experiencia Laboral";}
        else
        { contador+=db.delete("EXPERIENCIALABORAL","ID_EXPERIENCIALABORAL = ?",id);
        regAfectados="Experiencia Laboral Eliminada ";}
        return regAfectados;

    }
    /*FIN FR12001*/

    //  CRUD  FB12001            CRUD DE CARGO  ***************************************************************************************
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
    //CRUD Aplicacion
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
        Cursor cursor=db.rawQuery("Select ID_EMPLEADO from EMPLEADO",null);//ID_EMPLEADO  EMPLEADO
        //Cursor cursor =db.query("EMPLEADO",camposEmpleado,null,null,null,null,null);//para probar esta con la tabla cargo , cambiar a la tabla Empleado despues
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
        Cursor cursor=db.rawQuery("Select ID_EMPRESA from EMPRESA",null);
        //Cursor cursor =db.query("EMPRESA",camposEmpresaCar,null,null,null,null,null);//para probar esta con la tabla cargo , cambiar a la tabla Empresa despues
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
    // FIN CRUD FB12001****************************************************************






    public String insertar(Referencia referencia){

        String regInsertados="Referencia Insertada N�= " ;
        long cont=0;

        ContentValues refe=new ContentValues();
        refe.put("ID_REFERENCIA",referencia.getId_referencia());
        refe.put("ID_EMPLEADO",referencia.getId_empleado());
        refe.put("ID_EMPRESA",referencia.getId_empresa());
        refe.put("NOMBRE_REFERENCIA",referencia.getNombre_referencia());
        refe.put("TELEFONO_REFERENCIA",referencia.getTelefono_referencia());
        cont=db.insert("REFERENCIA", null, refe);

        if(cont==-1|| cont==0){
            regInsertados="Error al Insertar La referencia, ya existe esa referencia.";

        }
        else {
            regInsertados+=cont;
        }

        return regInsertados;
    }

    public String eliminar(Referencia referencia){

        String regDelete="Referencias Eliminadas= ";
        int cont=0;
        cont=db.delete("REFERENCIA","ID_REFERENCIA='"+referencia.getId_referencia()+"'",null);
        return regDelete+=cont;

        }

    public String modificar(Referencia referencia){
        if(verificarIntegridad(referencia,3)){
            String id[]={String.valueOf(referencia.getId_referencia()),String.valueOf(referencia.getId_empleado())};
            ContentValues refe=new ContentValues();
            refe.put("NOMBRE_REFERENCIA",referencia.getNombre_referencia());
            refe.put("TELEFONO_REFERENCIA",referencia.getTelefono_referencia());
            refe.put("ID_EMPRESA", referencia.getId_empresa());
            db.update("REFERENCIA",refe,"ID_REFERENCIA= ? AND ID_EMPLEADO= ?",id);
            return "Se Actualiz� la Referencia";

        }
        else{
            return "La referencia No existe o no esta asociada a ese empleado";
        }

    }

    public Referencia consultarReferencia(String idReferencia,String idEmpelado){
        String[] id={idReferencia,idEmpelado};
        Cursor cursor=db.query("REFERENCIA",camposReferencia,"ID_REFERENCIA= ? and ID_EMPLEADO= ?",id,null,null,null);

        if(cursor.moveToFirst()){
            Referencia referencia=new Referencia();
            referencia.setId_referencia(cursor.getInt(0));
            referencia.setId_empleado(cursor.getInt(1));
            referencia.setId_empresa(cursor.getInt(2));
            referencia.setNombre_referencia(cursor.getString(3));
            referencia.setTelefono_referencia(cursor.getString(4));
            return referencia;
        }else {

            return null;
        }
    }


    public String insertar(GradoEspecializacion especializacion){
        String regInsertados="Especializacion Insertada N�= " ;
        long cont=0;

        ContentValues cv=new ContentValues();
        cv.put("ID_ESPECIALIZACION", especializacion.getId_especializacion());
        cv.put("ID_INSTITUTOESTUDIO", especializacion.getId_institutoEstudio());
        cv.put("NOMBRE_ESPECIALIZACION", especializacion.getNombre_especializacion());
        cv.put("DURACION_ESPECIALIZACION", especializacion.getDuracion_especializacion());

        cont=db.insert("GRADOESPECIALIZACION", null, cv);

        if(cont==-1|| cont==0){
            regInsertados="Error al Insertar La Especializacion, ya existe esa Especializacion.";

        }
        else {
            regInsertados+=cont;
        }

        return regInsertados;

    }

    public String eliminar(GradoEspecializacion especializacion){

        String regDelete="Filas Eliminadas= ";
        int cont=0;
        cont=db.delete("GRADOESPECIALIZACION","ID_ESPECIALIZACION='"+especializacion.getId_especializacion()+"'",null);
        return regDelete+=cont;

    }

    public String modificar(GradoEspecializacion especializacion){
        if(/*verificarIntegridad(especializacion,4)*/true){         //Ahorita esto esta de prueba para poder correrlo
            String id[]={String.valueOf(especializacion.getId_especializacion())};
            ContentValues refe=new ContentValues();
            refe.put("ID_INSTITUTOESTUDIO", especializacion.getId_institutoEstudio());
            refe.put("NOMBRE_ESPECIALIZACION", especializacion.getNombre_especializacion());
            refe.put("DURACION_ESPECIALIZACION", especializacion.getDuracion_especializacion());
            db.update("GRADOESPECIALIZACION",refe,"ID_ESPECIALIZACION= ? ",id);
            return "Se Actualiz� la Especializacion ";

        }
        else{
            return "La Especializacion No existe o no esta asociada a ese Insitituo";
        }
    }

    public GradoEspecializacion consultarGradoEspecializacion(String idEspec){

        String[] id={idEspec};
        Cursor cursor=db.query("GRADOESPECIALIZACION",camposGradoEspecializacion,"ID_ESPECIALIZACION= ? ",id,null,null,null);

        if(cursor.moveToFirst()){
            GradoEspecializacion espec=new GradoEspecializacion();
            espec.setId_especializacion(cursor.getInt(0));
            espec.setId_institutoEstudio(cursor.getInt(1));
            espec.setNombre_especializacion(cursor.getString(2));
            espec.setDuracion_especializacion(cursor.getInt(3));

            return espec;
        }else {

            return null;
        }
    }

    public boolean verificarIntegridad(Object dato,int relacion) {


        switch (relacion) {
            case 1: {
                //Verificar que al insertar una relacion, exista el empleado y la empresa de referencia y ademas que no exista esa referencia
                Referencia referencia=(Referencia)dato;
                String id[]={String.valueOf(referencia.getId_empleado())};
                String id2[]={String.valueOf(referencia.getId_empresa())};

                Cursor cursor1=db.query("EMPLEADO",null,"ID_EMPLEADO=?",id,null,null,null);
                Cursor cursor2=db.query("EMPRESA",null,"ID_EMPRESA=?",id2,null,null,null);

                if(cursor1.moveToFirst()&cursor2.moveToFirst()){ //aqui solo unse un "&"
                    return true;

                }

                return false;
            }

            case 2:{
                //verificar que al ingresar una especializacion exista el instituto de estudio
                GradoEspecializacion especializacion=(GradoEspecializacion)dato;
                String id[]={String.valueOf(especializacion.getId_institutoEstudio())};


                Cursor cursor1=db.query("INSTITUTOESTUDIO",null,"ID_INSTITUTOESTUDIO=?",id,null,null,null);


                if(cursor1.moveToFirst()){ //aqui solo unse un "&"
                    return true;

                }

                return false;
            }
            case 3:
            {
                //verificar que al actualizar la Referencia exista y el empleado este asociado a esa referencia
                Referencia referencia=(Referencia)dato;
                String id[]={String.valueOf(referencia.getId_empleado())};
                String id2[]={String.valueOf(referencia.getId_referencia())};

                Cursor cursor1=db.query("REFERENCIA",null,"ID_EMPLEADO=?",id,null,null,null);
                Cursor cursor2=db.query("REFERENCIA",null,"ID_REFERENCIA=?",id2,null,null,null);

                if(cursor1.moveToFirst()&cursor2.moveToFirst()){ //aqui solo unse un "&"
                    return true;

                }

                return false;


            }
            case 4:
            {
                //verificar que al actualizar un gradoEspecializacion exista el instituto de estudio
                GradoEspecializacion especializacion=(GradoEspecializacion)dato;
                String id[]={String.valueOf(especializacion.getId_institutoEstudio())};


                Cursor cursor1=db.query("INSTITUTOESTUDIO",null,"ID_INSTITUTOESTUDIO=?",id,null,null,null);


                if(cursor1.moveToFirst()){ //aqui solo unse un "&"
                    return true;

                }

                return false;
            }

            default: {
                return false;
            }


        }

        }
    }

