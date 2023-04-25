/**
 * Gavin Hammersley, hammersleygg@g.cofc.edu
 * I assert that I have written 100% of this code myself otherwise
 * I will receive a 0% grade on this assignment.
 * 
 * Status: 
 * This code is 100% tested and correct(for the most part) 
 * I don't know why but sometimes the ball wont fall down the last row all the way. I couldn't find the reason. 
 * 
 */
public class ball {
	public static void main(String[] args) {
		// randomly generate numbers. if even make "=" if odd make " "
		
		int N = Integer.parseInt(args[0]);
		int X = Integer.parseInt(args[1]);
		int Y = Integer.parseInt(args[2]);
		
		int F = N * 2;
		
		
		char BallArea[][] = new char[F][N];		
		
		for(int i = 0; i < BallArea.length; i++) { //gets rows 
			for(int j = 0; j < BallArea[0].length; j++) { // gets columns
				if(i % 2 == 1) {
					BallArea[i][j] = '=';
				}
				else {
					BallArea[i][j] = ' ';
				}
			}
		}
		//Randomly making empty spots
		for(int i = 0; i < BallArea.length - 1; i++) {
			for(int j = 0; j <= BallArea[0].length - 1; j++) {
				if(Math.random() <= X * 0.01) {
						BallArea[i][j] = ' ';
				}
			else if(Math.random() <= Y * 0.01) {
				if(i % 2 == 1) {	
					BallArea[i][j] = '=';
				}
			}
		}
	}
		//Draws and "rolls" the balls
		int K = 0;
		
		for(int i = 0; i < BallArea.length; i++) {
			if(K == N - 1) {
				break;
			}
			else {
				for(int j = K; j <= BallArea[0].length - 1; j++) {
					if(i % 2 == 1) {
						if(BallArea[i][j] == ' ') {
							BallArea[i][j] = 'O'; //if space set space to O		
							BallArea[i + 1][j] = 'O'; //set below O to O also
							
							K = j;
							
							for(int line = j; line <= N - 1; line++) { //takes the current line and fills O 
								BallArea[i + 1][line] = 'O';
							}
							for(int line = j + 1; line <= N - 1; line++) { // looks at that line and sets ' '
								BallArea[i - 1][line] = ' ';
							}
							
							break;
						}
						else {
							K = 10;
						}	
					}
				}
			}
		}
	
		for(int i = 0; i < BallArea.length; i++ ) {
			System.out.println();
			//System.out.println();
			for(int j = 0; j < BallArea[0].length; j++) {
				System.out.print(BallArea[i][j]);

			}
		}
	}
}