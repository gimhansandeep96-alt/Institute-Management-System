package lk.ijse.institute1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordtxt;

    @FXML
    private TextField usernametxt;

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        String username = usernametxt.getText();
        String password = passwordtxt.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please fill all fields!");
            return;
        }

        String role = null;

        if (username.equals("admin") && password.equals("admin123")) {
            role = "Admin";
        } else if (username.equals("lecturer") && password.equals("lec123")) {
            role = "Lecturer";
        }

        if (role != null) {
            try {
                Stage stage = (Stage) loginBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/ijse/institute1/view/logininterface.fxml"));
                stage.setScene(new Scene(loader.load()));
                
                logininterfaceController dashboardController = loader.getController();
                dashboardController.setUserRole(role);

                stage.setTitle("SAMS - Dashboard (" + role + ")");
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "UI Error", "Could not load dashboard UI!");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password!");
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