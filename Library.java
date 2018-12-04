import java.util.*;
import java.awt.Frame;
import java.awt.FileDialog;
import java.io.*;
/**
 * The Library class stores LibraryItem objects in a collection and it is also
 * the class that represents the library itself in the University library system.
 * 
 * Display of the Library items is currently simulated by printing the details to the terminal window.
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public class Library
{
    //Map that stores LibraryItem objects, this has a String key to represent the unique item code.
    private Map<String, LibraryItem> itemsMap;
    //Map that stores LibraryUser objects, this has a String key to represent the unique userID
    private Map<String, LibraryUser> userMap;
    //Map that stores ItemReservation objects, this has a String key to represent the unique reservation number
    private Map<String, ItemReservation> itemReservationMap;
    //A diary that stores reservation dates
    private Diary diary;

    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        itemsMap = new HashMap<String, LibraryItem>();
        userMap = new HashMap<String, LibraryUser>();
        itemReservationMap = new HashMap<String, ItemReservation>();
        diary = new Diary();
    }
   
    /**
     * This method retrieves the itemReservationMap variable
     * 
     * @return this returns the itemReservationMap<code>HashMap</code>
     */
    public Map getReservationMap()
    {
        return itemReservationMap;
    }
    
    /**
     * This method retrieves a LibraryItem object from the userMap if there is an object that exists with the itemCode given as an argument.
     * 
     * @param itemCode this is the item code of the LibraryItem we want to retrieve from the itemsMap
     * @return the LibraryItem object if it exists in the itemsMap <code>HashMap</code> otherwise we return null here
     */
    public LibraryItem getItem(String itemCode)
    {
        if(itemsMap.containsKey(itemCode))
        {
            return itemsMap.get(itemCode);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * This method retrieves a LibraryUser object from the userMap if there is an object that exists with the userID given as an argument.
     * 
     * @param userID this is the user ID of the LibraryUser we want to retrieve from the userMap
     * @return the LibraryUser object if it exists in the userMap <code>HashMap</code> otherwise we return null here
     */
    public LibraryUser getUser(String userID)
    {
        if(userMap.containsKey(userID))
        {
            return userMap.get(userID);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * This method retrieves an itemReservation object from the itemReservationMap if there is an object that exists with the reservationNo given as an argument.
     * 
     * @param reservationNo this is the reservation number of the item reservation we want to retrieve from the itemReservationMap
     * @return the ItemReservation object if it exists in the itemReservationMap <code>HashMap</code> otherwise we return null here
     */
    public ItemReservation getItemReservation(String reservationNo)
    {
        if(itemReservationMap.containsKey(reservationNo))
        {
            return itemReservationMap.get(reservationNo);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * This method adds a LibraryItem object to the <code>HashMap</code> itemsMap
     * 
     * @param item the item we want to add to itemsMap
     */
    public void storeItem(LibraryItem item)
    {
        itemsMap.put(item.getItemCode(), item);
    }
    
    /**
     * This method adds a LibraryUser object to the <code>HashMap</code> userMap. It uses a while loop in a second if statment in order to ensure
     * that each userID is unique to that user. This is important because if two users had the same IDs, the HashMap would just overwrite the older user and therfore, it would 
     * no longer exist in the HashMap.
     * 
     * @param user the user we want to add to users (HashMap)
     */
    public void storeUser(LibraryUser user)
    {
        if(user.getUserID().equalsIgnoreCase("unknown"))   //if id is "unknown" or the one they have isn't uniqe, generate a new id
        {
            user.generateUserID("UNK", 6);
        }
        
        if(userMap.containsKey(user.getUserID()))
        {
            while(userMap.containsKey(user.getUserID()))    //While the user's ID here is the same as one in the HashMap, create a new one (create new UserID until it becomes unique)
            {
                user.generateUserID("UNK", 6);
            }
        }
        userMap.put(user.getUserID(), user);
    }
    
     /**
     * This method adds an ItemReservation object to the <code>HashMap</code> itemReservationMap
     * 
     * @param item the item we want to add to itemsMap
     */
    public void storeItemReservation(ItemReservation reservation)
    {
        itemReservationMap.put(reservation.getReservationNo(), reservation);
        diary.addReservation(reservation);
    }
    
    /**
     * If itemsList and users aren't empty, this method loops through every object in itemsList and users and will print out all of the details
     * of each LibraryItem and/or each LibraryUser. Dynamic method lookup will work at runtime in order to print out all the correct details.
     */
    public void printAllDetails()
    {
        if (itemsMap.isEmpty() && userMap.isEmpty())  //If there is nothing in the array list
            {
               System.out.println("Nothing in list, please read data from a file and then try printing details!");
            }
        else if(itemsMap.isEmpty())
            {
                System.out.println("Nothing in items list so only printing what is in user list:");
                for(LibraryUser user : userMap.values())
                {
                  user.printDetails();
                }
            }
        else if(userMap.isEmpty())
            {
                System.out.println("Nothing in user list so only printing what is in items list:");
                for(LibraryItem item : itemsMap.values())
                {
                 item.printDetails();
                }
            }
        else
           {
              for(LibraryItem item : itemsMap.values())
              {
                 item.printDetails();
              }
              
              for(LibraryUser user : userMap.values())
              {
                  user.printDetails();
              }
           }
    }
    
    /**
     * This method uses the FileDialog class to open a data file and read in the file name to 
     * the File class which represents the file we have selected. This file is then scanned
     * using the first Scanner object we have created and we pass a second Scanner object
     * to a particular class to extract the data depending on the type of data we are reading in.
     * 
     */
    public void readData()    
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD); //Tried setting frame parameter to null but recieved error so made variable null of type myFrame
        fileBox.setVisible(true);       //Makes dialog box appear
        
        String fileName = fileBox.getFile();    //Hands filename that we selected in dialog box to a string
        Scanner scanner = null; //Need to initialise this here so that it is accessible outside try statement
        File file = new File("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/" + fileName);     //File class mimics a data file as an object
        
        try{
            scanner = new Scanner(file);  //FileNotFoundException most likely to occur here if anywhere
         }
         catch(FileNotFoundException ex)
         {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
            System.err.println("Data file <" + fileName + "> does NOT exist!");
            System.err.println("Please Try Again");
            fileName = null;       //Unsuccessful read so reset file name
         }
         
        String typeOfData = null;
        Scanner dataScanner = null;     //Declared null here in order to have access to close at end of loop
        while (scanner.hasNext())
        {
           String lineOfText = scanner.nextLine().trim(); //trim method removes trailing or leading whitespace.
           if (lineOfText.startsWith("//"))
            {
                lineOfText = null;
            }
            else if(lineOfText.isEmpty())
            {
                lineOfText = null;
            }
            else if(lineOfText.trim().startsWith("["))
            {
                    //typeOfData = lineOfText.trim().substring(1, lineOfText.length() - 1);   //gets rid of the square brackets either side of the text
                                                                                              //removed as checks should occur below but nice idea so keep commented
                    if(lineOfText.equalsIgnoreCase("[CD Data]"))
                    {
                        typeOfData = "CD Data";
                    }
                    else if (lineOfText.equalsIgnoreCase("[DVD Data]"))
                    {
                        typeOfData = "DVD Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Book Data]"))
                    {
                        typeOfData = "Book Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Periodical Data]"))
                    {
                        typeOfData = "Periodical Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Library User Data]"))
                    {
                        typeOfData = "Library User Data";
                    }
                    else if (lineOfText.equalsIgnoreCase("[Item Reservation Data]"))
                    {
                        typeOfData = "Item Reservation Data";
                    }
                    else{
                        typeOfData = "Unknown Data";
                    }
            }
            else
            {                   
               dataScanner = new Scanner(lineOfText);
               dataScanner.useDelimiter("[ ]*(,)[ ]*");                  //Delimiter decides where we seperate the input of the lineOfText using regex
               LibraryItem libItem = null;                           //make libItem null here as we don't know dynamic type is yet
               LibraryUser user = null;
               ItemReservation itemReserve = null;
               if(typeOfData.equalsIgnoreCase("CD data"))
               {
                   libItem = new CD();
               }
               else if (typeOfData.equalsIgnoreCase("DVD data"))
               {
                   libItem = new DVD();
               }
               else if(typeOfData.equalsIgnoreCase("Book Data"))
               {
                   libItem = new Book();
               }
               else if(typeOfData.equalsIgnoreCase("Periodical Data"))
               {
                   libItem = new Periodical();
               } 
               else if(typeOfData.equalsIgnoreCase("Library User Data"))
               {
                   user = new LibraryUser();
               }
               else if(typeOfData.equalsIgnoreCase("Item Reservation Data"))
               {
                   itemReserve = new ItemReservation();
               }
               else if(typeOfData.equalsIgnoreCase("Unknown Data"))
               {
                   System.out.println("The type of data does not exist!");
                   libItem = null;
                   user = null;
               }
                if(libItem != null){ //Extract Data for dynamic type here
                   libItem.extractData(dataScanner);         //dataScanner passed to extractData method via dynamic method lookup
                   storeItem(libItem);
                } 
                else if(user != null)
                {
                    user.extractData(dataScanner);
                    storeUser(user); 
                }
                else if(itemReserve != null)
                {
                    itemReserve.extractData(dataScanner);
                    storeItemReservation(itemReserve);
                }
            }
        }
         scanner.close();
         dataScanner.close();

        // No EOFException as we know we will search entirety of scanner with while loop and .hasNext() method.
     }
    
     /**
     * This method is similar to the one above, excpet it has a parameter for which we can pass the filename.
     * This allows us to automate the process of reading a file during testing rather than opening a file dialog box
     * which slows down the testing process
     * 
     * @param filename the name of the file we want to examine during testing
     * 
     */
    public void testReadData(String fileName)    
    {
        Scanner scanner = null; //Need to initialise this here so that it is accessible outside try statement
        File file = new File(fileName);     //File class mimics a data file as an object
        

        try{
            scanner = new Scanner(file);  //FileNotFoundException most likely to occur here if anywhere
         }
         catch(FileNotFoundException ex)
         {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
            System.err.println("Data file <" + fileName + "> does NOT exist!");
            System.err.println("Please Try Again");
            fileName = null;       //Unsuccessful read so reset file name
         }
         
        String typeOfData = null;
        Scanner dataScanner = null;     //Declared null here in order to have access to close at end of loop
        while (scanner.hasNext())
        {
           String lineOfText = scanner.nextLine().trim(); //trim method removes trailing or leading whitespace.
           if (lineOfText.startsWith("//"))
            {
                lineOfText = null;
            }
            else if(lineOfText.isEmpty())
            {
                lineOfText = null;
            }
            else if(lineOfText.trim().startsWith("["))
            {
                    //typeOfData = lineOfText.trim().substring(1, lineOfText.length() - 1);   //gets rid of the square brackets either side of the text
                                                                                              //removed as checks should occur below but nice idea so keep commented
                    if(lineOfText.equalsIgnoreCase("[CD Data]"))
                    {
                        typeOfData = "CD Data";
                    }
                    else if (lineOfText.equalsIgnoreCase("[DVD Data]"))
                    {
                        typeOfData = "DVD Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Book Data]"))
                    {
                        typeOfData = "Book Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Periodical Data]"))
                    {
                        typeOfData = "Periodical Data";
                    }
                    else if(lineOfText.equalsIgnoreCase("[Library User Data]"))
                    {
                        typeOfData = "Library User Data";
                    }
                    else if (lineOfText.equalsIgnoreCase("[Item Reservation Data]"))
                    {
                        typeOfData = "Item Reservation Data";
                    }
                    else{
                        typeOfData = "Unknown Data";
                    }
            }
            else
            {                   
               dataScanner = new Scanner(lineOfText);
               dataScanner.useDelimiter("[ ]*(,)[ ]*");                  //Delimiter decides where we seperate the input of the lineOfText using regex
               LibraryItem libItem = null;                           //make libItem null here as we don't know dynamic type is yet
               LibraryUser user = null;
               ItemReservation itemReserve = null;
               if(typeOfData.equalsIgnoreCase("CD data"))
               {
                   libItem = new CD();
               }
               else if (typeOfData.equalsIgnoreCase("DVD data"))
               {
                   libItem = new DVD();
               }
               else if(typeOfData.equalsIgnoreCase("Book Data"))
               {
                   libItem = new Book();
               }
               else if(typeOfData.equalsIgnoreCase("Periodical Data"))
               {
                   libItem = new Periodical();
               } 
               else if(typeOfData.equalsIgnoreCase("Library User Data"))
               {
                   user = new LibraryUser();
               }
               else if(typeOfData.equalsIgnoreCase("Item Reservation Data"))
               {
                   itemReserve = new ItemReservation();
               }
               else if(typeOfData.equalsIgnoreCase("Unknown Data"))
               {
                   System.out.println("The type of data does not exist!");
                   libItem = null;
                   user = null;
               }
                if(libItem != null){ //Extract Data for dynamic type here
                   libItem.extractData(dataScanner);         //dataScanner passed to extractData method via dynamic method lookup
                   storeItem(libItem);
                } 
                else if(user != null)
                {
                    user.extractData(dataScanner);
                    storeUser(user); 
                }
                else if(itemReserve != null)
                {
                    itemReserve.extractData(dataScanner);
                    storeItemReservation(itemReserve);
                }
            }
        }
         scanner.close();
         dataScanner.close();

        // No EOFException as we know we will search entirety of scanner with while loop and .hasNext() method.
     }
    
    /**
     * This method takes a string as an argument which it uses as a file name to write to by passing it to a <code>PrintWriter</code> object's parameters. 
     * The actual writing of the data is carried out in the LibraryUser class as a matter of high cohesion. 
     * 
     * @param file is the name of the file we want to write to. If this file is not currently present, a new '.txt' file
     * with that name will be created.
     */
    public void testWriteUserData(String file)
    {
       String filename = "C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/" + file + ".txt";
       PrintWriter pWriter = null;         //Needed to access pWriter outside of try statement
        
       try
       {
           pWriter = new PrintWriter(filename);
       }
       catch(FileNotFoundException ex)
       {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
          System.err.println("Data file <" + filename + "> does NOT exist!");
          System.err.println("Please Try Again");
          filename = null;       //Unsuccessful read so reset file name
       }
        
       pWriter.println("// this is a comment, any lines that start with //");
       pWriter.println("// (and blank lines) should be ignored");
       pWriter.println();
       pWriter.println("// New user data");
       pWriter.println("// data is customerID, surname, firstName, otherInitials, title");
       pWriter.println();
       pWriter.println("[Library User Data]");
       for(LibraryUser user : userMap.values())
       {
           try
           {
               user.writeData(pWriter);
           }
           catch(FileNotFoundException ex) 
           {     System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
              System.err.println("Data file <" + filename + "> does NOT exist!");
              System.err.println("Please Try Again");
              filename = null;       //Unsuccessful read so reset file name
            }
       }
       pWriter.close();
    }
    
     /**
     * This method takes a string as an argument which it uses as a file name to write to by passing it to a <code>PrintWriter</code> object's parameters. 
     * The actual writing of the data is carried out in the LibraryUser class as a matter of high cohesion. 
     * 
     */
    public void writeUserData()
    {
       Frame myFrame = null;
       FileDialog fileBox = new FileDialog(myFrame, "Save As", FileDialog.SAVE);
       fileBox.setVisible(true);
       
       String file = fileBox.getFile();
       
       String filename = "C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/" + file + ".txt";
        
       PrintWriter pWriter = null;
       try
       {
            pWriter = new PrintWriter(filename);
       }
        catch(FileNotFoundException ex)
       {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
           System.err.println("Data file <" + filename + "> does NOT exist!");
           System.err.println("Please Try Again");
           filename = null;       //Unsuccessful read so reset file name
       }
       pWriter.println("// this is a comment, any lines that start with //");
       pWriter.println("// (and blank lines) should be ignored");
       pWriter.println();
       pWriter.println("// New user data");
       pWriter.println("// data is customerID, surname, firstName, otherInitials, title");
       pWriter.println();
       pWriter.println("[Library User Data]");
       pWriter.println("");
       for(LibraryUser user : userMap.values())
       {
        try
        {
           user.writeData(pWriter);
        }
        catch(FileNotFoundException ex) 
        {System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
         System.err.println("Data file <" + filename + "> does NOT exist!");
         System.err.println("Please Try Again");
         filename = null;       //Unsuccessful read so reset file name
        }
       }
       pWriter.close();
    }
    
     /**
     * This method takes a string as an argument which it uses as a file name to write to by passing it to a <code>PrintWriter</code> object's parameters. 
     * The actual writing of the data is carried out in the ItemReservation class as a matter of high cohesion. 
     * 
     */
    public void writeItemReservationData()
    {        
       Frame myFrame = null;
       FileDialog fileBox = new FileDialog(myFrame, "Save As", FileDialog.SAVE);
       fileBox.setVisible(true);
       
       String filename = fileBox.getFile();
       String file = "C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/" + filename + ".txt";
        
       PrintWriter pWriter = null;
       try
       {
            pWriter = new PrintWriter(filename);
       }
        catch(FileNotFoundException ex)
       {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
           System.err.println("Data file <" + filename + "> does NOT exist!");
           System.err.println("Please Try Again");
           filename = null;       //Unsuccessful read so reset file name
       }
       pWriter.println("// this is a comment, any lines that start with //");
       pWriter.println("// (and blank lines) should be ignored");
       pWriter.println();
       pWriter.println("// New item reservation data");
       pWriter.println("// data is reservationNo, itemCode, userID, startDate, title");
       pWriter.println();
       pWriter.println("[Item Reservation Data]");
       pWriter.println("");
       for(ItemReservation reservedItem : itemReservationMap.values())
       {
        try
        {
           reservedItem.writeData(pWriter);
        }
        catch(FileNotFoundException ex) 
        {System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
         System.err.println("Data file <" + filename + "> does NOT exist!");
         System.err.println("Please Try Again");
         filename = null;       //Unsuccessful read so reset file name
        }
       }
       pWriter.close();
    }
    
    /**
     * This method takes a string as an argument which it uses as a file name to write to by passing it to a <code>PrintWriter</code> object's parameters. 
     * The actual writing of the data is carried out in the ItemReservation class as a matter of high cohesion. 
     * 
     * @param file this is the name we want to give to the file we are writing to or the name of the file we want to append data to.
     * 
     */
    public void testWriteItemReservationData(String file)
    {  
       String filename = "C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/" + file + ".txt";
        
       PrintWriter pWriter = null;
       try
       {
            pWriter = new PrintWriter(filename);
       }
        catch(FileNotFoundException ex)
       {  System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
           System.err.println("Data file <" + filename + "> does NOT exist!");
           System.err.println("Please Try Again");
           filename = null;       //Unsuccessful read so reset file name
       }
       pWriter.println("// this is a comment, any lines that start with //");
       pWriter.println("// (and blank lines) should be ignored");
       pWriter.println();
       pWriter.println("// New item reservation data");
       pWriter.println("// data is reservationNo, itemCode, userID, startDate, title");
       pWriter.println();
       pWriter.println("[Item Reservation Data]");
       pWriter.println("");
       for(ItemReservation reservedItem : itemReservationMap.values())
       {
        try
        {
           reservedItem.writeData(pWriter);
        }
        catch(FileNotFoundException ex) 
        {System.err.println("\n\n*** FileNotFoundException ***");            //System.err prints to red error section of terminal
         System.err.println("Data file <" + filename + "> does NOT exist!");
         System.err.println("Please Try Again");
         filename = null;       //Unsuccessful read so reset file name
        }
       }
       pWriter.close();
    }
    
    /**
     * This method clears all objects in the itemList <code>HashMap</code>
     */
    public void clearItemMap()
    {
         itemsMap.clear();
    }
    
    /**
     * This method clears all objects in the users <code>HashMap</code>
     */
    public void clearUserMap()
    {
         userMap.clear();
    }
    
    /**
     * This method clears all objects in the item reservation <code>HashMap</code>
     */
    public void clearReservationMap()
    {
        itemReservationMap.clear();
    }
    
    /**
     * This method simulates making a reservation for an item in the library by firstly, checking if the the items and users actually exist in the 
     * appropriate <code>HashMap</code> and then creating an ItemReservation object and generating a reservation number for it.
     * 
     * @param userID this is the unique user ID of the user who is making the reservation
     * @param itemCode this is the unique item code of the item being reserved 
     * @param startDate this is the date, passed to the method as a string, that the reservation starts
     * @param noOfDays this is the length of the item reservation
     * 
     */
    public boolean makeItemReservation(String userID, String itemCode, String startDate, int noOfDays)
    {
        if(itemsMap.containsKey(itemCode) && userMap.containsKey(userID) && DateUtil.isValidDateString(startDate) && diary.getReservations(DateUtil.convertStringToDate(startDate)) == null) //Valid date and not reserved (checks diary)
       {
           ItemReservation itemReserve = new ItemReservation(null, userID, itemCode, startDate, noOfDays);
           itemReserve.generateReservationNo();
           storeItemReservation(itemReserve);
           return true;
       }
       else
       {
           System.out.println("Reservation is not valid, please use valid reservation information");
           return false;
       }
    }
    
   /**
    *  This method loops through each ItemReservation object, printing it's details. This method only prints details if item reservations actually exist within the Map;
    *  if not, we recieve an error message at the terminal notifying us that no item reservations are present.
    */
    public void printItemReservations()
    {
        if(itemReservationMap.isEmpty())
        {
            System.out.println("No item reservations currently exist");
        }
        else
        {
              for(ItemReservation reservation : itemReservationMap.values())
              {
                  reservation.printDetails();
              }
        }
    }
    
    /**
     * Using a start date and end date as arguments, this method prints out any reservations made within those dates, meaning they are stored as entries in the diary
     * as well as being stored in this class as objects in a Map.
     * 
     * @param startDate this is the start date of the reservation term a user wants to view
     * @param endDate this is the end date of the reservation term a user wants to view
     */
   public void printDiaryEntries(String startDate, String endDate)
    {
        diary.printEntries(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate));
    }
    
    /**
     * This method deletes any item reservation using the unique item reservation number given to it as an argument.
     * Entries are deleted from the diary and objects removed from the itemReservationMap.
     * 
     * @param itemReservationNo this is the item reservation number for the item reservation the user wants to delete
     */
   public void deleteItemReservation(String itemReservationNo)
   {
       if(itemReservationMap.containsKey(itemReservationNo))
       {
           diary.deleteReservation(itemReservationMap.get(itemReservationNo));
           itemReservationMap.remove(itemReservationNo);
       }
   }
}
        
      

