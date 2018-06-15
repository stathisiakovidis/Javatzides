import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class DepositController extends MainController implements Initializable{

	@FXML private Label balanceLabel;
	
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
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balanceLabel.setText(Double.toString((Main.loginUser.getBalance())));
	}

}