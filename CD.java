import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * 'CD' inherits from the AudioVisual class and models a CD in the University library system
 * that inherits all the atributes of an AudioVisual object and it has a number of tracks as well.
 * 
 * The class has two constructors in order to make testing an easier process.
 * 
 * 
 * @author Zacharias King
 * @version 22/02/2018
 */
public class CD extends AudioVisual
{
    //The number of tracks on the CD
    private int noOfTracks;
    //The artist of the CD
    private String artist;
    
    /**
     * Constructor for objects of an empty CD class used for testing with default values
     */
    public CD()
    {
        super();
        artist = null;
        noOfTracks = 0;
    }
    
    /**
     * This method simply returns the number of tracks the CD contains
     * 
     * @return the number of tracks that the CD contains
     */
    public int getNoOfTracks()
    {
        return noOfTracks;
    }
    
    /**
     * This method returns the name of the artist of the audio visual medium
     * 
     * @return the name of the artist
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * This method prints the details of the CD item calling an external method of printDetails of the superclass
     * as well as printing out the specific details of this (sub) class
     *
     * @Override
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Artist: " + getArtist());
        System.out.println("This CD has " + getNoOfTracks() + " tracks.");
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
        String artist = dataScanner.next().trim();
        int noOfTracks = dataScanner.nextInt();
        super.extractData(dataScanner);             //saves on code duplication
                
        //Setting values for each individual field
        this.artist = artist;
        this.noOfTracks = noOfTracks;
    }
        
    }


