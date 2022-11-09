package facades;

import dtos.UserDTO;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public UserDTO getByPersonId(String id) throws EntityNotFoundException {
        EntityManager em = emf.createEntityManager();
        User p = em.find(User.class, id);
        if (p == null)
            throw new EntityNotFoundException("The Person entity with ID: " + id + " Was not found");
        return new UserDTO(p);
    }


    public UserDTO update(UserDTO userDTO) throws EntityNotFoundException {

        User user = userDTO.createEntity();
        EntityManager em = emf.createEntityManager();

        System.out.println(user);

        em.getTransaction().begin();
        User p = em.find(User.class, userDTO.getUser_name());
        user.setUserPass(p.getUserPass());

        em.merge(user);
        em.getTransaction().commit();
        em.close();


        return new UserDTO(user);
    }
}
