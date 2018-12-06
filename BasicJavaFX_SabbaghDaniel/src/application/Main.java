package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import application.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	private AnchorPane rootLayout;	
	/**
	 * my Stage is public
	 */
	public Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AID School");
//			this.primaryStage.setX(500);
//			this.primaryStage.setY(500);
			this.primaryStage.setX(screenSize.getWidth()/7);   
			this.primaryStage.setY(screenSize.getHeight()/7);

			initRootLayout();
			primaryStage.show();
			

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Layouts.fxml"));
			rootLayout = (AnchorPane) loader.load();

			Scene scene = new Scene(rootLayout, 700,600);
			Image image = new Image("application/view/images/aeroplano.png");
			scene.setCursor(new ImageCursor(image));
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Shadows+Into+Light");
            Font.loadFont(getClass().getResourceAsStream("../resources/fonts/HipsterishFontNormal.ttf"), 20);
            
            primaryStage.setWidth(700);
            primaryStage.setHeight(600);
//          primaryStage.sizeToScene();
            
			primaryStage.setScene(scene);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
