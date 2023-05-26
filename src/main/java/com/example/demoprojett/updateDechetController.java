package com.example.demoprojett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class updateDechetController implements Initializable {
    @FXML
    TextField id1 ;
    @FXML private TextField nom1 ;
    @FXML private TextField quantite1 ;
    @FXML private TextField type1 ;
    @FXML private TextField date1 ;

    @FXML private Label lblid1;
    @FXML private Label lblnom1 ;
    @FXML private Label lblquantite1 ;
    @FXML private Label lbltype1 ;
    @FXML private Label lbldate1 ;
    @FXML private ComboBox combo;

    /*@FXML
    public void getUser(ActionEvent event) {
        int id = Integer.parseInt(lblid1.getText());
        User user = BDService.findById(id);
        nom1.setText(user.getNom());
        quantite1.setText(user.getEmail());
        type1.setText(String.valueOf(user.getPassword()));
        date1.setText(String.valueOf(user.ge()));


    }*/

    @FXML
    public void Updatedech(ActionEvent event) throws SQLException {

        int id = Integer.parseInt(this.id1.getText());
        String name = nom1.getText();
       // String type = type1.getText().toString();
        String selectedType = combo.getValue().toString();
        int quantite =Integer.parseInt(quantite1.getText());
       // Date date1 = new Date();

        Dechets dechets = new Dechets(id, name, quantite, selectedType);
        dechets.setId(id);
        dechets.setNom(name);

        boolean status = BDService.update(dechets);
        if(status==true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modifier dechet");
            alert.setContentText("dechet bien modifi�");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Salarier non modifi�");
            alert.showAndWait();
        }
    }
    public void vider() {
        id1.clear();
        nom1.clear();
        quantite1.clear();
        type1.clear();


    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> cbe= FXCollections.observableArrayList("Métaux","Plastique","Papier","Verre","Bois","Carton");
        combo.setItems(cbe);

    }

}
