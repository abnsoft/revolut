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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import revolut.domain.User;
import revolut.domain.UserService;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
@Path( "/user" )
public class RestUser {

    @GET
    @Path( "{userId}" )
    @Produces( MediaType.APPLICATION_JSON )
    public User handleUser( @PathParam( "userId" ) Integer userId ) {

        UserService userService = new UserService();

        // find user with userId
        User user = userService.find( userId );
        if ( user != null ) {

        } else {
            throw new WebApplicationException( "User not found", Response.Status.NOT_FOUND );
        }
        return user;
    }
}
