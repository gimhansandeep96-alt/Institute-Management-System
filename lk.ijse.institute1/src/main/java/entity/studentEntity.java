/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author asus
 */
public class studentEntity {
    private int student_id ;
    private String student_name;
    private String email ;
    private String adress ;

    public studentEntity() {
    }

    public studentEntity(int student_id, String student_name, String email, String adress) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.email = email;
        this.adress = adress;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "studentEntity{" + "student_id=" + student_id + ", student_name=" + student_name + ", email=" + email + ", adress=" + adress + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
