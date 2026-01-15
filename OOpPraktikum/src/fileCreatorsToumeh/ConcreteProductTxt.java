package fileCreatorsToumeh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductTxt extends ReaderProductToumeh {
	
	BufferedReader aus;
	
	public ConcreteProductTxt() throws FileNotFoundException {
		aus = new BufferedReader(new FileReader("Bahnhof.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String [] ergebnisZeile = new String[5];
		String zeile = aus.readLine();
		int i = 0;
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = aus.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();

	}

}
