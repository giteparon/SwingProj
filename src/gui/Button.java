package gui;

import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Button extends JButton {
  private boolean pressed = false;
  private String path;
  ImageIcon icon;
  public Button(String path) {
    this.path = path;
    ImageIcon icon = new ImageIcon(path);
    this.icon = icon;
    super(icon);
    this.setMargin(new Insets(0, 0, 0, 0));
    this.setBorder(null);
    this.setBorderPainted(false);
    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.addActionListener(e -> {
      handlePress();
    });
  }
  public abstract void handlePress();
  public void changeIcon(String path) {
    ImageIcon icon = new ImageIcon(path);
    this.setIcon(icon);
  }

}
