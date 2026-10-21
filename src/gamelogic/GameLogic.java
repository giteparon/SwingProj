package gamelogic;

import cards.DefaultCards;


public class GameLogic { //too little logic in here and too much in gamegui i should reorganize the code
  public static Object checkBust(Player p1, Dealer p2){
    if(p1.getAmt() > 21){
      return p2;
    }
    else if(p2.getAmt() > 21){
      return p1;
    }
    else{
      return null;
    }
  }
  public static Object checkWon(Player p1, Dealer p2){
    if(p1.getAmt() > p2.getAmt()){
      return p1;
    }
    else if(p2.getAmt() > p1.getAmt()){
      return p2;
    }
    else{
      return null;
    }
  }
  public static int[] dealInitCards(DefaultCards cards) {
    int[] cardsDealed = new int[2];
    cardsDealed[0] = cards.draw();
    cardsDealed[1] = cards.draw();
    return cardsDealed;
  }
  public static int dealCard(DefaultCards cards) {
    return cards.draw();
  }


}
