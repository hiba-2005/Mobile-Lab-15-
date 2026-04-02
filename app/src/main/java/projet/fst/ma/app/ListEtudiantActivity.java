package projet.fst.ma.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import projet.fst.ma.app.adapter.EtudiantAdapter;
import projet.fst.ma.app.classes.Etudiant;
import projet.fst.ma.app.service.EtudiantService;

public class ListEtudiantActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private EtudiantService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_etudiant);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        service = new EtudiantService(this);
        List<Etudiant> liste = service.findAll();

        EtudiantAdapter adapter = new EtudiantAdapter(this, liste);
        recycler.setAdapter(adapter);
    }
}