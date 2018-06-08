import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable{
	@FXML public Button registerButton;
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
		if(passwordField1.getText().equals(passwordField2.getText()));{
			Passenger newuser = new Passenger(nameField.getText()+" "+surnameField.getText(), passwordField1.getText(), emailField.getText(), String id, String phoneNum, String passport, double balance);
		}s
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText(null);
			alert.setContentText("Passwords do not match");

			alert.showAndWait();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
		
}
