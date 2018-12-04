import java.io.*;
import java.util.*;
/**
 * 'Test' models how a representation of how the user would go through the library system step by step.
 *
 * @author Zacharias King
 * @version 23/02/2018
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test() throws Exception
    {
        //Part 1, Step 1 (Object Creation and inheritance) This step requires us to ensure that the instance variables given to the 
        //superclass (AudioVisual) are successfully carried down to its subclasses and all details print out, including all of the 
        //shared attributes in the superclass and the unique variables to CD or DVD. With the addition of the 'Library' class, we 
        //also test to see if these objects are successfully stored in the itemsList ArrayList.
        
        CD testCD = new CD(); 
        //testCD.printDetails();     
        
        DVD testDVD = new DVD();
        //testDVD.printDetails();
        
        CD testCD2 = new CD();                    //Creating a further two items to give us more
        DVD testDVD2 = new DVD();                 //to add to the list

        Library testLibrary = new Library();
        
        //testLibrary.printAllDetails();          //This ensures the we get an error message with nothing yet in the ArrayList to print
        
        testLibrary.storeItem(testCD);
        testLibrary.storeItem(testDVD);
        testLibrary.storeItem(testCD2);
        testLibrary.storeItem(testDVD2);
        
        //testLibrary.printAllDetails();          //Checks to make sure we have stored 4 AudioVisual items in the ArrayList
        
        //Part 1, Step 2 (Reading Input from a file, extracting 'real' data and using this to add to an <code>ArrayList</code>) 
        //We have used two Scanner objects to both read lines from a file and break up these lines into 'real data', 
        //constructing objects corresponding to this data and adding them to 'itemsList' in the Library class.
        
        testLibrary.clearItemMap();        //Clear the item list so we can easily see if we have read data in
        //testLibrary.printAllDetails();
                                          
        //testLibrary.testReadData("cd_data.txt");      //For testing reasons, this will read the data faster via a filename given as an argument (doesn't work now as methods have changed the way 
                                                        // data is read)
        
        //testLibrary.printAllDetails();      //Using 'printAllDetails()', we can verify that we have read and broken down the data
                                            //successfully with 11 new objects inserted into 'itemsList'
        
           
        //Part 2, Step 1(Refactoring CD and DVD classes to extract data as part of their own responsibility and not the Library class's) 
        //Previously we have used two scanner objects in one loop inside of the library class to extract data, but now each AudioVisual item has their own
        //extract method and we will test these here
        
        //testLibrary.clearItemList();
        
        //testLibrary.testReadData("cd_data.txt");                 //Inside the readData() method is the extract method for each class, depending on the type of data being read
        //testLibrary.printAllDetails();          //We print details here to ensure we have read all the data successfully
        
        //testLibrary.clearItemList();
        
        //Part 2, Step 2 (Reading from a file that contains both CD and DVD data) 
        //We will now ensure that, using the flags in the text files, we can store the data accurately and print it out. This not only tests the refactoring of CD, DVD nad AudioVisual,
        //but also the new local variable we added which tells the method what data to read in.
        
        //testLibrary.testReadData("C:/Users/Zac/Desktop/Programming/BestProject/DataFiles/cd___dvd_data_1.txt");    //this ensures that we can read the data from the first file 
                                                                                                                                  //of both CD and DVD data and ignore comments and blank lines etc.
        //testLibrary.printAllDetails();
        /*
        testLibrary.clearItemList();
        
        //testLibrary.testReadData("C:/Users/Zac/Desktop/Programming/BestProject/DataFiles/cd___dvd_data_2.txt");  //testing of the 2nd file for the same method
        //testLibrary.printAllDetails(); 
        
        //Part 3, Step 1 (Reading in timesBorrowed and onLoan and reading in cd_&_dvd_data3.txt to prove it) 
        //We will now ensure that, upon editing the extractData() method in our AudioVisual superclass, that we can read in data that now contains 
        //timesBorrowed and onLoan. These values, just like previously, need to be stored in individual cd objects.
        
        testLibrary.testReadData("F:/java/BestestProject/DataFiles/cd___dvd_data_3.txt");
        testLibrary.printAllDetails();
        testLibrary.clearItemList();
        
        //Part 3, Step 2 and 3 (Amending our code to check for 'Unknown' data and refactoring hierarchy and reading in 'items_all.txt') 
        //After refactoring code as a side-effect of altering the inheritance hierarchy, we need to test to make sure that we can read in 'items-all.txt'
        //which contains two new pieces of data and so the readData() method in the Library class has been changed. The test below confirms that we have
        //succesfully read in the contents of the 'items_all.txt' file by printing out the details of all library items in the itemsList in the Library class.
        
        testLibrary.testReadData("F:/java/BestestProject/DataFiles/items_all.txt");
        testLibrary.printAllDetails();
        testLibrary.clearItemList();
        
        //Part 3, Step 4 (Testing our new LibraryUser class)
        //Now that we have implemented the 'LibraryUser' class, we need to test it by reading in 'library_user_data' and
        //'items_and_user_data' which, if printed out correctly tells us that our library system can now read and store objects
        //of the LibraryUser class, whilst, at the same time, filling in the variables by our extractData() methods.
        
        testLibrary.testReadData("F:/java/BestestProject/DataFiles/items_and_user_data.txt");
        testLibrary.printAllDetails();
        //testLibrary.clearUserList();              We do not want to clear this time as we will use the stored objects to write their details to a file
        
        //Part 3, Step 5 (Writing User Data)
        //Since we have used the PrintWriter class to write User Data to a file specified by the user, we need to test this with default values and a file should
        //appear within our 'DataFiles' directory. The user only has to enter a filename and the '.txt' extension should be appended automatically along with it's
        //default directory being set to 'DataFiles'.
        
        testLibrary.testWriteUserData("testfile"); 
        testLibrary.clearUserList();
        testLibrary.testReadData("F:/java/BestestProject/DataFiles/testfile.txt");
        testLibrary.printAllDetails();
        testLibrary.clearUserList();
        */
        //Part 4, Step 1 and Step 2 (Generating a userID using pseudo-random behaviour and making sure they are unique)
        //Now that we can generate a userID for users, we need to make sure this method works correctly, so it has been made public whilst we call it from the external test
        //class. We will first test the 'generateUserID()' method by itself and then test our newly modified 'storeUser()' method by reading in the 'library_user_data.txt' file
        //and printing the details of each userID afterwards as the readData() method inside Library calls the storeUser() method as part of the read. 
        //Also, in step 1, we successfully created a generateID() method in which users recieve an ID based on a prefix and a length of digits they want on the end of that prefix
        //Here, in step 2, we are ensuring that all userIDs are unique. This is done by using a method in the HashMap class which ensures that we do not get duplicate keys.
        //Having duplicate keys is a problem as it means the HashMap cannot store dupliacte keys and so objects in the map will be overwritten.
        
        
        LibraryUser libUser = new LibraryUser();
        libUser.setFirstName("Zac");
        libUser.setSurname("King");
        libUser.generateUserID("test", 8);      //This should give libUser a userID with the prefix 'test' and should include an 8 digit number after the prefix.
        libUser.printDetails();
        
        //testLibrary.testReadData("F:/java/BestestProject/DataFiles/library_user_data.txt");
        //testLibrary.printAllDetails();
        /*
        //Part 4, Step 3(Using HashMaps instead of ArrayList and making sure we can retrieve user data and item data)
        //We should now be able to retrieve a user via their userID from the HashMap and also an item via it's itemCode from the HashMap
        //This retrieval is done using our new methods 'getUser()' and 'getItem' which both make checks to first make sure the ids entered as arguments
        //actually exist in the map; if not we return null from the methods. We are also testing that every method still works as it should when we were
        //using Lists instead of Maps.
        
         */
        testLibrary.testReadData("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/library_user_data.txt");
        testLibrary.testReadData("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/items_all.txt");
        testLibrary.testWriteUserData("testfile"); 
        //testLibrary.clearUserList();
        //testLibrary.testReadData("F:/java/BestestProject/DataFiles/testfile.txt");
        testLibrary.printAllDetails();
        //testLibrary.clearUserList();
        
        System.out.println();
        
        libUser.setUserID("LU229999");      //For testing purposes, we have made this method so we can confirm that our new '.getUser()' method can grab a value based on a key
                                            //This has to be done otherwise the other userID's are all random and so we don't know what they are in order to find them.
                                            
        testLibrary.storeUser(libUser);
        
        System.out.println(testLibrary.getItem("LM002468"));        //Because normally, printing these would just give use the hex place in memory, we have made .toString()
                                                                    //Methods in order to override this usual occurence and print something useful when we retrieve an object from the map using .get();                
        System.out.println(testLibrary.getUser("LU229999"));
        
        
        //Part 4, Step 4(Date and DateUtil classes testing)
        //In this test, we will prove that we have confidence using both these classes by calling the method named 'convertStringToDate()' twice to create two date objects and also
        //then calling the 'daysBetween()' to print out the number of days between the two dates we have created.
        
        System.out.println();
        
        Date test1 = DateUtil.convertStringToDate("13-03-1998");
        Date test2 = DateUtil.convertStringToDate("14-03-1998");
        
        System.out.println(DateUtil.daysBetween(test1, test2));
        
        
        //Part 4, Step 5(ItemReservation class testing)
        //After implementing a new class called 'ItemReservation', we need to make sure we can initialise an instance of it correctly and that the constructor initialises the class's variables correctly.
        //Also we need to test that a unique item reservation number can be generated and we will print this to the terminal to see if it has worked. We will test the 'getItemReservation()' by printing it out
        //to the screen along with the new 'makeItemReservation()' method which simulates someone actually making making a reservation on a library item.
        
        /*System.out.println();
        
        ItemReservation itemReserve = new ItemReservation("000001", "LME0000001", "UNK123456", "14-03-2017", 7);
        testLibrary.storeItemReservation(itemReserve);
        
        ItemReservation itemReserveTest = new ItemReservation("unknown", "LME123456", "test123456", "19-05-2017", 7);
        itemReserveTest.generateReservationNo(testLibrary.getReservationMap());
        testLibrary.storeItemReservation(itemReserveTest);                              //The id for 'itemReserveTest' should be '000002' as there is already one reservation in the map
        System.out.println(itemReserveTest.getReservationNo());
        
        
        testLibrary.makeItemReservation("LU229999", "LM002468", "14-03-1998", 7);
        testLibrary.printItemReservations();
        
        testLibrary.testWriteItemReservationData("ItemReservations");
        testLibrary.clearReservationMap();
        
        testLibrary.testReadData("C:/Users/Zac/Desktop/Programming/BestestProject/DataFiles/ItemReservations.txt");
        testLibrary.printItemReservations();
        
        System.out.println();
        System.out.println(testLibrary.getItemReservation("000001"));        //Should return the hex place in memory as we are retrieving an object here
        
        
        */
        //Part 4, Step 6(Diary class testing)
        //After implementing a new class called 'Diary', we need to ensure it is adding to the functionality of our Library system and no bugs occur due to it's appearance.
        //We can do this by using our testLibrary as it contains an instance of the Diary class which helps make the Library class better.
        //Other testing involves the new method inside the Library class called 'printDiaryEntries' which allows users to specify a term for which they can view reservations 
        //booked for that term. This will mean that the above method called 'getItemReservation()' will not print out a hex place in memory now because we have written a '.toString()'
        //method, overriding the one in the 'Object' class
        
        testLibrary.makeItemReservation("LU229999", "LM002468", "14-03-2017", 7);
        
        testLibrary.printDiaryEntries("14-03-2017", "21-03-2017");              //the noOfDays given to our test ItemReservation objects above is 7 days and so 14 + 7 = 21, therefore these are the start and end dates
                                                                                //respectively
                                                                                

        
        testLibrary.deleteItemReservation("000001");
        testLibrary.printDiaryEntries("14-03-2017", "21-03-2017");              //After just deleting this item reservation from the system, it should no longer show when the entries are printed
        
        ItemReservation.writeLatestResNumber();                             //This will basically represent saving our latest itemReservationNo to a file which we can then use when we create further reservations later
                                                                            //even after closing the program
                                                                            
        testLibrary.makeItemReservation("LU229999", "LM002468", "20-03-2017", 7);
        testLibrary.printDiaryEntries("20-03-2017", "26-03-2017");                      //Creating another itemReservation and printing out it's details via the printDiaryEntries() method here will prove that we have read in
                                                                                        //the latest reservation number from a file and used it as a checkpoint from the last time we made reservations
        ItemReservation.writeLatestResNumber();
   }
}
