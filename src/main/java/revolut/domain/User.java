/**
 * Project ..... RestTest<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.Java@GMail.com<br>
 * Created ..... 2017-04-01<br>
 * <br>
 */
package revolut.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @since 2017.04.01
 * @author annik
 */
@XmlRootElement
@Entity
@Table( name = "user" )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal money = new BigDecimal( "0.0000" ).setScale( 4 );

    /**
     * Contructor. Needs for JAXB.
     */
    public User() {
    }

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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append( "User [id=" ).append( id );
        builder.append( ", name=" ).append( name );
        builder.append( ", money=" ).append( money );
        builder.append( "]" );
        return builder.toString();
    }

}
