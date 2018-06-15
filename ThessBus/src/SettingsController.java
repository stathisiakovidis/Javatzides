import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SettingsController extends MainController implements Initializable {
	@FXML private TextField nameField;
	@FXML private TextField subnameField;
	@FXML private TextField emailField;
	@FXML private TextField phoneField;
	@FXML private TextField idField;
	@FXML private TextField passportField;
	@FXML private TextField cardnumField;
	@FXML private PasswordField passwordField;
	@FXML private PasswordField confirmpasswordField;
	@FXML private Button saveButton;
	@FXML private Label usernameMenu;
	@FXML private Label balanceMenu;
	

	public void onClickSave(ActionEvent e) throws IOException
	{ 
		
		if(nameField.getText().equals("")||subnameField.getText().equals("")||passwordField.getText().equals("")||confirmpasswordField.getText().equals(""))
		{
			showAlert("Complete the necessary fields");
			
		}
		else
		{
			if(passwordField.getText().equals(confirmpasswordField.getText())) {
				if(phoneField.getText().length()==10) {
					if(emailField.getText().contains("@")){
					Passenger updatedPassenger = new Passenger(nameField.getText()+" "+subnameField.getText(), passwordField.getText(), emailField.getText(), cardnumField.getText(), idField.getText(), phoneField.getText(), passportField.getText(),Main.loginUser.getBalance());
					FileManager.updatePassenger(Main.loginUser, "Users.dat", updatedPassenger);
				    Main.loginUser.setNewData(nameField.getText()+" "+subnameField.getText(), passwordField.getText(), emailField.getText(),cardnumField.getText(), idField.getText(), phoneField.getText(), passportField.getText());
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
	public void initialize(URL location, ResourceBundle resources) {
		String name="", surname ="";
        StringTokenizer st = new StringTokenizer(Main.loginUser.getUsername());
        name = st.nextToken();
        surname = st.nextToken();
		nameField.setText(name);
		subnameField.setText(surname);
		emailField.setText(Main.loginUser.getEmail());
		phoneField.setText(Main.loginUser.getPhoneNum());
		idField.setText(Main.loginUser.getId());
		passportField.setText(Main.loginUser.getPassport());
		cardnumField.setText(Main.loginUser.getCardNum());
		usernameMenu.setText(Main.loginUser.getUsername());
		balanceMenu.setText(Double.toString(Main.loginUser.getBalance()));
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
