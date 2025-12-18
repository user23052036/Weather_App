import java.io.Serializable;

/**
 * A simple JavaBean class demonstrating the JavaBean design pattern.
 * This class follows JavaBean conventions with private fields, a no-arg constructor,
 * and public getter/setter methods. It implements Serializable to allow object persistence.
 * 
 * Purpose: Educational example showing proper JavaBean structure.
 * Expected Output: Used as a data container object in other classes.
 */
public class Bean implements Serializable
{
    // Private fields encapsulate the object's state
    private String name;
    private int id;
    private boolean isTrue;
    
    /**
     * No-argument constructor required by JavaBean specification.
     * Initializes a Bean object with default values.
     */
    public Bean(){}
    
    /**
     * Gets the name property.
     * 
     * @return the name as a String
     */
    public String getName()
    {return name;}
    
    /**
     * Gets the id property.
     * 
     * @return the id as an integer
     */
    public int getid()
    {return id;}
    
    /**
     * Gets the isTrue boolean property.
     * 
     * @return true or false based on the isTrue field
     */
    public boolean getisTrue()
    {return isTrue;}
    
    /**
     * Sets the name property.
     * 
     * @param name the name to set for this Bean
     */
    public void setName(String name)
    {this.name = name;}
    
    /**
     * Sets the id property.
     * 
     * @param id the id number to set for this Bean
     */
    public void setid(int id)
    {this.id = id;}
    
    /**
     * Sets the isTrue boolean property.
     * 
     * @param isTrue the boolean value to set
     */
    public void setisTrue(boolean isTrue)
    {this.isTrue = isTrue;}
}