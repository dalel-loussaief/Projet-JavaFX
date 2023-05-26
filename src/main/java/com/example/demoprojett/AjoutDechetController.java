package com.example.demoprojett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AjoutDechetController implements Initializable {

    @FXML private TextField id ;
    @FXML private TextField nom ;
    @FXML private TextField quantite ;
    @FXML private TextField type ;
  //  @FXML private DatePicker date ;

    @FXML private Label lblid ;
    @FXML private Label lblnom ;
    @FXML private Label lblquantite ;
    @FXML private Label lbltype ;
    @FXML private Label lbldate ;
    @FXML private ComboBox  combo;

    public static ListeDechetsController instance; // Déclarez la variable instance en tant que variable statique




    public void insertdata(ActionEvent event) {

        int id = Integer.parseInt(this.id.getText());
        String name = this.nom.getText();
       // String type = this.type.getText();
        String selectedType = combo.getValue().toString();
        int quantite = Integer.parseInt(this.quantite.getText());


         if (selectedType != null && !selectedType.isEmpty()) {
        Dechets dechets = new Dechets(0, name, quantite, selectedType);

        boolean status = BDService.save(dechets);
        if (status) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter dechet");
            alert.setContentText("dechet bien ajouté");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("dechet non ajouté");
            alert.showAndWait();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setContentText("Veuillez sélectionner une valeur pour le filtre");
        alert.showAndWait();
    }
}
    public void vider() {
        id.clear();
        nom.clear();
        type.clear();
        quantite.clear();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

       ObservableList<String> cbe= FXCollections.observableArrayList("Métaux","Plastique","Papier","Verre","Bois","Carton");
       combo.setItems(cbe);


    }


}
