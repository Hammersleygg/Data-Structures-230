import java.util.Scanner;
import java.io.File;


public class main extends hashFunction{
	
	public static void main(String[] args) throws Exception 
	{ 
		int entries = 0;
		int collisions = 0;
		int avgCollisions = 0;
		int mostCollisions = 0;
		String words = "";
		String splitWords = null;
		String tags = null;

		
		File lexicon = new File("LEXICON.txt");
		Scanner myScan = new Scanner(lexicon);
		
		
		LinkedList myHash[] = new LinkedList[24593];
		
		for(int i = 0; i < 24593; i++) {
			myHash[i] = new LinkedList();
		}
		

		while(myScan.hasNextLine()) {
			splitWords = myScan.next();
			int temp = hFunction(splitWords);
			myHash[temp].insertFront(splitWords + " " + myScan.nextLine());				
			entries++;
			}
		
		//if there are any occurrences of the same number in temp, collisions is index length - 1		
		for(int i = 0; i < 24593; i++) {
			if(myHash[i].length() > 1) {
				collisions += myHash[i].length() - 1;
			}
		}	
		
		//average number of collisions
		avgCollisions = collisions / 24593;
		
		//index with the most number of collisions and the words
		for(int i = 0; i < 24593; i++) {
			if(myHash[i].length() - 1 > mostCollisions) {
				mostCollisions = i;
				}
		}
		
		//Gets the words that are associated with the most collisions
		LinkedListNode temp = myHash[mostCollisions].getHead();
		words = (String) temp.getData();
			while(temp.getNext() != null){
				words += temp.getNext().getData() + ",";
				temp = temp.getNext();
			}


		System.out.println("1. The total number of lexical entries is: " + entries);
		System.out.println("2. The total number of collisions in the table is: " + collisions);
		System.out.println("3. The average number of collisions per lexical entry is: " + avgCollisions);
		System.out.println("4. The array index that had the most number of collisions is: " + mostCollisions);
		System.out.println("5. The words for that collision is: " + words);
		
		
		boolean stop = false;
		
		while(stop == false) {
			Scanner userScan = new Scanner(System.in);
			System.out.println("Please enter a word you would like to look for: ");

			String input = null;
			if(input != "DONE") {
				input = userScan.nextLine();
				int userWords = hFunction(input);
				tags = (String) myHash[userWords].getHead().getData();
				
				System.out.println("Here are the tags associated with your word: " + tags);
				System.out.println("");
			}
		}
		stop = true;
	}
}
