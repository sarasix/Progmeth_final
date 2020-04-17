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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resloader.Resloader;

public class Menu {
	public static Scene gameScene;
	public AnchorPane gamePane;
	public static Stage gameStage = new Stage();
	public static ImageView buttonPlay = new ImageView(Resloader.buttonPlay); 
	
	public Menu() {
		gameStage = new Stage();
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152,648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
		
		
		createBackground();
		createPlay();
		
	}
	public void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgMenu, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));
	
	}
	private void createPlay() {
		buttonPlay.setX(800);
		buttonPlay.setY(400);
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				System.out.println("ok");
				GamePlay.gameStage.show();
				
				
				
			}
		};
		buttonPlay.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(buttonPlay);
		gamePane.getChildren().add(root);
	}
	
	
	
}
