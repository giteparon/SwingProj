package gui;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel { //custom panel which can hold the layeredpane (tuff inheritance)
  private JLayeredPane cardsPanel = new JLayeredPane();
  public PlayerPanel() {
    super();
    this.setLayout(null);
    cardsPanel.setBounds(100, 100, 600, 75);
    cardsPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));
    this.add(cardsPanel);
  }
  public void setCardsPanel(JLayeredPane newPane) {
    if (cardsPanel != null) {
      remove(cardsPanel);
    }
    cardsPanel = newPane;
    cardsPanel.setBorder(BorderFactory.createLineBorder(Color.PINK));
    add(cardsPanel);
    revalidate();
    repaint();
  }
  public JLayeredPane getCardsPanel() {
    return cardsPanel;
  }
}
