import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreenController extends MainController implements Initializable {
	
	@FXML private Label usernameMenu;
	@FXML private Label balanceMenu;
	@FXML private Label welcome;
	@FXML private Label fineLabel;
	@FXML private Hyperlink payNow;
	@FXML private VBox payNowPane;

	public void onClickedTicket(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket_Panel.fxml"));
		Parent root = null;
		root = loader.load();

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
			if(f.isPaid() == false)
				choices.add("Date Time: " + f.getDate_time() + ", Bus: " + f.getBus() + ", Price: "
							+ Double.toString(f.getPrice()));
		}
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Επιλογή Προστίμου", choices);
		dialog.setTitle("Pay Fine");
		dialog.setHeaderText(null);
		dialog.setContentText("Διάλεξε το πρόστιμο" + System.lineSeparator() +"που θέλεις να πληρώσεις: ");
		Optional<String> result = dialog.showAndWait();
		
		if (result.isPresent()) {
			for (Fine f : Main.loginUser.getFines()) {
				if (result.get().contains(f.getDate_time())) {
					if (f.getPrice() <= Main.loginUser.getBalance()) {
						f.finePaid();
						Main.loginUser.reduceBalance(f.getPrice());
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Alert");
						alert.setHeaderText(null);
						alert.setContentText("Το πρόστιμο σου πληρώθηκε");
						alert.showAndWait();
						
						//initialize();
					} 
					else {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Alert");
						alert.setHeaderText(null);
						alert.setContentText("Το υπόλοιπό σου δεν επαρκεί!");
						alert.showAndWait();
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
		
		fineLabel.setText("   Έχεις (" + Main.loginUser.countUnpaidFines() + ") πρόστιμο/α απλήρωτο/α" 
				/*") πρόστιμο/α που κοστίζουν: " + Double.toString(Main.loginUser.calculateTotalFines()) + "€"*/);
		
		if(Main.loginUser.countUnpaidFines() == 0) {
			payNow.setMouseTransparent(true);
			payNow.setEffect(new GaussianBlur());
			fineLabel.setText("   Δεν έχεις πρόστιμα προς πληρωμή");
		}
		
		if(Main.loginUser.countMultiWayNotValidatedTickets() > 0) {
			HBox MultiWayTicketsHBox = new HBox();
			MultiWayTicketsHBox.setSpacing(30);
			MultiWayTicketsHBox.setPadding(new Insets(0, 0, 0, 20));
			
			Label multiWayTicketsLabel = new Label("Έχεις (" + Main.loginUser.countMultiWayNotValidatedTickets() + ") εισιτήριο/α πολλαπλών"
									+ System.lineSeparator() + "διαδρομών σε εκκρεμότητα");
			multiWayTicketsLabel.setFont(new Font(13));
			Hyperlink viewTicketslink = new Hyperlink("Προβολή");
			//viewTicketslink.setTextFill(new );
			viewTicketslink.setUnderline(true);
			viewTicketslink.setOnAction((ActionEvent e) -> {
			    onClickViewTickets(e);
			});
			MultiWayTicketsHBox.getChildren().add(multiWayTicketsLabel);
			MultiWayTicketsHBox.getChildren().add(viewTicketslink);
			
			payNowPane.getChildren().add(MultiWayTicketsHBox);
		}
		
		if(Main.loginUser.countNotValidCards() > 0) {
			//label ενημέρωσης - κουμπί για την προβολή τους?
		}
		
	}
	
	public void onClickViewTickets(ActionEvent e) {
		ArrayList<String> choices = new ArrayList<>();
		for (Product p: Main.loginUser.getProducts()) {
			if(p instanceof Ticket && ((Ticket)p).getRemaining_routes() > 0)
				choices.add("Ημερομηνία επικύρωσης: " + p.getDate_time() + ", Απομένουσες χρήσεις: " + 
							((Ticket)p).getRemaining_routes() + ", Τιμή: " + Double.toString(p.getPrice()) + "€");
		}
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Επιλογή Εισιτηρίου", choices);
		dialog.setTitle("Validate Ticket");
		dialog.setHeaderText(null);
		dialog.setContentText("Διάλεξε το εισιτήριο" + System.lineSeparator() +"που θα ήθελες να επικυρώσεις: ");
		Optional<String> result = dialog.showAndWait();
		
		if (result.isPresent()) {
			for (Product p : Main.loginUser.getProducts()) {
				if (result.get().contains(p.getDate_time())) {
					
					if(((Ticket)p).isValid() == false) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Alert");
						alert.setHeaderText(null);
						alert.setContentText("Σε ενημερώνουμε πως η επικύρωση του εισιτηρίου" + System.lineSeparator() + 
											 "είναι εκτός των χρονικών ορίων που ορίζονται γι αυτο!" + System.lineSeparator() +
											 "ΣΥΝΕΧΕΙΑ;");
						Optional<ButtonType> result1 = alert.showAndWait();
						if(result1.get() == ButtonType.CANCEL)
							break;
					}
					
					((Ticket)p).Refresh_num_of_routes();
					((Ticket)p).setValidation_date_time();
					FileManager.updateProduct(p, "Products.dat");
						
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Alert");
					alert.setHeaderText(null);
					alert.setContentText("Το εισιτήριο σου επικυρώθηκε");
					alert.showAndWait();
						
					//initialize();

				}
			}
		}
	}
}
