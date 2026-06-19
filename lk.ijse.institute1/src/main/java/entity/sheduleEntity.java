/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.time.LocalDate;
/**
 *
 * @author asus
 */
public class sheduleEntity {
   private String scheduleId;
    private int courseId;       
    private int lecturerId;     
    private String subjectName;
    private LocalDate date;
    private String time; 
      public sheduleEntity() {
    }

    public sheduleEntity(String scheduleId, int courseId, int lecturerId, String subjectName, LocalDate date, String time) {
        this.scheduleId = scheduleId;
        this.courseId = courseId;
        this.lecturerId = lecturerId;
        this.subjectName = subjectName;
        this.date = date;
        this.time = time;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "sheduleDTO{" + "scheduleId=" + scheduleId + ", courseId=" + courseId + ", lecturerId=" + lecturerId + ", subjectName=" + subjectName + ", date=" + date + ", time=" + time + '}';
    }
    
    
}
