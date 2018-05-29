

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LoginScreenController {
	
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	
	public void onClickedLogin(ActionEvent actionEvent) throws Exception{
		
		Stage primarystage = getStageFromEvent(actionEvent);
		/*primarystage.close();*/
		
		if(usernameField.getText().equals("") && passwordField.getText().equals("")) {
			
			/*Stage stage = new Stage();*/

			/*Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")), 600, 400); 

			stage .setTitle("Welcome to JavaFX!"); 
	        stage.setScene(scene); 
	        stage.sizeToScene(); 
			//stage.setMaximized(true);
	        stage.show();*/
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inspector.fxml"));
			LoginScreenController controller = new LoginScreenController();
			loader.setController(controller);
			
			Parent root = loader.load();
			Scene scene = new Scene(root, 600, 400);
			primarystage.setScene(scene);
			primarystage.setTitle("Inspector Screen");
			primarystage.show();
			
		}
		else {
		
			/*Popup popupwindow = new Popup();
			
			popupwindow.setX(300);
	        popupwindow.setY(200);
	        popupwindow.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
			popupwindow.show(getStageFromEvent(actionEvent));*/
			
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Λάθος όνομα και κωδικός");
	        alert.setHeaderText("Error");
	        alert.setContentText("Έχετε πληκτρολογήσει λανθασμένο κωδικό ή όνομα χρήστη");
	        Optional<ButtonType> result = alert.showAndWait();
	        
	        if (result.get() == ButtonType.OK)
	        	primarystage.show();
	    }
			
	}
	
	public void onHyperlinkSignUp(ActionEvent actionEvent) throws Exception{
		Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")), 600, 400); 

        Stage stage = new Stage();
		stage .setTitle("Welcome to JavaFX!"); 
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show();
	}
	
	/**********/
	public static Stage getStageFromEvent(ActionEvent actionEvent){
		Node  source = (Node)  actionEvent.getSource(); 
	    Stage stage  = (Stage) source.getScene().getWindow();
	    return stage;
	}
	
}
