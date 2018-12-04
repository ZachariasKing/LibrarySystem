import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * 'DVD' inherits from the AudioVisual class and models a DVD in the University library system
 * that inherits all the atributes of an AudioVisual object and it has a director
 * 
 * The class has two constructors in order to make testing an easier process.
 * 
 *
 * @author Zacharias King
 * @version 22/02/2018
 */
public class DVD extends AudioVisual
{
    //The director of the DVD content
    private String director;
    
    /**
     * Constructor for objects of class DVD used for testing with default values
     */
    public DVD()
    {
        super();
        this.director = null;
    }
    
    /**
     * This method simply returns the name of the DVD's director
     * 
     * @return the name of the director of the DVD content
     */
    public String getDirector()
    {
        return director;
    }
    
    /**
     * This method allows us to alter the name of the director of the DVD item
     * 
     * @param director the new name of the director we want to give to the DVD
     */
    public void setDirector(String director)
    {
        this.director = director;
    }
    
    /**
     * This method prints the details of the DVD item using the fields from the superclass
     * and the fields from this class
     * 
     * @Override
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The director of this DVD is " + getDirector() + ".");
    }
    
    /**
     * This method extracts data from a line of text given to the scanner being passed as an argument into
     * the method.
     * 
     * @param dataScanner is the <code>Scanner</code> used to extract each section of data with a certain 
     * delimiter
     * 
     * @Override
     */
    public void extractData(Scanner dataScanner)
    {   
        String director = dataScanner.next();
        super.extractData(dataScanner);     //saves on duplication of code
        
        this.setDirector(director);         //setting data here in global variable
    }
}
