public class TicTacToeException extends Exception{
    TicTacToeException(){
        super();
    }
    TicTacToeException(String s){super (s);}
}
/*
-why are creating exceptions helpful?
    it's easier to troubleshoot a super specific program. For example, you can create an exception
    for a tic-tac-toe game when someone decides to input the wrong symbol.

   -
 */