package fileCreatorsToumeh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductCSV extends ReaderProductToumeh {

	

	BufferedReader aus;
	
	public ConcreteProductCSV() throws FileNotFoundException {
		aus = new BufferedReader(new FileReader("Bahnhof.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String[] zeile = aus.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();

	}

}


