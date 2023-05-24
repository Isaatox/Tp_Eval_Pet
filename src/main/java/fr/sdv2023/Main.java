package fr.sdv2023;

import fr.sdv2023.EntityManager.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialiser la connection à la BDD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(em.isOpen()){
            System.out.println("Connecté");

            // Ajoutez différentes données dans chaque table
            Product product1 = new Product();
            product1.setNom("croquette");
            product1.setLabel("Croquette");
            product1.setType(ProdType.FOOD);
            product1.setPrice(10.0);

            Product product2 = new Product();
            product2.setNom("collier");
            product2.setLabel("Collier");
            product2.setType(ProdType.ACCESSORY);
            product2.setPrice(20.0);

            Product product3 = new Product();
            product3.setNom("litière");
            product3.setLabel("Litière");
            product3.setType(ProdType.CLEANING);
            product3.setPrice(30.0);

            em.persist(product1);
            em.persist(product2);
            em.persist(product3);

            PetStore petStore1 = new PetStore();
            petStore1.setNom("Cat&Co");
            petStore1.setManagerName("Jerry");

            PetStore petStore2 = new PetStore();
            petStore2.setNom("Dog&Co");
            petStore2.setManagerName("Sam");

            PetStore petStore3 = new PetStore();
            petStore3.setNom("Pig&Co");
            petStore3.setManagerName("Clover");

            em.persist(petStore1);
            em.persist(petStore2);
            em.persist(petStore3);

            Address address1 = new Address();
            address1.setNumber("52");
            address1.setStreet("Rue de chez moi");
            address1.setCity("Sofia");
            address1.setZipCode("1000");
            address1.setPetStore(petStore1);

            Address address2 = new Address();
            address2.setNumber("85");
            address2.setStreet("Rue de chez elle");
            address2.setCity("Florence");
            address2.setZipCode("50121");
            address2.setPetStore(petStore2);

            Address address3 = new Address();
            address3.setNumber("23");
            address3.setStreet("Rue de chez lui");
            address3.setCity("New York");
            address3.setZipCode("10010");
            address3.setPetStore(petStore3);

            em.persist(address1);
            em.persist(address2);
            em.persist(address3);

            Fish poisson1 = new Fish();
            poisson1.setLivingEnv(FishLivEnv.FRESH_WATER);
            poisson1.setBirth(LocalDate.now());
            poisson1.setCouleur("Rouge");
            poisson1.setPetStore(petStore1);

            Fish poisson2 = new Fish();
            poisson2.setLivingEnv(FishLivEnv.SEA_WATER);
            poisson2.setBirth(LocalDate.now());
            poisson2.setCouleur("Bleu");
            poisson2.setPetStore(petStore2);

            Fish poisson3 = new Fish();
            poisson3.setLivingEnv(FishLivEnv.SEA_WATER);
            poisson3.setBirth(LocalDate.now());
            poisson3.setCouleur("Marron");
            poisson3.setPetStore(petStore3);

            em.persist(poisson1);
            em.persist(poisson2);
            em.persist(poisson3);

            Cat chat1 = new Cat();
            chat1.setChipId("123456789");
            chat1.setBirth(LocalDate.now());
            chat1.setCouleur("Roux");
            chat1.setPetStore(petStore1);

            Cat chat2 = new Cat();
            chat2.setChipId("578474865");
            chat2.setBirth(LocalDate.now());
            chat2.setCouleur("Blanc");
            chat2.setPetStore(petStore2);

            Cat chat3 = new Cat();
            chat3.setChipId("1248756248");
            chat3.setBirth(LocalDate.now());
            chat3.setCouleur("Rouge");
            chat3.setPetStore(petStore3);

            em.persist(chat1);
            em.persist(chat2);
            em.persist(chat3);

            petStore1.getProducts().add(product1);
            petStore1.getProducts().add(product2);

            petStore2.getProducts().add(product3);
            petStore2.getProducts().add(product1);

            petStore3.getProducts().add(product2);
            petStore3.getProducts().add(product3);

            //Selectionner les animaux d'un Pet Store
            String query = "SELECT a FROM Animal a JOIN a.petStore p WHERE p.id = :IdPetStore";
            List<Animal> animals = em.createQuery(query, Animal.class)
                    .setParameter("IdPetStore", 1L)
                    .getResultList();

            //Différencier Chat ou Poisson
            for (Animal animal : animals) {
                if (animal instanceof Cat) {
                    Cat cat = (Cat) animal;
                    System.out.println("Chat - Couleur : " + cat.getCouleur() + ", Date de naissance : " + cat.getBirth());
                } else if (animal instanceof Fish) {
                    Fish fish = (Fish) animal;
                    System.out.println("Poisson - Environnement de vie : " + fish.getLivingEnv() + ", Date de naissance : " + fish.getBirth());
                }
            }

            em.getTransaction().commit();
        } else {
            System.out.println("non connecté");
        }
        //Fermer la connection à la BDD
        em.close();
        emf.close();
    }
}