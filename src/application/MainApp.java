package application;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.Menu;

public class MainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Menu.load();
			Media musicMenu = new Media(ClassLoader.getSystemResource("MusicMenu.mp3").toString());
			MediaPlayer mp = new MediaPlayer(musicMenu);
			mp.play();
			
			primaryStage = Menu.gameStage;
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}