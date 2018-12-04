import java.util.*;
/**
 * The Book class represents a book as a subclass of PrintedItem and contains those variables
 * inherited from PrintedItem and also the 'author' and 'isbn' of the book.
 * 
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public class Book extends PrintedItem
{
    // instance variables - replace the example below with your own
    private String author;
    private String isbn;
  
    /**
     * Constructor for objects of class Book
     */
    public Book()
    {
        // initialise instance variables
    }
    
    /**
     * This method returns the name of the author of the book
     * 
     * @return the author of the Book object
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * This method returns the ISBN of the book
     * 
     * @return the ISBN of the Book object
     */
    public String getIsbn()
    {
        return isbn;
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
        String author = dataScanner.next();
        String isbn = dataScanner.next();
        super.extractData(dataScanner);             //saves on code duplication
                
        //Setting values for each individual field
        this.author = author;
        this.isbn = isbn;
    }
    
    /**
     * This method prints out the details shared between each Book item
     * 
     */     
    public void printDetails()
    {
        super.printDetails();
        System.out.println("The author is " + getAuthor());
        System.out.println("The ISBN " + getIsbn());
    }
    
    /**
     * This method overrides the .toString() method in the Object class and so, instead of printing out a memory location in hex when printing the actual
     * object to screen we will print what is returned below.
     * 
     * @return the text we want to appear when the object itself gets printed out.
     * 
     */
    public String toString()
    {
        return "The author of this book is " + author + "\nThe ISBN of this book is " + isbn;
    }
}
