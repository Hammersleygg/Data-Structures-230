
public class BoardState implements Comparable{

	// You need to implement this!!
		
	private int board[];
	private int g; 
	private int h;
	private BoardState parent;
	
	
	public BoardState(int[]board, int g, int h, BoardState parent) {
		super();
		this.board = board;
		this.g = g;
		this.h = h;
		this.parent = parent;
	}
	
	
	public String toString() {
		String boardStr = 
				  board[0] + " " + board[1] + " " + board[2] + "\n"
				+ board[3] + " " + board[4] + " " + board[5] + "\n"
				+ board[6] + " " + board[7] + " " + board[8] + "\n" ;
		return boardStr;
			}
	
	public boolean equals(Object obj) {
		//compare 1d array and board states 
		BoardState myObj = (BoardState)obj;
		if(this.board == myObj.getBoard()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Object obj) {
		//return a number that compares to f score(distance and heuristic) between board states
		BoardState myObj = (BoardState)obj;
		if(this.board == myObj.getBoard()) {
			return 0;
		}
		else if(this.g + this.h > myObj.getG() + myObj.getH()){
			return 1;
		}
		else if(this.g + this.h < myObj.getG() + myObj.getH()){
			return -1;
		}
		return 0;
}

	//board
	public int[] getBoard() {
		return board;
	}
	public void setBoard(int[] board) {
		this.board = board;
	}
	//g
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	//h
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	//parent
	public BoardState getParent() {
		return parent;
	}
	public void setParent(BoardState parent) {
		this.parent = parent;
	}
}

