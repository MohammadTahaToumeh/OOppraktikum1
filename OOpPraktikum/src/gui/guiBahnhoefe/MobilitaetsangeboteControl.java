package gui.guiBahnhoefe;

import business.BahnhoefeModel;
import javafx.stage.Stage;
public class MobilitaetsangeboteControl {	
	private MobilitaetsangeboteView
 		mobilitaetsangeboteView;
	private BahnhoefeModel bahnhoefeModel;
	public MobilitaetsangeboteControl(Stage primaryStage){
 		this.bahnhoefeModel = bahnhoefeModel.getB();		
		this.mobilitaetsangeboteView 
		 	= new MobilitaetsangeboteView(this, primaryStage,
			bahnhoefeModel);
	}
}

