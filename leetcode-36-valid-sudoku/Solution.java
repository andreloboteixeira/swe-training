import java.util.*;
public class Solution{
    public static void main(String[] args){

        if(Solution.isValidSudoku(new char[][]{
            {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        }) == true){
            System.out.println("Ex1 correct");
        };

        if(Solution.isValidSudoku(new char[][]{
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
                }) == false){
            System.out.println("Ex2 correct");
        };
    }

    // t: checking all rows, cols, and boxes and each with 9 elements, and clearing 9 element memory. O(9+9+9)*(9+9) + O(9)), s: 3 arrays to store memory O(3*9)
    public static boolean isValidSudoku(char[][] board) {

        boolean[] rowMemory = new boolean[9];
        boolean[] colMemory = new boolean[9];
        boolean[] boxMemory = new boolean[9];

        for(int row = 0; row < 9; row++){
            Solution.clearMemory(rowMemory);
            for(int j = 0; j < 9; j++){
                char el = board[row][j];
                if(el != '.'){
                    if(rowMemory[el - '1']){
                        return false;
                    } else {
                        rowMemory[el - '1'] = true;
                    }
                }

            }

        }

        for(int col = 0; col < 9; col++){
            Solution.clearMemory(colMemory);
            for(int i = 0; i < 9; i++){
                char el = board[i][col];
                if(el != '.'){
                    if(colMemory[el - '1']){
                        return false;
                    } else {
                        colMemory[el - '1'] = true;
                    }
                }
            }

        }

        for(int rowBox = 0; rowBox < 3; rowBox++){
            for(int colBox = 0; colBox < 3; colBox++){
                Solution.clearMemory(boxMemory);

                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j ++){
                        char el = board[rowBox*3 + i][colBox*3 + j];
                        if(el != '.'){
                            if(boxMemory[el - '1']){
                                return false;
                            } else {
                                boxMemory[el - '1'] = true;
                            }
                        }
                    }
                }

            }
        }

        return true;

    }

    public static void clearMemory(boolean[] memory){
        for(int i = 0; i < memory.length; i++) memory[i] = false;
    }
}
