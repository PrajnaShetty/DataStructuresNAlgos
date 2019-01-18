package leetcode;

import java.io.IOException;
import java.util.HashSet;

class ValidSudoku {
    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;

                int rowIndex = 3 * (i/3);
                int colIndex = 3 * (i%3);

                if (board[rowIndex + j/3][colIndex + j%3] != '.' && !cubes.add(board[rowIndex + j/3][colIndex + j%3]))
                    return false;

            }
        }

        return  false;
    }


    public static void main(String[] args) throws IOException {
        char[][] invalidboard = {
  {'5','3','.','.','7','.','.','.','.'},
  {'6','.','.','1','9','5','.','.','.'},
  {'.','9','8','.','.','.','.','6','.'},
  {'8','.','.','.','6','.','.','.','3'},
  {'4','.','.','8','.','3','.','.','1'},
  {'7','.','.','.','2','.','.','.','6'},
  {'.','6','.','.','.','.','2','8','.'},
  {'.','.','.','4','1','9','.','.','5'},
  {'.','.','.','.','8','.','.','7','9'}};
        boolean ret = isValidSudoku(invalidboard);

        System.out.println(ret);
    }
}