package com.example.demoprojett;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static com.example.demoprojett.connexion.getCn;

public class HelloApplication extends Application {
    private static String login = "root";
    private static String password ="";
    private static String url = "jdbc:mysql://localhost/projet_java";
    @Override
    public void start(Stage stage) throws IOException {

        Connection conn= connexion.getCn();
        if (conn != null) {
            System.out.println("Database connected!");
        } else {
            System.out.println("Database connection failed!");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();




    }



    public static void main(String[] args) {
        launch();
    }
}