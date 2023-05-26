package com.example.demoprojett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class ListeDechetsController implements Initializable {
    @FXML
    private TableView<Dechets> table ;
    @FXML private TableColumn<Dechets,Integer> id ;
    @FXML private TableColumn<Dechets,String> nom ;
    @FXML private TableColumn<Dechets,Integer> quantite ;
    @FXML private TableColumn<Dechets,ComboBox<String>> type ;
   // @FXML private TableColumn<Dechets, Date> date ;

    public ObservableList<Dechets> data = FXCollections.observableArrayList();
    @FXML
    public void RemplirList(){
        try {
            Connection con =connexion.getCn();
            String sql = "SELECT  id ,nom ,type ,quantite   from  dechets ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            data.clear();
            while(rs.next()) {
                //data.add(new Dechets(rs.getInt(1), rs.getString(3),rs.getString(5), rs.getInt(2),rs.getDate(6)));
                data.add(new Dechets(rs.getInt("id"), rs.getString("nom"), rs.getInt("quantite"), rs.getString("type")));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }



    public ObservableList<Dechets> getData() {
        return data;
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      id.setCellValueFactory(new PropertyValueFactory<Dechets,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Dechets,String>("nom"));
        quantite.setCellValueFactory(new PropertyValueFactory<Dechets,Integer>("quantite"));
        type.setCellValueFactory(new PropertyValueFactory<Dechets,ComboBox<String>>("type"));
       // date.setCellValueFactory(new PropertyValueFactory<Dechets,Date>("date"));
       // RemplirList();


        table.setItems(data);


    }

    public void Ajoutdech() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AjouterDechet.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Form d'ajout d'un dechet");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void Updatep() {
        try {
            Stage stage2 = new Stage();
            Parent root2 =FXMLLoader.load(getClass().getResource("UpdateDechet.fxml"));
            Scene scene2 = new Scene(root2);
            stage2.setTitle("Form de modification d'un dechet");
            stage2.setScene(scene2);
            stage2.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void Supp() {
        try {
            Stage stage = new Stage();
            Parent root =FXMLLoader.load(getClass().getResource("DeleteDechet.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Form de supprission d'un dechet");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void AfficheDetails() {
        try {
            Stage stage = new Stage();
            Parent root =FXMLLoader.load(getClass().getResource("DetailsDechet.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("D�tails dechets");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    }

