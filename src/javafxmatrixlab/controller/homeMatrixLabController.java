package javafxmatrixlab.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafxmatrixlab.ErrorFunc;
import javafxmatrixlab.JavaFXMatrixLab;
import javafxmatrixlab.ModalWindow;
import javafxmatrixlab.MtF;
import javafxmatrixlab.SintacsisFunc;
import org.omg.CORBA_2_3.portable.InputStream;

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

    @FXML
    private ImageView ViewFormat;

    //Создание экземпляров класса
    JavaFXMatrixLab javaFXMatrixLab = new JavaFXMatrixLab();
    SintacsisFunc sintacsisFunc = new SintacsisFunc();
    ModalWindow modalWindow = new ModalWindow();
    ErrorFunc errorFunc = new ErrorFunc();

    public static class PublicVar {

        public static ObservableList<String> listOfHistory = FXCollections.observableArrayList(); //Массив текста из истории
        public static HashMap<String, MtF.Matrix> DATA_BASE_MATRIX = new HashMap<String, MtF.Matrix>();
        public static String OutputText = ""; //Текст из поля вывода
        public static String oldOutputText = "";//Сохраняет старый текст для возможности его восстановления
        public static Integer countOfDigits = 3;//Кол-во знаков после запятой
        public static Float epsilon = 0.001f;//Точность вычеслений дробей
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SintacsisFunc.PatternConst.initialize();
        allEvent();
        historyContainer.setItems(PublicVar.listOfHistory);
        textOut.setText(PublicVar.OutputText);
    }

    @FXML
    public void readCommand() {
        SintacsisFunc.Sintacsis sintacsis = null;
        if (!homeTextField.getText().isEmpty()) {
            sintacsis = new SintacsisFunc.Sintacsis(homeTextField.getText().replace(" ", ""));
            textOut.appendText(SintacsisFunc.readCommand(sintacsis));
            PublicVar.OutputText = textOut.getText();
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
        } else {
            modalWindow.newAlert(AlertType.INFORMATION, null, "Окно не нуждается в очистке, так как оно не имеет текста");
        }
    }

    @FXML
    public void FormatArea() {
        MtF.formatMode();
        String mode;
        if (MtF.Matrix.format) {
            mode = "on";
        } else {
            mode = "off";
        }
        PublicVar.OutputText += ">> Format:" + mode + "\n";
        textOut.setText(PublicVar.OutputText);
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
        } else {
            modalWindow.newAlert(AlertType.INFORMATION, null, "Старой версии текста не существует, так как не было проведено очистки окна");
        }
    }

    /**
     * Сохраняет всю информацию в текстовом поле во внешний файл txt
     *
     * @throws IOException
     */
    @FXML
    public void saveTextAreaToTxt() throws IOException {
        try (PrintWriter write = new PrintWriter("src\\javafxmatrixlab\\" + "textarea" + ".txt")) {
            write.println(PublicVar.OutputText);
        }
        modalWindow.newAlert(AlertType.INFORMATION, null, "Файл успешно сохранен");
    }

    /**
     * Добавляет окно настроек
     */
    @FXML
    public void settingsProgram() throws IOException {
        modalWindow.newAlert(AlertType.INFORMATION, null, "Это типа настройки");
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/settingsWindows.fxml"));
        modalWindow.newWindow(root, javaFXMatrixLab.nameProgram + "Настройки", false);

    }

    /**
     * Создает окно добавления матрицы
     *
     * @throws IOException
     */
    @FXML
    public void addMatrix() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/createMatrix.fxml"));
        modalWindow.newWindow(root, javaFXMatrixLab.nameProgram + " - " + "Добавить матрицу", false);
    }

    /**
     * Создает окно редактирования матрицы
     *
     * @param mouseEvent
     * @throws IOException
     */
    @FXML
    public void editMatrix(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {
            Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/editMatrix.fxml"));
            modalWindow.newWindow(root, javaFXMatrixLab.nameProgram + " - " + "Редактирование матрицы", false);
        }
    }

    /**
     * Осуществляет удаление матрицы из памяти
     */
    @FXML
    public void deleteMatrix() {
        if (historyContainer.getSelectionModel().getSelectedIndex() != -1) {
            PublicVar.DATA_BASE_MATRIX.remove(historyContainer.getSelectionModel().getSelectedItem());
            historyContainer.getItems().remove(historyContainer.getSelectionModel().getSelectedIndex());
        } else {
            modalWindow.newAlert(AlertType.ERROR, null, "Вы не выбрали матрицу в таблице которую хотите удалить");
        }
    }

    public void allEvent() {
        //По нажатию ENTER активируется функция
        homeTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ENTER) {
                    readCommand();
                }
            }
        });
    }

    public void closeProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

}
