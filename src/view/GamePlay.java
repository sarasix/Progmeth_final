package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resloader.Resloader;


public class GamePlay {
	public static Scene gameScene;
	public AnchorPane gamePane;
	public static Stage gameStage = new Stage();
	
	
	public static ImageView buttonHowToPlay;
	public static ImageView table; 
	
	
	
	public GamePlay() {
		
		
		gameStage = new Stage();
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152,648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
		
		
		buttonHowToPlay = new ImageView(Resloader.buttonFree);
		table = new ImageView(Resloader.table); 
		
		
		createBackground();
		createHowToPlay();
		createTable();
		
	}
	
	public void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgGame, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));
	
	}
	
	private void createHowToPlay() {
		buttonHowToPlay.setX(900);
		buttonHowToPlay.setY(500);
		
		
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				
				
			}
		};
		buttonHowToPlay.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(buttonHowToPlay);
		gamePane.getChildren().add(root);
	}
	private void createTable() {
		
		table.setFitHeight(50);
		table.setFitWidth(50);
		
		Group root = new Group(table);
		root.setTranslateX(100);
		root.setTranslateY(100);
		gamePane.getChildren().add(root);
		
		
	}
	
	
}
