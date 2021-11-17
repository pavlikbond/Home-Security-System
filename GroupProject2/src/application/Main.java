package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			primaryStage.setTitle("Security System");
			
			//Here is the Number Pad, I do have two blank buttons on there though. Got to fix that
			String[] keys = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "  ", "0", "  "};
			GridPane numPad = new GridPane();
			for (int i = 0; i <12; i++) {
				Button button = new Button(keys[i]);
				numPad.add(button, i % 3, (int) Math.ceil(i/3));
			}
			
	        root.setLeft(numPad);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
