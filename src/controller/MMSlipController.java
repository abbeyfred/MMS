package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import model.*;

public class MMSlipController extends Controller<Membership>{

    public final Membership getMembership() { return model; }
    
    @FXML private Label totalCreditsLbl;
    @FXML private Label totalExpenseLbl;
    @FXML private Label gasDeductionRateLbl;
    @FXML private Label payPerCreditLbl;
    @FXML private Label dollarAvailableLbl;
    @FXML private Label deductionRateLbl;
    
    @FXML private void initialize() {
        totalCreditsLbl.textProperty().bind(getMembership().totalCreditsProperty().asString("%.2f"));
        totalExpenseLbl.textProperty().bind(getMembership().expenseProperty().asString("$%.2f"));
        gasDeductionRateLbl.textProperty().bind(getMembership().GasdeductionRateProperty().asString("%.2f"));
        payPerCreditLbl.textProperty().bind(getMembership().payPerCreditProperty().asString("%.2f"));
        dollarAvailableLbl.textProperty().bind(getMembership().DollarAvailableProperty().multiply(1.00).asString("$%.2f"));
        deductionRateLbl.textProperty().bind(getMembership().deductionRateProperty().asString("%.2f"));     
    }
    
    @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }

}