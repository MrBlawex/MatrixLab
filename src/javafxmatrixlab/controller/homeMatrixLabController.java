package javafxmatrixlab.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafxmatrixlab.ErrorFunc;
import javafxmatrixlab.ErrorFunc.ErrorType;
import javafxmatrixlab.ModalWindow;
import javafxmatrixlab.JavaFXMatrixLab;
import javafxmatrixlab.MtF;
import javafxmatrixlab.SintacsisFunc;


public class homeMatrixLabController implements Initializable {
    
    @FXML
    private Button btn_enter;
    
    @FXML
    private Button btn_add;
    
    @FXML
    private Button btn_remove;

    @FXML
    private TextArea textOut;
    
    @FXML
    private TextField homeTextField;

    @FXML
    private ListView<String> historyContainer;

    //Создание экземпляров класса
    JavaFXMatrixLab javaFXMatrixLab = new JavaFXMatrixLab();
    SintacsisFunc sintacsisFunc = new SintacsisFunc();
    ModalWindow modalWindow = new ModalWindow();
    ErrorFunc errorFunc = new ErrorFunc();
     
    
    public static class PublicConst{
        public static ObservableList<String> listOfHistory = FXCollections.observableArrayList();//Массив текста из истории
        public static HashMap<String, MtF.Matrix> DATA_BASE_MATRIX = new HashMap<String, MtF.Matrix>();
    }
    
    //Внутренние переменные
    String OutputText = "";//Текст из поля вывода
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SintacsisFunc.PatternConst.initialize();
        ObservableList<String> value = FXCollections.observableArrayList("hi","Bro");
        historyContainer.setItems(value);
        
        MtF.Matrix A = new MtF.Matrix("A", 3,3);
        A.autoSetIntFloat(10.50f, 2);
        OutputText = A.toString(2);
        textOut.setText(OutputText);
        
        String command = "1,2,4;42.4,42.15";
        MtF.Matrix matrix = new MtF.Matrix("A", command);
        
    }    
    
    @FXML
    public void readCommand(){
        SintacsisFunc.Sintacsis sintacsis = null;
        if (!homeTextField.getText().isEmpty()) {
            sintacsis = new SintacsisFunc.Sintacsis(homeTextField.getText());
            OutputText += SintacsisFunc.readCommand(sintacsis);
            textOut.setText(OutputText);
        }
    }

    /**
     * Очищает окно вывода
     */
    @FXML
    public void ClearArea() {
        OutputText = "";
        textOut.setText("");
    }
    
    /**
     * Создает окно добавления матрицы
     * @throws IOException
     */
    @FXML
    public void addMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/createMatrix.fxml"));
        modalWindow.newWindow(root,javaFXMatrixLab.nameProgram + " - " + "Добавить матрицу",false);
    }
    
    /**
     * Создает окно редактирования матрицы
     * @throws IOException
     */
    @FXML
    public void editMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/editMatrix.fxml"));
        modalWindow.newWindow(root,javaFXMatrixLab.nameProgram + " - " + "Редактирование матрицы",false);
    }
    
    /**
     * Осуществляет удаление матрицы из памяти
     */
    @FXML
    public void deleteMatrix() { 
        if (historyContainer.getSelectionModel().getSelectedIndex() != -1) {
            historyContainer.getItems().remove(historyContainer.getSelectionModel().getSelectedIndex());
        }else{
            modalWindow.newAlert(AlertType.ERROR, null, "Вы не выбрали матрицу в таблице которую хотите удалить");
        }
    }
    
    public void refreshHistoryOfMatrix(){
        historyContainer.setItems(PublicConst.listOfHistory);
    }
}
