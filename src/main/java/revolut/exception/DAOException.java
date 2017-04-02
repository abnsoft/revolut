/**
 * Copyright 2017. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNdev.com<br>
 * <br>
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-02<br>
 * <br>
 */
package revolut.exception;

/**
 * 
 * @since 2017.04.02
 * @author annik
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;

    public DAOException() {
        super();
    }

    public DAOException( String msg ) {
        super( msg );
    }

    public DAOException( Throwable throwable ) {
        super( throwable );
    }

    public DAOException( String msg, Throwable throwable ) {
        super( msg, throwable );
    }

}
