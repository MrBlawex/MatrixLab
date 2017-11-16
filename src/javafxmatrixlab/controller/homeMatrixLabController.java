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
    public TextArea textOut;
    
    @FXML
    private TextField homeTextField;

    @FXML
    private ListView<String> historyContainer;

    //Создание экземпляров класса
    JavaFXMatrixLab javaFXMatrixLab = new JavaFXMatrixLab();
    SintacsisFunc sintacsisFunc = new SintacsisFunc();
    ModalWindow modalWindow = new ModalWindow();
    ErrorFunc errorFunc = new ErrorFunc();
     
    
    public static class PublicVar{
        public static ObservableList<String> listOfHistory = FXCollections.observableArrayList();//Массив текста из истории
        public static HashMap<String, MtF.Matrix> DATA_BASE_MATRIX = new HashMap<String, MtF.Matrix>();
        static String OutputText = "";//Текст из поля вывода
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SintacsisFunc.PatternConst.initialize();
        PublicVar.listOfHistory.add("hi");
        historyContainer.setItems(PublicVar.listOfHistory);
        printError(ErrorType.WRONG_NAME);
        String command = "13,2,3.14,3;4,5,6;7,8,9;10,11,12";
        MtF.Matrix A = new MtF.Matrix("A", command);
        PublicVar.OutputText = A.toString(2);
        textOut.setText(PublicVar.OutputText);
    }    
    
    @FXML
    public void readCommand(){
        SintacsisFunc.Sintacsis sintacsis = null;
        if (!homeTextField.getText().isEmpty()) {
            sintacsis = new SintacsisFunc.Sintacsis(homeTextField.getText());
            PublicVar.OutputText += SintacsisFunc.readCommand(sintacsis);
            textOut.setText(PublicVar.OutputText);
        }
        homeMatrixLabController.PublicVar.listOfHistory.add("dwawd");
        homeTextField.setText("");
    }

    /**
     * Очищает окно вывода
     */
    @FXML
    public void ClearArea() {
        PublicVar.OutputText = "";
        textOut.setText("");
    }
    
    public void refresh(String newText) {
        textOut.setText(newText);
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
    
    public void setNewVerList(){
        PublicVar.listOfHistory.add("dwadwa");
    }
    
    public void printError(ErrorType errorType) {
        PublicVar.OutputText += "\n" + ErrorFunc.returnError(errorType);
        refresh(PublicVar.OutputText);
    }
    
    
    
}
