package fr.sdv2023.EntityManager;

import javax.persistence.Entity;

@Entity
public class Fish extends Animal{
    //Création de la table Fish avec ces Setter & Setter

    private FishLivEnv livingEnv;

    public Fish() {
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
