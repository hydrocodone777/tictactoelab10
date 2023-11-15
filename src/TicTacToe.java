import java.util.Objects;
import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean play = true;
    int rowMove;
    int colMove;
    final String Player1 = "X";
    final String Player2 = "O";
    String playerTurn = " ";
    do {
        clearBoard();
        for (int x = 1; x <= 9; ++x) {
            display();
            if (x % 2 == 0) {
                playerTurn = Player2;
            } else {
                playerTurn = Player1;
            }
            do {
                rowMove = SafeInput.getRangedInt(in, playerTurn + "'s move. Enter Row: ", 1, 3);
                rowMove = rowMove - 1;
                colMove = SafeInput.getRangedInt(in, playerTurn + "'s move. Enter Column: ", 1, 3);
                colMove = colMove - 1;
                isValidMove(rowMove, colMove);
            } while (!isValidMove(rowMove, colMove));
            if (playerTurn.equals(Player1)) {
                board[rowMove][colMove] = " X ";
            } else {
                board[rowMove][colMove] = " O ";
            }
            isWin(playerTurn);
            if (isWin(playerTurn)) {
                display();
                System.out.print(playerTurn + " has won!");
                break;
            }
            if (x >= 8) {
                if (isTie()) {
                    display();
                    System.out.print("Tie!");
                    break;
                }
            }
        }
        play = SafeInput.getYNConfirm(in, "Play Again? [Y/N]");
        System.out.println();
        if(play){
            System.out.println();
        }
    }while(play);


}
    private static void clearBoard() {
        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                board[i][k] = " - ";
            }
        }
    }
    private static void display() {
        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                System.out.print(board[i][k]);
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        boolean valmove = false;
        if (board[row][col].equals(" - ")) {
            valmove = true;
        } else{
            System.out.print("Illegal move. Spot already taken ");
        }
        return valmove;
    }
    private static boolean isWin(String player){
        boolean winColWin = isColumnWin(player);
        boolean winRowWin = isRowWin(player);
        boolean winDiagWin = isDiagonalWin(player);
        boolean win = false;
        if(winColWin){
            win = true;
        } else if (winRowWin) {
            win= true;
        } else if (winDiagWin) {
            win= true;
        }
        return win;
    }
    private static boolean isTie(){
        boolean tie = false;
        int fill= 0;

        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                if(!board[i][k].equals(" - ")){
                    fill = fill + 1;
                }
            }
        }
        if(fill == 9){
            tie = true;
        }
        return tie;
    }
    private static boolean isColumnWin(String player){
        boolean win= false;
        if(board[0][1].equals(" X ")){
            if(board[1][1].equals(" X ")){
                if(board[2][1].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[0][0].equals(" X ")){
            if(board[1][0].equals(" X ")){
                if(board[2][0].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[0][2].equals(" X ")) {
            if (board[1][2].equals(" X ")) {
                if (board[2][2].equals(" X ")) {
                    win = true;
                }
            }
        }else if(board[0][1].equals(" O ")){
            if(board[1][1].equals(" O ")){
                if(board[2][1].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[0][0].equals(" O ")){
            if(board[1][0].equals(" O ")){
                if(board[2][0].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[0][2].equals(" O ")) {
            if (board[1][2].equals(" O ")) {
                if (board[2][2].equals(" O ")) {
                    win = true;
                }
            }
        }
        return win;
    }
    private static boolean isRowWin(String player){
        boolean win= false;
        if(board[0][0].equals(" X ")){
            if(board[0][1].equals(" X ")){
                if(board[0][2].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[1][0].equals(" X ")){
            if(board[1][1].equals(" X ")){
                if(board[1][2].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[2][0].equals(" X ")) {
            if (board[2][1].equals(" X ")) {
                if (board[2][2].equals(" X ")) {
                    win = true;
                }
            }
        }else if(board[0][0].equals(" O ")){
            if(board[0][1].equals(" O ")){
                if(board[0][2].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[1][0].equals(" O ")){
            if(board[1][1].equals(" O ")){
                if(board[1][2].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[2][0].equals(" O ")) {
            if (board[2][1].equals(" O ")) {
                if (board[2][2].equals(" O ")) {
                    win = true;
                }
            }
        }
        return win;
    }
    private static boolean isDiagonalWin(String player){
        boolean diagWin = false;
        if(Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[0][0], board[2][2])){
            if(board[0][0].equals(" - ")){
                diagWin = false;
            }else{
                diagWin = true;
            }
        }else if(Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[0][2], board[2][0])){
            if(board[2][0].equals(" - ")){
                diagWin = false;
            }else{
                diagWin = true;
            }
        }else{
            diagWin = false;
        }
        return diagWin;
    }
}
