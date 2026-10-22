package cards;

import java.util.ArrayList;

public class DefaultCards implements Icard { //this supports addition of skins in a later date if i will feel like it BY THE WAY ALL CARDS ARE AI GENERATED I CANNOT DRAW
  private int rndInd = -1;
  private ArrayList<Integer> prevRndInd = new ArrayList<Integer>();
  private String filePath;

  public DefaultCards() {
    rndInd = (int)(Math.random() * (DefaultCardsEnum.values().length - 1));
  }
  public int draw() {
    while(prevRndInd.contains(rndInd)) {
      if(prevRndInd.size() >= (DefaultCardsEnum.values().length - 1)) {
        this.shuffle();
      }
      rndInd = (int)(Math.random() * (DefaultCardsEnum.values().length - 1));
    }
    prevRndInd.add(rndInd);

    return DefaultCardsEnum.values()[rndInd + 1].id;
  }
  public void shuffle() {
    prevRndInd = new ArrayList<Integer>();
    System.out
  }
}
