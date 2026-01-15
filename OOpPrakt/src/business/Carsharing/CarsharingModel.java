package business.Carsharing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import business.Bahnhof.BahnhoefeModel;
import business.Bahnhof.Bahnhof;

public class CarsharingModel {
	private ArrayList<Carsharing> carsharing = new ArrayList<Carsharing>();
	private static CarsharingModel c;

	private CarsharingModel() {

	}

	public static CarsharingModel getC() {
		if (c == null) {
			c = new CarsharingModel();
		}
		return c;
	}

	public ArrayList<Carsharing> getCarsharing() {
		return carsharing;
	}

	public void addCarsharing(Carsharing carsharing) {
		this.carsharing.add(carsharing);

	}

	public void leseCarsharingAusCsvDatei() throws IOException {
		BufferedReader ein = new BufferedReader(new FileReader("Carsharing.csv"));
		ArrayList<Carsharing> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Carsharing(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.carsharing = ergebnis;
	}

}
