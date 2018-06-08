import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CardController extends MainController implements Initializable {
	private Passenger owner;
	private double cost;
	@FXML
	private Button monthly;
	@FXML
	private Button threeMonths;
	@FXML
	private Button sixMonths;
	@FXML
	private Button annual;
	@FXML
	private Pane buttonsPane;
	@FXML
	private VBox navBarVBox;
	@FXML
	private Hyperlink signOutHyperlink;
	
	public void generateMonthlyCard(ActionEvent event) throws IOException {
		cost = 15 * owner.getCheck();
		Card newcard = new Card(cost, owner, "Μηνιαία", 1);
		int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θες να συνεχίσεις;", "Close?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			if(owner.getBalance() >= newcard.getPrice()) {
				owner.reduceBalance(newcard.getPrice());
				owner.addProduct(newcard);
			}
			else {
				JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα ", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void generateThreeMonthsCard(ActionEvent event) throws IOException {
		cost = 42 * owner.getCheck();
		Card newcard = new Card(cost, owner, "Τριμηνιαία", 3);
		int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θες να συνεχίσεις;", "Close?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			if(owner.getBalance() >= newcard.getPrice()) {
				owner.reduceBalance(newcard.getPrice());
				owner.addProduct(newcard);
			}
			else {
				JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα ", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void generateSixMonthsCard(ActionEvent event) throws IOException {
		cost = 75 * owner.getCheck();
		Card newcard = new Card(cost, owner, "Εξαμινιαία", 6);
		int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θες να συνεχίσεις;", "Close?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			if(owner.getBalance() >= newcard.getPrice()) {
				owner.reduceBalance(newcard.getPrice());
				owner.addProduct(newcard);
			}
			else {
				JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα ", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public void generateAnnualCard(ActionEvent event) throws IOException {
		cost = 135 * owner.getCheck();
		Card newcard = new Card(cost, owner, "Ετήσια", 12);
		int reply = JOptionPane.showConfirmDialog(null, "Είσαι σίγουρος ότι θες να συνεχίσεις;", "Close?",  JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			if(owner.getBalance() >= newcard.getPrice()) {
				owner.reduceBalance(newcard.getPrice());
				owner.addProduct(newcard);
			}
			else {
				JOptionPane.showMessageDialog(null, "Δεν έχεις αρκετά χρήματα ", null, JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public Button getMonthly() {
		return monthly;
	}

	public Button getThreeMonths() {
		return threeMonths;
	}

	public Button getSixMonths() {
		return sixMonths;
	}

	public Button getAnnual() {
		return annual;
	}

	public Pane getButtonsPane() {
		return buttonsPane;
	}

	public VBox getNavBarVBox() {
		return navBarVBox;
	}

	public Hyperlink getSignOutHyperlink() {
		return signOutHyperlink;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
