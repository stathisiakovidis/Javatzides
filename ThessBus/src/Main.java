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
		Passenger temp = new Passenger("alex", "123", "fd", "2", "id", "232", "22", 40);
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = new FileOutputStream("Users.dat");
		oos = new ObjectOutputStream(fout);
		FileManager.InsertUser(temp, "Users.dat");
		oos.close();
		Parent root=null;
		root= FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus");
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Alert");
				alert.setHeaderText(null);
				alert.setContentText("Θες σίγουρα να βγεις;");
				
		        Optional<ButtonType> result = alert.showAndWait();
		        
				if(result.get() == ButtonType.OK) {
					if(Main.loginUser != null) {
						MainController controller = new MainController();
						Passenger temp = new Passenger(Main.loginUser.getUsername(), Main.loginUser.getPassword(), 
													   Main.loginUser.getEmail(), Main.loginUser.getCardNum(), 
												   	   Main.loginUser.getId(), Main.loginUser.getPhoneNum(), 
												   	   Main.loginUser.getPassport(), Main.loginUser.getBalance());
					
						FileManager.updatePassenger(loginUser, "Users.dat", temp);
						FileManager.insertProducts(Main.loginUser.getUsername(), Main.loginUser.getProducts(), "Products.dat");
						FileManager.updateFines(Main.loginUser.getUsername(), Main.loginUser.getFines(), "Fines.dat");
					}
				}
				else
					arg0.consume();
			}
		});
		primaryStage.show();
		
	}

	public static Stage getStagefromEvent(ActionEvent e) {
		Node source = (Node) e.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
}