package view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.Main;
import resloader.Resloader;

public class Menu {
	public static Scene gameScene;
	public static AnchorPane gamePane;
	public static Stage gameStage;
	public static ImageView buttonPlay;
	public static AudioClip sound;

	public static void load() {
		gameStage = new Stage();
		gameStage.setResizable(false);
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152, 648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
		buttonPlay = new ImageView(Resloader.buttonPlay);
		sound = new AudioClip ("file:res/MusicMenu.mp3");
		createBackground();
		createPlay();	
		sound.setVolume(0.1);
		sound.play();
		

	}

	private static void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgMenu, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));

	}

	private static void createPlay() {
		buttonPlay.setX(100);
		buttonPlay.setY(500);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				GamePlay.load();
				GamePlay.gameStage.show();
				Main.start();
				gameStage.hide();
				sound.stop();
				
			}
		};
		buttonPlay.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		Group root = new Group(buttonPlay);
		gamePane.getChildren().add(root);
	}

}
