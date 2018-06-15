import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	 
	static Passenger loginUser = null;
	static TicketInspector loginIns = null;

	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{
		Passenger temp = new Passenger("alex bla", "123", "fd@asd", "1234567890", "id", "1234567890", "22", 40);
		FileManager.InsertUser(temp, "Users.dat");
		
		/*TicketInspector tempInsp = new TicketInspector("Dionisis Antoniadis", "paok1998", "inspector12345");
		FileManager.InsertUser(tempInsp, "Users.dat");*/
		
		Parent root=null;
		root= FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus");
		primaryStage.show();
		
	}

	public static Stage getStagefromEvent(ActionEvent e) {
		Node source = (Node) e.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
}