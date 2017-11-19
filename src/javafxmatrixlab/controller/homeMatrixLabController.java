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
        public static ObservableList<String> listOfHistory = FXCollections.observableArrayList(); //Массив текста из истории
        public static HashMap<String, MtF.Matrix> DATA_BASE_MATRIX = new HashMap<String, MtF.Matrix>();
        public static String OutputText = ""; //Текст из поля вывода
        public static String oldOutputText = "";//Сохраняет старый текст для возможности его восстановления
        public static Integer countOfDigits = 2;
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SintacsisFunc.PatternConst.initialize();
        
        //Для тестов
        PublicVar.listOfHistory.add("StartItem");
        historyContainer.setItems(PublicVar.listOfHistory);
        MtF.Matrix A = new MtF.Matrix("A",4,4);
        A.autoSetInt(10);
        PublicVar.OutputText += A.toString(2);
        MtF.Matrix revA = MtF.ReversMatrix(A);
        PublicVar.OutputText += revA.toString(4);
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
        homeTextField.setText("");
    }

    /**
     * Очищает окно вывода
     */
    @FXML
    public void ClearArea() {
        if (!PublicVar.OutputText.isEmpty()) {
            PublicVar.oldOutputText = PublicVar.OutputText;
            PublicVar.OutputText = "";
            textOut.setText("");
        }
        else {
            modalWindow.newAlert(AlertType.INFORMATION, null, "Окно не нуждается в очистке, так как оно не имеет текста");
        }
    }
    /**
     * Возвращает старое окно вывода
     */
    @FXML
    public void getOldArea() {
        if (!PublicVar.oldOutputText.isEmpty()) {
            PublicVar.OutputText = PublicVar.oldOutputText;
            PublicVar.oldOutputText = "";
            textOut.setText(PublicVar.OutputText);
        }
        else {
            modalWindow.newAlert(AlertType.INFORMATION, null, "Старой версии текста не существует, так как не было проведено очистки окна");
        }
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
            PublicVar.DATA_BASE_MATRIX.remove(historyContainer.getSelectionModel().getSelectedItem());
            historyContainer.getItems().remove(historyContainer.getSelectionModel().getSelectedIndex());
        }else{
            modalWindow.newAlert(AlertType.ERROR, null, "Вы не выбрали матрицу в таблице которую хотите удалить");
        }
    }
    
}
