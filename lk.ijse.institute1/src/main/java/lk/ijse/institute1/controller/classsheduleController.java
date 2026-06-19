package lk.ijse.institute1.controller;

import bo.BOFactory;
import bo.custom.classsheduleBO;
import dto.sheduleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.util.ArrayList;

public class classsheduleController {

    private final classsheduleBO classsheduleBO = (classsheduleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SHEDULE);

    @FXML
    private ComboBox<String> cidcombobox; 

    @FXML
    private ComboBox<String> lidcombobox; 

    @FXML
    private ComboBox<String> timecombobox; 

    @FXML
    private TextField subjecttxt;

    @FXML
    private DatePicker datepiker;

    @FXML
    private Button savebtn;

    @FXML
    private Button clearBtn;

    @FXML
    private TableView<sheduleDTO> classsheduletbl; 

    @FXML
    private TableColumn<sheduleDTO, Integer> cidtbl;

    @FXML
    private TableColumn<sheduleDTO, String> subjecttbl;

    @FXML
    private TableColumn<sheduleDTO, Integer> lnametbl;

    @FXML
    private TableColumn<sheduleDTO, LocalDate> datetbl;

    @FXML
    private TableColumn<sheduleDTO, String> timetbl;

   public void initialize() {
        loadAllCourseIds();
        loadAllLecturerIds();
        setTimeSlots();
        setCellValueFactory();
        loadAllSchedules();

        classsheduletbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                cidcombobox.setValue(String.valueOf(newValue.getCourseId()));
                lidcombobox.setValue(String.valueOf(newValue.getLecturerId()));
                subjecttxt.setText(newValue.getSubjectName());
                datepiker.setValue(newValue.getDate());
                timecombobox.setValue(newValue.getTime());
            }
        });
    }

    private void loadAllCourseIds() {
        ObservableList<String> courseIds = FXCollections.observableArrayList("1", "2", "3");
        cidcombobox.setItems(courseIds);
    }

    private void loadAllLecturerIds() {
        ObservableList<String> lecturerIds = FXCollections.observableArrayList("1", "2", "3");
        lidcombobox.setItems(lecturerIds);
    }

    private void setTimeSlots() {
        ObservableList<String> timeSlots = FXCollections.observableArrayList(
            "08:30 AM - 11:30 AM",
            "01:00 PM - 04:00 PM",
            "04:30 PM - 07:30 PM"
        );
        timecombobox.setItems(timeSlots);
    }

    private void setCellValueFactory() {
        cidtbl.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        subjecttbl.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        lnametbl.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
        datetbl.setCellValueFactory(new PropertyValueFactory<>("date"));
        timetbl.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    private void loadAllSchedules() {
        try {
            classsheduletbl.getItems().clear();
            ArrayList<sheduleDTO> allSchedules = classsheduleBO.getAllSchedules();
            ObservableList<sheduleDTO> observableList = FXCollections.observableArrayList(allSchedules);
            classsheduletbl.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void savebtnOnAction(ActionEvent event) {
        String courseIdStr = cidcombobox.getValue();
        String lecturerIdStr = lidcombobox.getValue();
        String subject = subjecttxt.getText();
        LocalDate date = datepiker.getValue();
        String time = timecombobox.getValue();
        
        if (courseIdStr == null || lecturerIdStr == null || subject.isEmpty() || date == null || time == null) {
            new Alert(Alert.AlertType.WARNING, "please enter all values!").show();
            return;
        }

        try {
            String nextScheduleId = "S001"; 
            
            int courseId = Integer.parseInt(courseIdStr);
            int lecturerId = Integer.parseInt(lecturerIdStr);
            sheduleDTO dto = new sheduleDTO(nextScheduleId, courseId, lecturerId, subject, date, time);

            boolean isSaved = classsheduleBO.saveSchedule(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Class Schedule success!").show();
                clearFields();
                loadAllSchedules(); 
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong .").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    
     @FXML
    void deletebtnOnActtion(ActionEvent event) {
    sheduleDTO selectedItem = classsheduletbl.getSelectionModel().getSelectedItem();
        
        if (selectedItem == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a row to delete!").show();
            return;
        }

        try {
            boolean isDeleted = classsheduleBO.deleteSchedule(selectedItem.getScheduleId());
            
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Deleted successfully!").show();
                loadAllSchedules();
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
    void updatebtnONaction(ActionEvent event) {
        sheduleDTO selectedItem = classsheduletbl.getSelectionModel().getSelectedItem();
        
        if (selectedItem == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a row to update!").show();
            return;
        }

        String courseIdStr = cidcombobox.getValue();
        String lecturerIdStr = lidcombobox.getValue();
        String subject = subjecttxt.getText();
        LocalDate date = datepiker.getValue();
        String time = timecombobox.getValue();

        if (courseIdStr == null || lecturerIdStr == null || subject.isEmpty() || date == null || time == null) {
            new Alert(Alert.AlertType.WARNING, "Please enter all values!").show();
            return;
        }

        try {
            int courseId = Integer.parseInt(courseIdStr);
            int lecturerId = Integer.parseInt(lecturerIdStr);
            
            sheduleDTO dto = new sheduleDTO(selectedItem.getScheduleId(), courseId, lecturerId, subject, date, time);
            boolean isUpdated = classsheduleBO.updateSchedule(dto);

            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Updated successfully!").show();
                loadAllSchedules();
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
    void clearBtnOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        cidcombobox.getSelectionModel().clearSelection();
        lidcombobox.getSelectionModel().clearSelection();
        timecombobox.getSelectionModel().clearSelection();
        subjecttxt.clear();
        datepiker.setValue(null);
    }
    
    
 
   }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
