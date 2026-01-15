package business.Bahnhof;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fileCreatorsToumeh.ConcreteCreatorCSV;
import fileCreatorsToumeh.ConcreteCreatorTxt;
import fileCreatorsToumeh.ReaderCreatorToumeh;
import fileCreatorsToumeh.ReaderProductToumeh;
import ownUtil.Observable;
import ownUtil.Observer;

public class BahnhoefeModel implements Observable {
	private Vector<Observer> a = new Vector<Observer>();
	private ArrayList<Bahnhof> bahnhof = new ArrayList<Bahnhof>();
	private static BahnhoefeModel b;
	
	
	
	
	
	private BahnhoefeModel() {
		
	}
	

	public static BahnhoefeModel getB() {
		if(b == null) {
			b = new BahnhoefeModel();
		}
		return b;
	}


	

	 public ArrayList<Bahnhof> getBahnhof() {
		return bahnhof;
	}
	public void addBahnhof(Bahnhof bahnhof) {
		this.bahnhof.add(bahnhof);
		notifyObservers();
	}


	public void leseAusDatei(String typ) throws IOException{
    
      		
      			ReaderCreatorToumeh a;
      			if(typ.equals("csv")) {
      				a = new ConcreteCreatorCSV();
      			}else
      				a = new ConcreteCreatorTxt();
      			ReaderProductToumeh p = a.factoryMethod();
      			String zeile [] = p.leseAusDatei();
      				
      			this.bahnhof.add(new Bahnhof(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_")));
      				p.schliesseDatei();
      				notifyObservers();
      	  			
      		
       		
}
	public void schreibeBahnhoefeInCsvDatei() throws IOException {
			
				BufferedWriter aus 
					= new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
				for (Bahnhof b : this.bahnhof) {
					aus.write(b.gibBahnhofZurueck(';'));

				}
				aus.close();
	   			
			
		}


	@Override
	public void addObserver(Observer obs) {
		this.a.addElement(obs);
	}


	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.a.removeElement(obs);
		
	}


	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.size(); i++) {
			this.a.elementAt(i).update();

		}
		
	}
}
