import java.util.*;
/**
 * The PrintedItem class represents any items in the library that are printed such as periodicals and books.
 * Other than those that are inherited, the PrintedItem class contains the variables 'noOfPages' and 'publisher'as these
 * are shared only between printed items.
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public abstract class PrintedItem extends LibraryItem
{
    //This is the number of pages the printed item has
    private int noOfPages;
    //This stores the name of the publisher of the printed 
    private String publisher;

    /**
     * Constructor for objects of class PrintedItem
     */
    public PrintedItem()
    {
        super();
        noOfPages = 0;
        publisher = null;
    }
    
    /**
     * This method returns the number of pages of the printed item
     * 
     * @return the number of pages of the PrintedItem object
     */
    public int getNoOfPages()
    {
        return noOfPages;
    }
    
    /**
     * This method returns the publisher of the printed item
     * 
     * @return the name of the publisher of the PrintedItem object
     */
    public String getPublisher()
    {
        return publisher;
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
        int noOfPages = dataScanner.nextInt();
        String publisher = dataScanner.next().trim();
        super.extractData(dataScanner);             //saves on code duplication
                
        //Setting values for each individual field
        this.noOfPages = noOfPages;
        this.publisher = publisher;
    }
    
    /**
     * This method prints out the details of the PrintedItem object
     */     
    public void printDetails()
    {
        super.printDetails();
        System.out.println("This has " + getNoOfPages() + " pages");
        System.out.println("The publisher is " + getPublisher());
    }

}
