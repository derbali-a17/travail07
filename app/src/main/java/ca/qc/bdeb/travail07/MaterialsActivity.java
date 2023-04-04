package ca.qc.bdeb.travail07;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ca.qc.bdeb.travail07.entities.Material;
import ca.qc.bdeb.travail07.entities.Materials;

public class MaterialsActivity extends AppCompatActivity {

    private TextView materialsLblNoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        initView();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String categ = extras.getString("categ");
            Materials data  = extras.getParcelable("data");
            String message = "Il y a " + data.getMaterialList().size() +" " + categ + " \n";
            for (Material m : data.getMaterialList()) {
                message += m.getNom() + "\n";
            }
            materialsLblNoms.setText(message);

        }
    }

    private void initView() {
        materialsLblNoms = (TextView) findViewById(R.id.materials_lbl_noms);
    }
}