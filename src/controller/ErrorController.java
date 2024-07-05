package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.*;

public class ErrorController extends Controller<Validator> {

    public final Validator getValidator() { return model; }
    
    @FXML private Text errorsTxt;
    
    private void setErrors(String errors) {
        errorsTxt.setText(errors);
    }
    
    @FXML private void initialize() {
        String errors = "";
        for(String error : getValidator().errors()) {
            errors += error;
        }
        setErrors(errors);
    }
    
    @FXML private void handleOkay(ActionEvent event) {
        stage.close();
        getValidator().clear();
    }
}
