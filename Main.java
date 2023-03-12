package com.simha.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor");
		primaryStage.show();
	}
	private MenuBar createMenu(){

		// File Menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		// Help Menu
		Menu helpMenu=new Menu("Help");
		MenuItem AboutApp=new MenuItem("About");
		AboutApp.setOnAction(event -> AboutApp());
		helpMenu.getItems().addAll(AboutApp);
		// Menu Bar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void AboutApp(){
    // About section using "Alert"
		Alert newAlert=new Alert(Alert.AlertType.INFORMATION);
		newAlert.setTitle("My First Desktop App");
		newAlert.setHeaderText("Learning JavaFX");
		newAlert.setContentText("This is my first JavaFX Application");
		ButtonType Btn=new ButtonType("Okay");
		newAlert.getButtonTypes().setAll(Btn);
		Optional<ButtonType> ClickedBtn=newAlert.showAndWait();
	}
}
