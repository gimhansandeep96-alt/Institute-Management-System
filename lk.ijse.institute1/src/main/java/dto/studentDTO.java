/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author asus
 */
public class studentDTO {
    private int studentId;
    private String studentName;
    private String studentemail;
    private String studentadress;

    public studentDTO(int studentId, String studentName, String studentemail, String studentadress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentemail = studentemail;
        this.studentadress = studentadress;
    }

    public studentDTO() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public String getStudentadress() {
        return studentadress;
    }

    public void setStudentadress(String studentadress) {
        this.studentadress = studentadress;
    }

    @Override
    public String toString() {
        return "studentDTO{" + "studentId=" + studentId + ", studentName=" + studentName + ", studentemail=" + studentemail + ", studentadress=" + studentadress + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
