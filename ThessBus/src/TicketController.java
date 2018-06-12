import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
	
	private Passenger owner = Main.loginUser;
	private double cost;
	
	
	public void onClickedOneWay(ActionEvent e) {
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
	
	public void onClickedTwoWay(ActionEvent e) {
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
	
}
