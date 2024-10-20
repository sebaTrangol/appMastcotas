package com.example.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.Date;
import java.util.List;
import model.Animalito;
import model.AnimalitoDatabase;

public class MainActivity extends AppCompatActivity {

    // Instancia de la base de datos
    private AnimalitoDatabase animalitoDatabase;
    // TextView para mostrar el nombre del animalito
    private TextView animalitoNameTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Referencia al TextView de la interfaz de usuario
            animalitoNameTextView = findViewById(R.id.animalitoNameTextView);
            // Inicializar la base de datos de Room
            animalitoDatabase = AnimalitoDatabase.getDatabase(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear un nuevo objeto Animalito
        Animalito newAnimalito = new Animalito();
        newAnimalito.setName("Luna");
        newAnimalito.setType("Gato");
        newAnimalito.setAge(3);
        newAnimalito.setLastVaccinationDate(new Date());
        newAnimalito.setNextVaccinationDate(new Date());

        // Insertar el nuevo animalito en la base de datos
        new InsertAnimalitoTask().execute(newAnimalito);

        // Obtener todos los registros de animalitos y mostrar el nombre del primero
        new GetAllAnimalitosTask().execute();

        // Referencia al botón
        Button mascotasButton = findViewById(R.id.btn_mascotas);

        // Configurar la acción del botón
        mascotasButton.setOnClickListener(v -> {
            // Iniciar la actividad que mostrará la lista de mascotas
            Intent intent = new Intent(MainActivity.this, ListaMascotasActivity.class);
            startActivity(intent);
        });

        // Referencia al botón Registrar Mascotas
        Button registrarButton = findViewById(R.id.btn_registro);

        // Configurar la acción del botón
        registrarButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistrarMascotasActivity.class);
            startActivity(intent);
        });


    }

    // Clase AsyncTask para insertar animalitos en la base de datos
    private class InsertAnimalitoTask extends AsyncTask<Animalito, Void, Void> {
        @Override
        protected Void doInBackground(Animalito... animalitos) {
            // Insertar el animalito en la base de datos usando el DAO
            animalitoDatabase.animalitoDao().insertAnimalito(animalitos[0]);
            return null;
        }
    }

    // Clase AsyncTask para obtener todos los animalitos de la base de datos
    private class GetAllAnimalitosTask extends AsyncTask<Void, Void, List<Animalito>> {
        @Override
        protected List<Animalito> doInBackground(Void... voids) {
            // Obtener todos los animalitos de la base de datos usando el DAO
            return animalitoDatabase.animalitoDao().getAllAnimalitos();
        }

        @Override
        protected void onPostExecute(List<Animalito> animalitos) {
            if (animalitos != null && !animalitos.isEmpty()) {
                // Mostrar el nombre del primer animalito en el TextView
                Animalito firstAnimalito = animalitos.get(0);
                animalitoNameTextView.setText("Nombre del primer animalito: " + firstAnimalito.getName());
            } else {
                animalitoNameTextView.setText("No hay animalitos registrados.");
            }
        }
    }
}
