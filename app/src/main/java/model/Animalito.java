package model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "pets")
public class Animalito {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type; // Gato o Perro
    private int age;
    private Date lastVaccinationDate;
    private Date nextVaccinationDate;
    private List<Float> weightHistory;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public void setLastVaccinationDate(Date lastVaccinationDate) {
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public Date getNextVaccinationDate() {
        return nextVaccinationDate;
    }

    public void setNextVaccinationDate(Date nextVaccinationDate) {
        this.nextVaccinationDate = nextVaccinationDate;
    }

    public List<Float> getWeightHistory() {
        return weightHistory;
    }

    public void setWeightHistory(List<Float> weightHistory) {
        this.weightHistory = weightHistory;
    }
}
