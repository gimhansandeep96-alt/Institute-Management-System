package lk.ijse.institute1.controller;


import dto.lecturerDTO;
import entity.lecturerEntity;
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
import lk.ijse.institute1.dao.lecturerDAOImpl;

public class lecturerController {
private final lecturerDAOImpl lecturerDAO = new lecturerDAOImpl();
    @FXML
    private Button clearbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private TextField ladresstxt;

    @FXML
    private TableView<lecturerDTO> lectable;

    @FXML
    private TableColumn<lecturerDTO, String> lectableadress;

    @FXML
    private TableColumn<lecturerDTO, String> lectableemail;

    @FXML
    private TableColumn<lecturerDTO, Integer> lectableid;

    @FXML
    private TableColumn<lecturerDTO, String> lectablename;

    @FXML
    private TextField lemailtxt;

    @FXML
    private TextField lidtxt;

    @FXML
    private TextField lnametxt;

    @FXML
    private Button savebtn;

    @FXML
    private Button updatebtn;

     private final ObservableList <lecturerDTO> lecturerlist =FXCollections.observableArrayList();
     
     @FXML
    public void initialize(){
    lectableid.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));
    lectablename.setCellValueFactory(new PropertyValueFactory<>("lecturerName"));
    lectableemail.setCellValueFactory(new PropertyValueFactory<>("lectureremail"));
    lectableadress.setCellValueFactory(new PropertyValueFactory<>("lectureradress"));
    
    lectable.setItems(lecturerlist);
    loadAlllectures();
    }
    
    @FXML
    void clearbtnOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        lidtxt.clear();
        lnametxt.clear();
        lemailtxt.clear();
        ladresstxt.clear();
    }
    
    @FXML
    void deletebtnOnAction(ActionEvent event) {
 try {
            int id = Integer.parseInt(lidtxt.getText().trim());
            boolean result = lecturerDAO.delete(id);
            
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "lecturer Deleted Successfully! 😍").show();
                clearFields();
                loadAlllectures();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Delete lecturer! ❌").show();
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
            int id = Integer.parseInt(lidtxt.getText().trim());
            String name = lnametxt.getText().trim();
            String email = lemailtxt.getText().trim();
            String adress=ladresstxt.getText();

            lecturerDTO dto = new lecturerDTO(id, name, email, adress);
            lecturerEntity Entity = new lecturerEntity(dto.getLecturerId(), dto.getLecturerName(), dto.getLectureremail(), dto.getLectureradress());

            boolean result = lecturerDAO.save(Entity);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "lecturer Saved Successfully! 😍").show();
                clearFields();
                loadAlllectures();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Save lecturer! ❌").show();
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
           int id = Integer.parseInt(lidtxt.getText().trim());
            String name = lnametxt.getText().trim();
            String email = lemailtxt.getText().trim();
            String adress=ladresstxt.getText();

            lecturerDTO dto = new lecturerDTO(id, name, email, adress);
            lecturerEntity Entity = new lecturerEntity(dto.getLecturerId(), dto.getLecturerName(), dto.getLectureremail(), dto.getLectureradress());

            boolean result = lecturerDAO.update(Entity);
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "lecturer Updated Successfully! 😍").show();
                clearFields();
                loadAlllectures();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to Update lecturer! ❌").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter valid numbers for ID and Price!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    
    }


private void loadAlllectures(){
    try {
          lecturerlist.clear();  
          java.util.ArrayList<lecturerEntity> entityList=lecturerDAO.getAll();  
           for (lecturerEntity entity : entityList) {
            lecturerDTO dto = new lecturerDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getAddress()
            );
            lecturerlist.add(dto); }
          } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Failed to load lecturer: " + e.getMessage()).show();
        
        
          }
}
}












    
    
    
   
  
