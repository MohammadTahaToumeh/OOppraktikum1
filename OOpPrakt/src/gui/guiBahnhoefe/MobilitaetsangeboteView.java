package gui.guiBahnhoefe;

import java.io.IOException;

import business.Bahnhof.BahnhoefeModel;
import business.Bahnhof.Bahnhof;
import business.Carsharing.Carsharing;
import business.Carsharing.CarsharingModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class MobilitaetsangeboteView implements Observer {

	private MobilitaetsangeboteControl mobilitaetsangeboteControl;
	private BahnhoefeModel bahnhoefeModel;
	private CarsharingModel carsharingModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeBahnhoefe = new Label("Anzeige Bahnhoefe");
	private TextArea txtAnzeigeBahnhoefe = new TextArea();
	private Button btnAnzeigeBahnhoefe = new Button("Anzeige");
	private Label lblAnzeigeCarsharing = new Label("Anzeige Carsharing");
	private TextArea txtAnzeigeCarsharing = new TextArea();
	private Button btnAnzeigeCarsharing = new Button("csv-import und Anzeige");

	// -------Ende Attribute der grafischen Oberflaeche-------

	public MobilitaetsangeboteView(MobilitaetsangeboteControl mobilitaetsangeboteControl, Stage primaryStage,
			BahnhoefeModel bahnhoefeModel, CarsharingModel carsharingModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Mobilitaetsangeboten");
		primaryStage.show();
		this.mobilitaetsangeboteControl = mobilitaetsangeboteControl;
		this.carsharingModel = carsharingModel;
		this.bahnhoefeModel = bahnhoefeModel;
		this.initKomponentenMobil();
		this.initKomponentenCarsharing();
		this.initListenerMobil();
		this.initListenerCarsharing();

		this.bahnhoefeModel.addObserver(this);
	}

	private void initKomponentenMobil() {
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
	private void initKomponentenCarsharing() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeCarsharing.setLayoutX(20);
		lblAnzeigeCarsharing.setLayoutY(40);
		lblAnzeigeCarsharing.setFont(font);
		lblAnzeigeCarsharing.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeCarsharing);
// Textbereich	
		txtAnzeigeCarsharing.setEditable(false);
		txtAnzeigeCarsharing.setLayoutX(20);
		txtAnzeigeCarsharing.setLayoutY(90);
		txtAnzeigeCarsharing.setPrefWidth(220);
		txtAnzeigeCarsharing.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeCarsharing);
		// Button
		btnAnzeigeCarsharing.setLayoutX(20);
		btnAnzeigeCarsharing.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeCarsharing);
	}
	private void initListenerMobil() {
		btnAnzeigeBahnhoefe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				update();
			}
		});
	}
	private void initListenerCarsharing() {
		btnAnzeigeCarsharing.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					zeigeSporthallenAn();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void update() {
		if (bahnhoefeModel.getBahnhof().size() > 0) {
			StringBuffer s = new StringBuffer();
			for (Bahnhof b : bahnhoefeModel.getBahnhof()) {
				s.append(b.gibBahnhofZurueck(' '));
			}
			txtAnzeigeBahnhoefe.setText(s.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	private void zeigeSporthallenAn() throws IOException {
		carsharingModel.leseCarsharingAusCsvDatei();
		if (carsharingModel.getCarsharing().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Carsharing sh : carsharingModel.getCarsharing()) {
				text.append(sh.gibCarsharingZurueck(' ') + "\n");
			}
			this.txtAnzeigeCarsharing.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Es gibt keine Sporthalle in der csv-Datei!");
		}
	}

}
