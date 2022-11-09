import entities.Champion;
import entities.User;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main2 {

    public static void main(String[] args) {

        User user = new User("ina", "taco");
        Champion champion1 = new Champion("Kayle", "10");
        Champion champion2 = new Champion("Gwen", "887");
        user.getChampions().add(champion1);
        user.getChampions().add(champion2);


        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();



        try {
            em.getTransaction().begin();
            em.persist(user);

            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }


}
