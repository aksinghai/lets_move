package OldTest;

public class Game {
    public static void main(String[] args) {
        String[] objects = {"is" , "as" , "to"};
        int row = 3;
        int col = 3;
        char[][] board = new char[row][col];
        initialize(board, row, col);
        print(board, row, col);

        String[] object = {"is"};
        uniqueBoard(board,objects, 0,  object, 0, 0, row, col);
    }

    private static void initialize(char[][] board, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                board[i][j] = '?';
            }
        }
    }

    private static void print(char[][] board, int r, int c){
        System.out.println();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void uniqueBoard(char[][] board,String[] objects, int k,  String[] object,int i, int j, int row, int col){
        if(object.length == 0) {
            for(int m = k+1; m < objects.length; m++){
                String[] newObj = new String[1];
                newObj[0] = objects[k+1];
                uniqueBoard(board, objects, k+1, newObj, 0,0,row, col);
            }
            if(k+1 == objects.length){
                print(board, row, col);
            }
            return;
        }

        String str = object[0];
        int n = str.length();
        if(n <= (col-j) && allocationIsPossible(board, i, j, n)){
            char[][] newBoard = cloneBoard(board);
            int c = 0;
            int l = j;
            for(; l < j+n; l++){
                newBoard[i][l] = str.charAt(c++);
            }
            uniqueBoard(newBoard,objects, k, remainingObjects(object), i, l, row, col);
            uniqueBoard(board,objects, k, object, i, j+1, row, col);
        } else {
            if(i+1 < row){
                uniqueBoard(board,objects, k, object, i+1, 0, row, col);
            }
        }
    }

    private static String[] remainingObjects(String[] objects){
        String[] remaining = new String[objects.length-1];
        for(int i = 1; i < objects.length; i++){
            remaining[i-1] = objects[i];
        }
        return remaining;
    }

    private static char[][] cloneBoard(char[][] board){
        int r = board.length;
        int c = board[0].length;
        char[][] duplicate = new char[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                duplicate[i][j] = board[i][j];
            }
        }
        return duplicate;
    }

    private static boolean allocationIsPossible(char[][] board, int i, int j, int n){
        int r = board.length;
        int c = board[0].length;
        for(;j < j+n && j < c; j++){
            if(board[i][j] != '?'){
                return false;
            }
        }
        return true;
    }
}
