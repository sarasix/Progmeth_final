package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.Menu;

public class MainApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Menu.load();
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