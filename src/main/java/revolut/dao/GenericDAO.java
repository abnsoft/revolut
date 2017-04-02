/**
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-02<br>
 * <br>
 */
package revolut.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import revolut.exception.DAOException;

/**
 * Generic DAO class. <br>
 * This is a simple generic DAO. All it does is it allows for using its createEntityManager method from
 * extending classes.
 * 
 * @since 2017.04.02
 * @author annik
 */
public abstract class GenericDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Revolut" );

    /**
     * @return created {@link EntityManager}.
     */
    public EntityManager createEntityManager() {

        return emf.createEntityManager();
    }

    /**
     * Close {@link EntityManager}.
     */
    public static void closeEntityManager() {

        emf.close();
    }

    /**
     * @param em
     * @param e
     * @throws DAOException
     */
    public void transactionRollback( EntityManager em ) throws DAOException {

        if ( em != null ) {
            try {
                em.getTransaction().rollback();
                em.close();
            } catch (Exception e) {
                throw new DAOException( "Rollback and/or close EntityManager failed.", e );
            }

        } else {
            throw new DAOException( "EntityManager does not exists." );
        }
    }

}
