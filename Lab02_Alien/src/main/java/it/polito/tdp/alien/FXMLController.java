package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary AD;

	public void setModel(AlienDictionary AD) {
		this.AD = AD;
	}

	@FXML
	private void initialize(URL url, ResourceBundle rb) {
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField TextWord;
    
    @FXML
    private TextArea AreaofResponse;

    @FXML
    private Label txtAlienText;

    @FXML
    private Button ButtonTranslate;
    
    @FXML
    private Label instructIons;
    
    @FXML
    private Button ShowAllButton;

    @FXML
    void TranslatePressed(ActionEvent event) {
    	
    	String s = TextWord.getText();
    	
    	AD.AlphaCheck(s);
        
    	AreaofResponse.setText(AD.StringOutput(AD.getA()));
    	
    }
    
    @FXML
    void ClearPressed(ActionEvent event) {

    	TextWord.setText("<> <>");
    	AreaofResponse.setText("");
    	
    }
    
    @FXML
    void ShowAll(ActionEvent event) {
    	
    	AreaofResponse.setText(AD.ShowAllMethod());

    }

    @FXML
    void initialize() {
        assert txtAlienText != null : "fx:id=\"txtAlienText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ButtonTranslate != null : "fx:id=\"ButtonTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert TextWord != null : "fx:id=\"TextWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert instructIons != null : "fx:id=\"instructIons\" was not injected: check your FXML file 'Scene.fxml'.";
        assert ShowAllButton != null : "fx:id=\"ShowAllButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert AreaofResponse != null : "fx:id=\"AreaofResponse\" was not injected: check your FXML file 'Scene.fxml'.";
    }
}
