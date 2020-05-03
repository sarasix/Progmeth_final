package view;

import java.lang.Character.Subset;
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
import javafx.scene.SubScene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
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
	public static ImageView lamp0;
	public static ImageView lamp1;
	public static ImageView lamp2;
	public static ImageView lamp3;
	public static ImageView lamp4;
	public static ImageView lamp5;
	public static ImageView lamp6;
	public static ImageView lamp7;

	public static ImageView exitBarricade0;
	public static ImageView exitBarricade1;
	public static ImageView exitBarricade2;
	public static ImageView holeCover0;
	public static ImageView holeCover1;
	public static ImageView holeCover2;
	public static ImageView holeCover3;
	public static ImageView holeCover4;
	public static ImageView itemSelected;
	public static Scene subScene;
	public static boolean queueForExitItem;
	public static Stage subStage = new Stage(StageStyle.TRANSPARENT);
	public static AnchorPane subPane = new AnchorPane();

	public static ImageView buttonHowToPlay = new ImageView(Resloader.buttonFree);
	public static ImageView table = new ImageView(Resloader.table);
	public static ImageView buttonPlay = new ImageView(Resloader.buttonPlay);
	public static ImageView[][] tables = new ImageView[7][13];

	public static Stage card4 = new Stage();
	public static ArrayList<String> order;
	public static int round = 0;
	public static ImageView ivRound;
	public static int turn = 1;
	public static ImageView detective = new ImageView(Resloader.detective);
	public static ImageView jack = new ImageView(Resloader.jack);
	public static ImageView arrowOne;
	public static ImageView arrowTwo;
	public static ImageView arrowThree;
	public static ImageView arrowFour;
	public static ImageView arrowFive;
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);

	public static ArrayList<Integer> chaSel = new ArrayList<Integer>();
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

	public static ArrayList<ImageView> isChoice = new ArrayList<ImageView>();
	public static ArrayList<ImageView> missItem = new ArrayList<ImageView>();

	public static ImageView conan = new ImageView(Resloader.conan);
	public static ImageView haibara = new ImageView(Resloader.haibara);
	public static ImageView gin = new ImageView(Resloader.gin);
	public static ImageView kid = new ImageView(Resloader.kid);
	public static ImageView shadowMan = new ImageView(Resloader.shadowMan);
	public static ImageView kogoro = new ImageView(Resloader.kogoro);
	public static ImageView ran = new ImageView(Resloader.ran);
	public static ImageView heiji = new ImageView(Resloader.heiji);
	public static ImageView lightHaibara = new ImageView(Resloader.lightH);

	public static void load() {
		gameStage = new Stage();
		gameStage.setResizable(false);
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, 1152, 648);
		gameStage.setScene(gameScene);
		gameStage.setTitle("Game");

		createBackground();
		createTable();
		createHowToPlay();
		createTableChoice();
		createMissItem();

		ImageView choiceTitle = new ImageView(Resloader.choiceTitle);
		choiceTitle.setX(15);
		choiceTitle.setY(15);
		gamePane.getChildren().add(choiceTitle);

		subStage.setScene(new Scene(subPane, Color.TRANSPARENT));
	}

	public static void createBackground() {
		BackgroundImage background = new BackgroundImage(Resloader.bgGame, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		gamePane.setBackground(new Background(background));

	}

	private static void createHowToPlay() {
		buttonHowToPlay.setX(120);
		buttonHowToPlay.setY(530);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				createSubSceneHowToPlay(Resloader.ginability);
			}
		};
		buttonHowToPlay.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		Group root = new Group(buttonHowToPlay);
		gamePane.getChildren().add(root);
	}

	private static void createTable() {

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 13; j++) {
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

				tempTable.setX(145 + 66 * j);
				tempTable.setY(100 + 66 * i);

				tables[i][j] = tempTable;
				Group root = new Group(tables[i][j]);
				gamePane.getChildren().add(root);

			}
		}
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 13; j++) {

				if (Map.m2 != null) {
					if (Map.m2[i][j] instanceof Item) {
						if (Map.m2[i][j] instanceof Lamp) {

							if (((Lamp) Map.m2[i][j]).getNumber() == 0) {
								lamp0 = new ImageView(Resloader.lamp);
								lamp0.setFitHeight(60);
								lamp0.setFitWidth(60);
								lamp0.setX(148 + 66 * j);
								lamp0.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp0);
								EventHandler<MouseEvent> l0 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp0;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(0);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp0.addEventFilter(MouseEvent.MOUSE_RELEASED, l0);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 1) {
								lamp1 = new ImageView(Resloader.lamp);
								lamp1.setFitHeight(60);
								lamp1.setFitWidth(60);
								lamp1.setX(148 + 66 * j);
								lamp1.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp1);
								EventHandler<MouseEvent> l1 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp1;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(1);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp1.addEventFilter(MouseEvent.MOUSE_RELEASED, l1);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 2) {
								lamp2 = new ImageView(Resloader.lamp);
								lamp2.setFitHeight(60);
								lamp2.setFitWidth(60);
								lamp2.setX(148 + 66 * j);
								lamp2.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp2);
								EventHandler<MouseEvent> l2 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp2;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(2);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp2.addEventFilter(MouseEvent.MOUSE_RELEASED, l2);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 3) {
								lamp3 = new ImageView(Resloader.lamp);
								lamp3.setFitHeight(60);
								lamp3.setFitWidth(60);
								lamp3.setX(148 + 66 * j);
								lamp3.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp3);
								EventHandler<MouseEvent> l3 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp3;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(3);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp3.addEventFilter(MouseEvent.MOUSE_RELEASED, l3);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 4) {
								lamp4 = new ImageView(Resloader.lamp);
								lamp4.setFitHeight(60);
								lamp4.setFitWidth(60);
								lamp4.setX(148 + 66 * j);
								lamp4.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp4);
								EventHandler<MouseEvent> l4 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp4;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(4);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp4.addEventFilter(MouseEvent.MOUSE_RELEASED, l4);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 5) {
								lamp5 = new ImageView(Resloader.lamp);
								lamp5.setFitHeight(60);
								lamp5.setFitWidth(60);
								lamp5.setX(148 + 66 * j);
								lamp5.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp5);
								EventHandler<MouseEvent> l5 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp5;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(5);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp5.addEventFilter(MouseEvent.MOUSE_RELEASED, l5);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 6) {
								lamp6 = new ImageView(Resloader.lamp);
								lamp6.setFitHeight(60);
								lamp6.setFitWidth(60);
								lamp6.setX(148 + 66 * j);
								lamp6.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp6);
								EventHandler<MouseEvent> l6 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp6;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(6);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp6.addEventFilter(MouseEvent.MOUSE_RELEASED, l6);
							}
							if (((Lamp) Map.m2[i][j]).getNumber() == 7) {
								lamp7 = new ImageView(Resloader.lamp);
								lamp7.setFitHeight(60);
								lamp7.setFitWidth(60);
								lamp7.setX(148 + 66 * j);
								lamp7.setY(100 + 66 * i);
								gamePane.getChildren().add(lamp7);
								EventHandler<MouseEvent> l7 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 3) {
											itemSelected = lamp7;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findLampForTurn(7);
											createHighLightFieldForLamp();
										}

									}
								};
								lamp7.addEventFilter(MouseEvent.MOUSE_RELEASED, l7);
							}
						}
						if (Map.m2[i][j] instanceof ExitBarricade) {
							if (((ExitBarricade) Map.m2[i][j]).getNumber() == 0) {
								exitBarricade0 = new ImageView(Resloader.exitBarricade);
								exitBarricade0.setFitHeight(60);
								exitBarricade0.setFitWidth(60);
								exitBarricade0.setX(148 + 66 * j);
								exitBarricade0.setY(100 + 66 * i);
								gamePane.getChildren().add(exitBarricade0);
								EventHandler<MouseEvent> e0 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 5) {
											itemSelected = exitBarricade0;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findExitBarricadeForTurn(0);
											createHighLightFieldForExitBarricade();
										}

									}
								};
								exitBarricade0.addEventFilter(MouseEvent.MOUSE_RELEASED, e0);
							}
							if (((ExitBarricade) Map.m2[i][j]).getNumber() == 1) {
								exitBarricade1 = new ImageView(Resloader.exitBarricade);
								exitBarricade1.setFitHeight(60);
								exitBarricade1.setFitWidth(60);
								exitBarricade1.setX(148 + 66 * j);
								exitBarricade1.setY(100 + 66 * i);
								gamePane.getChildren().add(exitBarricade1);
								EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 5) {
											itemSelected = exitBarricade1;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findExitBarricadeForTurn(1);
											createHighLightFieldForExitBarricade();
										}

									}
								};
								exitBarricade1.addEventFilter(MouseEvent.MOUSE_RELEASED, e1);
							}
							if (((ExitBarricade) Map.m2[i][j]).getNumber() == 2) {
								exitBarricade2 = new ImageView(Resloader.exitBarricade);
								exitBarricade2.setFitHeight(60);
								exitBarricade2.setFitWidth(60);
								exitBarricade2.setX(148 + 66 * j);
								exitBarricade2.setY(100 + 66 * i);
								gamePane.getChildren().add(exitBarricade2);
								EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 5) {
											itemSelected = exitBarricade2;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findExitBarricadeForTurn(2);
											createHighLightFieldForExitBarricade();
										}

									}
								};
								exitBarricade2.addEventFilter(MouseEvent.MOUSE_RELEASED, e2);
							}
						}
						if (Map.m2[i][j] instanceof HoleCover) {
							if (((HoleCover) Map.m2[i][j]).getNumber() == 0) {
								holeCover0 = new ImageView(Resloader.holeCover);
								holeCover0.setFitHeight(60);
								holeCover0.setFitWidth(60);
								holeCover0.setX(148 + 66 * j);
								holeCover0.setY(100 + 66 * i);
								gamePane.getChildren().add(holeCover0);
								EventHandler<MouseEvent> h0 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 4) {
											itemSelected = holeCover0;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findHoleCoverForTurn(0);
											createHighLightFieldForHoleCover();
										}

									}
								};
								holeCover0.addEventFilter(MouseEvent.MOUSE_RELEASED, h0);
							}
							if (((HoleCover) Map.m2[i][j]).getNumber() == 1) {
								holeCover1 = new ImageView(Resloader.holeCover);
								holeCover1.setFitHeight(60);
								holeCover1.setFitWidth(60);
								holeCover1.setX(148 + 66 * j);
								holeCover1.setY(100 + 66 * i);
								gamePane.getChildren().add(holeCover1);
								EventHandler<MouseEvent> h1 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 4) {
											itemSelected = holeCover1;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findHoleCoverForTurn(1);
											createHighLightFieldForHoleCover();
										}

									}
								};
								holeCover1.addEventFilter(MouseEvent.MOUSE_RELEASED, h1);
							}
							if (((HoleCover) Map.m2[i][j]).getNumber() == 2) {
								holeCover2 = new ImageView(Resloader.holeCover);
								holeCover2.setFitHeight(60);
								holeCover2.setFitWidth(60);
								holeCover2.setX(148 + 66 * j);
								holeCover2.setY(100 + 66 * i);
								gamePane.getChildren().add(holeCover2);
								EventHandler<MouseEvent> h2 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 4) {
											itemSelected = holeCover2;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findHoleCoverForTurn(2);
											createHighLightFieldForHoleCover();
										}

									}
								};
								holeCover2.addEventFilter(MouseEvent.MOUSE_RELEASED, h2);
							}
							if (((HoleCover) Map.m2[i][j]).getNumber() == 3) {
								holeCover3 = new ImageView(Resloader.holeCover);
								holeCover3.setFitHeight(60);
								holeCover3.setFitWidth(60);
								holeCover3.setX(148 + 66 * j);
								holeCover3.setY(100 + 66 * i);
								gamePane.getChildren().add(holeCover3);
								EventHandler<MouseEvent> h3 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 4) {
											itemSelected = holeCover3;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findHoleCoverForTurn(3);
											createHighLightFieldForHoleCover();
										}

									}
								};
								holeCover3.addEventFilter(MouseEvent.MOUSE_RELEASED, h3);
							}
							if (((HoleCover) Map.m2[i][j]).getNumber() == 4) {
								holeCover4 = new ImageView(Resloader.holeCover);
								holeCover4.setFitHeight(60);
								holeCover4.setFitWidth(60);
								holeCover4.setX(148 + 66 * j);
								holeCover4.setY(100 + 66 * i);
								gamePane.getChildren().add(holeCover4);
								EventHandler<MouseEvent> h4 = new EventHandler<MouseEvent>() {
									public void handle(MouseEvent e) {
										if (abi == 4) {
											itemSelected = holeCover4;
											light.setBrightness(0.5);
											itemSelected.setEffect(light);
											Main.itemChosen = Main.findHoleCoverForTurn(4);
											createHighLightFieldForHoleCover();
										}

									}
								};
								holeCover4.addEventFilter(MouseEvent.MOUSE_RELEASED, h4);
							}
						}

					}

				}
			}

		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 13; j++) {
				if (Map.m2[i][j] instanceof Character) {

					if (Map.m2[i][j] instanceof Conan) {
						conan.setFitHeight(60);
						conan.setFitWidth(60);
						conan.setX(148 + 66 * j);
						conan.setY(100 + 66 * i);
						gamePane.getChildren().add(conan);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 2;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 2;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();
								}
							}
						};
						conan.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

					}
					if (Map.m2[i][j] instanceof Haibara) {
						haibara.setFitHeight(60);
						haibara.setFitWidth(60);
						haibara.setX(148 + 66 * j);
						haibara.setY(100 + 66 * i);
						lightHaibara.setX(140 + 66 * j);
						lightHaibara.setY(90 + 66 * i);
						lightHaibara.setScaleX(0.3);
						lightHaibara.setScaleY(0.3);
						gamePane.getChildren().addAll(haibara, lightHaibara);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 6;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 6;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						haibara.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

					}
					if (Map.m2[i][j] instanceof Ran) {
						ran.setFitHeight(60);
						ran.setFitWidth(60);
						ran.setX(148 + 66 * j);
						ran.setY(100 + 66 * i);
						gamePane.getChildren().add(ran);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 5;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 5;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						ran.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
					if (Map.m2[i][j] instanceof Kogoro) {
						kogoro.setFitHeight(60);
						kogoro.setFitWidth(60);
						kogoro.setX(148 + 66 * j);
						kogoro.setY(100 + 66 * i);
						gamePane.getChildren().add(kogoro);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 3;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 3;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						kogoro.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
					if (Map.m2[i][j] instanceof Heiji) {
						heiji.setFitHeight(60);
						heiji.setFitWidth(60);
						heiji.setX(148 + 66 * j);
						heiji.setY(100 + 66 * i);
						gamePane.getChildren().add(heiji);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 4;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 4;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						heiji.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
					if (Map.m2[i][j] instanceof Gin) {
						gin.setFitHeight(60);
						gin.setFitWidth(60);
						gin.setX(148 + 66 * j);
						gin.setY(100 + 66 * i);
						System.out.println(i + " " + j);
						gamePane.getChildren().add(gin);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 0;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 0;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						gin.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
					if (Map.m2[i][j] instanceof ShadowMan) {
						shadowMan.setFitHeight(60);
						shadowMan.setFitWidth(60);
						shadowMan.setX(148 + 66 * j);
						shadowMan.setY(100 + 66 * i);
						gamePane.getChildren().add(shadowMan);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 1;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 1;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						shadowMan.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
					if (Map.m2[i][j] instanceof Kid) {
						kid.setFitHeight(60);
						kid.setFitWidth(60);
						kid.setX(148 + 66 * j);
						kid.setY(100 + 66 * i);
						gamePane.getChildren().add(kid);
						EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {

								if (abi == 0) {
									cha = 7;
									abi = 10;
									createWalk();
								}
								if (abi == 1) {
									cha = 7;
									((CharacterWithAbility) Main.indexToCha(abi)).ability();
									createCardSel();

								}
							}
						};
						kid.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
					}
				}

			}
		}
	}

	public static void createWalkMax(Image i) {

		ImageView iv = setCenter(i);
		gamePane.getChildren().add(iv);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv);
				createWalk();
			}
		};

		iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

	}

	public static void createSubSceneHowToPlay(Image i) {

		ImageView iv = setCenter(i);
		iv.setScaleX(0.5);
		iv.setScaleY(0.5);

		gamePane.getChildren().add(iv);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv);

			}
		};

		iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

	}

	public static void createJack(Image i1, Image i2) {

		ImageView iv1 = setCenter(i1);
		gamePane.getChildren().add(iv1);
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv1);
				createJack_2(i2);
			}
		};

		iv1.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

	}

	public static void createJack_2(Image i) {

		ImageView iv = setCenter(i);
		iv.setScaleX(0.5);
		iv.setScaleY(0.5);

		gamePane.getChildren().add(iv);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv);
				Main.randomCard();

			}
		};

		iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

	}

	public static void createCard4(ImageView bg, int i1, int i2, int i3, int i4) {
		createRound();
		Main.removeItem();
		chaSel = new ArrayList<Integer>();
		cha1 = i1;
		cha2 = i2;
		cha3 = i3;
		cha4 = i4;
		createCardSel();
	}

	public static void createCardSel() {
		cha = -1;
		abi = -1;
		if (chaSel.size() == 4) {
			Main.isLight();

		} else {
			createTurn();
			abi = 10;
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
			c1.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
			c2.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler2);
			c3.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler3);
			c4.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler4);

			HBox subPane2 = new HBox();
			if (!chaSel.contains(1)) {
				subPane2.getChildren().addAll(c1);
			}
			if (!chaSel.contains(2)) {
				subPane2.getChildren().addAll(c2);
			}
			if (!chaSel.contains(3)) {
				subPane2.getChildren().addAll(c3);
			}
			if (!chaSel.contains(4)) {
				subPane2.getChildren().addAll(c4);
			}

			stPaneCard4.getChildren().add(subPane2);
			stPaneCard4.setAlignment(Pos.CENTER);

			subStage = new Stage(StageStyle.TRANSPARENT);
			subStage.setScene(new Scene(stPaneCard4, Color.TRANSPARENT));

			subStage.show();
		}

	}

	public static void createChosse() {

		Image i;
		if (cha == 6)
			i = Resloader.chooseBoth;
		else
			i = Resloader.choose;
		ImageView choose = setCenter(i);

		gamePane.getChildren().add(choose);

		System.out.print("character = " + Main.indexToName(cha));

		int choice = 0;
		for (int j = 0; j < 8; j++) {
			if (Main.allCharacter.get(j).getIsChoice()) {
				choice++;
			}
		}

		if (cha == 6 || cha == 7 || (cha == 2 && choice == 1)) {
			ImageView walk = new ImageView(Resloader.walkButton);

			walk.setX(576 - 60);
			walk.setY(324 + 20);
			EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {

					gamePane.getChildren().remove(choose);
					gamePane.getChildren().remove(walk);
					createWalkMax(Resloader.walk);

				}
			};
			walk.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
			gamePane.getChildren().addAll(walk);

		} else {
			ImageView walk = new ImageView(Resloader.walkButton);
			ImageView ability = new ImageView(Resloader.abilityButton);
			walk.setX(576 - 200);
			walk.setY(324 + 20);
			ability.setX(576 + 80);
			ability.setY(324 + 20);
			EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {

					gamePane.getChildren().remove(choose);
					gamePane.getChildren().remove(walk);
					gamePane.getChildren().remove(ability);
					createWalkMax(Resloader.walk);

				}
			};
			walk.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);

			EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(choose);
					gamePane.getChildren().remove(walk);
					gamePane.getChildren().remove(ability);
					ability();
				}
			};
			ability.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler2);
			gamePane.getChildren().addAll(walk, ability);
		}

	}

	public static void createWhereToGoToHole() {
		ImageView i = setCenter(Resloader.holeAppear);
		gamePane.getChildren().add(i);
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(i);

				ImageView h1 = new ImageView(Resloader.hilight);
				ImageView h2 = new ImageView(Resloader.hilight);
				ImageView h3 = new ImageView(Resloader.hilight);
				ImageView h4 = new ImageView(Resloader.hilight);
				ImageView h5 = new ImageView(Resloader.hilight);
				ImageView h6 = new ImageView(Resloader.hilight);
				ImageView h7 = new ImageView(Resloader.hilight);
				ImageView h8 = new ImageView(Resloader.hilight);
				h1.setX(144 + 66 * 5);
				h1.setY(100 + 66 * 0);

				h2.setX(144 + 66 * 9);
				h2.setY(100 + 66 * 1);

				h3.setX(144 + 66 * 1);
				h3.setY(100 + 66 * 3);

				h4.setX(144 + 66 * 5);
				h4.setY(100 + 66 * 3);

				h5.setX(144 + 66 * 7);
				h5.setY(100 + 66 * 3);

				h6.setX(144 + 66 * 11);
				h6.setY(100 + 66 * 3);

				h7.setX(144 + 66 * 3);
				h7.setY(100 + 66 * 5);

				h8.setX(144 + 66 * 7);
				h8.setY(100 + 66 * 6);

				gamePane.getChildren().addAll(h1, h2, h3, h4, h5, h6, h7, h8);
				EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {

						Main.holeColumn = 5;
						Main.holeRow = 0;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);

						}
					}
				};

				h1.addEventFilter(MouseEvent.MOUSE_RELEASED, e1);

				EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {

						Main.holeColumn = 9;
						Main.holeRow = 1;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h2.addEventFilter(MouseEvent.MOUSE_RELEASED, e2);

				EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						// gamePane.getChildren().removeAll(h1,h2,h3,h4,h5,h6,h7,h8);
						Main.holeColumn = 1;
						Main.holeRow = 3;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h3.addEventFilter(MouseEvent.MOUSE_RELEASED, e3);

				EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {

						Main.holeColumn = 5;
						Main.holeRow = 3;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h4.addEventFilter(MouseEvent.MOUSE_RELEASED, e4);

				EventHandler<MouseEvent> e5 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {

						Main.holeColumn = 7;
						Main.holeRow = 3;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h5.addEventFilter(MouseEvent.MOUSE_RELEASED, e5);

				EventHandler<MouseEvent> e6 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						// gamePane.getChildren().removeAll(h1,h2,h3,h4,h5,h6,h7,h8);
						Main.holeColumn = 11;
						Main.holeRow = 3;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h6.addEventFilter(MouseEvent.MOUSE_RELEASED, e6);

				EventHandler<MouseEvent> e7 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						// gamePane.getChildren().removeAll(h1,h2,h3,h4,h5,h6,h7,h8);
						Main.holeColumn = 3;
						Main.holeRow = 5;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};

				h7.addEventFilter(MouseEvent.MOUSE_RELEASED, e7);

				EventHandler<MouseEvent> e8 = new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {

						Main.holeColumn = 7;
						Main.holeRow = 6;
						Main.goToHole();
						if (Main.goToHole) {
							gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8);
							Main.goToHole = false;
							if (walk < Main.indexToCha(cha).getWalk())
								gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
						}
					}
				};
				h8.addEventFilter(MouseEvent.MOUSE_RELEASED, e8);

			}
		};

		i.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
	}

	public static void maxWalkAndGoToHole() {
		if (walk == Main.indexToCha(cha).getWalk()) {
			gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
			chaiv.setEffect(normal);
			if (cha == 6 && abi != 0) {
				abi = 6;
				ability();
			} else {
				createCardSel();
			}

		}

	}

	public static void createWalk() {

		arrowOne = new ImageView(Resloader.arrowUp);
		arrowTwo = new ImageView(Resloader.arrowLeft);
		arrowThree = new ImageView(Resloader.arrowDown);
		arrowFour = new ImageView(Resloader.arrowRight);
		arrowFive = new ImageView(Resloader.cancelWalk);

		arrowOne.setX(850);
		arrowOne.setY(562);

		arrowTwo.setX(800);
		arrowTwo.setY(562);

		arrowThree.setX(900);
		arrowThree.setY(562);

		arrowFour.setX(950);
		arrowFour.setY(562);

		arrowFive.setX(800);
		arrowFive.setY(603);

		arrowOne.setFitHeight(50);
		arrowTwo.setFitHeight(50);
		arrowThree.setFitHeight(50);
		arrowFour.setFitHeight(50);

		arrowOne.setFitWidth(50);
		arrowTwo.setFitWidth(50);
		arrowThree.setFitWidth(50);
		arrowFour.setFitWidth(50);

		arrowFive.setScaleX(0.7);
		arrowFive.setScaleY(0.7);

		chaiv = indexToIVBoard(cha);
		light.setBrightness(0.5);
		chaiv.setEffect(light);
		walk = 0;

		EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				dir1 = -1;
				dir2 = 0;
				Main.walk();

				if (walk >= Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
					chaiv.setEffect(normal);
					chaiv = indexToIVBoard(cha);
					if (!Main.jackEscape) {
						if (cha == 6) {
							abi = 6;
							ability();
						} else {

							createCardSel();
						}
					}
				}
			}
		};
		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				dir1 = 0;
				dir2 = -1;
				Main.walk();

				if (walk == Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
					chaiv.setEffect(normal);
					if (!Main.jackEscape) {
						if (cha == 6) {
							abi = 6;
							ability();
						} else {
							createCardSel();
						}
					}
				}

			}
		};
		EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				dir1 = 1;
				dir2 = 0;
				Main.walk();

				if (walk == Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
					chaiv.setEffect(normal);
					if (!Main.jackEscape) {
						if (cha == 6) {
							abi = 6;
							ability();
						} else {
							createCardSel();
						}
					}
				}
			}
		};
		EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				dir1 = 0;
				dir2 = 1;
				Main.walk();

				if (walk == Main.indexToCha(cha).getWalk()) {
					gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
					chaiv.setEffect(normal);
					if (!Main.jackEscape) {
						if (cha == 6 && abi != 0) {
							abi = 6;
							ability();
						} else {
							createCardSel();
						}
					}
				}
			}
		};
		EventHandler<MouseEvent> eventHandler5 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().removeAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);
				chaiv.setEffect(normal);
				if (!Main.jackEscape) {
					if (cha == 6) {
						abi = 6;
						ability();
					} else {
						createCardSel();
					}
				}
			}
		};
		arrowOne.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
		arrowTwo.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler2);
		arrowThree.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler3);
		arrowFour.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler4);
		arrowFive.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler5);

		gamePane.getChildren().addAll(arrowOne, arrowTwo, arrowThree, arrowFour, arrowFive);

	}

	public static void ability() {

		if (cha == 0) {
			abi = 0;
			ImageView iv;
			iv = setCenter(Resloader.ginability);
			gamePane.getChildren().add(iv);

			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(iv);
				}
			};

			iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

		}
		if (cha == 2) {
			abi = 2;
			((CharacterWithAbility) Main.allCharacter.get(2)).ability();

			ImageView ivMain = setCenter(Resloader.conanability);
			gamePane.getChildren().add(ivMain);

			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(ivMain);
					ImageView iv;
					iv = setCenter(indexToICard(Conan.choice));
					iv.setScaleX(0.5);
					iv.setScaleY(0.5);
					gamePane.getChildren().add(iv);
					EventHandler<MouseEvent> ell = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							gamePane.getChildren().remove(iv);

							createCardSel();
						}
					};
					iv.addEventFilter(MouseEvent.MOUSE_RELEASED, ell);
				}
			};

			ivMain.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);

		}
		if (cha == 6) {
			ImageView iv1 = new ImageView(Resloader.upLight);
			ImageView iv2 = new ImageView(Resloader.leftLight);
			ImageView iv3 = new ImageView(Resloader.downLight);
			ImageView iv4 = new ImageView(Resloader.rightLight);
			ImageView iv5 = new ImageView(Resloader.setLight);
			iv1.setX(850);
			iv1.setY(562);

			iv2.setX(800);
			iv2.setY(562);

			iv3.setX(900);
			iv3.setY(562);

			iv4.setX(950);
			iv4.setY(562);

			iv5.setX(800);
			iv5.setY(603);

			iv1.setFitHeight(50);
			iv2.setFitHeight(50);
			iv3.setFitHeight(50);
			iv4.setFitHeight(50);

			iv1.setFitWidth(50);
			iv2.setFitWidth(50);
			iv3.setFitWidth(50);
			iv4.setFitWidth(50);

			iv5.setScaleX(0.7);
			iv5.setScaleY(0.7);

			chaiv = indexToIVBoard(cha);
			light.setBrightness(0.5);
			chaiv.setEffect(light);

			Haibara haibara = (Haibara) Main.allCharacter.get(6);

			EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					lightHaibara.setRotate(0);
					haibara.setDirectionLight(3);
				}
			};
			EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					lightHaibara.setRotate(270);
					haibara.setDirectionLight(1);
				}
			};
			EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					lightHaibara.setRotate(180);
					haibara.setDirectionLight(4);
				}
			};
			EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					lightHaibara.setRotate(90);
					haibara.setDirectionLight(2);
				}
			};
			EventHandler<MouseEvent> eventHandler5 = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().removeAll(iv1, iv2, iv3, iv4, iv5);
					chaiv.setEffect(normal);
					createCardSel();

				}
			};
			iv1.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
			iv2.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler2);
			iv3.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler3);
			iv4.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler4);
			iv5.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler5);

			gamePane.getChildren().addAll(iv1, iv2, iv3, iv4, iv5);
		}
		if (cha == 1) {
			abi = 1;
			ImageView iv;
			iv = setCenter(Resloader.shadowManability);
			gamePane.getChildren().add(iv);

			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(iv);
				}
			};

			iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		}
		if (cha == 3) {
			abi = 3;
			ImageView iv = setCenter(Resloader.kogoroability);
			gamePane.getChildren().add(iv);
			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(iv);

				}
			};
			iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		}
		if (cha == 4) {

			abi = 4;
			ImageView iv = setCenter(Resloader.heijiability);
			gamePane.getChildren().add(iv);
			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(iv);

				}
			};
			iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		}
		if (cha == 5) {

			abi = 5;
			ImageView iv = setCenter(Resloader.ranability);
			gamePane.getChildren().add(iv);
			EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					gamePane.getChildren().remove(iv);

				}
			};
			iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		}

	}

	public static void createHighLightFieldForHoleCover() {
		ImageView h1 = new ImageView(Resloader.hilight);
		ImageView h2 = new ImageView(Resloader.hilight);
		ImageView h3 = new ImageView(Resloader.hilight);
		ImageView h4 = new ImageView(Resloader.hilight);
		ImageView h5 = new ImageView(Resloader.hilight);
		ImageView h6 = new ImageView(Resloader.hilight);
		ImageView h7 = new ImageView(Resloader.hilight);
		ImageView h8 = new ImageView(Resloader.hilight);
		queueForExitItem = false;

		
		
		h1.setX(144 + 66 * 5);
		h1.setY(100 + 66 * 0);
		
		h2.setX(144 + 66 * 9);
		h2.setY(100 + 66 * 1);

		h3.setX(144 + 66 * 1);
		h3.setY(100 + 66 * 3);

		h4.setX(144 + 66 * 5);
		h4.setY(100 + 66 * 3);

		h5.setX(144 + 66 * 7);
		h5.setY(100 + 66 * 3);

		h6.setX(144 + 66 * 11);
		h6.setY(100 + 66 * 3);

		h7.setX(144 + 66 * 3);
		h7.setY(100 + 66 * 5);

		h8.setX(144 + 66 * 7);
		h8.setY(100 + 66 * 6);
		ImageView cancelAbi = new ImageView(Resloader.cancelAbi);
		cancelAbi.setX(800);
		cancelAbi.setY(580);
		
		if(Map.m2[0][5]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[1][9]==null) {
			gamePane.getChildren().addAll(h2);
		}
		if(Map.m2[3][1]==null) {
			gamePane.getChildren().addAll(h3);
		}
		if(Map.m2[3][5]==null) {
			gamePane.getChildren().addAll(h4);
		}
		if(Map.m2[3][7]==null) {
			gamePane.getChildren().addAll(h5);
		}
		if(Map.m2[3][11]==null) {
			gamePane.getChildren().addAll(h6);
		}
		if(Map.m2[5][3]==null) {
			gamePane.getChildren().addAll(h7);
		}
		if(Map.m2[6][7]==null) {
			gamePane.getChildren().addAll(h8);
		}
		gamePane.getChildren().addAll(cancelAbi);
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 5;
				Main.indexItemField[0] = 0;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 9;
				Main.indexItemField[0] = 1;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 1;
				Main.indexItemField[0] = 3;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 5;
				Main.indexItemField[0] = 3;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e5 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 7;
				Main.indexItemField[0] = 3;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		EventHandler<MouseEvent> e6 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 11;
				Main.indexItemField[0] = 3;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e7 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 3;
				Main.indexItemField[0] = 5;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e8 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 7;
				Main.indexItemField[0] = 6;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> eAbi = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
				itemSelected.setEffect(normal);
				if (!queueForExitItem)
					createCardSel();

			}
		};
		h1.addEventFilter(MouseEvent.MOUSE_RELEASED, e1);
		h2.addEventFilter(MouseEvent.MOUSE_RELEASED, e2);
		h3.addEventFilter(MouseEvent.MOUSE_RELEASED, e3);
		h4.addEventFilter(MouseEvent.MOUSE_RELEASED, e4);
		h5.addEventFilter(MouseEvent.MOUSE_RELEASED, e5);
		h6.addEventFilter(MouseEvent.MOUSE_RELEASED, e6);
		h7.addEventFilter(MouseEvent.MOUSE_RELEASED, e7);
		h8.addEventFilter(MouseEvent.MOUSE_RELEASED, e8);
		
		cancelAbi.addEventFilter(MouseEvent.MOUSE_RELEASED, eAbi);

	}

	public static void createHighLightFieldForExitBarricade() {
		ImageView h1 = new ImageView(Resloader.hilight);
		ImageView h2 = new ImageView(Resloader.hilight);
		ImageView h3 = new ImageView(Resloader.hilight);
		ImageView h4 = new ImageView(Resloader.hilight);
		h1.setX(144 + 66 * 0);
		h1.setY(100 + 66 * 0);

		h2.setX(144 + 66 * 12);
		h2.setY(100 + 66 * 0);

		h3.setX(144 + 66 * 0);
		h3.setY(100 + 66 * 6);

		h4.setX(144 + 66 * 12);
		h4.setY(100 + 66 * 6);
		queueForExitItem = false;

		ImageView cancelAbi = new ImageView(Resloader.cancelAbi);
		cancelAbi.setX(800);
		cancelAbi.setY(580);
		if(Map.m2[0][0]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[0][12]==null) {
			gamePane.getChildren().addAll(h2);
		}
		if(Map.m2[6][0]==null) {
			gamePane.getChildren().addAll(h3);
		}
		if(Map.m2[6][12]==null) {
			gamePane.getChildren().addAll(h4);
		}
		gamePane.getChildren().addAll(cancelAbi);
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 0;
				Main.indexItemField[0] = 0;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 12;
				Main.indexItemField[0] = 0;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 0;
				Main.indexItemField[0] = 6;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 12;
				Main.indexItemField[0] = 6;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};
		EventHandler<MouseEvent> eAbi = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				gamePane.getChildren().removeAll(h1, h2, h3, h4, cancelAbi);
				itemSelected.setEffect(normal);
				if (!queueForExitItem)
					createCardSel();

			}
		};
		h1.addEventFilter(MouseEvent.MOUSE_RELEASED, e1);
		h2.addEventFilter(MouseEvent.MOUSE_RELEASED, e2);
		h3.addEventFilter(MouseEvent.MOUSE_RELEASED, e3);
		h4.addEventFilter(MouseEvent.MOUSE_RELEASED, e4);
		cancelAbi.addEventFilter(MouseEvent.MOUSE_RELEASED, eAbi);

	}

	public static void createHighLightFieldForLamp() {
		ImageView h1 = new ImageView(Resloader.hilight);
		ImageView h2 = new ImageView(Resloader.hilight);
		ImageView h3 = new ImageView(Resloader.hilight);
		ImageView h4 = new ImageView(Resloader.hilight);
		ImageView h5 = new ImageView(Resloader.hilight);
		ImageView h6 = new ImageView(Resloader.hilight);
		ImageView h7 = new ImageView(Resloader.hilight);
		ImageView h8 = new ImageView(Resloader.hilight);
		
		
		queueForExitItem = false;
		h1.setX(144 + 66 * 2);
		h1.setY(100 + 66 * 1);

		h2.setX(144 + 66 * 5);
		h2.setY(100 + 66 * 1);

		h3.setX(144 + 66 * 10);
		h3.setY(100 + 66 * 1);

		h4.setX(144 + 66 * 7);
		h4.setY(100 + 66 * 2);

		h5.setX(144 + 66 * 5);
		h5.setY(100 + 66 * 4);

		h6.setX(144 + 66 * 10);
		h6.setY(100 + 66 * 4);

		h7.setX(144 + 66 * 1);
		h7.setY(100 + 66 * 5);

		h8.setX(144 + 66 * 7);
		h8.setY(100 + 66 * 5);

		ImageView cancelAbi = new ImageView(Resloader.cancelAbi);
		cancelAbi.setX(800);
		cancelAbi.setY(580);

		if(Map.m2[1][2]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[1][5]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[1][10]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[2][7]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[4][5]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[4][10]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[5][1]==null) {
			gamePane.getChildren().addAll(h1);
		}
		if(Map.m2[5][7]==null) {
			gamePane.getChildren().addAll(h1);
		}
		gamePane.getChildren().addAll(cancelAbi);
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 2;
				Main.indexItemField[0] = 1;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h1.addEventFilter(MouseEvent.MOUSE_RELEASED, e1);

		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 5;
				Main.indexItemField[0] = 1;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h2.addEventFilter(MouseEvent.MOUSE_RELEASED, e2);

		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 10;
				Main.indexItemField[0] = 1;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h3.addEventFilter(MouseEvent.MOUSE_RELEASED, e3);

		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 7;
				Main.indexItemField[0] = 2;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h4.addEventFilter(MouseEvent.MOUSE_RELEASED, e4);

		EventHandler<MouseEvent> e5 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 5;
				Main.indexItemField[0] = 4;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h5.addEventFilter(MouseEvent.MOUSE_RELEASED, e5);

		EventHandler<MouseEvent> e6 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 10;
				Main.indexItemField[0] = 4;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h6.addEventFilter(MouseEvent.MOUSE_RELEASED, e6);

		EventHandler<MouseEvent> e7 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 1;
				Main.indexItemField[0] = 5;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h7.addEventFilter(MouseEvent.MOUSE_RELEASED, e7);

		EventHandler<MouseEvent> e8 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				Main.indexItemField[1] = 7;
				Main.indexItemField[0] = 5;
				queueForExitItem = Main.itemMove();

				if (queueForExitItem) {
					gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
					itemSelected.setEffect(normal);
					createCardSel();

				}
			}
		};

		h8.addEventFilter(MouseEvent.MOUSE_RELEASED, e8);
		EventHandler<MouseEvent> eAbi = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {

				gamePane.getChildren().removeAll(h1, h2, h3, h4, h5, h6, h7, h8, cancelAbi);
				itemSelected.setEffect(normal);
				if (!queueForExitItem)
					createCardSel();

			}
		};
		cancelAbi.addEventFilter(MouseEvent.MOUSE_RELEASED, eAbi);

	}

	public static void createIslight() {
		Image i = Resloader.jackLight;

		if (Main.MrJack.getIsLight() == false) {
			i = Resloader.jackDark;
		}

		ImageView iv = setCenter(i);

		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(iv);
				Main.isChoice();
			}
		};

		iv.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler);
		gamePane.getChildren().add(iv);
	}

	public static void createIsChoice() {
		Image i = Resloader.catchOrNext;
		ImageView iv = setCenter(Resloader.catchOrNext);
		StackPane pane = new StackPane();

		HBox h = new HBox();
		for (int j = 0; j < 8; j++) {
			if (Main.allCharacter.get(j).getIsChoice() == true) {
				ImageView c = indexToIVBoard_2(j);
				c.setFitHeight(60);
				c.setFitWidth(60);
				h.getChildren().add(c);
			}
		}

		ImageView yes = new ImageView(Resloader.catchJ);
		ImageView no = new ImageView(Resloader.next);

		yes.setX(576 + 80 + 20);
		yes.setY(380);
		no.setX(576 + 80 + 20);
		no.setY(430);

		EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(pane);
				gamePane.getChildren().remove(h);
				gamePane.getChildren().remove(yes);
				gamePane.getChildren().remove(no);
				GridPane c = new GridPane();
				StackPane st = new StackPane();
				st.getChildren().add(c);
				
				st.setAlignment(Pos.CENTER);
				
				Scene s = new Scene(st,800, 400);
				
				s.setFill(Color.TRANSPARENT);
		       
				subStage.setScene(s);
				//subStage.initStyle(StageStyle.TRANSPARENT);
				subStage.show();
				
			
				
				if (Main.indexToCha(0).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessGin);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(0).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 0, 0, 1, 1);
				}
				if (Main.indexToCha(1).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessShadowMan);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(1).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 1, 0, 1, 1);
				}
				if (Main.indexToCha(2).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessConan);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(2).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 2, 0, 1, 1);
				}
				if (Main.indexToCha(3).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessKogoro);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(3).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 3, 0, 1, 1);
				}
				if (Main.indexToCha(4).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessHeiji);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(4).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 0, 1, 1, 1);
				}
				if (Main.indexToCha(5).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessRan);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(5).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 1, 1, 1, 1);
				}
				if (Main.indexToCha(6).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessHaibara);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(6).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 2, 1, 1, 1);
				}
				if (Main.indexToCha(7).getIsChoice()) {
					ImageView k = setCenter(Resloader.guessKid);
					EventHandler<MouseEvent> l = new EventHandler<MouseEvent>() {
						public void handle(MouseEvent e) {
							subStage.hide();
							if (Main.indexToCha(7).getIsMrJack()) {
								ImageView g = setCenter(Resloader.win);
								gamePane.getChildren().add(g);
							} else {
								ImageView g = setCenter(Resloader.lose);
								gamePane.getChildren().add(g);
							}
						}
					};
					k.addEventFilter(MouseEvent.MOUSE_RELEASED, l);
					c.add(k, 3, 1, 1, 1);
				}

								

			}
		};

		EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				gamePane.getChildren().remove(pane);
				gamePane.getChildren().remove(h);
				gamePane.getChildren().remove(yes);
				gamePane.getChildren().remove(no);
				Main.randomCard();
			}
		};
		yes.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler1);
		no.addEventFilter(MouseEvent.MOUSE_RELEASED, eventHandler2);

		h.setLayoutX(576 - i.getWidth() / 2 + 40);
		h.setLayoutY(324 + i.getHeight() / 2 - 100);

		pane.getChildren().addAll(iv);

		pane.setLayoutX(576 - i.getWidth() / 2);
		pane.setLayoutY(324 - i.getHeight() / 2);
		gamePane.getChildren().addAll(pane, h, yes, no);
	}

	public static void createTableChoice() {

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

		for (int i = 0; i < 8; i++) {
			isChoice.get(i).setX(50);
			isChoice.get(i).setY(50 + i * 70);
			isChoice.get(i).setFitHeight(60);
			isChoice.get(i).setFitWidth(60);
			gamePane.getChildren().add(isChoice.get(i));
		}

	}

	public static void createMissItem() {
		ImageView iv1 = new ImageView(Resloader.eightMiss);
		ImageView iv2 = new ImageView(Resloader.sevenMiss);
		ImageView iv3 = new ImageView(Resloader.sixMiss);
		ImageView iv4 = new ImageView(Resloader.fiveMiss);
		ImageView iv5 = new ImageView(Resloader.fourMiss);
		ImageView iv6 = new ImageView(Resloader.threeMiss);
		ImageView iv7 = new ImageView(Resloader.twoMiss);
		ImageView iv8 = new ImageView(Resloader.oneMiss);

		missItem.add(iv1);
		missItem.add(iv2);
		missItem.add(iv3);
		missItem.add(iv4);
		missItem.add(iv5);
		missItem.add(iv6);
		missItem.add(iv7);
		missItem.add(iv8);

		ImageView title = new ImageView(Resloader.titleMiss);

		title.setX(830);
		title.setY(15);
		gamePane.getChildren().add(title);
		for (int i = 0; i < 8; i++) {
			missItem.get(i).setX(1045);
			missItem.get(i).setY(50 + i * 70);
			missItem.get(i).setFitHeight(60);
			missItem.get(i).setFitWidth(60);
			gamePane.getChildren().add(missItem.get(i));
		}
	}

	public static void createTurn() {
		detective.setX(425);
		detective.setY(580);
		jack.setX(425);
		jack.setY(580);

		if (round % 2 == 0) {
			if (Main.order1.get(chaSel.size()) == "D") {
				if (turn == 2) {
					gamePane.getChildren().add(detective);
					gamePane.getChildren().remove(jack);
					turn = 1;
				}

			} else {
				if (turn == 1) {
					gamePane.getChildren().add(jack);
					gamePane.getChildren().remove(detective);
					turn = 2;
				}
			}

		}
		if (round % 2 == 1) {
			if (Main.order2.get(chaSel.size()) == "D") {
				if (turn == 2) {
					gamePane.getChildren().add(detective);
					gamePane.getChildren().remove(jack);
					turn = 1;
				}

			} else {
				if (turn == 1) {
					gamePane.getChildren().add(jack);
					gamePane.getChildren().remove(detective);
					turn = 2;
				}
			}

		}

	}

	public static void createRound() {
		ImageView iv = new ImageView();
		gamePane.getChildren().remove(ivRound);
		if (round == 1) {
			iv = new ImageView(Resloader.n1);
		}
		if (round == 2) {
			iv = new ImageView(Resloader.n2);
		}
		if (round == 3) {
			iv = new ImageView(Resloader.n3);
		}
		if (round == 4) {
			iv = new ImageView(Resloader.n4);
		}
		if (round == 5) {
			iv = new ImageView(Resloader.n5);
		}
		if (round == 6) {
			iv = new ImageView(Resloader.n6);
		}
		if (round == 7) {
			iv = new ImageView(Resloader.n7);
		}
		if (round == 8) {
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

		int x = (int) i.getWidth();
		int y = (int) i.getHeight();
		ImageView iv = new ImageView(i);

		iv.setX(576 - x / 2);
		iv.setY(324 - y / 2);

		return iv;
	}

	public static ImageView indexToIVCard(int i) {
		ImageView iv = new ImageView();
		if (i == 0) {
			iv = new ImageView(Resloader.ginCard);
		}
		if (i == 1) {
			iv = new ImageView(Resloader.shadowManCard);
		}
		if (i == 2) {
			iv = new ImageView(Resloader.conanCard);
		}
		if (i == 3) {
			iv = new ImageView(Resloader.kogoroCard);
		}
		if (i == 4) {
			iv = new ImageView(Resloader.heijiCard);
		}
		if (i == 5) {
			iv = new ImageView(Resloader.ranCard);
		}
		if (i == 6) {
			iv = new ImageView(Resloader.haibaraCard);
		}
		if (i == 7) {
			iv = new ImageView(Resloader.kidCard);
		}

		iv.setFitHeight(366);
		iv.setFitWidth(300);
		return iv;
	}

	public static ImageView indexToIVBoard(int i) {
		ImageView iv = new ImageView();
		if (i == 0) {
			iv = gin;
		}
		if (i == 1) {
			iv = shadowMan;
		}
		if (i == 2) {
			iv = conan;
		}
		if (i == 3) {
			iv = kogoro;
		}
		if (i == 4) {
			iv = heiji;
		}
		if (i == 5) {
			iv = ran;
		}
		if (i == 6) {
			iv = haibara;
		}
		if (i == 7) {
			iv = kid;
		}

		return iv;

	}

	public static ImageView indexToIVBoard_2(int i) {
		ImageView iv = new ImageView();
		if (i == 0) {
			iv = new ImageView(Resloader.gin);
		}
		if (i == 1) {
			iv = new ImageView(Resloader.shadowMan);
		}
		if (i == 2) {
			iv = new ImageView(Resloader.conan);
		}
		if (i == 3) {
			iv = new ImageView(Resloader.kogoro);
		}
		if (i == 4) {
			iv = new ImageView(Resloader.heiji);
		}
		if (i == 5) {
			iv = new ImageView(Resloader.ran);
		}
		if (i == 6) {
			iv = new ImageView(Resloader.haibara);
		}
		if (i == 7) {
			iv = new ImageView(Resloader.kid);
		}

		return iv;

	}

	public static Image indexToICard(int i) {
		Image im = Resloader.gin;
		if (i == 0) {
			im = Resloader.ginCard;
		}
		if (i == 1) {
			im = Resloader.shadowManCard;
		}
		if (i == 2) {
			im = Resloader.conanCard;
		}
		if (i == 3) {
			im = Resloader.kogoroCard;
		}
		if (i == 4) {
			im = Resloader.heijiCard;
		}
		if (i == 5) {
			im = Resloader.ranCard;
		}
		if (i == 6) {
			im = Resloader.haibaraCard;
		}
		if (i == 7) {
			im = Resloader.kidCard;
		}

		return im;

	}

}
