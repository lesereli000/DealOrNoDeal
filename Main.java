import java.util.*;

class Main {
  public static void main(String[] args) {
    
    // for (Integer i: Board.randomizeArray(Board.validMoneyOptions)) {
    //   System.out.println(i);
    // }
  
    Scanner k = new Scanner(System.in);
    Board board = new Board();
    board.setCases();
    while(true){
      
      board.chooseFirstCase(k);
      // System.out.println(board.boardValues[board.playerCase]);
      
      board.chooseGameCases(6, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
    
      board.chooseGameCases(5, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(4, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(3, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(2, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(1, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(1, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(1, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.chooseGameCases(1, k);
      board.bankerOffer();
      if(!board.gameCheck(k))
        break;
      
      board.openFinalCase();
      break;
      
    }
    System.out.println("The game has ended");
  }
}