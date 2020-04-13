package resloader;

import javafx.scene.image.Image;

public class Resloader {
	public static final Image bgGame = new Image(ClassLoader.getSystemResource("project_2_background.png").toString()
			,1152,648, false, true);
	public static final Image buttonFree = new Image(ClassLoader.getSystemResource("apple.png").toString());
	public static final Image table = new Image(ClassLoader.getSystemResource("tarang.jpg").toString());;
	public static final Image bgMenu = new Image(ClassLoader.getSystemResource("bgGame.jpg").toString());;
	
	
}



