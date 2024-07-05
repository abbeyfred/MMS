package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class MembershipController extends Controller<Membership> {
    
    public final Membership getMembership() { return model; }
    
    Validator validator = new Validator();
    
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private TextField phoneTf;
    @FXML private TextField addressTf;
    @FXML private TextField IDTf;
    @FXML private TextField expenseTf;
    @FXML private Text typeTxt;
    @FXML private Button addBtn;
    @FXML private Button updateBtn;
    
    private String getName() {
        return nameTf.getText();
    }
    
    private void setName(String newName) {
        nameTf.setText(newName);
    }
    
    private String getEmail() {
        return emailTf.getText();
    }
    
    private void setEmail(String newEmail) {
        emailTf.setText(newEmail);
    }
    
    private String getPhone() {
        return phoneTf.getText();
    }
    
    private void setPhone(String newPhone) {
        phoneTf.setText(newPhone);
    }
    
    private String getAddress() {
        return addressTf.getText();
    }
    
    private void setAddress(String newAddress) {
        addressTf.setText(newAddress);
    }
    
    private String getID() {
        return IDTf.getText();
    }
    
    private void setID(String newId) {
        IDTf.setText(newId);
    }
    
    private double getExpense() {
        return Double.parseDouble(expenseTf.getText());
    }
    
    private void setExpense(double newExpense) {
        expenseTf.setText("" + newExpense);
    }
    
    private void setType(String newType) {
        typeTxt.setText(newType);
    }
        
    @FXML private void initialize() {
        setName(getMembership().getName());
        setEmail(getMembership().getEmail());
        setPhone(getMembership().getPhone());
        setAddress(getMembership().getAddress());
        setID(getMembership().getID());
        setExpense(getMembership().getexpense());
        setType(getMembership().getType());
        if(nameTf.textProperty().getValue().equals("")) {
            updateBtn.setDisable(true);
        }
        else {
            addBtn.setDisable(true);
        }
    }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        if(validator.isValid(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense())) {
            getMembership().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense());
            stage.close();
        }
        else {
            validator.generateErrors(getName(), getEmail(), getPhone(), getAddress(), getID(), getExpense());
            Stage errorStage = new Stage();
            errorStage.getIcons().add(new Image("view/error.png"));
            ViewLoader.showStage(validator, "/view/error.fxml", "Input Exceptions", errorStage);
            getMembership().getSuperMarket().getMemberships().remove(getMembership());
        }
    }
    
    @FXML private void handleUpdate(ActionEvent event) throws Exception {
        if(validator.isValid(getName(), getEmail(), getPhone(), getAddress(), getID(),  getExpense())) {
            getMembership().updateDetails(getName(), getEmail(), getPhone(), getAddress(), getID(),  getExpense());
            stage.close();
        }
        else {
            validator.generateErrors(getName(), getEmail(), getPhone(), getAddress(), getID(),  getExpense());
            Stage errorStage = new Stage();
            errorStage.getIcons().add(new Image("view/error.png"));
            ViewLoader.showStage(validator, "/view/error.fxml", "Input Exceptions", errorStage);
        }
    }
    
    @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }

}
