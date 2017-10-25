package javafxmatrixlab;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalWindow {
    public void newWindow(Parent root,String title,Boolean resizeble) throws IOException{        
        int headpix = 50;
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
//        stage.setMinWidth(640);
//        stage.setMinHeight(headpix + 480);
        stage.setTitle(title);
        stage.setResizable(resizeble);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setScene(scene);
        stage.show();
    }
}