package threads;

import gui.GameGui;
import gui.Igui;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.SwingUtilities;

public class MainThread {
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private Thread main;
    public ArrayList<Igui> guis = new ArrayList<>();
    private volatile boolean run = true; //visible across threads
    public static final int TICK = 50;
    public MainThread(){
      Thread main = new Thread(() -> {// i have great plans for this thread TRUST
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
      });
      main.start();
      this.main = main;

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
