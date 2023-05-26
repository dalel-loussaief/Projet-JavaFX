package com.example.demoprojett;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private AnchorPane rootPane ;
    @FXML
    public void Loading(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Gestiondechets(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ListeDechets.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void GestionUser(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ListeEmployees.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GestionEntreprise(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ListeVendeurs.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public void filtragedechet(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FiltrerDechet.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void Filtrer2(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Filtre2.fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
}
