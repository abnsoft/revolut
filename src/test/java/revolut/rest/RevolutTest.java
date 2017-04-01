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
package revolut.rest;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

/**
 * Class contains methods which are used in every test.
 * 
 * @since 2017.04.01
 * @author annik
 */
public abstract class RevolutTest extends JerseyTest {

    @Override
    protected Application configure() {

        return new ResourceConfig( RestStatus.class );
    }

}
