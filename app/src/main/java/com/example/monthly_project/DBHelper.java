package com.example.monthly_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DBHelper extends SQLiteOpenHelper {

    String [] komputery = {
            "Ryzen 7 3700X 3,6 GHz 16GB DDR4 3600MHz SSD M.2 2TB RTX 2060S, cena 5680zł",
            "Intel Core i7 11700 8 X 2,9 GHz 16GB DDR4 SSD 500GB M.2 GTX 1660 6GB, cena 5850zł",
            "Intel Core i5 12400 6 X 2,4GHz 16GB DDR4 SSD 500GB M.2 GTX 1050 Ti 4GB, cena 3824,99 zł"

    };

    String [] komputery_opis = {
      "Super szybki komputer złożony bezpośrednio w naszym salonie. Osiągnij maksymalną wydajność w najlepszej cenie dzięki procesorowi AMD Ryzen 7 i karcie graficznej NVIDIA RTX 2060 Super.",
      "Idealny dla profesjonalnych zadań, niezawodny procesor Intel Core i7 jedenastej generacji zapewni najwyższą wydajność w programach profesjonalnych, a karta graficzna GTX 1660 świetnie go w tym uzupełni.",
      "Budżetowa opcja dla rozpoczynających swoją przygodę z komputerami stacjonarnymi, szybki procesor Intel Core i5 podoła każdej wymagającej grze, a grafika NVIDIA GTX 1050 Ti poradzi sobie z każdym zadaniem z zadowalającą wydajnością."
    };

    Double [] komputery_cena = {
            (double)5680, (double)5850, 3824.99
    };

    String [] myszki = {
            "Logitech G PRO X SUPERLIGHT Black, cena 549,99zł",
            "Glorious Model D Wireless Matte White, cena 479,99zł",
            "Roccat Kone Pro Air White, cena 649 zł"
    };

    String [] myszki_opis = {
            "Nowoczesna ultra-lekka myszka Logitech G PRO X SUPERLIGHT waży zaledwie 56 gramów, co podniesie na najwyższy poziom jakość twojej rozgrywki.",
            "Skierowany od graczy, dla graczy Model D Wireless łączy ze sobą najlepsze cechy topowych modeli na rynku z budżetową ceną lekkiej i bezprzewodowej myszki.",
            "Niemiecki design i precyzja Roccat, dostarczy ci najwyższej jakości przy używaniu myszki Roccat Kone Pro Air. Najlepszy na rynku sensor PureEye osiąga maksymalną precyzję, a waga zaledwie 64 gramów przy ergonomicznych kształcie zapewni ci najwyższy komfort użytkowania."
    };

    Double [] myszki_cena = {
            549.99, 479.99, (double)649
    };

    String [] klawiatury = {
            "SteelSeries Apex 3 TKL, cena 249,99zł",
            "Corsair K55 RGB PRO, cena 189,99zł",
            "Razer Ornata V2 Chroma Black, cena 365zł"
    };

    String [] klawiatury_opis = {
            "Mechaniczna klawiatura budżetowa od znanej marki SteelSeries zapewni ci świetny komfort pisania i wysoką jakość produktu.",
            "Nowa budżetowa opcja od cenionej na rynku klawiatur firmy Corsair, posiada najwyższej jakości klawisze oraz konfigurowalne podświetlenie RGB.",
            "Najbardziej znana marka gamingowych produktów, Razer oferuje najnowszy model swojej popularnej hybrydowej klawiatury z podietleniem Chroma RGB."
    };

    Double [] klawiatury_cena = {
            249.99, 189.99, (double)365
    };

    String [] kamery = {
            "Razer Kiyo Full HD, cena 339,99zł",
            "Logitech C920 Pro Full HD, cena 425zł",
            "Creative Live! Cam Sync 1080p V2, cena 198zł"
    };

    String [] kamery_opis = {
            "Kamera od gamingowej marki Razer, spełni idealną funkcję dla wszystkich streamerów i YouTuberów. Dzięki wbudowanemu auto-focus oraz studyjnemu podświetleniu jakość obrazu jest porównywalna z najdroższymi aparatami cyfrowymi.",
            "Klasyczny model Logitech w wysokiej rozdzielczości nada się idealnie do wszystkich wirtualnych spotkań, rozmów czy filmów.",
            "Budżetowa kamera internotowa od Creative jest świetną opcją na wszystkie spotkania online oraz rozmowy na kamerce ze znajomymi."
    };

    Double [] kamery_cena = {
            339.99, (double)425, (double)198
    };

    int [] komputery_img = {
            R.drawable.komputer1,
            R.drawable.komputer2,
            R.drawable.komputer3
    };

    int [] myszki_img = {
            R.drawable.myszka1,
            R.drawable.myszka2,
            R.drawable.myszka3
    };

    int [] klawiatury_img = {
            R.drawable.klawiatura1,
            R.drawable.klawiatura2,
            R.drawable.klawiatura3
    };

    int [] kamery_img = {
            R.drawable.kamera1,
            R.drawable.kamera2,
            R.drawable.kamera3
    };

    private Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ShopDB.db";

    public static final String DBKomputery = "CREATE TABLE komputery(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  " +
            "name TEXT," +
            "description TEXT," +
            "cena DOUBLE, " +
            "zdjecie TEXT"+
            ");";

    public static final String DBMyszki = "CREATE TABLE myszki(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  " +
            "name TEXT," +
            "description TEXT," +
            "cena DOUBLE, " +
            "zdjecie TEXT"+
            ");";

    public static final String DBKlawiatury = "CREATE TABLE klawiatury(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  " +
            "name TEXT," +
            "description TEXT," +
            "cena DOUBLE, " +
            "zdjecie TEXT"+
            ");";

    public static final String DBKamery = "CREATE TABLE kamery(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  " +
            "name TEXT," +
            "description TEXT," +
            "cena DOUBLE, " +
            "zdjecie TEXT"+
            ");";

    public static final String DBZamowienia = "CREATE TABLE zamowienia(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  " +
            "data STRING," +
            "komputer_id INTEGER," +
            "myszka_id INTEGER," +
            "klawiatura_id INTEGER," +
            "kamera_id INTEGER," +
            "cena_suma DOUBLE," +
            "name TEXT" +
            ");";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public String imageToBA(int[] images, int i) {
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), images[i]);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 10, baos);
        byte[] bytes = baos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public Bitmap base64ToString(String base64String){
        byte[] imageByteArray = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBKomputery);
        db.execSQL(DBMyszki);
        db.execSQL(DBKlawiatury);
        db.execSQL(DBKamery);
        db.execSQL(DBZamowienia);
        insertTable(db);
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");


    public void insertOrder(Integer komputer_id, Integer mouse_id, Integer keyboard_id, Integer kamera_id, Double cena_suma, String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Date date = new Date(System.currentTimeMillis());
        ContentValues values;

        values = new ContentValues();
        values.put("data", formatter.format(date));
        values.put("komputer_id", komputer_id);
        values.put("myszka_id", mouse_id);
        values.put("klawiatura_id", keyboard_id);
        values.put("kamera_id", kamera_id);
        values.put("cena_suma", cena_suma);
        values.put("name", name);

        db.insert("zamowienia", null, values);
    }

    public Double getCenaSuma(Integer komputer_id, Integer mouse_id, Integer keyboard_id, Integer kamera_id){
        SQLiteDatabase db = this.getReadableDatabase();

        String query_pc = "SELECT cena FROM komputery WHERE id = " + komputer_id.toString();
        Cursor cursor = db.rawQuery(query_pc, null);
        cursor.moveToFirst();
        Double cena_pc = cursor.getDouble(0);
        cursor.close();

        String query_mouse = "SELECT cena FROM myszki WHERE id = " + mouse_id.toString();
        String query_keyboard = "SELECT cena FROM klawiatury WHERE id = " + keyboard_id.toString();
        String query_kamera = "SELECT cena FROM kamery WHERE id = " + kamera_id.toString();


        if(mouse_id != 4 && keyboard_id == 4 && kamera_id == 4){
            Cursor c2 = db.rawQuery(query_mouse, null);
            c2.moveToFirst();
            Double cena = c2.getDouble(0);
            Double cena_suma = cena + cena_pc;
            return cena_suma;
        }else if(mouse_id == 4 && keyboard_id != 4 && kamera_id == 4){
            Cursor c2 = db.rawQuery(query_keyboard, null);
            c2.moveToFirst();
            Double cena = c2.getDouble(0);
            Double cena_suma = cena + cena_pc;
            return cena_suma;
        }else if(mouse_id == 4 && keyboard_id == 4 && kamera_id != 4) {
            Cursor c2 = db.rawQuery(query_kamera, null);
            c2.moveToFirst();
            Double cena = c2.getDouble(0);
            Double cena_suma = cena + cena_pc;
            return cena_suma;
        }else if(mouse_id != 4 && keyboard_id != 4 && kamera_id == 4){
            Cursor c1 = db.rawQuery(query_mouse, null);
            Cursor c2 = db.rawQuery(query_keyboard, null);
            c1.moveToFirst();
            c2.moveToFirst();
            Double cena1 = c1.getDouble(0);
            Double cena2 = c2.getDouble(0);
            Double cena_suma = cena1 + cena2 + cena_pc;
            return cena_suma;
        }else if(mouse_id != 4 && keyboard_id == 4 && kamera_id != 4){
            Cursor c1 = db.rawQuery(query_mouse, null);
            Cursor c2 = db.rawQuery(query_kamera, null);
            c1.moveToFirst();
            c2.moveToFirst();
            Double cena1 = c1.getDouble(0);
            Double cena2 = c2.getDouble(0);
            Double cena_suma = cena1 + cena2 + cena_pc;
            return cena_suma;
        }else if(mouse_id == 4 && keyboard_id != 4 && kamera_id != 4){
            Cursor c1 = db.rawQuery(query_keyboard, null);
            Cursor c2 = db.rawQuery(query_kamera, null);
            c1.moveToFirst();
            c2.moveToFirst();
            Double cena1 = c1.getDouble(0);
            Double cena2 = c2.getDouble(0);
            Double cena_suma = cena1 + cena2 + cena_pc;
            return cena_suma;
        }else if(mouse_id != 4 && keyboard_id != 4 && kamera_id != 4){
            Cursor c1 = db.rawQuery(query_mouse, null);
            Cursor c2 = db.rawQuery(query_keyboard, null);
            Cursor c3 = db.rawQuery(query_kamera, null);
            c1.moveToFirst();
            c2.moveToFirst();
            c3.moveToFirst();
            Double cena1 = c1.getDouble(0);
            Double cena2 = c2.getDouble(0);
            Double cena3 = c3.getDouble(0);
            Double cena_suma = cena1 + cena2 + cena3 + cena_pc;
            return cena_suma;
        }
        else{
        return cena_pc;
        }
    }

    public void insertTable(SQLiteDatabase db) {

        ContentValues values;

        for (int i = 0; i < komputery.length; i++) {
            values = new ContentValues();
            values.put("name", komputery[i]);
            values.put("description", komputery_opis[i]);
            values.put("cena", komputery_cena[i]);
            values.put("zdjecie", imageToBA(komputery_img, i));
            db.insert("komputery", null, values);

            values = new ContentValues();
            values.put("name", myszki[i]);
            values.put("description", myszki_opis[i]);
            values.put("cena", myszki_cena[i]);
            values.put("zdjecie", imageToBA(myszki_img, i));
            db.insert("myszki", null, values);

            values = new ContentValues();
            values.put("name", klawiatury[i]);
            values.put("description", klawiatury_opis[i]);
            values.put("cena", klawiatury_cena[i]);
            values.put("zdjecie", imageToBA(klawiatury_img, i));
            db.insert("klawiatury", null, values);

            values = new ContentValues();
            values.put("name", kamery[i]);
            values.put("description", kamery_opis[i]);
            values.put("cena", kamery_cena[i]);
            values.put("zdjecie", imageToBA(kamery_img, i));
            db.insert("kamery", null, values);
        }
    }


    public ArrayList<Komputer> readKomputery(){
        ArrayList<Komputer> arr = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM komputery";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                Double price = cursor.getDouble(3);
                String base64string = cursor.getString(4);
                Bitmap bitmap = base64ToString(base64string);

                Komputer komputer = new Komputer(id, name, description, price, base64string, bitmap);
                arr.add(komputer);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public ArrayList<Myszka> readMyszki(){
        ArrayList<Myszka> arr = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM myszki";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                Double price = cursor.getDouble(3);
                String base64string = cursor.getString(4);
                Bitmap bitmap = base64ToString(base64string);

                Myszka myszka = new Myszka(id, name, description, price, base64string, bitmap);
                arr.add(myszka);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public ArrayList<Klawiatura> readKlawiatury(){
        ArrayList<Klawiatura> arr = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM klawiatury";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                Double price = cursor.getDouble(3);
                String base64string = cursor.getString(4);
                Bitmap bitmap = base64ToString(base64string);

                Klawiatura klawiatura = new Klawiatura(id, name, description, price, base64string, bitmap);
                arr.add(klawiatura);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public ArrayList<Kamera> readKamery(){
        ArrayList<Kamera> arr = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM kamery";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                Double price = cursor.getDouble(3);
                String base64string = cursor.getString(4);
                Bitmap bitmap = base64ToString(base64string);

                Kamera kamera = new Kamera(id, name, description, price, base64string, bitmap);
                arr.add(kamera);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public ArrayList<ZamowienieModel> readZamowienia(){
        ArrayList<ZamowienieModel> arr = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM zamowienia";
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                int komputer_id = cursor.getInt(2);
                int myszka_id = cursor.getInt(3);
                int klawiatura_id = cursor.getInt(4);
                int kamera_id = cursor.getInt(5);
                double cena_suma = cursor.getDouble(6);
                String name = cursor.getString(7);

                ZamowienieModel zamowienieModel = new ZamowienieModel(id, date, komputer_id, myszka_id, klawiatura_id, kamera_id, cena_suma, name);
                arr.add(zamowienieModel);
            }while(cursor.moveToNext());
        }
        return arr;
    }

    public static ZamowienieModel readZamowienieDetail(int i, Context context){

        ZamowienieModel returner = new ZamowienieModel();
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM zamowienia WHERE id = " + String.valueOf(i);
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                int komputer_id = cursor.getInt(2);
                int myszka_id = cursor.getInt(3);
                int klawiatura_id = cursor.getInt(4);
                int kamera_id = cursor.getInt(5);
                double cena_suma = cursor.getDouble(6);
                String name = cursor.getString(7);

                ZamowienieModel zamowienieModel = new ZamowienieModel(id, date, komputer_id, myszka_id, klawiatura_id, kamera_id, cena_suma, name);
                return zamowienieModel;

            }while(cursor.moveToNext());
        }return returner;
    }
}
