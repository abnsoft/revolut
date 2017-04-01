package revolut.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * Status class indicates that service is fine.
 * 
 * @since 2017.04.01
 * @author annik
 */
@Path( "/status" )
public class RestStatus {

    @GET
    @Produces( "text/plain" )
    public String handleStatus() {

        return "OK";
    }

}
