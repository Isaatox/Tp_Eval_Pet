package fr.sdv2023.EntityManager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    //Création de la table PetStore avec ces Setter & Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String managerName;
    @ManyToMany
    @JoinTable(name="petStore_product",
            joinColumns= @JoinColumn(name="id_petStore", referencedColumnName=
                    "id"),
            inverseJoinColumns= @JoinColumn(name="id_product", referencedColumnName="id")
    )
    private Set<Product> products = new HashSet<>();
    @OneToOne(mappedBy = "petStore")
    private Address address;
    @OneToMany(mappedBy="petStore")
    private Set<Animal> animals;
    public PetStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", address=" + address +
                ", animals=" + animals +
                '}';
    }
}
