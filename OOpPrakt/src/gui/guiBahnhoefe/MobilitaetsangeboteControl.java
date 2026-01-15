package gui.guiBahnhoefe;

import java.io.IOException;

import business.Bahnhof.BahnhoefeModel;
import business.Carsharing.CarsharingModel;
import javafx.stage.Stage;

public class MobilitaetsangeboteControl {
	private MobilitaetsangeboteView mobilitaetsangeboteView;
	private BahnhoefeModel bahnhoefeModel;
	private CarsharingModel carsharingModel;

	public MobilitaetsangeboteControl(Stage primaryStage) {
		this.bahnhoefeModel = bahnhoefeModel.getB();
		this.carsharingModel = carsharingModel.getC();
		this.mobilitaetsangeboteView = new MobilitaetsangeboteView(this, primaryStage, bahnhoefeModel, carsharingModel);
	}

	public void leseSporthallenAusCsvDatei() {
		try {
			this.carsharingModel.leseCarsharingAusCsvDatei();
		} catch (IOException exc) {
			this.mobilitaetsangeboteView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Sporthallen!");
		} catch (Exception exc) {
			this.mobilitaetsangeboteView
					.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen von " + " Sporthallen!");
		}
	}

}
