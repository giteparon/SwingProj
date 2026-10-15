package gamelogic;

import cards.DefaultCards;
import cards.DefaultCardsEnum;
import java.util.ArrayList;

public class Player {
  private String name;
  private int amt = 0;
  private boolean blackjack = false;
  private int aces = 0;
  public ArrayList<Integer> cards;
  public Player(String name, DefaultCards defaultCards) {
    this.name = name;
    int[] arrayCards = GameLogic.dealInitCards(defaultCards);
    for(int i = 0; i < arrayCards.length; i++){
      this.cards.add(arrayCards[i]);
    }
    amt = sumPlayerCards();
    if(amt == 21){
      blackjack = true;
    }
    if(DefaultCardsEnum.getSprite(cards.get(0)).value == 11){
      aces++;
    }
    if(DefaultCardsEnum.getSprite(cards.get(1)).value == 11){
      aces++;
    }
  }
  protected int sumPlayerCards(){
    int sum = 0;
    for(int i =0; i < this.cards.size(); i++){
      sum+=this.cards.get(i);
    }
    if(sum > 21 && aces > 0){
      sum -= 10;
      aces--;
    }
    return sum;
  }
  public void addCard(DefaultCards defaultCards){
    int card = GameLogic.dealCard(defaultCards);
    this.cards.add(card);
    if(DefaultCardsEnum.getSprite(card).value == 11){
      aces++;
    }
    amt = sumPlayerCards();

  }
  public int getAmt(){
    return this.amt;
  }
  public boolean isBlackjack(){
    return this.blackjack;
  }
  public String getName(){
    return this.name;
  }
}
