import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DepositController extends MainController implements Initializable{

	@FXML private Label balanceLabel;
	
	public void OnClicked(ActionEvent e) {
		System.out.println("Yesssss");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		balanceLabel.setText(Double.toString((Main.loginUser.getBalance())));
	}

}