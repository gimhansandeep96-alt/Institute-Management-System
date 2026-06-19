package lk.ijse.institute1.controller;

import bo.BOFactory;
import bo.custom.attendanceBO;
import dto.attendanceDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;
import java.util.ArrayList;

public class classattendanceController {

    private final attendanceBO attendanceBO = (attendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);

    @FXML
    private TableColumn<attendanceDTO, Integer> attendanceidtbl;

    @FXML
    private TextField attendanceidtxt;

    @FXML
    private Button clearbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private Button savebtn;

    @FXML
    private ComboBox<String> scheduleidcombo;

    @FXML
    private TableColumn<attendanceDTO, Integer> scheduleidtbl;

    @FXML
    private ComboBox<String> statuscombo;

    @FXML
    private TableColumn<attendanceDTO, String> statustbl;

    @FXML
    private TableView<attendanceDTO> studentattendancetbl;

    @FXML
    private ComboBox<String> studentidcombo;

    @FXML
    private TableColumn<attendanceDTO, Integer> studentidtbl;

    @FXML
    private Button updatebtn;

    public void initialize() {
        attendanceidtxt.setEditable(false);
        attendanceidtxt.setDisable(true);
        
        loadAllScheduleIds();
        loadAllStudentIds();
        setStatusOptions();
        setCellValueFactory();
        loadAllAttendance();

        studentattendancetbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                attendanceidtxt.setText(String.valueOf(newValue.getAttendanceId()));
                scheduleidcombo.setValue(String.valueOf(newValue.getScheduleId()));
                studentidcombo.setValue(String.valueOf(newValue.getStudentId()));
                statuscombo.setValue(newValue.getStatus());
            }
        });
    }

    private void loadAllScheduleIds() {
        ObservableList<String> scheduleIds = FXCollections.observableArrayList("1", "2", "3");
        scheduleidcombo.setItems(scheduleIds);
    }

    private void loadAllStudentIds() {
        ObservableList<String> studentIds = FXCollections.observableArrayList("1", "2", "3");
        studentidcombo.setItems(studentIds);
    }

    private void setStatusOptions() {
        ObservableList<String> statusOptions = FXCollections.observableArrayList("Present", "Absent");
        statuscombo.setItems(statusOptions);
    }

    private void setCellValueFactory() {
        attendanceidtbl.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        scheduleidtbl.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        studentidtbl.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        statustbl.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllAttendance() {
        try {
            studentattendancetbl.getItems().clear();
            ArrayList<attendanceDTO> allAttendance = attendanceBO.getAllAttendance();
            ObservableList<attendanceDTO> observableList = FXCollections.observableArrayList(allAttendance);
            studentattendancetbl.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void savebtnonaction(ActionEvent event) {
        String scheduleIdStr = scheduleidcombo.getValue();
        String studentIdStr = studentidcombo.getValue();
        String status = statuscombo.getValue();

        if (scheduleIdStr == null || studentIdStr == null || status == null) {
            new Alert(Alert.AlertType.WARNING, "Please enter all values!").show();
            return;
        }

        try {
            int scheduleId = Integer.parseInt(scheduleIdStr);
            int studentId = Integer.parseInt(studentIdStr);
            
            attendanceDTO dto = new attendanceDTO(0, scheduleId, studentId, status);
            boolean isSaved = attendanceBO.saveAttendance(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Attendance successfully marked!").show();
                clearFields();
                loadAllAttendance();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void updatebtnonaction(ActionEvent event) {
        attendanceDTO selectedItem = studentattendancetbl.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a row to update!").show();
            return;
        }

        String scheduleIdStr = scheduleidcombo.getValue();
        String studentIdStr = studentidcombo.getValue();
        String status = statuscombo.getValue();

        if (scheduleIdStr == null || studentIdStr == null || status == null) {
            new Alert(Alert.AlertType.WARNING, "Please enter all values!").show();
            return;
        }

        try {
            int scheduleId = Integer.parseInt(scheduleIdStr);
            int studentId = Integer.parseInt(studentIdStr);

            attendanceDTO dto = new attendanceDTO(selectedItem.getAttendanceId(), scheduleId, studentId, status);
            boolean isUpdated = attendanceBO.updateAttendance(dto);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Attendance updated successfully!").show();
                loadAllAttendance();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Update failed!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void deletebtnonaction(ActionEvent event) {
        attendanceDTO selectedItem = studentattendancetbl.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a row to delete!").show();
            return;
        }

        try {
            boolean isDeleted = attendanceBO.deleteAttendance(selectedItem.getAttendanceId());

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Deleted successfully!").show();
                loadAllAttendance();
                clearFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Delete failed!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    @FXML
    void clearbtnonaction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        attendanceidtxt.clear();
        scheduleidcombo.getSelectionModel().clearSelection();
        studentidcombo.getSelectionModel().clearSelection();
        statuscombo.getSelectionModel().clearSelection();
    }
}