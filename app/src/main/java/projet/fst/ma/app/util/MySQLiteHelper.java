package projet.fst.ma.app.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Version et nom de la base
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "gestion_etudiants.db";

    // Nom de la table
    public static final String TABLE_ETUDIANT = "etudiant";

    // Colonnes
    public static final String COL_ID = "id";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";

    // Requête de création
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_ETUDIANT + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " TEXT NOT NULL, "
                    + COL_PRENOM + " TEXT NOT NULL"
                    + ");";

    public MySQLiteHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // stratégie simple pour TP : suppression puis recréation
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT);
        onCreate(database);
    }
}