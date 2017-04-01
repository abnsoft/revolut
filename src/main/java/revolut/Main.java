package revolut;

import java.io.IOException;

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
        h.setInitParameter( "jersey.config.server.provider.packages", "revolut.rest" );

        context.addServlet( h, "/*" );

        try {

            server.start();
            server.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
