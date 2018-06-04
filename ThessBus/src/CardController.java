import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CardController extends MainController implements Initializable{

	@FXML private Button monthly;
	@FXML private Button threeMonths;
	@FXML private Button sixMonths;
	@FXML private Button annual;
	@FXML private Pane buttonsPane;
	@FXML private VBox navBarVBox;
	@FXML private Hyperlink signOutHyperlink;
		
	public void generateCard(ActionEvent event) {
		Card newcard = null;
		boolean flag=true;
		/*if(owner.getNumPas()==null){
		 * 		if(event.getSource()==Miniaia){ 
		 * 			if(owner.getBalance()>= 30/owner.getCheck())
		 * 				newcard.setType("Μηνιαία");
		 * 				newcard.setCost(15);
		 * 				flag=false; 
		 *		 }else if(button.id.equals("Card84"){ 
		 * 			if(owner.getBalance()>=84)
		 * 				newcard.setType("Τριμηνιαία");
		 * 				newcard.setCost(84);
		 * 				flag=false; 
		 * 		 }else if(button.id.equals("Card150"){ 
		 * 			if(owner.getBalance()>=150)
		 * 				newcard.setType("Εξαμηνιαία");
		 * 				newcard.setCost(150);
		 * 				flag=false;
		 * 		 }else if(button.id.equals("Card270"){ 
		 * 			if(owner.getBalance()>=270)
		 * 				newcard.setType("Ετήσια");
		 * 				newcard.setCost(270);
		 * 				flag=false; 
		 * }else
		 * 		 if(button.id.equals("Card15"){ 
		 * 			if(owner.getBalance()>=15)
		 * 				newcard.setType("Μηνιαία Μειωμένο");
		 * 				newcard.setCost(15); 
		 * 				flag=false;
		 *		 }else if(button.id.equals("Card42"){ 
		 * 			if(owner.getBalance()>=42)
		 * 				newcard.setType("Τριμηνιαία Μειωμένο");
		 * 				newcard.setCost(42);
		 * 				flag=false; 
		 * 		 }else if(button.id.equals("Card75"){ 
		 * 			if(owner.getBalance()>=75)
		 * 				newcard.setType("Εξαμηνιαία Μειωμένο");
		 * 				newcard.setCost(75);
		 * 				flag=false;
		 * 		 }else if(button.id.equals("Card135"){ 
		 * 			if(owner.getBalance()>=135)
		 * 				newcard.setType("Ετήσια Μειωμένο");
		 * 				newcard.setCost(135);
		 * 				flag=false;
		 * if(flag==true){
		 * 		Alert errorAlert = new Alert(AlertType.ERROR);
		 *		errorAlert.setHeaderText("Error excepted");
		 *		errorAlert.setContentText("You have not enough money.\n Transaction Failed!");
		 *		errorAlert.showAndWait();
		 * }else{
		 * 		newcard.setOwner(owner);
		 * 		owner.products.add(newcard);
		 * 		owner.reduseBalance(newcard.getCost());
		 * }
		 */
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
			
	}

	public VBox getNavBarVBox() {
		return navBarVBox;
	}

	public Hyperlink getSignOutHyperlink() {
		return signOutHyperlink;
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
	
}
