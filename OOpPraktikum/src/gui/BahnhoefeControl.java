package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;

import business.BahnhoefeModel;
import business.Bahnhof;
import javafx.stage.Stage;

public class BahnhoefeControl {
	private BahnhoefeView bahnhoefeView;
	private BahnhoefeModel bahnhoefeModel;
	
	public BahnhoefeControl(Stage primaryStage) {
		this.bahnhoefeModel = new BahnhoefeModel();
		this.bahnhoefeView = new BahnhoefeView(this, bahnhoefeModel, primaryStage);
	}

	void nehmeBahnhofAuf(){
    	try{ 
    		bahnhoefeModel.setBahnhof(new Bahnhof(bahnhoefeView.getTxtName().getText(), bahnhoefeView.getTxtOrt().getText(), Integer.parseInt(bahnhoefeView.getTxtAnzahlGleise().getText()), Integer.parseInt(bahnhoefeView.getTxtLetzteRenovierung().getText()), bahnhoefeView.getTxtZugarten().getText().split(";")));
    		
    		bahnhoefeView.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		bahnhoefeView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			bahnhoefeModel.leseAusDatei(typ);
      	  			bahnhoefeView.zeigeInformationsfensterAn(
      	  	   			"Der Bahnhof wurde gelesen!");
      		}else if("txt".equals(typ)) {
      			bahnhoefeModel.leseAusDatei(typ);
  	  			bahnhoefeView.zeigeInformationsfensterAn(
  	  	   			"Der Bahnhof wurde gelesen!");
      		}
       		else{
	   			bahnhoefeView.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			bahnhoefeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
			exc.printStackTrace();
		}
		catch(Exception exc){
			bahnhoefeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
	
	public void schreibeBahnhoefeInCsvDatei() {
		try {
			bahnhoefeModel.schreibeBahnhoefeInCsvDatei();
   			bahnhoefeView.zeigeInformationsfensterAn(
	   			"Die Bahnhoefe wurden gespeichert!");
		}	
		catch(IOException exc){
			bahnhoefeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			bahnhoefeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
}
