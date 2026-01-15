package gui.guiBahnhoefe;

import business.BahnhoefeModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class MobilitaetsangeboteView implements Observer{
	
private MobilitaetsangeboteControl
 	mobilitaetsangeboteControl;
private BahnhoefeModel bahnhoefeModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBahnhoefe     
 		= new Label("Anzeige Bahnhoefe");
    	private TextArea txtAnzeigeBahnhoefe  = new TextArea();
    	private Button btnAnzeigeBahnhoefe = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public MobilitaetsangeboteView(
 		MobilitaetsangeboteControl 
 		MobilitaetsangeboteControl, 
   	 	Stage primaryStage, 
 		BahnhoefeModel bahnhoefeModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Mobilitaetsangeboten");
    		primaryStage.show();
    		this.mobilitaetsangeboteControl 
 			= mobilitaetsangeboteControl;
 		this.bahnhoefeModel = bahnhoefeModel;
 		this.initKomponenten();
		this.initListener();
		this.bahnhoefeModel.addObserver(this);
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeBahnhoefe.setLayoutX(310);
    		lblAnzeigeBahnhoefe.setLayoutY(40);
    		lblAnzeigeBahnhoefe.setFont(font);
    		lblAnzeigeBahnhoefe.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBahnhoefe);           
// Textbereich	
        	txtAnzeigeBahnhoefe.setEditable(false);
     		txtAnzeigeBahnhoefe.setLayoutX(310);
    		txtAnzeigeBahnhoefe.setLayoutY(90);
     		txtAnzeigeBahnhoefe.setPrefWidth(220);
    		txtAnzeigeBahnhoefe.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBahnhoefe);        	
        	// Button
          	btnAnzeigeBahnhoefe.setLayoutX(310);
        	btnAnzeigeBahnhoefe.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBahnhoefe); 
   }
   
   private void initListener() {
	    btnAnzeigeBahnhoefe.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	    			update();
	        	} 
   	    });
    }
   
    public void update(){
    		if(bahnhoefeModel.getBahnhof() != null){
    			txtAnzeigeBahnhoefe.setText(
    				bahnhoefeModel.getBahnhof()
 				.gibBahnhofZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bahnhof aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	

    
}
