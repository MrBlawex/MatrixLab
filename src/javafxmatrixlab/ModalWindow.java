package javafxmatrixlab;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWindow {
    JavaFXMatrixLab javaFXMatrixLab = new JavaFXMatrixLab();

    /**
     * Создание нового окна
     * @param rootStage - ссылка на документ разметки
     * @param title - название окна
     * @param resizeble - изменение размера окна
     * @throws IOException
     */
    public void newWindow(Parent rootStage,String title,Boolean resizeble) throws IOException{        
        int headpix = 50;
        Scene scene = new Scene(rootStage);
        
        Stage stage = new Stage();
//        stage.setMinWidth(640);
//        stage.setMinHeight(headpix + 480);
        stage.setTitle(javaFXMatrixLab.nameProgram + " - " + title);
        stage.setResizable(resizeble);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Создание диалогового окна
     * @param alertType - тип окна
     * @param HeaderText - текст верхней части окна
     * @param ContextText - текст оснвной части окна
     */
    public void newAlert(Alert.AlertType alertType,String HeaderText,String ContextText){
        Alert alert = new Alert(alertType);
        alert.setTitle(javaFXMatrixLab.nameProgram);
        alert.setHeaderText(HeaderText);
        alert.setContentText(ContextText);
        alert.showAndWait();
    }
}