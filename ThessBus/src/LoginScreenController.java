

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginScreenController {
	@FXML public Button loginButton;
	@FXML public TextField usernameField;
	@FXML public PasswordField passwordField;
	
	public void onClickedLogin(ActionEvent e)  {
		
		Stage primarystage = Main.getStagefromEvent(e);
		primarystage.close();
		
		if(usernameField.getText().equals("1") && passwordField.getText().equals("1"))
		{
			try {
				Stage stage = new Stage();
				Parent root=null;
				root= FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("ThessBus: Home");
				stage.show();
					
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
		else {
		System.out.println("geia");
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
	
	public static Stage getStageFromEvent(ActionEvent actionEvent){
		Node  source = (Node)  actionEvent.getSource(); 
	    Stage stage  = (Stage) source.getScene().getWindow();
	    return stage;
	}
	
}
