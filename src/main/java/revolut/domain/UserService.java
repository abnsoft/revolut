/**
 * Copyright 2017. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNdev.com<br>
 * <br>
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-01<br>
 * <br>
 */
package revolut.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import revolut.dao.UserDAO;
import revolut.exception.DAOException;

/**
 * Service for {@link User}
 * 
 * @since 2017.04.01
 * @author annik
 */
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger( UserService.class );

    /**
     * Find {@link User} by userId.
     * 
     * @param userId
     * @return {@link User} or NULL.
     */
    public User find( Integer userId ) {

        UserDAO userDao = new UserDAO();
        User user = null;
        try {
            user = userDao.getUserById( userId );
        } catch (DAOException e) {
            LOG.error( "Read User[{}] failed.", userId );
        }

        return user;
    }

    /**
     * Persist user.
     * 
     * @param user
     */
    public void save( User user ) {

        UserDAO userDao = new UserDAO();
        try {
            userDao.persistUser( user );

        } catch (DAOException e) {
            LOG.error( "Persisting the User failed. {}", user );
        }
    }

    /**
     * Persist user.
     * 
     * @param user
     */
    public void merge( User user ) {

        UserDAO userDao = new UserDAO();
        try {
            userDao.mergeUser( user );

        } catch (DAOException e) {
            LOG.error( "Merge the User failed. {}", user );
        }
    }

}
