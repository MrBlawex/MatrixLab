package javafxmatrixlab.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SettingsWindowsController implements Initializable {

    @FXML
    private Label coutOfchar;

    @FXML
    private Slider sliderEps;

    @FXML
    private Label coutOfEps;

    @FXML
    private Slider sliderCout;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sliderEps.valueProperty().addListener((newValue) -> {
            coutOfEps.setText(String.valueOf((int) sliderEps.getValue()));
            sliderEps.setValue(Math.round(sliderEps.getValue()));
        });
        
        sliderCout.valueProperty().addListener((newValue) -> {
            coutOfchar.setText(String.valueOf((int) sliderCout.getValue()));
            sliderCout.setValue(Math.round(sliderCout.getValue()));
        });
        
        sliderEps.setValue(homeMatrixLabController.PublicVar.epsInt);
        sliderCout.setValue(homeMatrixLabController.PublicVar.countOfDigits);
       
        coutOfEps.setText(String.valueOf((int) sliderEps.getValue()));
        coutOfchar.setText(String.valueOf((int) sliderCout.getValue()));
    }    
    
    
    
    @FXML
    public void setNewValueEps(){
        homeMatrixLabController.PublicVar.epsInt = (int) sliderEps.getValue();
        homeMatrixLabController.PublicVar.epsilon = changeEps(sliderEps.getValue());
    }
    
    @FXML
    public void setNewValueCout(){
        homeMatrixLabController.PublicVar.countOfDigits = (int) Math.round(sliderCout.getValue());
    }
    
    @FXML
    public void refreshNewValueEps(){
        coutOfEps.setText(String.valueOf((int) Math.round(sliderEps.getValue())));
    }
    
    @FXML
    public void refreshNewValueCout(){
        coutOfchar.setText(String.valueOf((int) Math.round(sliderCout.getValue())));
    }
    
    public Float changeEps(Double value){
        return (float) Math.pow(10, -1 * Math.round(value));
    }
}
