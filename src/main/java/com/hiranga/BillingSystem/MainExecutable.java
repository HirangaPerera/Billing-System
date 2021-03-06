package com.hiranga.BillingSystem;
import com.hiranga.BillingSystem.DashBoard.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainExecutable extends Application {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("/com/hiranga/BillingSystem/DashBoard/DashBoardGUI.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("AddSuppliar.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
