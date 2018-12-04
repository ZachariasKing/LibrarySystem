import java.util.Scanner;
/**
 * The AudioVisual class represents audio visual items in the library system that can 
 * be borrowed and have their own loan status, cost, artist, item code, title and playing time.
 * 
 * AudioVisual items that carry these attributes and more inherit from this class.
 *
 * @author Zacharias King
 * @version 14/04/2018
 */
public abstract class AudioVisual extends LibraryItem
{
    //The total playing time of the item in minutes
    private int playingTime;

    /**
     * Constructor for objects of class AudioVisual which creates an empty AudioVisual object
     * This constructor is needed as a call to super in the subclasses in order to create
     * empty specialized objects.
     * 
     * In order to emphasize that this object is empty, we have explicitly declared 'null', '0' or 'false' respectively
     * for string, int and boolean values.
     *  
     */
    public AudioVisual()
    {
        super();
        playingTime = 0;
    }
   
    /**
     * This method returns the playing time of the audio visual item in minutes
     * 
     * @return the playing time of the audio visual item in minutes
     */
    public int getPlayingTime()
    {
        return playingTime;
    }
    
    /**
     * This method allows us to alter the playing time of an audio visual item
     * 
     * @param minutes the new playing time in minutes which we want to assign.
     */     
    public void setPlayingTime(int minutes)
    {
        this.playingTime = minutes;
    }
    
    /**
     * This method prints out the details shared between each AudioVisual item, using an if statement
     * to check whether the item is on loan or not
     * 
     */     
    public void printDetails()
    {
        super.printDetails();
        System.out.println("This has a playing time of: " + getPlayingTime() + " minutes");
    }

        
    /**
     * This method extracts data from a line of text given to the scanner being passed as an argument into
     * the method. In particular, for refactoring purposes, this class extracts the shared attributes of all AudioVisual items
     * 
     * @param dataScanner is the <code>Scanner</code> used to extract each section of data with a certain 
     * delimiter
     */
    public void extractData(Scanner dataScanner)
    {
        int playingTime = dataScanner.nextInt();
        super.extractData(dataScanner);
        
        this.setPlayingTime(playingTime);
    }

}
