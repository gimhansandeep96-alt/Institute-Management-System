/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DBconnection {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/student_course_db";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "2005";
    
    private static DBconnection dbc;
    private Connection conn;
    
    private DBconnection() throws SQLException  {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public static DBconnection getInstance() throws SQLException {
        return (dbc==null) ? dbc = new DBconnection() : dbc;
    }
    
    public Connection getConnection() {
        return conn;
    }
}
