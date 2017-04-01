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
package revolut.domain;

import java.math.BigDecimal;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
public class User {

    private Integer id;

    private String name;

    private BigDecimal money = new BigDecimal( "0.0" );

    /**
     * Getter.
     * 
     * @return the id
     */
    public Integer getId() {

        return id;
    }

    /**
     * Setter.
     * 
     * @param id
     *            the id to set
     */
    public void setId( Integer id ) {

        this.id = id;
    }

    /**
     * Getter.
     * 
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * Setter.
     * 
     * @param name
     *            the name to set
     */
    public void setName( String name ) {

        this.name = name;
    }

    /**
     * Getter.
     * 
     * @return the money
     */
    public BigDecimal getMoney() {

        return money;
    }

    /**
     * Setter.
     * 
     * @param money
     *            the money to set
     */
    public void setMoney( BigDecimal money ) {

        this.money = money;
    }

}
