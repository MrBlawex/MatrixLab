package javafxmatrixlab.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafxmatrixlab.MtF;

public class createMatrixController implements Initializable {

    @FXML
    TextField fieldN, fieldM, fieldName;

    @FXML
    Button btn_create, btn_rand;

    @FXML
    AnchorPane innerPane;

    public int n, m;
    public String name = "Ans";
    public LinkedList<LinkedList<TextField>> listField = new LinkedList<LinkedList<TextField>>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldN.setText("0");
        fieldM.setText("0");
        fieldName.setText("Ans");
    }

    @FXML
    public void handlerRun() {
        n = Integer.valueOf(fieldN.getText());
        m = Integer.valueOf(fieldM.getText());
        name = fieldName.getText();
        for (int i = 0; i < n; i++) {
            listField.get(1).clear();
        }
        LinkedList<TextField> rowList = new LinkedList<>();
        double h = 16, w = 16;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                TextField newField = new TextField("0");
                newField.setMaxWidth(64);
                newField.setLayoutX(w);
                newField.setLayoutY(h);
                rowList.add(j, newField);
                w += 68;
                innerPane.getChildren().add(newField);
            }
            listField.add(i, rowList);
            rowList.clear();
            h += 32;
            w = 16;
        }

    }

    @FXML
    public MtF.Matrix getMatrix() {
        MtF.Matrix matr = new MtF.Matrix(name, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matr.matrix[i][j] = Float.valueOf(listField.get(i).get(j).getText());
            }
        }
        return matr;
    }

}
