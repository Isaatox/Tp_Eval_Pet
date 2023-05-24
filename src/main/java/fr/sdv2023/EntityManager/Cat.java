package fr.sdv2023.EntityManager;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal{
    private String chipId;

    public Cat() {
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
