import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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

	public void setDataToFields(String product_num)
	{
		lastNameField.setText(product_num);
	}
	
	public void onClickedCheckData(ActionEvent actionEvent) {
		Stage primaryStage = getStageFromEvent(actionEvent);
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(" ");
        alert.setHeaderText("Error");
        alert.setContentText(" ");
        
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setText(" ");
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setText(" ");
        
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
    		Scene scene = new Scene(root, 600, 400);
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