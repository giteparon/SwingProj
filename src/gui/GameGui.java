package gui;

import javax.swing.*;
import java.awt.*;

public class GameGui implements Igui{
    JFrame frame;
    JPanel  playerSide;
    JPanel dealerSide;

    public GameGui(JFrame frame){
        playerSide = new JPanel();
        playerSide.setBounds(1, frame.getHeight() / 2 + 1, frame.getWidth() - 1, frame.getHeight() / 2 - 1);
        playerSide.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        dealerSide = new JPanel();
        frame.add(playerSide);
        frame.add(dealerSide);
    }
    public void open() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    public void render(){
        playerSide.setBounds(1, frame.getHeight() / 2 + 1, frame.getWidth() - 1, frame.getHeight() / 2 - 1);

    }
}
