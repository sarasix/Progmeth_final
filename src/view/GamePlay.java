package view;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.*;
import character.Character;
import initial.Initial;
import item.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
	public static ArrayList<String> order ;
	public static int round = 0;
	public static ImageView ivRound;
	
	
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);	
	//private static int randomNumber;
	
	public static ArrayList <Integer> chaSel = new ArrayList<Integer> ();
	public static int cha = 0;
	public static ImageView chaiv;
	public static int walk = 0;
	public static int dir1 = 0;
	public static int dir2 = 0;
	public static int cha1;
	public static int cha2;
	public static int cha3;
	public static int cha4;
	public static ColorAdjust light = new ColorAdjust();
	public static ColorAdjust normal = new ColorAdjust(); 
	
	public static int abi = 10;
	
	public static ArrayList < ImageView > isChoice = new ArrayList <ImageView>();
	
	
	public static ImageView conan = new ImageView(Resloader.conan);
	public static ImageView haibara = new ImageView(Resloader.haibara);
	public static ImageView gin = new ImageView(Resloader.gin);
	public static ImageView kid = new ImageView(Resloader.kid);
	public static ImageView shadowMan = new ImageView(Resloader.shadowMan);
	public static ImageView kogoro = new ImageView(Resloader.kogoro);
	public static ImageView ran = new ImageView(Resloader.ran);
	public static ImageView heiji = new ImageView(Resloader.heiji);
	
	public GamePlay() {
		
		
		gameStage = new Stage();
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152,648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");
			
		createBackground();
		createTable();
		createHowToPlay();
		createIsChoice();
		
		subStage.setScene(new Scene(subPane,Color.TRANSPARENT));
		
	}
	
	
	public void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgGame, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));
	
	}
	
	private void createHowToPlay() {
		buttonHowToPlay.setX(120);
		buttonHowToPlay.setY(530);
			
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				
				createSubScene(buttonPlay);
			}
		};
		buttonHowToPlay.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
	
		Group root = new Group(buttonHowToPlay);
		gamePane.getChildren().add(root);
	}
	private static void createTable() {
		//Initial initial = new Initial();
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
				
				
				
				
			}
		}
		for(int i=0;i<7;i++) {
			for(int j=0;j<13;j++) {
				ImageView tempTable2 = new ImageView();
					
				if(Map.m2!=null)
					{
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
								tempTable2.setFitHeight(60);
								tempTable2.setFitWidth(60);
							
								tempTable2.setX(148+66*j);
								tempTable2.setY(100+66*i);
								Group root2 = new Group(tempTable2);
								gamePane.getChildren().add(root2);
							
						}
						
					
				}
			}
		
	
		}
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<13;j++) {
				if(Map.m2[i][j] instanceof Character) {
					
					
					if(Map.m2[i][j] instanceof Conan) {
						conan.setFitHeight(60);
						conan.setFitWidth(60);
						conan.setX(148+66*j);
						conan.setY(100+66*i);	
						gamePane.getChildren().add(conan);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 2;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						conan.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
						
					}
					if(Map.m2[i][j] instanceof Haibara) {
						haibara.setFitHeight(60);
						haibara.setFitWidth(60);
						haibara.setX(148+66*j);
						haibara.setY(100+66*i);	
						gamePane.getChildren().add(haibara);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 6;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						haibara.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
						
					}
					if(Map.m2[i][j] instanceof Ran) {
						ran.setFitHeight(60);
						ran.setFitWidth(60);
						ran.setX(148+66*j);
						ran.setY(100+66*i);	
						gamePane.getChildren().add(ran);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 5;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						ran.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
					if(Map.m2[i][j] instanceof Kogoro) {
						kogoro.setFitHeight(60);
						kogoro.setFitWidth(60);
						kogoro.setX(148+66*j);
						kogoro.setY(100+66*i);	
						gamePane.getChildren().add(kogoro);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 3;
								if(abi == 0) {
									createWalk();
								}	
							}
						};
						kogoro.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
					if(Map.m2[i][j] instanceof Heiji) {
						heiji.setFitHeight(60);
						heiji.setFitWidth(60);
						heiji.setX(148+66*j);
						heiji.setY(100+66*i);	
						gamePane.getChildren().add(heiji);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 4;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						heiji.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
					if(Map.m2[i][j] instanceof Gin) {
						gin.setFitHeight(60);
						gin.setFitWidth(60);
						gin.setX(148+66*j);
						gin.setY(100+66*i);	
						System.out.println(i+" "+j);
						gamePane.getChildren().add(gin);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 0;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						gin.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
					if(Map.m2[i][j] instanceof ShadowMan) {
						shadowMan.setFitHeight(60);
						shadowMan.setFitWidth(60);
						shadowMan.setX(148+66*j);
						shadowMan.setY(100+66*i);	
						gamePane.getChildren().add(shadowMan);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 1;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						shadowMan.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
					if(Map.m2[i][j] instanceof Kid) {
						kid.setFitHeight(60);
						kid.setFitWidth(60);
						kid.setX(148+66*j);
						kid.setY(100+66*i);	
						gamePane.getChildren().add(kid);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
								cha = 7;
								if(abi == 0) {
									createWalk();
								}
							}
						};
						kid.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
					}
				}
			
			}
		}
	}
	public static void createSubPane(Image i){
		
		ImageView iv = setCenter(i);
		gamePane.getChildren().add(iv);
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv);
				
				
				
				light.setBrightness(0.5);	
				
				chaiv = indexToIVBoard(cha);
				chaiv.setEffect(light);
				//เพิ่มกรอบบ
				walk  = 0 ;
				createWalk();
						
				}
			};
				
		iv.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
				
		
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
				Main.randomCard();
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
		
		
	}
	public static void createIV(ImageView iv ,int x,int y) {
		
		iv.setX(x);
		iv.setY(y);
		
		Group root = new Group(iv);
		gamePane.getChildren().add(root);
		
	}
	////////////////////////
	public static void createCard4(ImageView bg,int i1,int i2,int i3 ,int i4) {	
		createRound(); 
		chaSel = new ArrayList<Integer>();
		cha1 = i1;
		cha2 = i2;
		cha3 = i3;
		cha4 = i4; 
		createCardSel();
	}
	public static void createCardSel() {
		
		
		if(chaSel.size()==4) {
			Main.isLight();
			Main.isChoice();
			Main.randomCard();
		}
		else {
			StackPane stPaneCard4 = new StackPane();
			
			ImageView c1 = indexToIVCard(cha1);
			ImageView c2 = indexToIVCard(cha2);
			ImageView c3 = indexToIVCard(cha3);
			ImageView c4 = indexToIVCard(cha4);
			  
			
		    EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
						chaSel.add(1);
						cha = cha1;
						createChosse();
						subStage.hide();
					}
			};
			EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
						chaSel.add(2);
						cha = cha2;
						createChosse();
						subStage.hide();
					}
			};
			EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
						chaSel.add(3);
						cha = cha3;
						createChosse();
						subStage.hide();
					}
			};
			EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
						chaSel.add(4);
						cha = cha4;
						createChosse();
						subStage.hide();
					}
			};
			c1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler1);
			c2.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler2);
			c3.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler3);
			c4.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler4);
		  
		    
		    HBox subPane2 = new HBox();
		    if(!chaSel.contains(1)) {
		    	subPane2.getChildren().addAll(c1);
		    }
		    if(!chaSel.contains(2)) {
		    	subPane2.getChildren().addAll(c2);
		    }
		    if(!chaSel.contains(3)) {
		    	subPane2.getChildren().addAll(c3);
		    }
		    if(!chaSel.contains(4)) {
		    	subPane2.getChildren().addAll(c4);
		    }
		    
		    stPaneCard4.getChildren().add(subPane2);    
		    stPaneCard4.setAlignment(Pos.CENTER);
		    
		    subStage = new Stage(StageStyle.TRANSPARENT);
			subStage.setScene(new Scene(stPaneCard4,Color.TRANSPARENT));
		    
			subStage.show();
		}
			
		
	}
	public static void createChosse() {	

		Image i = Resloader.choose;
		ImageView choose = setCenter(i);	
		gamePane.getChildren().add(choose);
		
		
		ImageView walk = new ImageView (Resloader.apple);
		ImageView ability = new ImageView (Resloader.apple);
		walk.setX(576-200);
		walk.setY(324+20);
		ability.setX(576+80);
		ability.setY(324+20);
		gamePane.getChildren().addAll(walk,ability);
		
		EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	

				
				gamePane.getChildren().remove(choose);
				gamePane.getChildren().remove(walk);
				gamePane.getChildren().remove(ability);
				createSubPane(Resloader.walk);			
				
				}
			};
		walk.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler1);
		
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(choose);
				gamePane.getChildren().remove(walk);
				gamePane.getChildren().remove(ability);
				ability();
			}
		};
		ability.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler2);
		
		
	}
	public static void createWalk(){
		
		ImageView iv1 = new ImageView(Resloader.apple);//^
		ImageView iv2 = new ImageView(Resloader.apple);//<
		ImageView iv3 = new ImageView(Resloader.apple);//v
		ImageView iv4 = new ImageView(Resloader.apple);//>
		ImageView iv5 = new ImageView(Resloader.apple);//x
		
		iv1.setX(970);
		iv1.setY(470);
		
		iv2.setX(920);
		iv2.setY(520);
		
		iv3.setX(970);
		iv3.setY(520);
		
		iv4.setX(1020);
		iv4.setY(520);
		
		iv5.setX(800);
		iv5.setY(520);
		
		System.out.println(cha+" "+Main.indexToName(cha)+" "+Main.indexToCha(cha).getWalk());
		
		
		EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	
				dir1 = -1;
				dir2 = 0;
				Main.walk();
				if(walk>=Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(iv1,iv2,iv3,iv4,iv5);
					chaiv.setEffect(normal);
					//chaiv = indexToIVBoard(cha); 
					createCardSel();
				}
			}
		};
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	
				dir1 = 0;
				dir2 = -1;
				Main.walk();
				if(walk==Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(iv1,iv2,iv3,iv4,iv5);
					chaiv.setEffect(normal);
					createCardSel();
				}
				
			}
		};
		EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	
				dir1 = 1;
				dir2 = 0;
				Main.walk();
				if(walk==Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(iv1,iv2,iv3,iv4,iv5);
					chaiv.setEffect(normal);
					createCardSel();
				}	
			}
		};
		EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	
				dir1 = 0;
				dir2 = 1;
				Main.walk();
				if(walk==Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(iv1,iv2,iv3,iv4,iv5);
					chaiv.setEffect(normal);
					createCardSel();
				}
			
			}
		};
		EventHandler<MouseEvent> eventHandler5 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {	
				gamePane.getChildren().removeAll(iv1,iv2,iv3,iv4,iv5);
				createCardSel();
				
			}
		};
		iv1.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler1);
		iv2.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler2);
		iv3.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler3);
		iv4.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler4);
		iv5.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler5); 
		
		gamePane.getChildren().addAll(iv1,iv2,iv3,iv4,iv5);
	  
	}
	public static void ability() {
		ImageView iv ;
		
		if(cha == 0) {
			abi = 0;
	
			iv = setCenter(Resloader.ginability);
			gamePane.getChildren().add(iv);
			
			
			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {	
					gamePane.getChildren().remove(iv);
				}
			};
			
			iv.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
			
		}
		
		
		
		
	}
	public static void createIsChoice() {
		
		ImageView iv1 = new ImageView(Resloader.gin);
		ImageView iv2 = new ImageView(Resloader.shadowMan);
		ImageView iv3 = new ImageView(Resloader.conan);
		ImageView iv4 = new ImageView(Resloader.kogoro);
		ImageView iv5 = new ImageView(Resloader.heiji);
		ImageView iv6 = new ImageView(Resloader.ran);
		ImageView iv7 = new ImageView(Resloader.haibara);
		ImageView iv8 = new ImageView(Resloader.kid);
		
		isChoice.add(iv1);
		isChoice.add(iv2);
		isChoice.add(iv3);
		isChoice.add(iv4);
		isChoice.add(iv5);
		isChoice.add(iv6);
		isChoice.add(iv7);
		isChoice.add(iv8);
		
		for(int i=0;i<8;i++) {
			isChoice.get(i).setX(50);
			isChoice.get(i).setY(50+i*70);
			isChoice.get(i).setFitHeight(60);
			isChoice.get(i).setFitWidth(60);
			gamePane.getChildren().add(isChoice.get(i));
		}		
	
	}
	public static void createRound(){
		ImageView iv = new ImageView();
		if(round==1) {
			iv = new ImageView(Resloader.n1);
		}
		if(round==2) {
			iv = new ImageView(Resloader.n2);
		}
		if(round==3) {
			iv = new ImageView(Resloader.n3);
		}
		if(round==4) {
			iv = new ImageView(Resloader.n4);
		}
		if(round==5) {
			iv = new ImageView(Resloader.n5);
		}
		if(round==6) {
			iv = new ImageView(Resloader.n6);
		}
		if(round==7) {
			iv = new ImageView(Resloader.n7);
		}
		if(round==8) {
			iv = new ImageView(Resloader.n8);
		}
		ivRound = iv;
		
		ivRound.setX(530);
		ivRound.setY(9);
		ivRound.setScaleX(0.7);
		ivRound.setScaleY(0.7);
		gamePane.getChildren().add(ivRound);
	}
	public static ImageView setCenter(Image i) {
		//gamePane.add(pane);
		int x = (int) i.getWidth();
		int y = (int) i.getHeight();
		ImageView iv = new ImageView(i);
		
		iv.setX(576-x/2);
		iv.setY(324-y/2);
	
		
		return iv;
	}

	public static ImageView indexToIVCard(int i) {
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
	public static ImageView indexToIVBoard(int i) {
		ImageView iv = new ImageView();
		if(i == 0 )
		{
			iv = gin;
		}
		if(i == 1 )
		{
			iv = shadowMan;
		}
		if(i == 2 )
		{
			iv = conan;
		}
		if(i == 3 )
		{
			iv = kogoro;
		}
		if(i == 4 )
		{
			iv = heiji;
		}
		if(i == 5 )
		{
			iv = ran;
		}
		if(i == 6 )
		{
			iv = haibara;
		}
		if(i == 7 )
		{
			iv = kid;
		}
		
		
		
		return iv;
		
	}
	
	
}
