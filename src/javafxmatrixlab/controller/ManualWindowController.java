/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmatrixlab.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Bogdan
 */
public class ManualWindowController implements Initializable {

    @FXML
    private WebView mainWin;

    URL url;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        url = getClass().getResource("/javafxmatrixlab/manual.html");
        mainWin.getEngine().load(url.toExternalForm());
        mainWin.contextMenuEnabledProperty().set(false);
        
    }
}
