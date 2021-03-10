package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea tempoImpiegato;

    @FXML
    private Button canc;
    
    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	this.txtResult.setText("");
    	String w = this.txtParola.getText();
    	try{
    		Integer.parseInt(w);
    		this.txtResult.setText("Devi inserire una parola");
    	}catch(NumberFormatException nfe)
    	{
    		elenco.addParola(w);
    	this.tempoImpiegato.setText(Integer.toString((int) System.nanoTime() - (int)startTime) + " nanosecondi");
    	
    	String stringa = "";
    	ArrayList<String> p = (ArrayList<String>) this.elenco.getElenco();
    	for(String s: p)
    		stringa = stringa + s + "\n";
    	
    	this.txtResult.setText(stringa);
    	}
    	
    }

    @FXML
    void cancellaParola(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	String s = this.txtResult.getSelectedText();
    	
    	if(s != null) {
    		this.elenco.cancellaParola(s);
    		this.tempoImpiegato.setText(Integer.toString((int) System.nanoTime() - (int) startTime) + " nanosecondi");
    	
    		this.txtResult.appendText("");
    		List<String> pi = (ArrayList<String>) this.elenco.getElenco();
    		
    		String stringa = "";
    		for(String st: pi)
    	    	stringa = stringa + st + "\n";
    	    	
        	this.txtResult.setText(stringa);	
    	}else {
    		this.txtResult.setText("Devi selezionare una parola per cancellarla");
   		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtResult.setText("");
    	this.txtParola.setText("");
    	
    	this.elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tempoImpiegato != null : "fx:id=\"tempoImpiegato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert canc != null : "fx:id=\"canc\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}
