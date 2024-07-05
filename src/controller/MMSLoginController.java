package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class MMSLoginController extends Controller<Session> {

    public final Session getSession() { return model; }
    
    @FXML private TextField emailTf;
    @FXML private PasswordField passwordPf;
    @FXML private Label errorLbl;
    
    private String getEmail() {
        return emailTf.getText();
    }
    
    private void setEmail(String initial) {
        emailTf.setText(initial);
    }
    
    private String getPassword() {
        return passwordPf.getText();
    }
    
    private void setPassword(String initial) {
        passwordPf.setText(initial);
    }
    
    private void setErrorMessage(String message) {
        errorLbl.setText(message);
    }
    
    @FXML private void handleOK(ActionEvent event) throws Exception {
        SuperMarket superMarket = getSession().getSuperMarket(getEmail(), getPassword());
        if(superMarket != null) {
            Stage superMarketStage = new Stage();
            superMarketStage.getIcons().add(new Image("view/SuperMarket.png"));
            ViewLoader.showStage(superMarket, "/view/SuperMarket.fxml", "Session Admin: " + superMarket.getName(), superMarketStage);
            stage.close();
        }
        else {
            setErrorMessage("Incorrect login details");
            setEmail("");
            setPassword("");
        }
    }
    
    @FXML private void handleCancel(ActionEvent event) {
        stage.close();
    }
}

