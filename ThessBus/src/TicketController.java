import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TicketController extends MainController{

	@FXML
	private Button oneWayNormal;
	@FXML
	private Button oneWayReduced;
	@FXML
	private Button twoWayNormal;
	@FXML
	private Button twoWayReduced;

	private Passenger aPassenger;
	
	public void onClickedOneWayNormal(ActionEvent e) {
		//aPassenger.addProduct(new Ticket(null, 0, aPassenger, null, null, null, 0, 0, null));
	}
	
	
}
