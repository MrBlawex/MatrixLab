package javafxmatrixlab.controller;

import static java.lang.Math.random;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow.AnchorLocation;
import javafxmatrixlab.MtF;
import java.util.Random;

public class createMatrixController implements Initializable {

    @FXML
    private TextField fieldN, fieldM, fieldName, fieldFromRange, fieldToRange,
            fieldEps;

    @FXML
    private Button btn_create, btn_rand, btn_createMatrix;

    @FXML
    private ChoiceBox choiceTypeNumber;

    @FXML
    private AnchorPane innerPane;

    public int n, m;
    public String name = "Ans";
    public TextField[][] arrayField;

    float randRangeS = 0;
    float randRangeE = 100;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldN.setText("3");
        fieldM.setText("3");
        fieldName.setText("Ans");
        choiceTypeNumber.getItems().addAll("Int", "Real");
        choiceTypeNumber.setValue("Int");
    }

    @FXML
    public void handlerRun() {
        n = Integer.valueOf(fieldN.getText());
        m = Integer.valueOf(fieldM.getText());
        name = fieldName.getText();
        innerPane.getChildren().clear();
        arrayField = new TextField[n][m];
        double h = 16, w = 16;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                TextField newField = new TextField("0");
                newField.setMaxWidth(64);
                newField.setLayoutX(w);
                newField.setLayoutY(h);
                Tooltip newTooltip = new Tooltip("N:" + (i + 1) + " M:" + (j + 1));
                newField.setTooltip(newTooltip);
                arrayField[i][j] = newField;
                w += 68;
                innerPane.getChildren().add(arrayField[i][j]);

            }
            h += 32;
            w = 16;
        }
    }

    @FXML
    public void handlerRandFill() {
        Random rand = new Random(System.currentTimeMillis());

        if (choiceTypeNumber.getValue() == "Int") {
            randRangeS = (float) Integer.valueOf(fieldFromRange.getText());
            randRangeE = (float) Integer.valueOf(fieldToRange.getText());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arrayField[i][j].setText(String.valueOf(randRangeS + rand.nextInt((int) (randRangeE - randRangeS + 1))));
                }
            }
        } else if (choiceTypeNumber.getValue() == "Real") {

            randRangeS = Float.valueOf(fieldFromRange.getText() + "f");
            randRangeE = Float.valueOf(fieldToRange.getText() + "f");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    float t = rand.nextFloat() * (randRangeE - randRangeS) + 1 + randRangeS;

                    t *= 10 * Math.pow(10, Integer.valueOf(fieldEps.getText()) - 1);
                    t = Math.round(t);
                    t /= 10 * Math.pow(10, Integer.valueOf(fieldEps.getText()) - 1);
                    arrayField[i][j].setText(String.valueOf(t));
                }
            }
        }
    }

    //Добавляет создану матрицу в список
    @FXML
    public void getMatrix() {
        name = fieldName.getText();
        MtF.Matrix matr = new MtF.Matrix(name, n, m);
        float[][] res = new float[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Float.valueOf(arrayField[i][j].getText());
            }
        }
        matr.matrix = res;
        homeMatrixLabController.PublicVar.DATA_BASE_MATRIX.put(name, matr);
        homeMatrixLabController.PublicVar.listOfHistory.remove(name);
        homeMatrixLabController.PublicVar.listOfHistory.add(name);
    }

}
