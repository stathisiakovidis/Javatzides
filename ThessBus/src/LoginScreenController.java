

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
import javafx.stage.Stage;


public class LoginScreenController {
	
	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
	
	public void onClickedLogin(ActionEvent actionEvent) throws Exception{
		
		Stage primarystage = getStageFromEvent(actionEvent);
		/*primarystage.close();*/
		
		if(usernameField.getText().equals("") && passwordField.getText().equals("")) {
			
			Stage stage = new Stage();

			Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!")), 600, 400); 

			stage .setTitle("Welcome to JavaFX!"); 
	        stage.setScene(scene); 
	        stage.sizeToScene(); 
			//stage.setMaximized(true);
	        stage.show();
				
		}
		else {
		
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
