import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CardController {
	// private User owner;
	@FXML
	public Button Miniaia,Triminaia,Examiniaia,Ethsia;
	
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

}
