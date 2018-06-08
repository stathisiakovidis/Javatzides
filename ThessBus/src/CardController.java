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
	private Passenger owner = Main.loginUser;
	private double cost;
	@FXML
	private Button monthlyReduced;
	@FXML
	private Button threeMonthsReduced;
	@FXML
	private Button sixMonthsReduced;
	@FXML
	private Button annualReduced;
	@FXML
	private Pane buttonsPane;
	@FXML
	private VBox navBarVBox;
	@FXML
	private Hyperlink signOutHyperlink;
	@FXML
	private Button monthlyNormal;
	@FXML
	private Button threeMonthsNormal;
	@FXML
	private Button sixMonthsNormal;
	@FXML
	private Button annualNormal;
	
	
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

	public Button getMonthlyNormal() {
		return monthlyNormal;
	}

	public Button getThreeMonthsNormal() {
		return threeMonthsNormal;
	}

	public Button getSixMonthsNormal() {
		return sixMonthsNormal;
	}

	public Button getAnnualNormal() {
		return annualNormal;
	}
	
	public Button getMonthlyReduced() {
		return monthlyReduced;
	}

	public Button getThreeMonthsReduced() {
		return threeMonthsReduced;
	}

	public Button getSixMonthsReduced() {
		return sixMonthsReduced;
	}

	public Button getAnnualReduced() {
		return annualReduced;
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
		if(owner != null) {
			if(owner.getCheck() == 1) {
				monthlyNormal.setMouseTransparent(true);
				threeMonthsNormal.setMouseTransparent(true);
				sixMonthsNormal.setMouseTransparent(true);
				annualNormal.setMouseTransparent(true);
			}
			else {
				monthlyReduced.setMouseTransparent(true);
				threeMonthsReduced.setMouseTransparent(true);
				sixMonthsReduced.setMouseTransparent(true);
				annualReduced.setMouseTransparent(true);
			}
		}

	}

}
