import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FineController extends MainController implements Initializable {

	@FXML Pane leftPane;
	@FXML Hyperlink backHyperlink;
	@FXML TextField nameField;
	@FXML TextField lastNameField;
	@FXML TextField idField;
	@FXML TextField adressField;
	@FXML TextField phoneField;
	@FXML TextField busField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void onClickedFine(ActionEvent actionEvent)
	{
//		String name = nameField.getText() + " " + lastNameField.getText();
//		User user = (User) FileManager.search(name, "Users.ser");
//		Fine fine = new Fine(user,inspector.getInspector_num,busField.getText());
//		FileManager.insertFine(fine, "UserFine.ser");
	}
	public Pane getLeftPane() {
		return leftPane;
	}

	public Hyperlink getBackHyperlink() {
		return backHyperlink;
	}
	
}