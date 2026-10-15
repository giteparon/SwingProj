package gui;
import javax.swing.JTextArea;
import main.Main;
import cards.DefaultCards;
import cards.DefaultCardsEnum;

import gamelogic.Dealer;
import gamelogic.GameLogic;
import gamelogic.Player;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import threads.MainThread;

public class MainMenuGui implements Igui {
  private static JFrame frame;

  private final DefaultCards cards = new DefaultCards();
  private final ArrayList<JLabel> playerCardLabels = new ArrayList<>();
  private final ArrayList<JLabel> dealerCardLabels = new ArrayList<>();
  private final Container container;
  private final Player player;
  private final Dealer dealer;

  // Call this on the Swing thread (SwingUtilities.invokeLater) after the frame has a size.
  public MainMenuGui(JFrame frame) {
    MainMenuGui.frame = frame;
    this.container = frame.getContentPane();
    container.setLayout(null);

    player = new Player("Player", cards);
    dealer = new Dealer("Dealer", cards);
    System.out.println("Player : " + player.toString() + " Dealer : " + dealer.toString());
    JButton hit = new JButton("Hit");
    JButton deal = new JButton("Stand");

    hit.addActionListener(e -> {
      player.addCard(cards);
      renderHands();
      if(GameLogic.checkBust(player, dealer) != null){
        Main.getInstance().scheduleSwingTasks(() ->{
          winnerText("dealer won!");
        });
      }
    });
    deal.addActionListener(e -> {
      dealer.dealTill17(cards);
      renderHands();
      if(GameLogic.checkBust(player, dealer) != null){
        if(GameLogic.checkWon(player, dealer) == null){
          Main.getInstance().scheduleSwingTasks(() -> {
            winnerText("tie");
          });
        }
        else{
          Main.getInstance().scheduleSwingTasks(() ->{
            winnerText("Player won!");
          });
        }

      }
      else if(GameLogic.checkBust(player, dealer) == null){
        Main.getInstance().scheduleSwingTasks(() ->{
          winnerText(GameLogic.checkWon(player, dealer).toString() + " won the game");
        });
      }
    });

    hit.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 - 25, 100, 50);
    deal.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 25, 100, 50);
    container.add(hit);
    container.add(deal);

    renderHands();
  }
  private static void winnerText(String text){
    JTextArea _t = new JTextArea(text);
    _t.setBounds(frame.getWidth() / 2 - 150, 10, 300, 300);
    frame.add(_t);
    render();
  }
  // Rebuilds the card labels from the current hands. Must run on the Swing thread.
  private void renderHands() {
    rebuildLabels(playerCardLabels, player.cards, 100);
    rebuildLabels(dealerCardLabels, dealer.cards, frame.getWidth() - 300);
    render();
  }

  private void rebuildLabels(ArrayList<JLabel> labels, ArrayList<Integer> hand, int x) {
    for (JLabel l : labels) {
      container.remove(l);
    }
    labels.clear();

    for (int i = 0; i < hand.size(); i++) {
      String path = DefaultCardsEnum.getSprite(hand.get(i)).getPath();
      ImageIcon icon = new ImageIcon(path);
      if (icon.getIconWidth() <= 0) {
        System.err.println("Could not load card image: " + path);
      }
      JLabel label = new JLabel(icon);
      label.setBounds(x, 100 + i * 50, icon.getIconWidth(), icon.getIconHeight());
      labels.add(label);
      container.add(label);
    }
  }

  public void open() {
    frame.setVisible(true);
  }

  public void close() {
    frame.setVisible(false);
  }

  public static void render() {
    if (frame == null) {
      return; // frame not created yet
    }
    frame.revalidate();
    frame.repaint();
  }
}