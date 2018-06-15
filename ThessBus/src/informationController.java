import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class informationController extends MainController implements Initializable{

	@FXML private Label usernameMenu;
	@FXML private Label balanceMenu;
	

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		usernameMenu.setText(Main.loginUser.getUsername());
		balanceMenu.setText(Double.toString(Main.loginUser.getBalance()));
		
	}

}