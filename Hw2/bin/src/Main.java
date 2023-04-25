//import java.util.Scanner;
public class Main{

	public static void main(String[] args) {

	// Create an EightPuzzle object and have it solve a puzzle
		int board[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		
		int array1[] = new int[] {2, 6, 0, 3, 5, 1, 4, 7, 8};
		int array2[] = new int[] {1,4,2,0,7,5,3,6,8};

		int swap1[] = new int[] {1,0,2,3,4,5,6,7,8};
		int swap[] = new int[] {1,2,5,3,4,8,6,0,7};		
		
		
		EightPuzzle temp = new EightPuzzle(swap);
		//temp.solve(board);
		//temp.manhattan(board, array1);
		//temp.checkReachable(array1);
				
		
		/*
		manhattan(board, array2);
		checkReachable(array2);
		System.out.println();
		manhattan(board, array3);
		checkReachable(array3);
		System.out.println();
		manhattan(board, array4);
		checkReachable(array4);
		System.out.println();
		System.out.println(board.equals(array2));
		System.out.println(array2.equals(array2));
		System.out.println();
		*/
		
	}

}


