package main;

import gui.GameGui;


import javax.swing.*;
import java.awt.*;
//THIS DOESNT WORK IN SCHOOL
//import javafx.application.Platform;
//import music.Song;
import threads.MainThread;
public class Main {
  public static MainThread mainThread = new MainThread();
  private static GameGui gameGui;
  public static void main(String[] args)
  {
    System.out.println("main started");
    //main thread init
      mainThread.scheduleSwingTasks(() -> {
        System.out.println("swing task running");
        JFrame mainFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        mainFrame.setSize((int)width, (int)height);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameGui = new GameGui(mainFrame);
        mainThread.guis.add(gameGui);
        gameGui.open();
        mainFrame.setVisible(true);
      });

    //javafx init thread THIS DOESNT WORK IN SCHOOL
     //THIS DOESNT WORK IN SCHOOL
    //THIS DOESNT WORK IN SCHOOL
//    Platform.startup(() -> {
//      System.out.println("JavaFX Toolkit initialized successfully.");
//    });
//    Platform.runLater(() -> {
//      try {
//        Song main = new Song("mainMenuMusic");
//        System.out.println("playing song");
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    });








  }
  public static GameGui getGameGuiInstance(){
    return gameGui;
  }
  public static MainThread getThreadInstance() {
    return mainThread;
  }
}