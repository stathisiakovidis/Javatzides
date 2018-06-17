import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class StartScreenController extends MainController implements Initializable {
	@FXML
	private Label usernameMenu;
	@FXML
	private Label balanceMenu;
	@FXML
	private Label welcome;
	@FXML
	private Label fineLabel;
	@FXML
	private Hyperlink payNow;

	public void onClickedTicket(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket_Panel.fxml"));
		Parent root = null;
		root = loader.load();
		TicketController ctrl = (TicketController) loader.getController();

		Scene scene = new Scene(root);

		// setUserData so that the fxml file of the loader can be retrieved
		scene.setUserData(loader);

		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Ticket Purchase");
		primaryStage.show();
	}

	public void onClickedCard(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
		Parent root = null;
		root = loader.load();
		CardController ctrl = (CardController) loader.getController();

		Scene scene = new Scene(root);

		// setUserData so that the fxml file of the loader can be retrieved
		scene.setUserData(loader);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Card Purchase");
		primaryStage.show();
	}

	public void onClickPayNow(ActionEvent e) throws IOException {
		ArrayList<String> choices = new ArrayList<>();
		for (Fine f : Main.loginUser.getFines()) {
			choices.add("Date Time:" + f.getDate_time() + ", Bus:" + f.getBus() + ", Price"
					+ Double.toString(f.getPrice()));
		}
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Επιλογή Προστίμου", choices);
		dialog.setTitle("Pay Fine");
		dialog.setHeaderText(null);
		dialog.setContentText("Διάλεξε το πρόστιμο που θέλεις να πληρώσεις: ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			for (Fine f : Main.loginUser.getFines()) {
				if (result.get().contains(f.getDate_time())) {
					if (f.getPrice() >= Main.loginUser.getBalance()) {
						f.finePaid();
						Main.loginUser.reduceBalance(f.getPrice());
						break;
					} else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Alert");
						alert.setHeaderText(null);
						alert.setContentText("Το υπόλοιπό σου δεν επαρκεί!");
						alert.showAndWait();
						break;
					}

				}
			}

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameMenu.setText(Main.loginUser.getUsername());
		balanceMenu.setText(Double.toString(Main.loginUser.getBalance()));
		welcome.setText("Γεια σου, " + Main.loginUser.getUsername() + "!");
		if (Main.loginUser.getFines().isEmpty())
			payNow.setMouseTransparent(true);

		fineLabel.setText("Έχεις (" + Integer.toString(Main.loginUser.getFines().size())
				+ ") πρόστιμο/α που κοστίζουν: " + Double.toString(Main.loginUser.calculateTotalFines()) + "€");
	}

}
