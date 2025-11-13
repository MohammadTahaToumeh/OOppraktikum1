package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsToumeh.ConcreteCreatorCSV;
import fileCreatorsToumeh.ConcreteCreatorTxt;
import fileCreatorsToumeh.ReaderCreatorToumeh;
import fileCreatorsToumeh.ReaderProductToumeh;

public class BahnhoefeModel {

	private Bahnhof bahnhof;
	
	public Bahnhof getBahnhof() {
		return bahnhof;
	}

	public void setBahnhof(Bahnhof bahnhof) {
		this.bahnhof = bahnhof;
	}

	 public void leseAusDatei(String typ) throws IOException{
    
      		
      			ReaderCreatorToumeh a;
      			if(typ.equals("csv")) {
      				a = new ConcreteCreatorCSV();
      			}else
      				a = new ConcreteCreatorTxt();
      			ReaderProductToumeh p = a.factoryMethod();
      			String zeile [] = p.leseAusDatei();
      				
      			this.bahnhof = new Bahnhof(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_"));
      				p.schliesseDatei();
      	  			
      		
       		
}
	public void schreibeBahnhoefeInCsvDatei() throws IOException {
			
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
				aus.write(this.getBahnhof().gibBahnhofZurueck(';'));
				aus.close();
	   			
			
		}
}
