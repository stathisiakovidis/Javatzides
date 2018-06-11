import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PurchaseDataController implements Initializable {
	@FXML private TextField lastNameField;
	@FXML private Button checkDataButton;
	@FXML private TextField nameField;
	@FXML private TextField dateTimeField;
	@FXML private TextField lastValidationDateTimeField;
	@FXML private TextField typeProductField;
	@FXML private TextField productNumField;
	@FXML private TextField busField;
	@FXML private TextField routesField;
	@FXML private TextField priceField;
	
	/*public void setDataToFields(String name ,String lastName,String busNum,String type,String dateTime,
								String lastValidationDateTime,String productNum,int routes, double price)
	{
		lastNameField.setText(lastName);
		nameField.setText(name);
		dateTimeField.setText(dateTime);
		lastValidationDateTimeField.setText(lastValidationDateTime);
		typeProductField.setText(type);
		productNumField.setText(productNum);		
		busField.setText(busNum);
		routesField.setText(Integer.toString(routes));
		priceField.setText(Double.toString(price));
	}*/
	public void setDataToFields(Product productChecked, int typeOfProduct) {
		
		String name="", surname ="";
        StringTokenizer st = new StringTokenizer(productChecked.getOwner().getUsername());
        name = st.nextToken();
        surname = st.nextToken();
        lastNameField.setText(surname);
        nameField.setText(name);
        
        String dateTime = productChecked.getDate_time();
        dateTimeField.setText(dateTime.substring(0, 13) + ":" + dateTime.substring(13, 15) + ":" + dateTime.substring(15, 17));
        
        productNumField.setText(productChecked.getProduct_num());
        priceField.setText(Double.toString(productChecked.getPrice()));
        
        if(typeOfProduct == 0) {
        	busField.setText("-");
        	lastValidationDateTimeField.setText("-");
        	typeProductField.setText("Κάρτα: " + ((Card) productChecked).getDuration() + " μηνών/α");
        	routesField.setText("Απεριορίστων διαδρομών");
        }
        else {
        	busField.setText(((Ticket) productChecked).getBus());
        	
        	String validationDateTime = ((Ticket) productChecked).getValidation_date_time();
        	lastValidationDateTimeField.setText(validationDateTime.substring(0, 13) + ":" + validationDateTime.substring(13, 15) +
        										":" + validationDateTime.substring(15, 17));
        	typeProductField.setText("Εισιτήριο");
        	String numOfRoutes = (((Ticket) productChecked).getNo_of_routes() == 1) ? "Μονής" :
        							((Ticket) productChecked).getNo_of_routes() + "-πλής";
        	routesField.setText(numOfRoutes + " διαδρομής");
        }
        		
	}
	
	public void onClickedCheckData(ActionEvent actionEvent) throws NumberFormatException, ParseException {
		int duration = 120;
		Main.loginIns.ticketValidation(dateTimeField.getText(), duration, busField.getText(), 
									lastValidationDateTimeField.getText(), Double.parseDouble(priceField.getText()));
		
		Stage primaryStage = getStageFromEvent(actionEvent);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Έλεγχος");
        alert.setHeaderText("Error");
        alert.setContentText(" ");
        
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText("ΟΚ");
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText("Πρόστιμο");
        
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == ButtonType.OK) {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Inspector.fxml"));
			Parent root = null;
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle(" ");
			primaryStage.show();
        }
        else if(result.get() == ButtonType.CANCEL) {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Fine.fxml"));
    		Parent root = null;
    		try {
				root = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		FineController ctrl = (FineController) loader.getController();
    		ctrl.getLeftPane().getChildren().remove(ctrl.getBackHyperlink());
    		
    		Scene scene = new Scene(root, 600, 400);
    		
    		//setUserData so that the fxml file of the loader can be retrieved
    		scene.setUserData(loader);
    		
    		primaryStage.setScene(scene);
    		primaryStage.setTitle(" ");
    		primaryStage.show();
        }
        	
	}

	public static Stage getStageFromEvent(ActionEvent actionEvent) {
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}