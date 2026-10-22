package gui;

import gamelogic.GameLogic;
import main.Main;

public class HitButton extends Button {
  private GameGui gameGui;
  public HitButton() {
    super("./resources/GUI/hit_unpressed.png");
  }
  @Override
  public void handlePress() {
    gameGui = Main.getGameGuiInstance();
    if(gameGui.getGameEnd() == false){
      gameGui.getPlayer().addCard(gameGui.getCards());
      gameGui.renderDealerHands();
      if(GameLogic.checkBust(gameGui.getPlayer(), gameGui.getDealer()) != null){
        Main.getThreadInstance().scheduleSwingTasks(() ->{
          gameGui.winnerText("Dealer won!");
        });
      }
    }
    Main.getThreadInstance().scheduleTasks(() ->{
      changeIcon("./resources/GUI/hit_pressed.png");
      Main.getThreadInstance().sleep(3);
      changeIcon("./resources/GUI/hit_unpressed.png");
    });
  }
}
