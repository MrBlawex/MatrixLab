package javafxmatrixlab.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafxmatrixlab.ErrorFunc;
import javafxmatrixlab.ModalWindow;
import javafxmatrixlab.MtF;
import javafxmatrixlab.JavaFXMatrixLab;
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
     
    //Глобальные переменные
    ObservableList<String> listOfHistory = FXCollections.observableArrayList();//Массив текста из истории
  
    
    //Внутренние переменные
    String OutputText = "";//Текст из поля вывода
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> value = FXCollections.observableArrayList("hi","Bro");
    }    
    
    @FXML
    public void readCommand(){
        SintacsisFunc.Sintacsis sintacsis = null;
        if (homeTextField.getText() != "") {
            sintacsis = new SintacsisFunc.Sintacsis(homeTextField.getText());
        }
        OutputText += SintacsisFunc.readCommand(sintacsis);
    }
    @FXML//Очистить поле вывода
    public void ClearArea() {
        OutputText = "";
        textOut.setText("");
    }
    
    
    @FXML
    public void addMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/createMatrix.fxml"));
        modalWindow.newWindow(root,javaFXMatrixLab.nameProgram + " - " + "Добавить матрицу",false);
    }
    
    @FXML
    public void editMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/editMatrix.fxml"));
        modalWindow.newWindow(root,javaFXMatrixLab.nameProgram + " - " + "Редактирование матрицы",false);
    }
    
    @FXML
    public void deleteMatrix() { 
        if (historyContainer.getSelectionModel().getSelectedIndex() == 1) {
            int selectionIndex = historyContainer.getSelectionModel().getSelectedIndex();
            listOfHistory.remove(selectionIndex);
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(javaFXMatrixLab.nameProgram);
            alert.setHeaderText("Ошибка");
            alert.setContentText("Вы не выбрали матрицу в таблице которую хотите удалить");
            alert.showAndWait();        
        }
    }
}