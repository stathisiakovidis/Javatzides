
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class VisitorScreenController extends MainController{

	// Event Listener on Button.onAction
	@FXML
	public void onClickedTicket(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket_Panel.fxml"));
		Parent root = null;
		root = loader.load();
        TicketPanelController ctrl = (TicketPanelController)loader.getController();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Ticket Purchase");
		primaryStage.show();
	}
	// Event Listener on Button.onAction
	@FXML
	public void onClickedCard(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
		Parent root = null;
		root = loader.load();
        CardController ctrl = (CardController)loader.getController();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Card Purchase");
		primaryStage.show();
	}
}
