
import java.util.*;
public class Sudoku {
	private static int size=9;
	public static void main(String[] args) {
		System.out.print("Welcome! lets solve Soduko :)");
		char[][] board = new char[size][size];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
		System.out.println();
        System.out.println("Enter the Sudoku puzzle (use '.' for empty cells):");
        
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < size; j++) {
                board[i][j] = line.charAt(j);
            }
        }
		
//		char[][] board = 
//			    { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
//				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
//				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
//				{ '7', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
//				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solve(0, 0, board);
	}

	public static void solve(int r, int c, char[][] board) {

		if (c == 9) {
			r++;
			c = 0;
		}
		if (r == 9) {
			Disp(board);
			return;
		}
		if (board[r][c] != '.') {
			solve(r, c + 1, board);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isSafe(i, r, c, board)) {
					board[r][c] = (char) ('0' + i);
					solve(r, c + 1, board);
				}
			}
			board[r][c] = '.';
		}
	}

	private static boolean isSafe(int i, int r, int c, char[][] board) {
		for(int C = 0;C<9;C++) {
			if(board[r][C]==(char)(i+'0')) {
				return false;
			}
		}
		for(int R = 0;R<9;R++) {
			if(board[R][c]==(char)(i+'0')) {
				return false;
			}
		}
		int boxr = r/3;
		int boxc = c/3;
		for(int R = boxr*3;R<boxr*3+3;R++) {
			for(int C = boxc*3;C<boxc*3+3;C++) {
				if(board[R][C]==(char)(i+'0')) {
					return false;
				}
			}
		}
		return true;
	}

	public static void Disp(char[][] board) {
		System.out.println( "Voila! Here is our answer");
		System.out.println();
		
		for (char[] row : board) {
			for (char ch : row) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
		System.out.println("===============================================");
	}
}