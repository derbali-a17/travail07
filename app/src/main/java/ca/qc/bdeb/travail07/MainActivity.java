package ca.qc.bdeb.travail07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ca.qc.bdeb.travail07.entities.Etudiant;
import ca.qc.bdeb.travail07.entities.Material;
import ca.qc.bdeb.travail07.entities.Materials;

public class MainActivity extends AppCompatActivity {

    private EditText mainTxtNom;
    private EditText mainTxtAge;
    private EditText mainTxtNoda;

    List<Material> materials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMaterials();
    }

    private void initMaterials() {
        materials = new ArrayList<>();
        materials.add(new Material(1, "PC", 1999.99f, R.drawable.ic_pc, "Hardware"));
        materials.add(new Material(2, "Winrar", 0.00f, R.drawable.ic_winrar, "Software"));
        materials.add(new Material(3, "Android Studio", 0.00f, R.drawable.ic_android_studio, "Software"));
        materials.add(new Material(4, "Keyboard", 59.99f, R.drawable.ic_keyboard, "Hardware"));
    }

    public void envoyerDonnees(View view) {
        String nom  = mainTxtNom.getText().toString();
        int age  = Integer.parseInt(mainTxtAge.getText().toString());
        int noDA = Integer.parseInt(mainTxtNoda.getText().toString());
        Etudiant etudiant = new Etudiant(nom, age, noDA);
        Intent intent = new Intent(this, EtudiantActivity.class);
        intent.putExtra("etudiant", etudiant);
        startActivity(intent);
    }

    private void initView() {
        mainTxtNom = (EditText) findViewById(R.id.main_txt_nom);
        mainTxtAge = (EditText) findViewById(R.id.main_txt_age);
        mainTxtNoda = (EditText) findViewById(R.id.main_txt_noda);
    }

    public void getSoftwares(View view) {
        List<Material> hardwares = materials.stream().filter(m -> m.getCategorie().equals("Software")).collect(Collectors.toList());
        Intent intent  = new Intent(this, MaterialsActivity.class);
        Materials data = new Materials(hardwares);
        intent.putExtra("data", data);
        intent.putExtra("categ", "softwares");
        startActivity(intent);
    }

    public void getHardwares(View view) {
        List<Material> hardwares = materials.stream().filter(m -> m.getCategorie().equals("Hardware")).collect(Collectors.toList());
        Intent intent  = new Intent(this, MaterialsActivity.class);
        Materials data = new Materials(hardwares);
        intent.putExtra("data", data);
        intent.putExtra("categ", "hardwares");
        startActivity(intent);
    }
}