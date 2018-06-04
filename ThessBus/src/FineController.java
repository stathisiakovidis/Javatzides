import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;

public class FineController extends MainController implements Initializable {

	@FXML Pane leftPane;
	@FXML Hyperlink backHyperlink;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public Pane getLeftPane() {
		return leftPane;
	}

	public Hyperlink getBackHyperlink() {
		return backHyperlink;
	}
	
}