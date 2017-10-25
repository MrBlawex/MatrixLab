package javafxmatrixlab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXMatrixLab extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/javafxmatrixlab/fxml/homeMatrixLab.fxml"));
        
        int headpix = 50;
        Scene scene = new Scene(root);
        
        stage.setMinWidth(850);
        stage.setMinHeight(headpix + 550);
        stage.setTitle("MatrixLab");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}