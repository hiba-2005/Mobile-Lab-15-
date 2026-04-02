package projet.fst.ma.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import projet.fst.ma.app.classes.Etudiant;
import projet.fst.ma.app.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private Button add;

    private EditText id;
    private Button rechercher;
    private Button supprimer;
    private Button btnListe;
    private TextView res;

    void clear() {
        nom.setText("");
        prenom.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EtudiantService es = new EtudiantService(this);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        add = findViewById(R.id.bn);

        id = findViewById(R.id.id);
        rechercher = findViewById(R.id.load);
        supprimer = findViewById(R.id.delete);
        btnListe = findViewById(R.id.btnListe);
        res = findViewById(R.id.res);

        add.setOnClickListener(v -> {
            es.create(new Etudiant(
                    nom.getText().toString(),
                    prenom.getText().toString()
            ));

            clear();

            for (Etudiant e : es.findAll()) {
                Log.d("DATA", e.getNom() + " " + e.getPrenom());
            }

            Toast.makeText(MainActivity.this, "Étudiant ajouté", Toast.LENGTH_SHORT).show();
        });

        rechercher.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                res.setText("");
                Toast.makeText(MainActivity.this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                res.setText("");
                Toast.makeText(MainActivity.this, "Étudiant introuvable", Toast.LENGTH_SHORT).show();
                return;
            }

            res.setText(e.getNom() + " " + e.getPrenom());
        });

        supprimer.setOnClickListener(v -> {
            String txt = id.getText().toString().trim();

            if (txt.isEmpty()) {
                Toast.makeText(MainActivity.this, "Saisir un id", Toast.LENGTH_SHORT).show();
                return;
            }

            Etudiant e = es.findById(Integer.parseInt(txt));

            if (e == null) {
                Toast.makeText(MainActivity.this, "Aucun étudiant à supprimer", Toast.LENGTH_SHORT).show();
                return;
            }

            es.delete(e.getId());
            res.setText("");

            Toast.makeText(MainActivity.this, "Étudiant supprimé", Toast.LENGTH_SHORT).show();
        });

        btnListe.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListEtudiantActivity.class);
            startActivity(intent);
        });
    }
}