package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.sg.prism.NGShape.Mode;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	Model model;	

    public void setModel(Model model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Button btnSimulazione;

    @FXML
    void doSimulazione(ActionEvent event) {
    	txtOutput.clear();
    	model.load();
    	txtOutput.setText(model.simula());
    }

    @FXML
    void initialize() {
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimulazione != null : "fx:id=\"btnSimulazione\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
