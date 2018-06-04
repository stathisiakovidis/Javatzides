import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TicketController extends MainController implements Initializable {

	@FXML private Button oneWayNormal;
	@FXML private Button oneWayReduced;
	@FXML private Button twoWayNormal;
	@FXML private Button twoWayReduced;
	@FXML private Pane buttonsPane;
	@FXML private VBox navBarVBox;
	@FXML private Hyperlink signOutHyperlink;
	
	private Passenger aPassenger;
	
	public void onClickedOneWayNormal(ActionEvent e) {
		//aPassenger.addProduct(new Ticket(null, 0, aPassenger, null, null, null, 0, 0, null));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public VBox getNavBarVBox() {
		return navBarVBox;
	}

	public Hyperlink getSignOutHyperlink() {
		return signOutHyperlink;
	}

	public Button getOneWayNormal() {
		return oneWayNormal;
	}

	public Button getOneWayReduced() {
		return oneWayReduced;
	}

	public Button getTwoWayNormal() {
		return twoWayNormal;
	}

	public Button getTwoWayReduced() {
		return twoWayReduced;
	}

	public Pane getButtonsPane() {
		return buttonsPane;
	}
	
}
