/**
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-01<br>
 * <br>
 */
package revolut.rest;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import revolut.domain.User;
import revolut.domain.UserService;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
@Path( "/user" )
public class RestUser {

    private static final Logger LOG = LoggerFactory.getLogger( RestUser.class );

    /**
     * @param userId
     * @return {@link User} as JSON.
     */
    @GET
    @Path( "/{userId}" )
    @Produces( MediaType.APPLICATION_JSON )
    public User handleUser( @PathParam( "userId" ) Integer userId ) {

        UserService userService = new UserService();

        // find user with userId
        User user = userService.find( userId );
        if ( user != null ) {
            LOG.debug( "Found User={}", user );

        } else {
            throw new WebApplicationException( "User not found", Response.Status.NOT_FOUND );
        }
        return user;
    }

    /**
     * Add money to the userId
     * 
     * @param userId
     * @return {@link User}
     */
    @PUT
    @Path( "/add/{userId}/{money}" )
    public Response handlePutUser( String body, @PathParam( "userId" ) Integer userId,
            @PathParam( "money" ) String money ) {

        UserService userService = new UserService();

        // find user with userId
        User user = userService.find( userId );

        if ( user != null && money != null ) {
            LOG.debug( "PUT Add money[{}] for User={}", money, user );

            //
            user.setMoney( user.getMoney().add( new BigDecimal( money ) ) );
            LOG.debug( "User[{}], New Money[{}]", userId, user.getMoney() );

            userService.merge( user );

        } else {
            throw new WebApplicationException( "User not found", Response.Status.NOT_FOUND );
        }

        String data = "Money added";
        return Response.status( 200 ).entity( data ).build();
    }

    /**
     * Move Money from user to other user.
     * 
     * @param body
     * @param fromUuserId
     * @param money
     * @param toUserId
     * 
     * @return {@link User}
     */
    @PUT
    @Path( "/move/{fromUserId}/{howMuchMoney}/{toUserId}" )
    public Response handleMoveUser( String body, @PathParam( "fromUserId" ) Integer fromUserId,
            @PathParam( "howMuchMoney" ) String money, @PathParam( "toUserId" ) Integer toUserId ) {

        UserService userService = new UserService();

        // find user with userId
        User fromUser = userService.find( fromUserId );
        User toUser = userService.find( toUserId );

        if ( fromUser != null && money != null && toUserId != null ) {
            LOG.debug( "Move money[{}] from User[{}] to User[{}]", money, fromUser, toUser );

            // need TRANSACTION here 
            userService.moveMoney( fromUser, toUser, money );

            LOG.debug( "{}", fromUser );
            LOG.debug( "{}", toUser );

        } else {
            throw new WebApplicationException( "MOVE MONEY: Users or money not found",
                    Response.Status.NOT_FOUND );
        }

        String data = "Money moved";
        return Response.status( 200 ).entity( data ).build();
    }

}
