package javafxmatrixlab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXMatrixLab extends Application {
    
    public String nameProgram = "MatrixLab";
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/homeMatrixLab.fxml"));
        
        int headpix = 50;
        Scene scene = new Scene(root);
        
        stage.setMinWidth(870);
        stage.setMinHeight(headpix + 550);
        stage.setTitle(nameProgram);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
    Замеченые Баги:
        - Кривой вывод при большом количестве знаков
        - Баг при сохранении "ошибочной" матрицы в Ans
        - Ошибка при вызове несуществующей матрицы в списке

*/