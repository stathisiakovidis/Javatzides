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
		//Passenger temp = new Passenger("alex bla", "123", "fd@asd", "1234567890", "id", "1234567890", "22", 40);
		//FileManager.InsertUser(temp, "Users.dat");
		
		TicketInspector tempInsp = new TicketInspector("Dionisis Antoniadis", "paok1998", "inspector1");
		FileManager.InsertUser(tempInsp, "Inspectors.dat");
		
		TicketInspector tempInsp1 = new TicketInspector("George Koulaxidis", "12345", "inspector2");
		FileManager.InsertUser(tempInsp1, "Inspectors.dat");
		
		TicketInspector tempInsp3 = new TicketInspector("Alex Ermidaras", "123456", "inspector3");
		FileManager.InsertUser(tempInsp3, "Inspectors.dat");
		
		TicketInspector tempInsp4 = new TicketInspector("Xristina Papapasxali", "2121", "inspector4");
		FileManager.InsertUser(tempInsp4, "Inspectors.dat");
		
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