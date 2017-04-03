/**
 * Copyright 2017. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNdev.com<br>
 * <br>
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-02<br>
 * <br>
 */
package revolut.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import revolut.domain.User;
import revolut.exception.DAOException;

/**
 * 
 * @since 2017.04.02
 * @author annik
 */
public class UserDAO extends GenericDAO {

    private static final Logger LOG = LoggerFactory.getLogger( UserDAO.class );

    /**
     * Make an {@link User}`s instance managed and persistent.
     * 
     * @param user
     * @throws DAOException
     */
    public void persistUser( User user ) throws DAOException {

        EntityManager em = createEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            em.persist( user );

            tx.commit();
            em.close();

        } catch (Exception e) {
            LOG.error( "Persist User failed. {}", ReflectionToStringBuilder.toString( user ), e );
            transactionRollback( em );
        }
    }

    /**
     * Make an {@link User}`s instance managed and persistent.
     * 
     * @param user
     * @throws DAOException
     */
    public void mergeUser( User user ) throws DAOException {

        EntityManager em = createEntityManager();

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            em.merge( user );

            tx.commit();
            em.close();

        } catch (Exception e) {
            LOG.error( "Persist User failed. {}", ReflectionToStringBuilder.toString( user ), e );
            transactionRollback( em );
        }
    }

    /**
     * Execute a SELECT query and return the query results as an untyped List.
     * 
     * @return the query results.
     * @throws DAOException
     */
    @SuppressWarnings( "unchecked" )
    public List<User> getAllUsers() throws DAOException {

        EntityManager em = createEntityManager();
        List<User> allUsers = null;

        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Query allUsersQuery = em.createQuery( "select u from User u " );

            allUsers = allUsersQuery.getResultList();

            tx.commit();
            em.close();

        } catch (Exception e) {
            LOG.error( "Getting all Users failed.", e );
            transactionRollback( em );
        }
        return allUsers;
    }

    /**
     * Execute a SELECT query where userId and returns the query result as {@link User}.
     * 
     * @param userId
     *            of {@link User}
     * @return founded {@link User}.
     * @throws DAOException
     */
    @SuppressWarnings( "unchecked" )
    public User getUserById( int userId ) throws DAOException {

        EntityManager em = createEntityManager();
        List<User> allUsers = null;

        try {

            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Query allUsersQuery = em.createQuery( "select u from User u where id = :userId " );
            allUsersQuery.setParameter( "userId", userId );

            allUsers = allUsersQuery.getResultList();

            tx.commit();
            em.close();

        } catch (Exception e) {
            LOG.error( "Getting User by id [{}] failed.", userId );
            transactionRollback( em );
        }

        return allUsers != null && allUsers.size() > 0 ? allUsers.iterator().next() : null;
    }

}
