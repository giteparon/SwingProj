package gui;

import cards.DefaultCards;
import cards.DefaultCardsEnum;
import gamelogic.Dealer;
import gamelogic.Player;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuGui implements Igui {
  DefaultCards cards = new DefaultCards();
  ArrayList<JLabel>  playerCardLabels = new ArrayList<>();
  ArrayList<JLabel>  dealerCardLabels = new ArrayList<>();
  Container container;
  static JFrame frame;


  public MainMenuGui(JFrame frame) {
    this.frame = frame;
    this.container = frame.getContentPane();
    container.setLayout(null);
    JPanel panel = new JPanel();



//    String pathCard = DefaultCardsEnum.getSprite(1).getPath();
//    ImageIcon icon = new ImageIcon(pathCard);
//    JLabel label = new JLabel(icon);



    JButton hit = new JButton("Hit");
    JButton stand = new JButton("Deal");
    Player player = new Player("Player", cards);
    Dealer dealer = new Dealer("Dealer", cards);
    hit.addActionListener((new ActionListener(){
      public void actionPerformed(ActionEvent e){
        player.addCard(cards);
      }
    }));
    stand.addActionListener((new ActionListener(){
      public void actionPerformed(ActionEvent e){
        dealer.dealTill17(cards);
      }
    }));
    for(int i = 0; i < player.cards.size(); i++){
      String pathCard = DefaultCardsEnum.getSprite(player.cards.get(i)).getPath();
      ImageIcon icon = new ImageIcon(pathCard);
      JLabel _l = new JLabel(icon);
      _l.setBounds(100, 100 + i * 50, icon.getIconWidth(), icon.getIconHeight());
      container.add(_l);
    }
    for(int i = 0; i < dealer.cards.size(); i++){
      dealerCardLabels.add(new JLabel());
    }
//    label.setBounds(frame.getWidth() / 2 - 50, frame.getHeight() / 2 - 200, 100, 200);
    hit.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 - 25, 100, 50);
    stand.setBounds(frame.getWidth() / 2 - 100, frame.getHeight() / 2 + 25, 100, 50);
    container.add(hit);
    container.add(stand);
//
//    container.add(label);

    frame.revalidate();
    frame.repaint();

  }
  public void open() {

  }
  public void close() {

  }
  public static void render(){
    frame.revalidate();
    frame.repaint();
  }

}
