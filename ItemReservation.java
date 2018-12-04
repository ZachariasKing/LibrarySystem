import java.util.*;
import java.awt.Frame;
import java.awt.FileDialog;
import java.io.*;
/**
 * ItemReservation models an item reservation in the sense that it stores a unique reservation number, item code for the reserved item,
 * userID of the borrowing user, start date of the reservation lasts.
 *
 * @author Zacharias King
 * @version 26/04/2018
 */
public class ItemReservation
{
    //unique reservation number for the reservation
    private String reservationNo;
    //itemCode of the item being borrowed/reserved
    private String itemCode;
    //userID of the user borrowing the item
    private String userID;
    //start date of the reservation
    private Date startDate;
    //number of days the reservation will be held
    private int noOfDays;
    //unique (class variable) reservation number keeping track of numbers used so far. (the end number used in the reservationNo String)
    private static int latestResNumber;

    /**
     * Constructor for objects of class ItemReservation
     */
    public ItemReservation()
    {
        //Empty (Null values default)
    }

    /**
     * Constructor for objects of class ItemReservation
     */
    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }

    /**
     * This accessor method returns the reservation number for the ItemReservation
     * 
     * @return This returns the reservation number
     */
    public String getReservationNo()
    {
        return reservationNo;
    }

    /**
     * This accessor method returns the item code for the ItemReservation
     * 
     * @return this returns the itemCode of the ItemReservation object
     */
    public String getItemCode()
    {
        return itemCode;
    }

    /**
     * This accessor method returns the user ID for the ItemReservation
     * 
     * @return this returns the userID of the ItemReservation object
     */
    public String getUserID()
    {
        return userID;
    }

    /**
     * This accessor method returns the start datefor the ItemReservation
     * 
     * @return this returns the startDate of the ItemReservation object
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     * This accessor method returns the number of days of the reservation
     * 
     * @return this returns the length of the ItemReservation in number of days
     */
    public int getNoOfDays()
    {
        return noOfDays;
    }

    public boolean isLatestReservationNoPresent()
    {
        File file = new File("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/latestNumber.txt");
        Scanner latestNoScan = null;
        try
        {
            latestNoScan = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
            System.err.println("Data file <" + file.getName() + "> does NOT exist!");
            System.err.println("Please Try Again");
        }

        if(latestNoScan.nextInt() > 0)
        { 
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method generates a unique reservation number for each item reservation. It uses the HashMap's current size in order to determine a new reservation number.
     * So, for example, if the itemReservationMap had 2 key/value pairs already, the number generated would pad however many zeros and add +1 of the size (e.g. 000003)
     * 
     * @param reservationMap this is the Map we want to use to determine its size and base a unique reservation number off of this
     * 
     */
    public void generateReservationNo()  
    {
        File file = new File("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/latestNumber.txt");
        Scanner latestNoScan = null;
        try
        {
            latestNoScan = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
            System.err.println("Data file <" + file.getName() + "> does NOT exist!");
            System.err.println("Please Try Again");
        }
        
        if(latestNoScan.hasNext())  ///first checks to see if the file actually contains any data
        {
            int numberInFile = latestNoScan.nextInt();      //if file contains data, we assign the number inside to a local variable in order to check that it is worth 
            latestNoScan.close();
            
               if(numberInFile > 0 && latestResNumber < numberInFile)    //If there is actually a number in the text file, use it as the next reservationNumber    
               {
                    latestResNumber = numberInFile + 1;     //+1 to show that this is a new entry since the one entered into the file
               }
               else
               {
                   writeLatestResNumber();          //If the number in the file is less than the current res number, we overwrite the number to say that the current latestResNo is the most recent
               }
        }

        
        if (latestResNumber < 10)
        {
            reservationNo = "00000" + (latestResNumber + 1);
            latestResNumber++;
        }
        else if(latestResNumber >= 10  && latestResNumber < 100)
        {
            reservationNo = "0000" + (latestResNumber + 1);
            latestResNumber++;
        }
        else if(latestResNumber >= 100  && latestResNumber < 1000)
        {
            reservationNo = "000" + (latestResNumber + 1);
            latestResNumber++;
        }
        else if(latestResNumber >= 1000  && latestResNumber < 10000)
        {
            reservationNo = "00" + (latestResNumber + 1);
            latestResNumber++;
        }
        else if(latestResNumber >= 10000  && latestResNumber < 100000)
        {
            reservationNo = "0" + (latestResNumber + 1);
            latestResNumber++;
        }
        else if(latestResNumber >= 100000  && latestResNumber < 1000000)
        {
            reservationNo = "" + (latestResNumber + 1);
            latestResNumber++;
        }

    }
    
    /**
     * This method writes the latestResNo to a file that we can then use when generating a new item reservation number for the next 
     * item reservation, should we happen to terminate our library system.
     */
    public static void writeLatestResNumber()
    {
        PrintWriter pWriter = null;
        try
        {
            pWriter = new PrintWriter("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/latestNumber.txt");
        }
        catch(FileNotFoundException ex)
        {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
            System.err.println("Data file <" + "latestNumber.txt" + "> does NOT exist!");
            System.err.println("Please Try Again");
        }

        pWriter.print(latestResNumber);
        pWriter.close();
    }

    /**
     * This method prints out the details for an ItemReservation instance
     */
    public void printDetails()
    {
        System.out.println();
        System.out.println("Reservation Number: " + reservationNo);
        System.out.println("Item Code of borrowed item: " + itemCode);
        System.out.println("User ID of borrowing user: " + userID);
        System.out.println("Reservation start date: " + DateUtil.convertDateToShortString(startDate));
        System.out.println("Reservation term length: " + noOfDays);
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
        String lineOfOutput = reservationNo + ", " + itemCode + ", " + userID + ", " +  DateUtil.convertDateToShortString(startDate) + ", " + noOfDays;
        pWriter.println(lineOfOutput);; //FileNotFoundException most likely to occur here if anywhere. This gets rid of the need to throw anymore as it is actually dealt with.
    }

    /**
     * This method extracts data from a line of text given to the scanner being passed as an argument into
     * the method.
     * 
     * @param dataScanner is the <code>Scanner</code> used to extract each piece of data with a certain 
     * delimiter (here it is "[ ]*(,)[ ]*")
     */
    public void extractData(Scanner dataScanner)
    {
        String reservationNo = dataScanner.next();
        String itemCode = dataScanner.next();
        String userID = dataScanner.next();
        String startDate = dataScanner.next();
        int noOfDays = dataScanner.nextInt();

        this.reservationNo = reservationNo;
        this.itemCode = itemCode;
        this.userID = userID;
        this.startDate = DateUtil.convertStringToDate(startDate);   //Need to convert string input here to actual Date object
        this.noOfDays = noOfDays;
    }
    
    /**
     * This method overrides the 'toString()' method in the Object class and, instead of just printing the hexidecimal value of the object in memory,
     * we can use this to print out useful information about the object when it is printed.
     * 
     * @return a String of useful information about the specific ItemReservation object
     * 
     * @override 
     */
    public String toString()
    {
        return "Reservation Number: " + reservationNo + " " + "Item Code of borrowed item: " + itemCode + " " + "User ID of borrowing user: " 
        + userID + " " + "Reservation start date: " + DateUtil.convertDateToShortString(startDate) + " " + 
        "Reservation term length: " + noOfDays;
    }
}
