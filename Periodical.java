import java.util.*;
/**
 * The Periodical class represents a periodical item as a subclass of the PrintedItem class.
 * Along with it's inherited variables, the Periodical calss contains the 'publicationDate'
 * variable which is unique to every instance of the Periodical class.
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public class Periodical extends PrintedItem
{
    // instance variables - replace the example below with your own
    private String publicationDate;

    /**
     * Constructor for objects of class Periodical
     */
    public Periodical()
    {
        // initialise instance variables

    }

    /**
     * This method returns the publication date of the periodical item
     * 
     * @return the publication date of the periodical item
     */
    public String getPublicationDate()
    {
        return publicationDate;
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
        String publicationDate = dataScanner.next();            //scan publicationDate first and then the variables in the superclass
        super.extractData(dataScanner); 
                
        //Setting values for each individual field
        this.publicationDate = publicationDate;
    }
    
    /**
     * This method prints out the details shared between each periodical item
     * 
     */     
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The publication date is " + getPublicationDate());
    }
}
