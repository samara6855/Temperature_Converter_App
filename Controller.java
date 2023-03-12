package com.simha.javafxapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField inputTextField;
	@FXML
	public Button convertButton;
	private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT="Fahrenheit to Celsius";
	private Boolean isC_TO_F= true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);
		choiceBox.setValue(C_TO_F_TEXT);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(isC_TO_F)){
				isC_TO_F=true;
			} else {
				isC_TO_F=false;
			} });
		convertButton.setOnAction(event -> {
            convert();
		});
	}

	private void convert() {
      String input=inputTextField.getText();
      float enteredTemperature=0.0f;
      try {
	      enteredTemperature = Float.parseFloat(input);
      } catch(Exception ex){
      	warnUser();
      	return;
	      // After return statement, code execution terminates.
      }

      float newTemperature=0.0f;
      if(isC_TO_F){
      	newTemperature=(enteredTemperature * 9 / 5) + 32;
      } else{
        newTemperature=(enteredTemperature - 32) * 5 / 9;
      }
      display(newTemperature);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered!");
		alert.setContentText("Please enter a valid input");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit= isC_TO_F? " F" : " C";
		System.out.println("The Converted Temperature is : " + newTemperature + unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The converted temperature is : " + newTemperature + unit);
		alert.show();
	}
}
