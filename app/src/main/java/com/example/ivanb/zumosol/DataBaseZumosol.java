package com.example.ivanb.zumosol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseZumosol {

// TABLA PARA EL CONTADOR DE LOS ZUMOS

    public static final String TABLE_NAME_ZUMOS = "botellas";
    public static final String CN_ID = "_id";
    public static final String CN_BOTELLAS = "Tipo de botella";
    public static final String CN_NUMERO = "Numero de botellas";

    public static final String CREATE_TABLE_ZUMOS =  " create table " +TABLE_NAME_ZUMOS+ " ("
            + CN_BOTELLAS + " primary key text not null,"
            + CN_NUMERO + " integer) ;";

// TABLA PARA LAS PREGUNTAS

    public static final String TABLE_NAME_PREGUNTAS = "preguntas";
    public static final String CN_PREGUNTAS = "Preguntas";
    public static final String CN_MUCHO = "Mucho";
    public static final String CN_POCO = "Poco";
    public static final String CN_NADA = "Nada";

    public static final String CREATE_TABLE_PREGUNTAS =  " create table " +TABLE_NAME_PREGUNTAS+ " ("
            + CN_PREGUNTAS + " primary key text not null,"
            + CN_MUCHO + " integer,"
            + CN_POCO + " integer,"
            + CN_NADA + " integer) ;";

    // CREACION DE LA BASE DE DATOS
    public class DataBaseHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "ZUMOSOL.sqlite";
        private static final int DB_SCHEME_VERSION = 1;

        public DataBaseHelper(Context context) {
            super(context, DB_NAME, null, DB_SCHEME_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_PREGUNTAS);
            db.execSQL(CREATE_TABLE_ZUMOS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //modificar o añadir datos a las tablas de la base de datos

        }
    }

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    // CONSTRUCTOR DE LA BASE DE DATOS
    public DataBaseZumosol(Context context) {
        helper = new DataBaseHelper(context);
        //LA CREA SI NO EXISTE, Y SI EXISTE LA DEVUELVE EN MODO ESCRITURA
        db = helper.getWritableDatabase();

    }

    private ContentValues generarValoresZumos(String tipoZumo, String numeroZumos){

        // COLUMN HACK es para hacer compatible con otras bases de datos
        //Contenedor de valores se hace en un metodo aparte porque se suele usar mucho
        // key es el nombre de la columna, y el tipo de cosas que se le pasan

        ContentValues valores = new ContentValues();
        valores.put(CN_BOTELLAS, tipoZumo);
        valores.put(CN_NUMERO, numeroZumos);

        return valores;
    }

    public void insertarZumos (String tipoZumo, String numeroZumos){

        //db.insert(TABLE_NAME_ZUMOS, null, generarValoresZumos(tipoZumo,numeroZumos));
        db.execSQL("insert into "+TABLE_NAME_ZUMOS+" values (null,'"+tipoZumo+"',"+numeroZumos+")");

    }

    public void eliminar(String tipoZumo){
        db.delete(TABLE_NAME_ZUMOS, CN_BOTELLAS + "=?", new String[]{tipoZumo});
        //Se pone el array de strings porque se puede borrar varios de una sola vez
        // el =? indica que se borrara en funcion de lo que ponga en el array de tipoZumo
    }

    public void eliminarMultiple(String zumo1, String zumo2){
        db.delete(TABLE_NAME_ZUMOS, CN_BOTELLAS + "IN (?,?)", new String[]{zumo1,zumo2});
    }

    public void modificarCantidad(String tipoZumo, String nuevaCantidad){

        db.update(TABLE_NAME_ZUMOS, generarValoresZumos(tipoZumo, nuevaCantidad), CN_BOTELLAS + "=?", new String[]{tipoZumo});
    }

    public Cursor cargarNumeroZumos(){
        String[] numeroZumos = new String[]{CN_NUMERO};
        return db.query(TABLE_NAME_ZUMOS, numeroZumos, null, null, null, null, null);
    }
}
