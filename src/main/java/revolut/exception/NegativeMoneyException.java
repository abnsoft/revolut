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
 * When balance of user is negative.
 * 
 * @since 2017.04.02
 * @author annik
 */
public class NegativeMoneyException extends Exception {

    private static final long serialVersionUID = 1L;

    public NegativeMoneyException() {
        super();
    }

    public NegativeMoneyException( String msg ) {
        super( msg );
    }

    public NegativeMoneyException( Throwable throwable ) {
        super( throwable );
    }

    public NegativeMoneyException( String msg, Throwable throwable ) {
        super( msg, throwable );
    }

}
