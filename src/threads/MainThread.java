package threads;

import gui.MainMenuGui;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private Thread main;
    private volatile boolean run = true; //visible across threads
    public static final int TICK = 50;
    public MainThread(){
      main = new Thread(() -> {
        try{
          while(run){
            Runnable task;
            while((task = tasks.poll()) != null){
              executeScheduledTasks(task);

            }
            MainMenuGui.render();

            Thread.sleep(TICK);
          }
        }
        catch (InterruptedException e){
          if(run){
            Thread.currentThread().interrupt();
          }
        }


      });
      main.start();

    }
    private void executeScheduledTasks(Runnable task){
      task.run();
    }
    public void scheduleTasks(Runnable task){
      this.tasks.add(task);
    }
    public void interruptThread(){
      run = false;
      main.interrupt();
    }
}
