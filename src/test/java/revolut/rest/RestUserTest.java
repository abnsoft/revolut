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

import java.math.BigDecimal;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
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

import com.google.gson.Gson;

import revolut.Init;
import revolut.domain.User;

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

    @Ignore
    @Test
    public void userNotFound() {

        Response response = target( "/user/-1" ).request().get();

        Assert.assertTrue( "User info responce NOT FOUDN.",
                Response.Status.NOT_FOUND.getStatusCode() == response.getStatus() );
    }

    @Ignore
    @Test
    public void user1FoundStatus() {

        Response response = target( "/user/1" ).request( MediaType.APPLICATION_JSON ).get();

        LOG.debug( "Response={}", ReflectionToStringBuilder.toString( response ) );

        Assert.assertTrue( "Get User responce is OK.",
                Response.Status.OK.getStatusCode() == response.getStatus() );

    }

    @Ignore
    @Test
    public void user1FoundJSON() {

        String response = target( "/user/1" ).request( MediaType.APPLICATION_JSON ).get( String.class );

        LOG.debug( "Response={}", ReflectionToStringBuilder.toString( response ) );

        Gson gson = new Gson();

        User userJson = gson.fromJson( response, User.class );

        Assert.assertTrue( "Get User ID.", userJson.getId() == 1 );
        Assert.assertTrue( "Get User Name.", "Ivan1".equals( userJson.getName() ) );

        String money = userJson.getMoney().setScale( 4 ).toString();
        LOG.debug( "money={}", money );
        Assert.assertTrue( "Get User Money.", "1000.0000".equals( money ) );

    }

//    @Ignore
    @Test
    public void user2AddMoney() {

        String response = target( "/user/2" ).request( MediaType.APPLICATION_JSON ).get( String.class );

        LOG.debug( "user/2 Response={}", ReflectionToStringBuilder.toString( response ) );

        Gson gson = new Gson();

        User userJson = gson.fromJson( response, User.class );

        Assert.assertTrue( "Get User ID.", userJson.getId() == 2 );

        Assert.assertTrue( "Get User Name.", "Ivan2".equals( userJson.getName() ) );

        String money = userJson.getMoney().setScale( 4 ).toString();
        LOG.debug( "money={}", money );
        Assert.assertTrue( "Get User Money.", "2000.0000".equals( money ) );

        // add money 
        Form form = new Form();

        Response response2 = target( "/user/add/2/200" ) //
                .request() //
                .put( Entity.entity( form, MediaType.APPLICATION_FORM_URLENCODED_TYPE ) );

        LOG.debug( "PUT user Response={}", ReflectionToStringBuilder.toString( response2 ) );

        Assert.assertEquals( "PUT money. Status CODE.", Response.Status.OK.getStatusCode(),
                response2.getStatus() );

        // check out new value 
        response = target( "/user/2" ).request( MediaType.APPLICATION_JSON ).get( String.class );

        LOG.debug( "New Value : user/2 Response={}", ReflectionToStringBuilder.toString( response ) );

        gson = new Gson();
        userJson = gson.fromJson( response, User.class );

        Assert.assertTrue( "Get User ID.", userJson.getId() == 2 );

        money = userJson.getMoney().setScale( 4 ).toString();
        LOG.debug( "new money={}", money );
        Assert.assertTrue( "Get User Money.", "2200.0000".equals( money ) );

    }

}
