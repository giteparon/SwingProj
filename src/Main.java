import gui.MainMenuGui;

import javax.swing.*;
import java.awt.*;
import javafx.application.Platform;
import music.Song;
import threads.MainThread;
// Main class
class Main {

  // Main driver method
  public static void main(String[] args)
  {
    //main thread init
    MainThread mainThread = new MainThread();
    mainThread.scheduleTasks(() -> {
      JFrame mainFrame = new JFrame();
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      double width = screenSize.getWidth();
      double height = screenSize.getHeight();
      mainFrame.setSize((int)width, (int)height);
      mainFrame.setResizable(true);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setVisible(true);
      MainMenuGui mainMenuGui = new MainMenuGui(mainFrame);

    });
    //javafx init thread
    Platform.startup(() -> {
      System.out.println("JavaFX Toolkit initialized successfully.");
    });
    Platform.runLater(() -> {
      try {
        Song main = new Song("mainMenuMusic");
        System.out.println("playing song");
      } catch (Exception e) {
        e.printStackTrace();
      }
    });








  }
}