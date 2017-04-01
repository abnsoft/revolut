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

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
public class RestUserTest extends RevolutTest {

    @Test
    public void name() {

        String response = target( "/user/1" ).request().get( String.class );
        Assert.assertTrue( "User info responce.", "OK".equals( response ) );
    }
}
