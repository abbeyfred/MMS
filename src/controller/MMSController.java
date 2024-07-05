package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import model.*;


public class MMSController extends Controller<MMS>{
    
    public final MMS getMMS() { return model; }
            
    @FXML private TableView<Membership> slipsTv;
    @FXML private Label totalExpenseLbl;
    @FXML private Label AvgGasdeductionRateLbl;
    @FXML private Label AvgPayPerCreditLbl;
    @FXML private Label TotalCreditsLbl;
    @FXML private Label AvgDeductionRateLbl;
    @FXML private Label TotalDollarAvailableLbl;
    @FXML private TableColumn<Membership, String> expenseClm;
    @FXML private TableColumn<Membership, String> creditsClm;
    @FXML private TableColumn<Membership, String> gasDeductionRateClm;
    @FXML private TableColumn<Membership, String> deductionRateClm;
    @FXML private TableColumn<Membership, String> payPerCreditClm;
    @FXML private TableColumn<Membership, String> dollarAvailableClm;
            
    @FXML private void initialize() {
        slipsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        totalExpenseLbl.textProperty().bind(getMMS().ExpenseProperty().asString("$%.2f"));
        AvgGasdeductionRateLbl.textProperty().bind(getMMS().GasdeductionRateProperty().asString("%.2f"));
        AvgPayPerCreditLbl.textProperty().bind(getMMS().PayPerCreditProperty().asString("%.2f"));
        TotalCreditsLbl.textProperty().bind(getMMS().totalCreditsProperty().asString("%.2f"));
        AvgDeductionRateLbl.textProperty().bind(getMMS().deductionRateProperty().asString("%.2f"));
        TotalDollarAvailableLbl.textProperty().bind(getMMS().DollarAvailableProperty().asString("$%.2f"));
        
        expenseClm.setCellValueFactory(cellData -> cellData.getValue().expenseProperty().asString("$%.2f"));
        creditsClm.setCellValueFactory(cellData -> cellData.getValue().totalCreditsProperty().asString("%.2f"));
        gasDeductionRateClm.setCellValueFactory(cellData -> cellData.getValue().GasdeductionRateProperty().asString("%.2f"));
        deductionRateClm.setCellValueFactory(cellData -> cellData.getValue().deductionRateProperty().asString("%.2f"));
        payPerCreditClm.setCellValueFactory(cellData -> cellData.getValue().payPerCreditProperty().asString("%.2f"));
        dollarAvailableClm.setCellValueFactory(cellData -> cellData.getValue().DollarAvailableProperty().multiply(1.00).asString("$%.2f"));
    }
    
    @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }
    
}
