package music;

//
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;





public class Song implements Isound{
  String fileName;
  Media song;
  MediaPlayer player;
  public Song(String fileName){
//    this.fileName = fileName;
//    this.song = new Media(new File("./resources/music/" + fileName + ".mp3").toURI().toString());
//    this.player = new MediaPlayer(song);
//    player.setCycleCount(MediaPlayer.INDEFINITE);
//    this.play();
//idfk
  }
  public void play(){
    player.play();
  }
  public void stop(){
    player.stop();


  }
  public void loop(boolean toggle){
    if(toggle){
      this.stop();
      player.setCycleCount(MediaPlayer.INDEFINITE);
      this.play();
    }
    else{
      this.stop();
      player.setCycleCount(1);
      this.play();
    }

  }
}
