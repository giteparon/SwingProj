package gamelogic;

import cards.DefaultCards;


public class GameLogic {
  public static Player checkWon(Player p1, Player p2){





    return null;
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
