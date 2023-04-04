package ca.qc.bdeb.travail07;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.bdeb.travail07.entities.Etudiant;

public class EtudiantActivity extends AppCompatActivity {

    private TextView etudiantLblNom;
    private TextView etudiantLblAge;
    private TextView etudiantLblNoda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant);
        initView();

        //recupérer le parcelable
        Bundle extras =  getIntent().getExtras();
        if(extras != null){
            Etudiant etudiant = extras.getParcelable("etudiant");
            etudiantLblNom.setText(etudiant.getNom());
            etudiantLblAge.setText("" + etudiant.getAge());
            etudiantLblNoda.setText("" + etudiant.getNoDA());
        }
    }

    private void initView() {
        etudiantLblNom = (TextView) findViewById(R.id.etudiant_lbl_nom);
        etudiantLblAge = (TextView) findViewById(R.id.etudiant_lbl_age);
        etudiantLblNoda = (TextView) findViewById(R.id.etudiant_lbl_noda);
    }
}