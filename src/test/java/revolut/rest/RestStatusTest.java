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
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
public class RestStatusTest extends JerseyTest {

    @Override
    protected Application configure() {

        return new ResourceConfig( RestStatus.class );
    }

    @Test
    public void name() {

        String response = target( "/status" ).request().get( String.class );
        Assert.assertTrue( "Status responce.", "OK".equals( response ) );
    }
}
