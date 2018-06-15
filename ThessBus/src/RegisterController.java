import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController extends MainController implements Initializable{
	@FXML public TextField nameField;
	@FXML public TextField surnameField;
	@FXML public TextField emailField;
	@FXML public PasswordField passwordField1;
	@FXML public PasswordField passwordField2;
	@FXML public TextField passportField;
	@FXML public TextField phoneField;
	@FXML public TextField idField;
	@FXML public TextField cardField;
	
	public void onClickedRegister(ActionEvent e) throws IOException  {
		if(nameField.getText().equals("")||surnameField.getText().equals("")||passwordField1.getText().equals("")||passwordField2.getText().equals(""))
		{
			showAlert("Complete the necessary fields");
			
		}
		else
		{
			if(passwordField1.getText().equals(passwordField2.getText())) {
				if(phoneField.getText().length()==10) {
					if(emailField.getText().contains("@")){
				    Main.loginUser = new Passenger(nameField.getText()+" "+surnameField.getText(), passwordField1.getText(), emailField.getText(), cardField.getText(), idField.getText(), phoneField.getText(), passportField.getText(),0);
					FileManager.InsertUser(Main.loginUser, "Users.dat");
					//appear the start screen when he register
			
					Stage primaryStage = getStageFromEvent(e);
					FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
					Parent root = null;
					root = loader.load();
			        StartScreenController ctrl = (StartScreenController)loader.getController();
					
					Scene scene = new Scene(root);
					primaryStage.setScene(scene);
					primaryStage.setTitle("ThessBus: StartScreen");
					primaryStage.show();
					System.out.println(Main.loginUser.getUsername());
			        }
					else 
					{
						showAlert("The email address is not valid");
					}
				}
				else
				{
					showAlert("The phone number must have 10 digits");
				}
			}
			else
			{
				showAlert("Passwords do not match");
			}
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	public void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Alert");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
		
}
