import java.util.*;
import java.io.*;
/**
 * The LibraryUser class represents the users of a library in the sense that it has a 'userID', a 'surname',
 * a 'firstName', 'otherInitials' and a 'title'.
 * 
 * @author Zacharias King
 * @version 14/04/2018
 */
public class LibraryUser
{
    //The user ID given to the user
    private String userID;
    //The user's surname
    private String surname;
    //The user's firstName
    private String firstName;
    //The user's otherInitials
    private String otherInitials;
    //The user's title e.g. 'Mr' or 'Mrs'
    private String title;

    /**
     * Constructor for objects of class LibraryUser
     */
    public LibraryUser()
    {
       userID = null;
       surname = null;
       firstName = null;
       otherInitials = null;
       title = null;
    }
    
    /**
     * This method returns the userID of the user
     * 
     * @return the userID of the LibraryUser object
     */
    public String getUserID()
    {
        return userID;
    }
    
    /**
     * This method returns the surname of the user
     * 
     * @return the surname of the LibraryUser object
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * This method returns the firstName of the user
     * 
     * @return the firstName of the LibraryUser object
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * This method returns the otherInitials of the user
     * 
     * @return the otherInitials of the LibraryUser object
     */
    public String getOtherInitials()
    {
        return otherInitials;
    }
    
    /**
     * This method returns the title of the user
     * 
     * @return the title of the LibraryUser object
     */
        public String getTitle()
    {
        return title;
    }
    
    /**
     * This method allows to set a new surname for a LibraryUser
     * 
     * @param surname this is the new surname we want to give the the LibraryUser object
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    /**
     * This method allows to set a new first name for a LibraryUser
     * 
     * @param firstName this is the new first name we want to give the the LibraryUser object
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    
    /**
     * This method allows to set a new userID for a LibraryUser
     * 
     * @param userID this is the new userID we want to give the the LibraryUser object
     */
    public void setUserID(String userID)
    {
        this.userID = userID;
    }    
    
    /**
     * This method prints out the details of the LibraryUser item based on the data stored within 
     * the variables.
     * 
     */  
    public void printDetails()
    {
        System.out.println();
        System.out.println("The user ID for this user is " + userID);
        System.out.println("The user's name is " + surname + " " + firstName);
        System.out.println("The user's other initials are " + otherInitials);
    }
    
    /**
     * This method extracts data from a line of text given to the scanner being passed as an argument into
     * the method. In particular, for refactoring purposes, this class extracts the shared attributes of all LibraryUser items
     * 
     * @param dataScanner is the <code>Scanner</code> used to extract each section of data with a certain delimiter
     */
    public void extractData(Scanner dataScanner)
    {
        String customerID = dataScanner.next();
        String surname = dataScanner.next();
        String firstName = dataScanner.next();
        String otherInitials = dataScanner.next();
        String title = dataScanner.next();
        
        this.userID = customerID;
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    /**
     * This method firstly creates a 'lineOfOutput' using the data we have stored in the insance variables and then,
     * using a <code>PrintWriter</code> object, we write it to the file name it was given in Library
     * 
     * @param pWriter is the <codePrintWriter</code> that is already linked to a file to write to.
     * @throws FileNotFoundException
     */
    public void writeData(PrintWriter pWriter) throws FileNotFoundException
    {
        String lineOfOutput = userID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title;
        pWriter.println(lineOfOutput);; //FileNotFoundException most likely to occur here if anywhere. This gets rid of the need to throw anymore as it is actually dealt with.
    }
   
    /**
     * This method takes a prefix and a length to generate a userID and assign it to the LibraryUser object
     * 
     * @param prefix this is the prefix used in the userID before the number
     * @param length this is the length of numbers we want after the prefix in the userID
     */
    public void generateUserID(String prefix, int length)
    {
        int counter = 0;
        int sum = 0;
        for(int i = 1; counter < length; counter ++)        //Multiply by 10 for the length of numbers we want in the ID in order to get a range for the random generator (from 0 <= i < n)
        {
            i *= 10;
            sum = i;
        }
        int range = sum;       
        
        //Date date = new Date();
        Random randGen = new Random(System.currentTimeMillis());       //seed here is based on time on milliseconds since 1st January 1970 (unlikely to get same seed unless at same time)
        userID = prefix + (randGen.nextInt(range));                 //Finally this assigns the two joined values to the userID variable
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
        return "The user ID for this user is " + userID + "\nThe user's name is " + firstName + " " + surname + "\nThe user's other initials are " + otherInitials;
    }
  
}
