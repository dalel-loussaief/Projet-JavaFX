module com.example.demoprojett {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demoprojett to javafx.fxml;
    exports com.example.demoprojett;
}