/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author asus
 */
public class attendanceDTO {
    private int attendanceId;
    private int scheduleId;
    private int studentId;
    private String status;

    public attendanceDTO() {
    }

    public attendanceDTO(int attendanceId, int scheduleId, int studentId, String status) {
        this.attendanceId = attendanceId;
        this.scheduleId = scheduleId;
        this.studentId = studentId;
        this.status = status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    @Override
    public String toString() {
        return "attendanceDTO{" + "attendanceId=" + attendanceId + ", scheduleId=" + scheduleId + ", studentId=" + studentId + ", status=" + status + '}';
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
