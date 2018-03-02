package javafxmatrixlab.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafxmatrixlab.MtF;


public class editMatrixController implements Initializable {

    MtF.Matrix matrix;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setMatrix(MtF.Matrix matrix) {
        this.matrix = matrix;
    }
}