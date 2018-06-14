import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicketController extends MainController implements Initializable {

	@FXML private Button oneWayNormal;
	@FXML private Button oneWayReduced;
	@FXML private Button twoWayNormal;
	@FXML private Button twoWayReduced;
	@FXML private Pane buttonsPane;
	@FXML private VBox navBarVBox;
	@FXML private Hyperlink signOutHyperlink;
	@FXML private ComboBox<String> busesComboBox;
	
	private String bus = "";
	private Passenger owner = Main.loginUser;
	private double cost;
	
	
	public void onClickedOneWay(ActionEvent e) {
		if(bus != "") {
			cost = 0.5 * owner.getCheck();
			Ticket newTicket= new Ticket(cost, owner, "Μονής", 1, null);
			int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θέλεις να συνεχίσεις;", "Κλείσιμο;",  JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
			   if(owner.getBalance() < cost) {
				   JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα", null, JOptionPane.WARNING_MESSAGE);
			   }
			   else {
				   owner.reduceBalance(cost);
				   owner.addProduct(newTicket);
			   }
			}
		}
		else 
			noBusSelectedAlert();
	}
	
	public void onClickedTwoWay(ActionEvent e) {
		if(bus != "") {
			cost = 0.6 * owner.getCheck();
			Ticket newTicket= new Ticket(cost, owner, "Διπλής", 2, null);
			int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θέλεις να συνεχίσεις;", "Κλείσιμο;",  JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
			   if(owner.getBalance() < cost) {
				   JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα", null, JOptionPane.WARNING_MESSAGE);
			   }
			   else {
				   owner.reduceBalance(cost);
				   owner.addProduct(newTicket);
			   }
			}
		}
		else
			noBusSelectedAlert();
	}
	
	public void comboBoxChoice(ActionEvent actionEvent) {
		bus = busesComboBox.getValue().substring(0, 2);
		bus = bus + ((busesComboBox.getValue().substring(2, 3).equals("Ν")) ? "Ν" : "");
		System.out.println(bus);
	}
	
	public void noBusSelectedAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText(null);
		alert.setContentText("Πρώτα διάλεξε λεωφορείο!");
		alert.showAndWait();
	}
	
	/*public void onClickedOneWayRedused(ActionEvent e) {
		System.out.println("HEY");
	}
	
	public void onClickedTwoWayRedused(ActionEvent e) {
		System.out.println("HEY");
	}*/

	
	/*public void clickedButton(ActionEvent e) {
		
		Ticket ticket = new Ticket(null, 1.0, owner, null, null, null, 1, 12, null);
		
		if(e.getSource().equals(oneWayNormal)) {
			ticket.setPrice(1);
			ticket.setNo_of_routes(1);
		}
		else if(e.getSource().equals(oneWayReduced)) {
			ticket.setPrice(0.5);
			ticket.setNo_of_routes(1);
		}
		else if(e.getSource().equals(twoWayNormal)) {
			ticket.setPrice(1.20);
			ticket.setNo_of_routes(2);
		}
		else if(e.getSource().equals(twoWayReduced)) {
			ticket.setPrice(0.60);
			ticket.setNo_of_routes(2);
		}
		
		int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θες να συνεχίσεις;", "Close?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			if(owner.getBalance() >= ticket.getPrice()) {
				owner.reduceBalance(ticket.getPrice());
				owner.addProduct(ticket);
			}
			else
				 JOptionPane.showMessageDialog(null, "ΒΛΑΧΑ ΒΛΑΧΑ ΦΤΩΧΙΑ ", null, JOptionPane.WARNING_MESSAGE);
		}
		
	}*/

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		busesComboBox.setPromptText("Σε ποιό λεωφορείο είσαι?");
		busesComboBox.setItems(FXCollections.
				observableArrayList("14: ’νω Τούμπα - Ν.Σ. Σταθμός", "78Ν ΚΤΕΛ - Αεροδρόμιο Νυχτερινό",
				"02: Α.Σ. ΙΚΕΑ - Ν.Σ. Σταθμός μέσω Εγνατίας", "31: Βούλγαρη - ΚΤΕΛ", "30: Τριανδρία - Αποθήκη"));
		
		if(owner != null) {
			if(owner.getCheck() == 1) {
				oneWayNormal.setMouseTransparent(true);
				twoWayNormal.setMouseTransparent(true);}
			else {
				oneWayReduced.setMouseTransparent(true);
				twoWayReduced.setMouseTransparent(true);
			}
		}
		
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

	public ComboBox<String> getBusesComboBox() {
		return busesComboBox;
	}
	
}
