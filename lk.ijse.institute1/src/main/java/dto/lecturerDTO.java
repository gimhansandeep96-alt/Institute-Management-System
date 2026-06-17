/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;
    
/**
 *
 * @author asus
 */
public class lecturerDTO {

    private int lecturerId;
    private String lecturerName;
    private String lectureremail;
    private String lectureradress;

        public lecturerDTO() {
        }

    public lecturerDTO(int lecturerId, String lecturerName, String lectureremail, String lectureradress) {
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.lectureremail = lectureremail;
        this.lectureradress = lectureradress;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLectureremail() {
        return lectureremail;
    }

    public void setLectureremail(String lectureremail) {
        this.lectureremail = lectureremail;
    }

    public String getLectureradress() {
        return lectureradress;
    }

    public void setLectureradress(String lectureradress) {
        this.lectureradress = lectureradress;
    }

    @Override
    public String toString() {
        return "lecturerDTO{" + "lecturerId=" + lecturerId + ", lecturerName=" + lecturerName + ", lectureremail=" + lectureremail + ", lectureradress=" + lectureradress + '}';
    }
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
