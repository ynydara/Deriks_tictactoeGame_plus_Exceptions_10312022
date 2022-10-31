import java.io.IOException;
/*
-how to throw exceptions
    1- declare in the method header/ constructor
    2 -inside the method or constructor , check if the input is invalid "throw" new exception
    how to create custom exceptions
 */
public class TicTacToe {

    //TicTacToe(int r) throws IOException, Exception{

   // }
//    public int division(int a, int b) throws TicTacToeException {
  //      if(b != 0){
    //    return a/b;
   // } else {
     //   throw new TicTacToeException("You can't divide by zero! Try something else.");
       // }
    //}


        private char[][] board;
        private char nextPlayer;
        private char winner;

        //game constructor
        TicTacToe() {
            board = new char[3][3];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++){
                    board[i][j] = ' ';
                }
            }
        }

        //setter and getter methods
        public char getNextPlayer() {
            return nextPlayer;
        }
        public void setNextPlayer(char symbol) {
            this.nextPlayer = symbol;
        }
        public char getWinner() {
            return winner;
        }

        //checks for valid symbol input
        public boolean isValidPlayer(char firstPlayer) {
            boolean valid = false;
            if (firstPlayer == 'x' || firstPlayer == 'o') {
                valid = true;
            }
            return valid;
        }

        //assigns a spot with 'x' or 'o' depending on turn.
        public void playNextMove(char symbol, int row, int column) throws TicTacToeException {
            if (!isGameWon()) {
                //guard if statement
                if(row < 0 || row >2 || column < 0 || column > 2) {
                    throw new TicTacToeException("Invalid row/column.");
                }

                //if(row >= 0 && row <=2 && column >=0 && column <=2) {
                  if(board[row][column] == 'x' || board[row][column] == 'o') {
                      throw new TicTacToeException("Spot already taken");
                  }
                  //  if (board[row][column] != 'x' && board[row][column] != 'o') {
                        board[row][column] = symbol;
                        if (nextPlayer == 'x') {
                            nextPlayer = 'o';
                        }
                        else if (nextPlayer == 'o') {
                            nextPlayer = 'x';
                        }

                    }
                   // else{
                   //     throw new TicTacToeException("That spot is already taken!");
                        //System.out.println("That spot is already taken!");
                  //  }
                }
                //else {
                    //throw new TicTacToeException("That space is not an option, try again!");
                    //System.out.println("That space is not an option, try again!");
                //}
           // }

        //}


        //checks to see if there is a win or if there's a tie
        public boolean isGameWon() {
            boolean over = false;

            //check rows
            for (int i = 0; i < board.length; i ++) {
                if(board[i][0] == board[i][1] && board [i][0] == board[i][2] && board[i][0] != ' ') {
                    over = true;
                    winner = board[i][0];
                    break;
                }
            }

            //check columns
            for (int i = 0; i < board.length; i ++) {
                if(board[0][i] == board[1][i] && board [0][i] == board[2][i] && board[0][i] != ' ') {
                    over = true;
                    winner = board[0][i];
                    break;
                }
            }

            //check diagonals
            if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ')){
                over = true;
                winner = board[1][1];
            }

            //check for tie
            if (!over && board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' && board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' &&
                    board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' ') {
                over = true;
                winner = 't';
            }

            return over;
        }

        //gameboard display with row/column labels
        public String toString() {
            return  "   c0  c1  c2\n" +
                    "r0  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" "+"\n" +
                    "   -----------\n" +
                    "r1  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" "+"\n" +
                    "   -----------\n" +
                    "r2  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" "+"\n";
        }
    }

