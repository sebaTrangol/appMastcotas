package model;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

// Especifica que esta clase es una base de datos Room y qué entidad utiliza
@Database(entities = {Animalito.class}, version = 1)
@TypeConverters({Converters.class, ListConverter.class}) // Añadimos los convertidores
public abstract class AnimalitoDatabase extends RoomDatabase {

    // Método abstracto que proporciona acceso al DAO
    public abstract AnimalitoDao animalitoDao();

    // Singleton para evitar múltiples instancias de la base de datos
    private static volatile AnimalitoDatabase INSTANCE;

    // Método para obtener la instancia única de la base de datos
    public static AnimalitoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AnimalitoDatabase.class) {
                if (INSTANCE == null) {
                    // Construir la base de datos usando Room
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AnimalitoDatabase.class, "animalito_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

