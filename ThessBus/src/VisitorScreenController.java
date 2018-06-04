
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VisitorScreenController extends MainController implements Initializable{

	@FXML private VBox navBarVBox;
		
	public void onClickedTicket(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = MainController.getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket_Panel.fxml"));
		Parent root = null;
		root = loader.load();
        
		TicketController ctrl = (TicketController)loader.getController();
		ctrl.getNavBarVBox().setMouseTransparent(true);
		ctrl.getNavBarVBox().setEffect(new GaussianBlur());
		ctrl.getOneWayNormal().setMouseTransparent(true);
		ctrl.getOneWayReduced().setMouseTransparent(true);
		ctrl.getTwoWayNormal().setMouseTransparent(true);
		ctrl.getTwoWayReduced().setMouseTransparent(true);
		ctrl.getButtonsPane().getChildren().remove(ctrl.getSignOutHyperlink());
		
		Scene scene = new Scene(root);
		
		//setUserData so that the fxml file of the loader can be retrieved
		scene.setUserData(loader);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Ticket Purchase");
		primaryStage.show();
	}
	
	public void onClickedCard(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = MainController.getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Card.fxml"));
		Parent root = null;
		root = loader.load();
        
		CardController ctrl = (CardController)loader.getController();
		ctrl.getNavBarVBox().setMouseTransparent(true);
		ctrl.getNavBarVBox().setEffect(new GaussianBlur());
		ctrl.getAnnual().setMouseTransparent(true);
		ctrl.getMonthly().setMouseTransparent(true);
		ctrl.getSixMonths().setMouseTransparent(true);
		ctrl.getThreeMonths().setMouseTransparent(true);
		ctrl.getButtonsPane().getChildren().remove(ctrl.getSignOutHyperlink());
		
		Scene scene = new Scene(root);
		
		//setUserData so that the fxml file of the loader can be retrieved
		scene.setUserData(loader);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Card Purchase");
		primaryStage.show();
	}
	
	//Να μπουν αυτά τα δύο μέσα στο fxml του Visitor 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		navBarVBox.setMouseTransparent(true);
		navBarVBox.setEffect(new GaussianBlur());
	}
}
