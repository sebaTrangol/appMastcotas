package com.example.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class ListaMascotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        // Aquí puedes agregar la lógica para mostrar la lista de mascotas

        // Referencia al botón de volver
        Button btnVolver = findViewById(R.id.btn_volver);

        // Configurar la acción del botón para volver a la pantalla principal
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(ListaMascotasActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Esto es opcional, para evitar volver a esta pantalla con el botón "Atrás"
        });
    }
}
