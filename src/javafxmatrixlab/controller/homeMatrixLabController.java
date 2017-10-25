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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafxmatrixlab.ModalWindow;


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
    ModalWindow modalWindow = new ModalWindow();
    
    //Глобальные переменные
    ObservableList<String> listOfHistory = FXCollections.observableArrayList();//Массив текста из истории
    
    //Внутренние переменные
    String OutputText = null;//Текст из поля вывода
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> value = FXCollections.observableArrayList("hi","Bro");
    }    
    
    @FXML//Очистить поле вывода
    public void ClearArea() {
        OutputText = "";
        textOut.setText("");
    }
    
    
    @FXML
    public void addMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafx_equalmathlab/fxml/createMatrix.fxml"));
        modalWindow.newWindow(root,"Добавить матрицу",false);
    }
    
    public void editMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafx_equalmathlab/fxml/editMatrix.fxml"));
        modalWindow.newWindow(root,"Редактирование матрицы",false);
    }
    
    @FXML
    public void deleteMatrix() { 
        int selectionIndex = historyContainer.getSelectionModel().getSelectedIndex();
        
        listOfHistory.remove(selectionIndex);
    }
}