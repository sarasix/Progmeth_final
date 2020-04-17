package view;


import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resloader.Resloader;


public class GamePlay {
	public static Scene gameScene;
	public AnchorPane gamePane;
	public static Stage gameStage = new Stage();
	public static AnchorPane window;
	public static Scene subScene ;
	public static Stage subStage = new Stage();
	
	
	
	public static ImageView buttonHowToPlay = new ImageView(Resloader.buttonFree);;
	public static ImageView table = new ImageView(Resloader.table); ; 
	public static ImageView apple1 = new ImageView(Resloader.apple1);
	public static ImageView buttonPlay = new ImageView(Resloader.buttonPlay);
	public static ImageView[][] tables = new ImageView[7][13] ;
	
	
	public GamePlay() {
		
		
		gameStage = new Stage();
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152,648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
		
		window = new AnchorPane();
		subScene = new Scene(window,300,300);
		subStage.setScene(subScene);
		
		
		
		
		
		createBackground();
		createHowToPlay();
		createTable();
		//createSubScene();
		
	}
	
	public void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgGame, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));
	
	}
	
	private void createHowToPlay() {
		buttonHowToPlay.setX(20);
		buttonHowToPlay.setY(500);
		
		
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				
				
				ImageView resume1 = buttonPlay;
				
	            Stage subStage = new Stage(StageStyle.TRANSPARENT);
	            AnchorPane subPane = new AnchorPane();
				subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
				resume1.setX(10);
				resume1.setY(10);
				
				
				EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						subStage.hide();
						
					}
				};
				
				resume1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler1);
				
				subPane.getChildren().add(resume1);
				subStage.show();
			}
		};
		buttonHowToPlay.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(buttonHowToPlay);
		gamePane.getChildren().add(root);
	}
	private void createTable() {
		
		for(int i=0 ;i<7;i++) {
			for (int j=0 ;j<13;j++) {
				ImageView tempTable = new ImageView(Resloader.table);
				tempTable.setFitHeight(64);
				tempTable.setFitWidth(64);
			
				tempTable.setX(145+66*j);
				tempTable.setY(100+66*i);
				
				tables[i][j] = tempTable ;
				Group root = new Group(tables[i][j]);
				gamePane.getChildren().add(root);
				
				
			}
		}
		
	
		
	}
	public void createSubScene(){
		apple1.setX(300);
		apple1.setY(300);
		
		
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				
				
			}
		};
		apple1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(apple1);
		gamePane.getChildren().add(root);
		
	}
	
	
}
