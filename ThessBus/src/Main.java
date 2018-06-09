import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	 
	 static  Passenger loginUser= new Passenger("alex", "123", "fd", "2", "id", "232", "22", 40);
	 static  TicketInspector loginIns=null;

	public static void main(String[] args)
	{
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{
		ObjectOutputStream oos = null;
		FileOutputStream fout = new FileOutputStream("User.ser");
		oos = new ObjectOutputStream(fout);
		FileManager.InsertUser(loginUser, "User.ser");
		oos.close();
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