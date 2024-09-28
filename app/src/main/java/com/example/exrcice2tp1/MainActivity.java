package com.example.exrcice2tp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Assurez-vous que ces lignes sont dans votre activité (ex : MainActivity.java)
    EditText Nom, Surface, Nombre, Address;
    Button btnCalcul;
    CheckBox poolCheckBox;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison des vues avec leurs ID respectifs
        Nom = findViewById(R.id.name);
        Surface = findViewById(R.id.surface);
        Nombre = findViewById(R.id.nombre);
        Address = findViewById(R.id.adresse);
        btnCalcul = findViewById(R.id.button_calculate);
        poolCheckBox = findViewById(R.id.checkBox_pool);
        resultTextView = findViewById(R.id.textView_result);

        // Ajoutez des vérifications et des événements comme un clic sur le bouton
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action lors du clic sur le bouton
                int surface = Integer.parseInt(Surface.getText().toString());
                int nombre = Integer.parseInt(Nombre.getText().toString());
                boolean hasPool = poolCheckBox.isChecked();

                // Calcul des impôts

                int baseTax = surface * 2;
                int additionalTax = nombre * 50 + (hasPool ? 100 : 0);
                int totalTax = baseTax + additionalTax;

                // Afficher les résultats
                String result = "Impôt de base : " + baseTax +
                        "\nImpôt supplémentaire : " + additionalTax +
                        "\nImpôt total : " + totalTax;
                resultTextView.setText(result);

            }
        });

    }
}