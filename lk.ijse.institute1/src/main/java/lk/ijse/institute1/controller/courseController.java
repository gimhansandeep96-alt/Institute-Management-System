package lk.ijse.institute1.controller;

import dto.courseDTO;
import entity.courseEntity;
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
import lk.ijse.institute1.dao.courseDAOImpl;

public class courseController {
private final courseDAOImpl courseDAO = new courseDAOImpl();
    @FXML
    private Button clearbtn;
    
    

    @FXML
    private TableView<courseDTO> coursetable;

    @FXML
    private Button deletebtn;

    @FXML
    private TableColumn<courseDTO,String > durationtbl;

    @FXML
    private TableColumn<courseDTO,Integer> idtble;

    @FXML
    private TableColumn<courseDTO,String > nametbl;

    @FXML
    private TableColumn<courseDTO,Double> pricetbl;

    @FXML
    private Button savebtn;

    @FXML
    private TextField txtduration;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtprice;

    @FXML
    private Button updatebtn;

    private final ObservableList <courseDTO> courselist =FXCollections.observableArrayList();
            
    @FXML
    public void initialize(){
    idtble.setCellValueFactory(new PropertyValueFactory<>("courseId"));
    nametbl.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    durationtbl.setCellValueFactory(new PropertyValueFactory<>("duration"));
    pricetbl.setCellValueFactory(new PropertyValueFactory<>("price"));
    
    coursetable.setItems(courselist);
    loadAllCourses();
    
   coursetable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue != null) {
        
        txtid.setText(String.valueOf(newValue.getCourseId())); 
        txtname.setText(newValue.getCourseName());
        txtduration.setText(newValue.getDuration());
        txtprice.setText(String.valueOf(newValue.getPrice()));
    }
});
    }
    
    
    
   @FXML
    void clearbtnOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtid.clear();
        txtname.clear();
        txtduration.clear();
        txtprice.clear();
    }

    
    @FXML
    void deletebtnOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText().trim());
            boolean result = courseDAO.delete(id);
            
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Course Deleted Successfully! 😍").show();
                clearFields();
                loadAllCourses();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete Course! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid ID to delete!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
   
    @FXML
    void savebtnOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText().trim());
            String name = txtname.getText().trim();
            String duration = txtduration.getText().trim();
            double price = Double.parseDouble(txtprice.getText().trim());

            courseDTO dto = new courseDTO(id, name, duration, price);
            courseEntity Entity = new courseEntity(dto.getCourseId(), dto.getCourseName(), dto.getDuration(), dto.getPrice());

            boolean result = courseDAO.save(Entity);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Course Saved Successfully! 😍").show();
                clearFields();
                loadAllCourses();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save Course! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for ID and Price!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    
    @FXML
    void updatebtnOnAction(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtid.getText().trim());
            String name = txtname.getText().trim();
            String duration = txtduration.getText().trim();
            double price = Double.parseDouble(txtprice.getText().trim());

            courseDTO dto = new courseDTO(id, name, duration, price);
            courseEntity Entity = new courseEntity(dto.getCourseId(), dto.getCourseName(), dto.getDuration(), dto.getPrice());

            boolean result = courseDAO.update(Entity);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Course Updated Successfully! 😍").show();
                 clearFields();
                loadAllCourses();
                
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update Course! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for ID and Price!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    
    
    private void loadAllCourses() {
        try {
          courselist.clear();  
          java.util.ArrayList<courseEntity> entityList = courseDAO.getAll();  
           for (courseEntity entity : entityList) {
            courseDTO dto = new courseDTO(
                entity.getCourse_id(),
                entity.getCourse_name(),
                entity.getDuration(),
                entity.getPrice()
            );
            courselist.add(dto); }
          } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Failed to load courses: " + e.getMessage()).show();
    }
} 
        
}   
    
    
    
    
    
    
    
