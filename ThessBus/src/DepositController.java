import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class DepositController extends MainController implements Initializable{

	@FXML private Label balanceLabel;
	@FXML private Label usernameMenu;
	@FXML private Label balanceMenu;
	
	public void OnClicked(ActionEvent e) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Deposit");
		dialog.setHeaderText("Εισαγωγή χρημάτων στον λογαριασμό ThessBus");
		dialog.setContentText("Παρακαλούμε εισάγετε ποσό:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    Main.loginUser.updateBalance(Double.parseDouble(result.get()));
		    balanceLabel.setText(Double.toString(Main.loginUser.getBalance()));
		    
		    Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert");
			alert.setHeaderText(null);
			alert.setContentText("Το ποσό σου ανανεώθηκε!");
			alert.showAndWait();
			
		    Passenger temp = new Passenger(Main.loginUser.getUsername(),
			Main.loginUser.getPassword(), Main.loginUser.getEmail(),
			Main.loginUser.getCardNum(), Main.loginUser.getId(),
			Main.loginUser.getPhoneNum(), Main.loginUser.getPassport(),
			Main.loginUser.getBalance());

			FileManager.updatePassenger(Main.loginUser, "Users.dat", temp);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balanceLabel.setText(Double.toString((Main.loginUser.getBalance())));
		usernameMenu.setText(Main.loginUser.getUsername());
		balanceMenu.setText(Double.toString(Main.loginUser.getBalance()));
	}

}