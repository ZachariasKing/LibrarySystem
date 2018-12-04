import java.util.*;
/**
 * The LibraryItem class is the main superclass for any item in the library. This means that it stores all of the common
 * attributes of each item.
 * 
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public abstract class LibraryItem
{
    //The title of the audio visual object
    private String title;
    //The unique item code for each audio visual object. 
    private String itemCode;
    //The amount of times this item has been borrowed
    private int timesBorrowed;
    //By giving true or false, this indicates whether the item is on loan or not
    private boolean onLoan;
    //The cost of this item in pence
    private int cost;
    
    /**
     * Constructor for objects of class LibraryItem
     */
    public LibraryItem()
    {
        title = null;
        itemCode = null;
        timesBorrowed = 0;
        onLoan = false;
        cost = 0;
    }
    
    /**
     * This method returns the title of an LibraryItem
     * 
     * @return the title of the LibraryItem
     */
    public String getTitle()
    {
        return title;
    }
        
    /**
     * This method returns the item code for the item
     * 
     * @return the item code for the item
     */       
    public String getItemCode()
    {
        return itemCode;
    }
    
    /**
     * This method returns the cost of the LibraryItem in pence
     * 
     * @return the cost of the item in pence
     */
    public int getCost()
    {
        return cost;
    }
    
    /**
     * This method returns the loan status of the item (true or false)
     * 
     * @return loan status of the item
     */    
    public boolean getOnLoan()
    {
        return onLoan;
    }
    
    /**
     * This method returns the amount of times the LibraryItem has been borrowed
     * 
     * @return the amount of times the LibraryItem has been borrowed
     */    
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }
    
    /**
     * This method allows us to alter the title of a Library Item
     * 
     * @param newTitle is the new title given to the LibraryItem
     */     
    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }
    
    /**
     * This method allows us to alter the value of an LibraryItem's item code
     * 
     * @param itemCode the new item code we want to assign to an item
     */          
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }
    
    /**
     * This method allows us to alter the cost of an item in pence
     * 
     * @param cost the new cost assigned to an item in pence
     */          
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
    /**
     * This method allows us to alter the status of loan of the item
     * 
     * @param onLoan the new status declaring whether an item is on loan or not
     */     
    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }
    
    /**
     * This method allows us to alter the amount of times a LibraryItem has been borrowed
     * 
     * @param timesBorrowed the new amount of times the LibraryItem item has been borrowed
     */     
    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed = timesBorrowed;
    }
    
    /**
     * This method models the item being borrowed and so increments the amount of times one has been borrowed
     * As the item is being borrowed, it will be on loan also, so we set the value of onLoan to true
     */     
    public void borrowItem()
    {
        timesBorrowed++;
        onLoan = true;
    }
    
    /**
     * This method extracts data from a line of text given to the scanner being passed as an argument into
     * the method. In particular, for refactoring purposes, this class extracts the shared attributes of all LibraryItem items
     * 
     * @param dataScanner is the <code>Scanner</code> used to extract each section of data with a certain 
     * delimiter
     */
    public void extractData(Scanner dataScanner)
    {
        String title = dataScanner.next();
        String itemCode = dataScanner.next();
        int price = dataScanner.nextInt();
        int timesBorrowed = dataScanner.nextInt();
        boolean onLoan = dataScanner.nextBoolean();
        
        this.setTitle(title);
        this.setItemCode(itemCode);
        this.setCost(price);
        this.onLoan = onLoan;
        this.timesBorrowed = timesBorrowed;
        
    }
    
    /**
     * This method prints out the details shared between each LibraryItem, using an if statement
     * to check whether the item is on loan or not
     * 
     */     
    public void printDetails()
    {
        System.out.println(); //Details preceded by blank line to make text easier to read on output
        System.out.println("Title: " + getTitle());    
        System.out.println("Item Code: " + getItemCode()); 
        System.out.println("This has been borrowed " + getTimesBorrowed() + " time(s).");
        if(onLoan == false)
        {
            System.out.println("This is not currently on loan.");
        }
        else
        {
            System.out.println("This is currently on loan.");
        }
        System.out.println("This costs: " + getCost() + "p");
    }
}
