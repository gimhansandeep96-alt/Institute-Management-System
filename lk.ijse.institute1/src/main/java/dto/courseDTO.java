/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author asus
 */
public class courseDTO {
    private int courseId;
    private String courseName;
    private String duration;
    private double price;

    public courseDTO() {
    }

    public courseDTO(int courseId, String courseName, String duration, double price) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.price = price;
    }

   

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "courseDTO{" + "courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", price=" + price + '}';
    }
    
     
}
