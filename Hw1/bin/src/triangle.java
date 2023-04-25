/**
 * Gavin Hammersley, hammersleygg@g.cofc.edu
 * I assert that I have written 100% of this code myself otherwise
 * I will receive a 0% grade on this assignment.
 * 
 * Status: 
 * This code is 100% tested and correct
 * 
 */
import java.util.*;
public class triangle {
    public static void getResults(String triangleInput)
    {
    	//splitting the user input in an array
        String[] myArray = triangleInput.split(" ");
        
        	//setting all the sides = to 0 at the start
			int AB = 0;
			int BC = 0;
			int AC = 0;
			int area = 0;
			
			//looking through the array to see if the letters match
			if (myArray[0].equals("AB")) {
				AB = Integer.parseInt(myArray[1]);
			}
			
			if (myArray[2].equals("AB")) {
				AB = Integer.parseInt(myArray[3]);
			}
			
			if (myArray[0].equals("BC")) {
				BC = Integer.parseInt(myArray[1]);
			}
			
			if (myArray[2].equals("BC")) {
				BC = Integer.parseInt(myArray[3]);
			}
			
			if (myArray[0].equals("AC")) {
				AC = Integer.parseInt(myArray[1]);
				}
			
			if (myArray[2].equals("AC")) {
				AC = Integer.parseInt(myArray[3]);
				}
			
			
			//Doing on the math one each side and setting the answers to an empty string
			String letters = " ";
			
			if (AB == 0) {
				AB = (int)Math.sqrt((int)(AC * AC) - (int)(BC * BC));
				letters = "AB: " + AB;
				}
			
			if (BC == 0) {
				BC = (int)Math.sqrt((int)(AC * AC) - (int)(AB * AB));
				letters = "BC: " + BC;
				}
			
			if (AC == 0) {
				AC = (int)Math.sqrt((int)(AB * AB)+(int)(BC * BC));
				letters = "AC: " + AC;
			}
			
			//finding the area 
			area = ( AB * BC ) / 2;  
			
			//printing the results 
			System.out.println(letters +  ", AREA: " + area);
			
    }
    

    public static void main(String[] args)
    {
    	// AB - Base
    	// BC - Height
    	// AC - Hypot
    	
    	/*
    	AB 3 BC 4
    	BC 4 AC 5
    	AC 891 AB 125
    	//BC 1923 AC 9999
    	-1 
    	 */
    	
    	int i = 0;
 	
    	Scanner myScan = new Scanner(System.in);
    	
    	//looping through user input and storing it in the string then calling the main function
    	while(myScan.hasNext()) {
    		String triangleString = myScan.nextLine();
    		if(i < triangleString.length()) {
    			i++;
    			getResults(triangleString);
    		}

    	}
        myScan.close();
	}
}
