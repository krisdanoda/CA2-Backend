import entities.Champion;
import entities.Role;
import entities.User;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main3 {

    public static void main(String[] args) {

        User user = new User("ame", "dog");
        Champion champion1 = new Champion("Kayle", 10L);
        Champion champion2 = new Champion("Gwen", 887L);

        Role userRole = new Role("user");
        user.addChampion(champion1);
        user.addChampion(champion2);


        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();



        try {
            em.getTransaction().begin();
            user.addRole(userRole);
            em.persist(user);

            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }


}
