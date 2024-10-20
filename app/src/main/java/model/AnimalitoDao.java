package model;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalitoDao{
    // Insertar un nuevo registro de Animalito en la base de datos
    @Insert
    void insertAnimalito(Animalito animalito);

    // Obtener todos los registros de Animalito desde la base de datos
    @Query("SELECT * FROM pets")
    List<Animalito> getAllAnimalitos();

    // Obtener un solo Animalito basado en su ID
    @Query("SELECT * FROM pets WHERE id = :id")
    Animalito getAnimalitoById(int id);
}
