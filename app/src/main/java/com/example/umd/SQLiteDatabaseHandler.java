package com.example.umd;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.umd.objects.Nutrients;
import com.example.umd.objects.Player;
import com.example.umd.objects.Workouts;
import java.util.Random;
public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "PlayersDB";

    //Declare Tables in DB
    private static final String TABLE_NAME = "Players";
    private static final String INPUT_TABLE_NAME = "WorkoutInputs";
    private static final String NUTRIENT_INPUT_TABLE = "DailyInputs";

    //Declare attributes for Player Class
    private static final String KEY_NAME = "name";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_PASS = "pass";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_FREQ = "freq";

    //Declare Attributes for Daily Nutrient Intake
    private static final String KEY_ID = "id";
    private static final String KEY_CALORIES= "calories";
    private static final String KEY_CARBS = "carbs";
    private static final String KEY_PROTEIN = "protein";
    private static final String KEY_SUGAR = "sugar";
    private static final String KEY_SLEEP = "sleep";
    private static final String KEY_FAT = "fat";
    private static final String KEY_CHOLESTEROL = "cholesterol";
    private static final String KEY_FIBER = "fiber";
    private static final String KEY_DATE = "date";

    //Declare Attributes for Daily Workouts
    private static final String KEY_EXERCISEDURATION= "duration";
    private static final String KEY_EXERCISETYPE = "type";
    private static final String KEY_SETS = "sets";
    private static final String KEY_REPS = "reps";
    private static final String KEY_ExerciseWEIGHT = "exerciseweight";
    private static final String KEY_EXERCISEDATE = "exerciseDate";

    //Declare Columns in DB
    private static final String[] COLUMNS = { KEY_NAME, KEY_MOBILE,
            KEY_PASS, KEY_GENDER, String.valueOf(KEY_WEIGHT), String.valueOf(KEY_HEIGHT), KEY_FREQ};
    private static final String[] NUTRIENT_COLUMNS = { KEY_ID, KEY_NAME, KEY_CALORIES, KEY_CARBS, KEY_PROTEIN, KEY_SUGAR, KEY_SLEEP, KEY_FAT, KEY_CHOLESTEROL, KEY_FIBER, KEY_DATE};
    private static final String[] EXERCISE_COLUMNS = { KEY_ID, KEY_NAME, KEY_EXERCISEDURATION, KEY_EXERCISETYPE, KEY_SETS, KEY_REPS, KEY_EXERCISEDATE, KEY_DATE};

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating table in database
        String CREATION_TABLE = "CREATE TABLE Players ( "
                + "name TEXT PRIMARY KEY, "
                + "mobile TEXT, " + "pass TEXT, " + "gender TEXT, " + "weight INTEGER, " + "height INTEGER, " +"freq TEXT )";

        String DAILY_INPUTS = "CREATE TABLE DailyInputs ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT, " + "CALORIES INTEGER, "
                + "CARBS INTEGER, " + "PROTEIN INTEGER, " + "SUGAR INTEGER, " + "SLEEP INTEGER, " + "FAT INTEGER, "
                + "CHOLESTEROL INTEGER, " + "FIBER INTEGER, " + "date DATE )";

        String DAILY_WORKOUT_INPUTS = "CREATE TABLE WorkoutInputs ( "
        + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT, " + "duration INTEGER, " + "type STRING, " + "SETS INTEGER, " + "REPS INTEGER, "
                + "exerciseweight, " + "date DATE )";

        Log.d("MSG", "FAILED AFTER CREATING DAILY INPUT");
        db.execSQL(CREATION_TABLE);
        db.execSQL(DAILY_INPUTS);
        db.execSQL(DAILY_WORKOUT_INPUTS);
    }

    public boolean initializedb()
    {
        String playerTable = TABLE_NAME;
        String nutrientTable = NUTRIENT_INPUT_TABLE;
        String workoutTable = INPUT_TABLE_NAME;
        if(numberofrowsinDB(NUTRIENT_INPUT_TABLE) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES('antoopo', '734', 'abc', 'Male', 129, 80, 'Always')");
            db.execSQL("INSERT INTO " + INPUT_TABLE_NAME + " VALUES(7, 'antoop', 2000, 'cardio', 20, 50, 8, '2020-07-04')");
            db.execSQL("INSERT INTO " + NUTRIENT_INPUT_TABLE + " VALUES(99, 'antoop', 2000, 250, 200, 50, 8, 70, 0, 20, '2020-07-04')");
            //insert in the order you need the values
            //Alter this statement to not let users insert without fields filled out
            db.close();
            return true;
        }
        {
            return false;
        }
    }
    //only do this the first time you load the database

    public int numberofrowsinDB(String table_name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        int numRows = (int) DatabaseUtils.queryNumEntries(db, table_name);
        db.close();

        return numRows;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + INPUT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + NUTRIENT_INPUT_TABLE);
        this.onCreate(db);
    }

    public void deleteOne(Player player) {
        // Get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id = ?", new String[] { String.valueOf(player.getName()) });
        db.close();
    }
    public boolean checkifexists(String key)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE Name = ? ", new String[]{ key } );

// If name doesn't exist -> add
        if (res.getCount() == 0) {
            return false;

        }
        Log.d("Uname does exist", "YESSS");
        // else -> return false and give error
        return true;

    }
    public boolean checkLoginCredentials(String key, String pword){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE name = ? ", new String[] { key } );
        Cursor res2 = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE pass = ? ", new String[] { pword });
        if (res.moveToLast()){
            if(res2.moveToLast()){
                Log.d("PASSWORD LOOKS RIGHT", "MSG");
                return true;
            }
        }
        else {
            return false;
        }
        return false;
    }
    public Player getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor != null)
            cursor.moveToFirst();

        Player player = new Player();
        player.setName(cursor.getString(0));
        player.setMobile(cursor.getString(1));
        player.setPass(cursor.getString(2));
        player.setGender(cursor.getString(3));
        player.setWeight(Integer.parseInt(cursor.getString(4)));
        player.setHeight(Integer.parseInt(cursor.getString(5)));
        player.setFreq(cursor.getString(6));

        return player;
    }

    public List<Player> allPlayers() {

        List<Player> players = new LinkedList<Player>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = null;

        if (cursor.moveToFirst()) {
            do {
                player = new Player();
                player.setName(cursor.getString(0));
                player.setMobile(cursor.getString(1));
                player.setPass(cursor.getString(2));
                player.setGender(cursor.getString(3));
                player.setWeight(Integer.parseInt(cursor.getString(4)));
                player.setHeight(Integer.parseInt(cursor.getString(5)));
                player.setFreq(cursor.getString(6));
                players.add(player);
            } while (cursor.moveToNext());
        }

        return players;
    }

    public void addPlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, player.getName());
        values.put(KEY_MOBILE, player.getMobile());
        values.put(KEY_PASS, player.getPass());
        values.put(KEY_GENDER, player.getGender());
        values.put(KEY_WEIGHT, player.getWeight());
        values.put(KEY_HEIGHT, player.getHeight());
        values.put(KEY_FREQ, player.getFreq());
        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }
    public void addNutrients(Nutrients nutrients) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int min = (int) Math.ceil(1);
        int max = (int) Math.floor(65000);
        int rand = (int) Math.floor(Math.random() * (max - min + 1) + min); //The maximum is inclusive and the minimum is inclusive
        Log.d("Record ID ", String.valueOf(rand));
        values.put(KEY_ID, rand);
        values.put(KEY_NAME, nutrients.getName());
        Log.d("Carb Message", String.valueOf(nutrients.getTotalCarbs()));
        values.put(KEY_CALORIES, nutrients.getTotalCalories());
        values.put(KEY_CARBS,nutrients.getTotalCarbs());
        values.put(KEY_PROTEIN, nutrients.getTotalProtein());
        values.put(KEY_SUGAR, nutrients.getTotalSugar());
        values.put(KEY_SLEEP, nutrients.getTotalSleep());
        values.put(KEY_FAT, nutrients.getTotalFat());
        values.put(KEY_CHOLESTEROL, nutrients.getCholesterol());
        values.put(KEY_FIBER, nutrients.getDietaryFiber());
        // insert
        db.insert(NUTRIENT_INPUT_TABLE,null, values);
        db.close();
    }
    public void addWorkout(Workouts workouts) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int rand = (int) Math.random();
        values.put(KEY_ID, rand);
        values.put(KEY_NAME, workouts.getUName());
        values.put(KEY_EXERCISEDURATION, workouts.getExerciseDuration());
        values.put(KEY_EXERCISETYPE, workouts.getExerciseType());
        values.put(KEY_SETS, workouts.getExerciseSets());
        values.put(KEY_REPS, workouts.getExerciseReps());
        values.put(KEY_ExerciseWEIGHT, workouts.getExerciseWeight());
        values.put(KEY_DATE, workouts.getExerciseDate().toString());
        // insert
        db.insert(INPUT_TABLE_NAME,null, values);
        db.close();
    }

    public int updatePlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOBILE, player.getMobile());
        values.put(KEY_PASS, player.getPass());
        values.put(KEY_GENDER, player.getGender());
        values.put(KEY_WEIGHT, player.getWeight());
        values.put(KEY_HEIGHT, player.getHeight());
        values.put(KEY_FREQ, player.getFreq());

        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(player.getName()) });
        db.close();
        return i;
    }

    public Nutrients getTodayMetric(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Nutrients rec = new Nutrients();
        Cursor res = db.rawQuery("SELECT * FROM " + NUTRIENT_INPUT_TABLE + " WHERE name = ? ", new String[]{ name });
        if (res.moveToLast()) {
            rec.setName(name);
            rec.setTotalCalories(res.getColumnIndex(String.valueOf(2)));
            rec.setTotalCarbs(res.getColumnIndex(String.valueOf(3)));
            rec.setTotalProtein(res.getColumnIndex(String.valueOf(4)));
            rec.setTotalSugar(res.getColumnIndex(String.valueOf(5)));
            rec.setTotalSleep(res.getColumnIndex(String.valueOf(6)));
            rec.setTotalFat(res.getColumnIndex(String.valueOf(7)));
            rec.setCholesterol(res.getColumnIndex(String.valueOf(8)));
            rec.setDietaryFiber(res.getColumnIndex(String.valueOf(9)));
        }
        db.close();
        return rec;
    }
}