module lk.ijse.lk.ijse.institute1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    // 1. App.java තියෙන ප්‍රධාන package එක (මෙතන 'lk.ijse' කෑලි දෙකක් තියෙන්නම ඕනේ)
    opens lk.ijse.lk.ijse.institute1 to javafx.fxml;
    exports lk.ijse.lk.ijse.institute1;

    // 2. Controller package එක (දැන් තියෙන්නේ එක පාරයි, duplicate වෙන්නේ නැහැ)
    opens lk.ijse.institute1.controller to javafx.fxml;
    exports lk.ijse.institute1.controller;

    // 3. DAO package එක
    opens lk.ijse.institute1.dao to javafx.fxml;
    exports lk.ijse.institute1.dao;

    // 4. DTO package එක
    opens dto to javafx.fxml;
    exports dto;

    // 5. DB package එක
    opens db to javafx.fxml;
    exports db;
}