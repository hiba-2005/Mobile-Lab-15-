package projet.fst.ma.app.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import projet.fst.ma.app.R;
import projet.fst.ma.app.classes.Etudiant;
import projet.fst.ma.app.service.EtudiantService;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.ViewHolder> {

    private List<Etudiant> liste;
    private Context context;
    private EtudiantService service;

    public EtudiantAdapter(Context context, List<Etudiant> liste) {
        this.context = context;
        this.liste = liste;
        this.service = new EtudiantService(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom, prenom;
        Button delete, edit;

        public ViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.txtNom);
            prenom = itemView.findViewById(R.id.txtPrenom);
            delete = itemView.findViewById(R.id.btnDelete);
            edit = itemView.findViewById(R.id.btnEdit);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_etudiant, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Etudiant e = liste.get(position);

        holder.nom.setText(e.getNom());
        holder.prenom.setText(e.getPrenom());

        // SUPPRIMER
        holder.delete.setOnClickListener(v -> {
            service.delete(e.getId());
            liste.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "Supprimé", Toast.LENGTH_SHORT).show();
        });

        // MODIFIER
        holder.edit.setOnClickListener(v -> {
            showEditDialog(e);
        });
    }

    private void showEditDialog(Etudiant e) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_etudiant, null);

        EditText newNom = new EditText(context);
        EditText newPrenom = new EditText(context);

        newNom.setHint("Nom");
        newPrenom.setHint("Prenom");

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(newNom);
        layout.addView(newPrenom);

        new AlertDialog.Builder(context)
                .setTitle("Modifier")
                .setView(layout)
                .setPositiveButton("OK", (dialog, which) -> {
                    e.setNom(newNom.getText().toString());
                    e.setPrenom(newPrenom.getText().toString());

                    service.update(e);
                    notifyDataSetChanged();
                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}