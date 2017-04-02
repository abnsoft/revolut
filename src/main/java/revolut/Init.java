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
package revolut;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import revolut.dao.UserDAO;
import revolut.domain.User;

/**
 * 
 * @since 2017.04.02
 * @author annik
 */
public class Init {

    private static final Logger LOG = LoggerFactory.getLogger( Init.class );

    /**
     * Initialization class.
     */
    public static final void init() {

        try {
            UserDAO userDao = new UserDAO();

            // add user 1
            User u = new User();
//            u.setId( 1 );
            u.setMoney( new BigDecimal( "1000.0000" ) );
            u.setName( "Ivan1" );

            userDao.persistUser( u );

            // add user 2
            u = new User();
//            u.setId( 2 );
            u.setMoney( new BigDecimal( "2000.0000" ) );
            u.setName( "Ivan2" );

            userDao.persistUser( u );

            // add user 3
            u = new User();
//            u.setId( 3 );
            u.setMoney( new BigDecimal( "3000.0000" ) );
            u.setName( "Ivan3" );

            userDao.persistUser( u );

            // add user 4
            u = new User();
//            u.setId( 4 );
            u.setMoney( new BigDecimal( "4000.0000" ) );
            u.setName( "Ivan4" );

            userDao.persistUser( u );

        } catch (Exception e) {
            LOG.error( "Initializing Users failed.", e );
        }
    }

}
