package revolut;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class (RUN ME as APP).
 * 
 * @since 2017.04.01
 * @author annik
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger( Main.class );

    /**
     * Runner/main method.
     * 
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException {

        Server server = new Server( 8888 );
        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );

        context.setContextPath( "/" );
        server.setHandler( context );

        ServletHolder h = new ServletHolder( new ServletContainer() );
        h.setInitParameter( "jersey.config.server.provider.packages",
                "org.codehaus.jackson.jaxrs;revolut.rest" );
        h.setInitParameter( "jersey.api.json.POJOMappingFeature", "true" );

        context.addServlet( h, "/*" );

        try {
            Class.forName( "org.h2.Driver" );
            Connection conn =
                    DriverManager.getConnection( "jdbc:h2:mem:revolut;DB_CLOSE_DELAY=-1", "sa", "" );

            // initializing database.
            Init.init();

            // add application code here
            server.start();
            server.join();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
