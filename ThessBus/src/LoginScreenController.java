

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginScreenController implements Initializable{
	@FXML public Button loginButton;
	@FXML public TextField usernameField;
	@FXML public PasswordField passwordField;
	@FXML private Hyperlink visitorHyperlink;
	
	public void onClickedLogin(ActionEvent e) throws IOException  {
		
		Stage primarystage = Main.getStagefromEvent(e);
		primarystage.close();
		
		if(usernameField.getText().equals("1") && passwordField.getText().equals("1"))
		{
			Stage stage = getStageFromEvent(e);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
			Parent root = null;
			root = loader.load();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("ThessBus: Home");
			stage.show();
		}
		
		else if(usernameField.getText().equals("inspector") && passwordField.getText().equals("1")) {
			Stage stage = getStageFromEvent(e);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Inspector.fxml"));
			Parent root = null;
			root = loader.load();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("ThessBus: Inspector");
			stage.show();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Error", null, JOptionPane.WARNING_MESSAGE);
		}	
	}
	public void onClickedSignUp(ActionEvent actionEvent) throws Exception {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterScreen.fxml"));
		Parent root = null;
		root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Sign Up");
		primaryStage.show();
	}
	
	public void onHyperlinkVisitor(ActionEvent actionEvent) throws Exception {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("VisitorScreen.fxml"));
		Parent root = null;
		root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Visitor");
		primaryStage.show();
	}
	
	public static Stage getStageFromEvent(ActionEvent actionEvent){
		Node  source = (Node)  actionEvent.getSource(); 
	    Stage stage  = (Stage) source.getScene().getWindow();
	    return stage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
