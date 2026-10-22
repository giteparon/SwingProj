package gui;

import gamelogic.GameLogic;
import main.Main;

public class StandButton extends Button {
  private GameGui gameGui = Main.getGameGuiInstance();
  public StandButton() {
    super("./resources/GUI/hit_pressed.png");
  }
  @Override
  public void handlePress() {
    if(gameGui.getGameEnd() == false){
      gameGui.getPlayer().addCard(gameGui.getCards());
      gameGui.renderDealerHands();
      if(GameLogic.checkBust(gameGui.getPlayer(), gameGui.getDealer()) != null){
        Main.getThreadInstance().scheduleSwingTasks(() ->{
          gameGui.winnerText("Dealer won!");
        });
      }
    }
  }
}
