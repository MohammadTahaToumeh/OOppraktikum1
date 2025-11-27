package main;

import gui.BahnhoefeAnwendungssystem;
import gui.BahnhoefeControl;
import gui.guiBahnhoefe.MobilitaetsangeboteControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BahnhoefeControl(primaryStage);
		Stage a = new Stage();
		new MobilitaetsangeboteControl(a);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
