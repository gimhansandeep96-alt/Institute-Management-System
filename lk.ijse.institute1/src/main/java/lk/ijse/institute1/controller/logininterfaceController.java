package lk.ijse.institute1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import javafx.stage.Stage;

public class logininterfaceController {

    @FXML
    private Button classScheduleBtn;

    @FXML
    private AnchorPane contextPane;

    @FXML
    private Button courseManagementBtn;

    @FXML
    private Button lecturerManagementBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button studentAttendanceBtn;

    @FXML
    private Button studentManagementBtn;

    private String userRole;

    public void setUserRole(String role) {
        this.userRole = role;
        if (role.equalsIgnoreCase("Lecturer")) {
            courseManagementBtn.setDisable(true);
            studentManagementBtn.setDisable(true);
            lecturerManagementBtn.setDisable(true);
        }
    }

    private void setUi(String fxmlPath) {
        try {
            URL resource = getClass().getResource("/lk/ijse/institute1/view/" + fxmlPath + ".fxml");
            
            if (resource == null) {
                showAlert(Alert.AlertType.ERROR, "Error", fxmlPath + ".fxml not found!\nPlease check resources/lk/ijse/institute1/view/ folder.");
                return;
            }
            
            Parent node = FXMLLoader.load(resource);
            contextPane.getChildren().clear();
            contextPane.getChildren().add(node);
            
            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "UI Load Error", "Could not load UI: " + e.getMessage());
        }
    }

    @FXML
    void courseManagementBtnOnAction(ActionEvent event) {
        setUi("course");
    }

    @FXML
    void studentManagementBtnOnAction(ActionEvent event) {
        setUi("student");
    }

    @FXML
    void lecturerManagementBtnOnAction(ActionEvent event) {
        setUi("lecturer");
    }

    @FXML
    void classScheduleBtnOnAction(ActionEvent event) {
        setUi("classshedule");
    }

    @FXML
    void studentAttendanceBtnOnAction(ActionEvent event) {
        setUi("classattendance");
    }

    @FXML
    void logoutBtnOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to logout?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                Stage stage = (Stage) contextPane.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/institute1/view/login.fxml"));
                stage.setScene(new Scene(loader.load()));
                stage.centerOnScreen();
                stage.setTitle("SAMS - Login");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Could not load login page.");
            }
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}