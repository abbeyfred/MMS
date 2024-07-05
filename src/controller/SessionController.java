package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;
import javafx.application.Platform;

public class SessionController extends Controller<Session> {
    
    public final Session getSession() { return model; }
    
    @FXML private void handleLogin(ActionEvent event) throws Exception {
        Stage MMSLoginStage = new Stage();
        MMSLoginStage.getIcons().add(new Image("view/book.png"));
        ViewLoader.showStage(getSession(), "/view/MMSlogin.fxml", "Sign In", MMSLoginStage);
    }
    
    @FXML private void handleExit(ActionEvent event) {
        Platform.exit();
    }
}
