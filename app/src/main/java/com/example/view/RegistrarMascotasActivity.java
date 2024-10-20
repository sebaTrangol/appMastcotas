package com.example.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class RegistrarMascotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_mascotas);

        // Referencia al botón de volver
        Button btnVolver = findViewById(R.id.btn_volver);

        // Configurar la acción del botón para volver a la pantalla principal
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrarMascotasActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
