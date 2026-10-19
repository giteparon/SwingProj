package threads;

import gui.GameGui;
import gui.Igui;
import gui.MainMenuGui;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.SwingUtilities;

public class MainThread {
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private Thread main;
    public static ArrayList<Igui> guis;
    private volatile boolean run = true; //visible across threads
    public static final int TICK = 50;
    public MainThread(){
        try {
          while(run){
            Runnable task;
            if(guis != null){
                for(int i = 0; i < guis.size(); i++){
                    guis.get(i).render();
                }
            }


            while((task = tasks.poll()) != null){
              executeScheduledTasks(task);

            }


            Thread.sleep(TICK);
          }

        }
        catch(InterruptedException e){
            System.out.println(e);
      }
    }
    private void executeScheduledTasks(Runnable task){
      task.run();
    }
    public void scheduleTasks(Runnable task){
      this.tasks.add(task);
    }
  public void scheduleSwingTasks(Runnable task){
    SwingUtilities.invokeLater(task);
  }
    public void interruptThread(){
      run = false;
      main.interrupt();
    }
}
