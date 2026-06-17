/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author asus
 */
public class courseEntity {
   private int course_id ;
   private String  course_name;
   private String duration;
   private double price;

    public courseEntity() {
    }

    public courseEntity(int course_id, String course_name, String duration, double price) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.duration = duration;
        this.price = price;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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
        return "courseEntity{" + "course_id=" + course_id + ", course_name=" + course_name + ", duration=" + duration + ", price=" + price + '}';
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
