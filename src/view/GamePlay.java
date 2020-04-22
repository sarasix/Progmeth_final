package view;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.*;
import character.Character;
import controller.Controller;
import initial.Initial;
import item.*;
import item.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main;
import map.Map;
import resloader.Resloader;


public class GamePlay {
	public static Scene gameScene;
	public static AnchorPane gamePane;
	public static Stage gameStage = new Stage();
	
	public static Scene subScene ;
	
	
	public static Stage subStage = new Stage(StageStyle.TRANSPARENT);
    public static AnchorPane subPane = new AnchorPane();
	
	
	public static ImageView buttonHowToPlay = new ImageView(Resloader.buttonFree);
	public static ImageView table = new ImageView(Resloader.table);
	public static ImageView buttonPlay = new ImageView(Resloader.buttonPlay);
	public static ImageView[][] tables = new ImageView[7][13] ;
	
	public static Stage card4 = new Stage();
	public static int order = 0;
	
	
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);	
	private static int randomNumber;
	
	public static boolean start = false;
	
	public GamePlay() {
		
		
		gameStage = new Stage();
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152,648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
			
		createBackground();
		createHowToPlay();
		createTable();
		
		
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
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
				
				createSubScene(buttonPlay);
			}
		};
		buttonHowToPlay.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(buttonHowToPlay);
		gamePane.getChildren().add(root);
	}
	private void createTable() {
		Initial initial = new Initial();
		for(int i=0 ;i<7;i++) {
			for (int j=0 ;j<13;j++) {
				ImageView tempTable = new ImageView();
				if (Initial.m1[i][j] == 1) {
					tempTable = new ImageView(Resloader.table);
				}
				if (Initial.m1[i][j] == 2) {
					tempTable = new ImageView(Resloader.wall);
				}
				if (Initial.m1[i][j] == 3) {
					tempTable = new ImageView(Resloader.lampBase);
				}
				if (Initial.m1[i][j] == 4) {
					tempTable = new ImageView(Resloader.hole);
				}
				if (Initial.m1[i][j] == 5) {
					tempTable = new ImageView(Resloader.Exit);
				}
					
				tempTable.setFitHeight(64);
				tempTable.setFitWidth(64);
			
				tempTable.setX(145+66*j);
				tempTable.setY(100+66*i);
				
				
				tables[i][j] = tempTable ;
				Group root = new Group(tables[i][j]);
				gamePane.getChildren().add(root);
				
				ImageView tempTable2 = new ImageView();
				
				
				if(Map.m2!=null)
				{
					if(Map.m2[i][j] instanceof Item) {
						if(Map.m2[i][j] instanceof Item) {
							
							if(Map.m2[i][j] instanceof Lamp) {
								tempTable2 = new ImageView(Resloader.lamp);
							}
							if(Map.m2[i][j] instanceof ExitBarricade) {
								tempTable2 = new ImageView(Resloader.exitBarricade);
							}
							if(Map.m2[i][j] instanceof HoleCover) {
								tempTable2 = new ImageView(Resloader.holeCover);
							}
						}
					}
					if(Map.m2[i][j] instanceof Character) {
							
							if(Map.m2[i][j] instanceof Conan) {
								tempTable2 = new ImageView(Resloader.conan);
								
							}
							if(Map.m2[i][j] instanceof Haibara) {
								tempTable2 = new ImageView(Resloader.haibara);
							}
							if(Map.m2[i][j] instanceof Ran) {
								tempTable2 = new ImageView(Resloader.ran);
							}
							if(Map.m2[i][j] instanceof Kogoro) {
								tempTable2 = new ImageView(Resloader.kogoro);
							}
							if(Map.m2[i][j] instanceof Heiji) {
								tempTable2 = new ImageView(Resloader.heiji);
							}
							if(Map.m2[i][j] instanceof Gin) {
								tempTable2 = new ImageView(Resloader.gin);
							}
							if(Map.m2[i][j] instanceof ShadowMan) {
								tempTable2 = new ImageView(Resloader.shadowMan);
							}
							if(Map.m2[i][j] instanceof Kid) {
								tempTable2 = new ImageView(Resloader.kid);
							}
					}
					
				}
				
				tempTable2.setFitHeight(60);
				tempTable2.setFitWidth(60);
			
				tempTable2.setX(148+66*j);
				tempTable2.setY(100+66*i);
				Group root2 = new Group(tempTable2);
				gamePane.getChildren().add(root2);
				
			}
		}
		
	
	}
	public static void createSubScene(ImageView iv){
			
		Stage subStage = new Stage(StageStyle.TRANSPARENT);
	    AnchorPane subPane = new AnchorPane();
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				subStage.hide();
						
				}
			};
				
		iv.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
				
		subPane.getChildren().add(iv);
		//gameStage=subStage;
		subStage.show();
		
	}
	public static void createSubSceneEnd(ImageView iv){
		
		Stage subStage = new Stage(StageStyle.TRANSPARENT);
	    AnchorPane subPane = new AnchorPane();
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				subStage.hide();
				//
			
				//gamePane.getChildren().add(stPaneCard4);
				
				Main.randomCard();
				//Controller.order = 1;
				//Controller.loopRound();		
				}
			};
				
		iv.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
		
		subPane.getChildren().add(iv);
		
		subStage.show();
		
	}
	public static void createOverlabSubScane(ImageView iv1,ImageView iv2)
	{
		
		Stage subStage = new Stage(StageStyle.TRANSPARENT);
	    AnchorPane subPane = new AnchorPane();
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				subStage.hide();
				createSubSceneEnd(iv2);
						
				}
			};
				
		iv1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
				
		subPane.getChildren().add(iv1);
		//gameStage=subStage;
		subStage.show();
		
	}public static void createOverlabSubScane_2(ImageView iv1,int x,int y,ImageView iv2)
	{
		
		Stage subStage = new Stage(StageStyle.TRANSPARENT);
	    AnchorPane subPane = new AnchorPane();
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				subStage.hide();
				createSubSceneEnd(iv2);
						
				}
			};
				
		iv1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
		iv1.setX(x);
		iv1.setY(y);
		
		Group root = new Group(iv1);
		gamePane.getChildren().add(root);
		
		//subPane.getChildren().add(iv1);
		//gameStage=subStage;
		//subStage.show();
		
	}
	public static void createIV(ImageView iv ,int x,int y) {
		
		iv.setX(x);
		iv.setY(y);
		
		Group root = new Group(iv);
		gamePane.getChildren().add(root);
		
	}
	public static void createCard4(ImageView bg,ImageView c1,ImageView c2,ImageView c3 ,ImageView c4) {	
		 StackPane stPaneCard4 = new StackPane();
	    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
					createchosse();
					
				}
			};
		c1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
		c2.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
		c3.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
		c4.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	  

		HBox subPane1 = new HBox();
	    subPane1.getChildren().add(bg);
	    //subPane1.setAlignment(Pos.CENTER);
	    
	    HBox subPane2 = new HBox();
	    subPane2.getChildren().addAll(c1,c2,c3,c4);
	    //subPane2.setAlignment(Pos.CENTER);
	    
	    stPaneCard4.getChildren().addAll(subPane1,subPane2);    
	    stPaneCard4.setAlignment(Pos.CENTER);
	    
	    subStage = new Stage(StageStyle.TRANSPARENT);
		subStage.setScene(new Scene(stPaneCard4,Color.TRANSPARENT));
	    
		subStage.show();
		//createOverlabSubScane(new ImageView(Resloader.apple),new ImageView(Resloader.walk));
		
		
		
	}
	public static void createchosse() {
		Image i = Resloader.choose;
		AnchorPane subPane = new AnchorPane();

		ImageView iv = setCenter(i);
		subPane.getChildren().add(iv);
		
		gamePane.getChildren().add(subPane);

		subStage.hide();	
		
		
	}
	public static ImageView setCenter(Image i) {
		//gamePane.add(pane);
		int x = (int) i.getWidth();
		int y = (int) i.getHeight();
		ImageView iv = new ImageView(i);
		
		iv.setX(576-x/2);
		iv.setY(324-y/2);
	
		System.out.println( (int)iv.getFitHeight()/2);
		
		return iv;
	}

	public static ImageView indexToIV(int i) {
		ImageView iv = new ImageView();
		if(i == 0 )
		{
			iv = new ImageView(Resloader.ginCard);
		}
		if(i == 1 )
		{
			iv = new ImageView(Resloader.shadowManCard);
		}
		if(i == 2 )
		{
			iv = new ImageView(Resloader.conanCard);
		}
		if(i == 3 )
		{
			iv = new ImageView(Resloader.kogoroCard);
		}
		if(i == 4 )
		{
			iv = new ImageView(Resloader.heijiCard);
		}
		if(i == 5 )
		{
			iv = new ImageView(Resloader.ranCard);
		}
		if(i == 6 )
		{
			iv = new ImageView(Resloader.haibaraCard);
		}
		if(i == 7 )
		{
			iv = new ImageView(Resloader.kidCard);
		}
		
		
		iv.setFitHeight(366);
		iv.setFitWidth(300);
		return iv;
	}
	
	
}
