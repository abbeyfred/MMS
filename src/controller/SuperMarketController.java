package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class SuperMarketController extends Controller<SuperMarket> {
    
    public final SuperMarket getSuperMarket() { return model; }
    
    @FXML private TableView<Membership> membershipsTv;
    @FXML private TextField nameTf;
    @FXML private TextField emailTf;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button SLIPBtn;
    
    private String getName() {
        return nameTf.getText();
    }
    
    private String getEmail() {
        return emailTf.getText();
    }
    
    private Membership getSelectedMembership() {
        return membershipsTv.getSelectionModel().getSelectedItem();
    }
    
    @FXML private void initialize() {
        membershipsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        nameTf.textProperty().addListener(
            (observable, oldName, newName) -> {
                if(getEmail().equals("")) {
                    getSuperMarket().filterList(newName, "123456789");
                }
            }
        );
        emailTf.textProperty().addListener(
            (observable, oldEmail, newEmail) -> {
                if(getName().equals("")) {
                    getSuperMarket().filterList("123456789", newEmail);
                }
            }
        );
        membershipsTv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldMembership, newMembership) -> {
                deleteBtn.setDisable(newMembership == null);
                selectBtn.setDisable(newMembership == null);
                SLIPBtn.setDisable(newMembership == null);
            }
        );
    }
    
    @FXML private void handleAdd(ActionEvent event) throws Exception {
        Membership membership = new Membership("", "", "", "", "", 0.0);
        getSuperMarket().addMembership(membership);
        Stage membershipStageAdd = new Stage();
        membershipStageAdd.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(membership, "/view/Membership.fxml", "Adding New Membership", membershipStageAdd);
    }
    
    @FXML private void handleDelete(ActionEvent event) {
        getSuperMarket().removeMembership(getSelectedMembership());
    }
    
    @FXML private void handleSelect(ActionEvent event) throws Exception {
        Stage membershipStage = new Stage();
        membershipStage.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(getSelectedMembership(), "/view/Membership.fxml", "Accessing File: " + getSelectedMembership().getName(), membershipStage);
        deleteBtn.setDisable(true);
        selectBtn.setDisable(true);
        SLIPBtn.setDisable(true);
    }
    
    @FXML private void handleSLIP(ActionEvent event) throws Exception {
        Stage slipStage = new Stage();
        slipStage.getIcons().add(new Image("view/edit.png"));
        ViewLoader.showStage(getSelectedMembership(), "/view/slip.fxml", getSelectedMembership().getName() + " SLIP Report", slipStage);
        deleteBtn.setDisable(true);
        selectBtn.setDisable(true);
        SLIPBtn.setDisable(true);
    }
    
    @FXML private void handleReport(ActionEvent event) throws Exception {
        Stage reportStage = new Stage();
        reportStage.getIcons().add(new Image("view/uts.jpeg"));
        ViewLoader.showStage(new MMS(getSuperMarket()), "/view/mms.fxml", "MMS Report", reportStage);
    }
    
    @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }
                
}
