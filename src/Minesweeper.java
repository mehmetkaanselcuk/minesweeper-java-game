import java.util.Scanner;
import java.util.Random;


public class Minesweeper {
    int rowNumber, colNumber, size,success=0;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    Minesweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber*colNumber;
    }

    public void run(){
        preparegame();
        print(map);
        int row,column,success=0;
        System.out.println("The game has started!");
        while(game){
            print(board);
            System.out.println("Row :");
            row = scan.nextInt();
            System.out.println("Column :");
            column = scan.nextInt();

            if (row < 0 || row >= rowNumber) {
                System.out.println("Invalid coordinate !");
                continue;
            }
            if (column < 0 || column >= colNumber) {
                System.out.println("Invalid coordinate !");
                continue;
            }

            if(map[row][column] != -1){
                checkMayin(row,column);
                success++;
                if(success==(size/4)){
                    System.out.println("Congratulations, you did it without stepping on any mines.");
                    break;
                }
            }else{
                game=false;
                System.out.println("Game Over!");
            }
        }
    }


    public void preparegame(){
        int randRow, randCol, count=0;
        while(count != (size/4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if(map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }

        }
    }

    public void print(int [][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] > 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



    }

    public void checkMayin(int r, int c){
        if (map[r][c] == 0) {
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < rowNumber - 3) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }
        }

        if (board[r][c] == 0) {
            board[r][c] = -2;
        }

    }

}
