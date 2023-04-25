/**
 * Gavin Hammersley, hammersleygg@g.cofc.edu
 * I assert that I have written 100% of this code myself otherwise
 * I will receive a 0% grade on this assignment.
 * 
 * Status: 
 * This code is 100% tested and correct
 * 
 */

import java.util.Scanner;
public class morse {
    public static void convertMorse(String[] morseLetters,
                                      String morseCode) {
    	
        String[] myArray = morseCode.split(" ");
		
     	int spaceCreator = 0;
		  
        for (int i = 0; i < myArray.length; i++) {
		  	for (int j = 0; j < morseLetters.length; j++) {
                if (myArray[i].compareTo(morseLetters[j]) == 0) {
					System.out.print((char)(j + 'a')); //takes the char a and adds "places" to generate the next letters
					spaceCreator = 0;
					break;	
                }
				  if (myArray[i].compareTo(morseLetters[j]) == -2 && spaceCreator != 1) { // looking at the spaces of the code, -2 is returned from
					System.out.print(" ");												  // compareTo()
					spaceCreator = 1;
				  }
            }
        }
    }

    public static void main(String[] args)
    {
    		Scanner myScan = new Scanner(System.in);
    		
      		String[] morseLetters = {
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."
				};
				
        // Given Strings
      		while(myScan.hasNext()) {
      			String morseCode = myScan.nextLine();
      			convertMorse(morseLetters, morseCode);
      		}
        		//".... . .-.. .-.. ---   -- -.--   -. .- -- .   .. ...   ... .- --"; //hello my name is sam
		   //"-.-. --- ..-. -.-.   .-. --- -.-. -.- ..." //COFC Rocks
		   //".... ..   " // HI
		   //"-----"; // End of Line
           myScan.close();

	}
}

		
		

