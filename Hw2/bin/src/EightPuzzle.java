import java.util.Arrays;

public class EightPuzzle{
	

	// You need to implement this!
	public EightPuzzle(int[] board) {
		if(checkReachable(board) == true) {
			solve(board);
		}
		else {
			System.out.println("Sorry this doesn't work...");
		}
	}
	
	public int manhattan(int[] board, int[] array) {
		int sum = 0;
		
		for(int i = 0; i < board.length; i++) {
			if(array[i] != 0) {	
				int X1 = board[i] % 3;
				int X2 = array[i] % 3;
				int Y1 = Math.floorDiv(board[i], 3);
				int Y2 = Math.floorDiv(array[i], 3);
		
				sum += Math.abs(X1 - X2) + Math.abs(Y1 - Y2);
			}
			else {
				i++;
			}
		}
		//System.out.print("Manhattan:" + sum);
		return sum;
	}

	public boolean checkReachable(int[] array) {
		
		int counter = 0;
		boolean reachable = true; 
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 1; j < array.length; j++) {
				if(array[i] > array[j] && array[j] != 0 && i < j) {
					counter = counter + 1;
				}
			}
			
		}
		if(counter % 2 == 0) {
			//System.out.println("Inversions: " + counter);
			reachable = true;
		}
		else {
			reachable = false;
		}
			
		return reachable;
	}
	
	
	
	
	private void printPath(BoardState board) {
		if(board != null) {
			printPath(board.getParent());
			System.out.println(board);
		}
			}
	
	public void solve(int[] goal) {
		
		PriorityQueue open = new PriorityQueue();
		PriorityQueue close = new PriorityQueue();
		
		int board[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};		
		open.priorityEnqueue(new BoardState(board, 0, manhattan(board, goal), null));
		boolean finished = false;
		while(!finished) {
			BoardState current = (BoardState)
			open.dequeue();
			
			//to get the if statement to work and put you into printPath I
			//had to import arrays from the java library's and compare that way
			
			//if(Arrays.toString(current.getBoard()) == Arrays.toString(goal)) { //this is the line that doesn't work i think
			if(Arrays.equals(current.getBoard(), goal)) {
				printPath(current);
				finished = true;
			}
			else {
				LinkedList kids = getChildren(current.getBoard());
				LinkedListNode temp = kids.getHead();
				close.priorityEnqueue(current);
				while(temp != null) {
					BoardState kids2;
					kids2 = new BoardState((int[])(temp.getData()), current.getG() + 1, manhattan(board, goal), current);
					if(close.find(kids2) == null) {
						open.priorityEnqueue(kids2);
					}
					temp = temp.getNext();					
				}
			}
		}
	}
	
	
	private LinkedList getChildren(int[] board) {
		LinkedList childList = new LinkedList();
		
		int location = 0;
		for(int i = 0; i < board.length; i++) {
			if(board[i] == 0) {
				location = board[i];
			}
		}
		
		if(board[0] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
			}
			
			ch1[0] = ch1[1];
			ch1[1] = 0;
			
			ch2[0] = ch2[3];
			ch2[3] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
		
			return childList;
		}
		
		if(board[1] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			int ch3[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
				ch3[i] = board[i];
			}
			
			ch1[1] = ch1[2];
			ch1[2] = 0;
			
			ch2[1] = ch2[4];
			ch2[4] = 0;
			
			ch3[1] = ch3[0];
			ch3[0] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			childList.insertFront(ch3);
			
			return childList;
		}
		
		if(board[2] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
			}
			
			ch1[2] = ch1[5];
			ch1[5] = 0;
			
			ch2[2] = ch2[1];
			ch2[1] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			
			return childList;
		}
		
		if(board[3] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			int ch3[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
				ch3[i] = board[i];
			}
			
			ch1[3] = ch1[4];
			ch1[4] = 0;
			
			ch2[3] = ch2[6];
			ch2[6] = 0;
			
			ch3[3] = ch3[0];
			ch3[0] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			childList.insertFront(ch3);
			
			return childList;
		}
		
		if(board[4] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			int ch3[] = new int[9];
			int ch4[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
				ch3[i] = board[i];
				ch4[i] = board[i];
			}
			
			ch1[4] = ch1[1];
			ch1[1] = 0;
			
			ch2[4] = ch2[3];
			ch2[3] = 0;
			
			ch3[4] = ch3[5];
			ch3[5] = 0;
			
			ch4[4] = ch4[7];
			ch4[7] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			childList.insertFront(ch3);
			childList.insertFront(ch4);

			return childList;
		}
		
		if(board[5] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			int ch3[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
				ch3[i] = board[i];
			}
			
			ch1[5] = ch1[2];
			ch1[2] = 0;
			
			ch2[5] = ch2[4];
			ch2[4] = 0;
			
			ch3[5] = ch3[8];
			ch3[8] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			childList.insertFront(ch3);
			
			return childList;
		}
		
		if(board[6] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
			}
			
			ch1[6] = ch1[3];
			ch1[3] = 0;
			
			ch2[6] = ch2[7];
			ch2[7] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			
			return childList;
		}
		
		if(board[7] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			int ch3[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
				ch3[i] = board[i];
			}
			
			ch1[7] = ch1[4];
			ch1[4] = 0;
			
			ch2[7] = ch2[6];
			ch2[6] = 0;
			
			ch3[7] = ch3[8];
			ch3[8] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			childList.insertFront(ch3);
			
			return childList;
		}
		
		if(board[8] == location) {
			int ch1[] = new int[9];
			int ch2[] = new int[9];
			
			for(int i = 0; i < 9; i++) {
				ch1[i] = board[i];
				ch2[i] = board[i];
			}
			
			ch1[8] = ch1[5];
			ch1[5] = 0;
			
			ch2[8] = ch2[7];
			ch2[7] = 0;
			
			childList.insertFront(ch1);
			childList.insertFront(ch2);
			
			return childList;
		}
		return childList;	
	}
}
