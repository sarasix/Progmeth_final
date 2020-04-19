package application;
import main.*;
import javafx.application.Application;
import javafx.stage.Stage;
import view.GamePlay;
import view.Menu;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,1280,720);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(GamePlay.gameScene);
			
			Menu m = new Menu();
			primaryStage = Menu.gameStage;
			
			
			
			//primaryStage = GamePlay.gameStage;
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}