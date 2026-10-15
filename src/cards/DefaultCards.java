package cards;

import java.util.ArrayList;

public class DefaultCards implements Icard {
  private int rndInd = -1;
  private ArrayList<Integer> prevRndInd = new ArrayList<Integer>();
  private String filePath;

  public DefaultCards() {
    rndInd = (int)(Math.random() * DefaultCardsEnum.values().length);
  }
  public int draw() {
    while(prevRndInd.contains(rndInd)) {
      if(prevRndInd.size() >= DefaultCardsEnum.values().length) {
        this.shuffle();
      }
      rndInd = (int)(Math.random() * DefaultCardsEnum.values().length);
    }
    prevRndInd.add(rndInd);

    return DefaultCardsEnum.values()[rndInd].id;
  }
  public void shuffle() {
    prevRndInd = new ArrayList<Integer>();
  }
}
