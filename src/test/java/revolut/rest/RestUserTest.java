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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import revolut.Init;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
public class RestUserTest extends JerseyTest {

    private static final Logger LOG = LoggerFactory.getLogger( RestUserTest.class );

    @Before
    public void init() {

        Init.init();
    }

    @Override
    protected Application configure() {

        return new ResourceConfig( RestUser.class );
    }

    @Test
    @Ignore
    public void userNotFound() {

        Response response = target( "/user/-1" ).request().get();

        Assert.assertTrue( "User info responce NOT FOUDN.",
                Response.Status.NOT_FOUND.getStatusCode() == response.getStatus() );
    }

    @Test
    public void user1Found() {

        Response response = target( "/user/1" ).request( MediaType.APPLICATION_JSON ).get();

        LOG.debug( "Response={}", ReflectionToStringBuilder.toString( response ) );

        Assert.assertTrue( "Get User responce is OK.",
                Response.Status.OK.getStatusCode() == response.getStatus() );

//        Assert.assertTrue( "Get User responce is OK.",
//                Response.Status.OK.getStatusCode() == response.getStatus() );
    }

}
