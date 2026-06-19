package lk.ijse.institute1.controller;

import bo.BOFactory;
import static bo.BOFactory.BOTypes.STUDENT;
import bo.custom.studentBO;
import bo.custom.Impl.studentBOImpl;
import bo.superBO;
import dto.studentDTO;
import entity.studentEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.institute1.dao.DAOFactory;
import static lk.ijse.institute1.dao.DAOFactory.DAOTypes.STUDENT;
import lk.ijse.institute1.dao.custom.studentDAO;
import lk.ijse.institute1.dao.custom.impl.studentDAOImpl;

public class studentController {
private final studentBO studentBO =(studentBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    @FXML
    private Button clearbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private TextField sadresstxt;

    @FXML
    private Button savebtn;

    @FXML
    private TextField semailtxt;

    @FXML
    private TextField sidtxt;

    @FXML
    private TextField snametxt;

    @FXML
    private TableColumn<studentDTO, String> stbladress;

    @FXML
    private TableColumn<studentDTO, String> stblemail;

    @FXML
    private TableColumn<studentDTO, Integer> stblid;

    @FXML
    private TableColumn<studentDTO, String> stblname;

    @FXML
    private TableView<studentDTO> studenttbl;

    @FXML
    private Button updatebtn;
    
        private final ObservableList <studentDTO> studentlist =FXCollections.observableArrayList();

 @FXML
    public void initialize(){
    stblid.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    stblname.setCellValueFactory(new PropertyValueFactory<>("studentName"));
    stblemail.setCellValueFactory(new PropertyValueFactory<>("studentemail"));
    stbladress.setCellValueFactory(new PropertyValueFactory<>("studentadress"));
    
    studenttbl.setItems(studentlist);
    loadAllstudent();
    
    
    studenttbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue != null) {
            sidtxt.setText(String.valueOf(newValue.getStudentId())); 
            snametxt.setText(newValue.getStudentName());
            semailtxt.setText(newValue.getStudentemail());
            sadresstxt.setText(newValue.getStudentadress());
        }
    });
    
    }
        
        
        
        
    @FXML
    void clearbtnOnAction(ActionEvent event) {
      clearFields();
    }

     private void clearFields() {
       sidtxt.clear();
        snametxt.clear();
        semailtxt.clear();
        sadresstxt.clear();
    }

    @FXML
    void deletebtnOnAction(ActionEvent event) {
try {
            int id = Integer.parseInt(sidtxt.getText().trim());
            boolean result = studentBO.delete(id);
            
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Student Deleted Successfully! 😍").show();
                clearFields();
                loadAllstudent();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Student! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid student ID !").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void savebtnOnAction(ActionEvent event) {
try {
            int id = Integer.parseInt(sidtxt.getText().trim());
            String name = snametxt.getText().trim();
            String email = semailtxt.getText().trim();
            String adress =sadresstxt.getText().trim();

            studentDTO dto = new studentDTO(id, name, email, adress);
            //studentEntity Entity = new studentEntity(dto.getStudentId(), dto.getStudentName(), dto.getStudentemail(), dto.getStudentadress());

            boolean result = studentBO.save(dto);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Student Saved Successfully! 😍").show();
                clearFields();
                loadAllstudent();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Student! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for student ID !").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }




    }

    @FXML
    void updatebtnOnAction(ActionEvent event) {
 try {
            int id = Integer.parseInt(sidtxt.getText().trim());
            String name = snametxt.getText().trim();
            String email = semailtxt.getText().trim();
            String adress =sadresstxt.getText().trim();

            studentDTO dto = new studentDTO(id, name, email, adress);
            //studentEntity Entity = new studentEntity(dto.getStudentId(), dto.getStudentName(), dto.getStudentemail(), dto.getStudentadress());
            
            boolean result = studentBO.update(dto);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Student Updated Successfully! 😍").show();
                clearFields();
                loadAllstudent();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Student! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for student ID !").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    
    private void loadAllstudent() {
         try {
        studentlist.clear();  
        
        java.util.ArrayList<studentDTO> dtoList = studentBO.getAll();  
        
        studentlist.addAll(dtoList); 
        
    } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Failed to load Student: " + e.getMessage()).show();
    }
} 
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    

