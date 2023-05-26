package com.example.demoprojett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteDechetController implements Initializable {
    @FXML private TextField id ;
    @FXML private Label iddech;
    public ObservableList<Dechets> data = FXCollections.observableArrayList();
   /* public void Deletedech(ActionEvent event) {
        int id = Integer.parseInt(this.id.getText());

        boolean status = BDService.delete(id);
        if (status) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supprimer dechet");
            alert.setContentText("dechet bien supprimé");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Impossible de supprimer le dechet");
            alert.showAndWait();
        }
    }*/

    @FXML
    public void Deletedech(ActionEvent event) {
        int id = Integer.parseInt(this.id.getText());

        boolean status = BDService.delete(id);
        if (status) {
            // Suppression de l'élément de la liste data
            Dechets dechetASupprimer = null;
            for (Dechets dechet : data) {
                if (dechet.getId() == id) {
                    dechetASupprimer = dechet;
                    break;
                }
            }
            if (dechetASupprimer != null) {
                data.remove(dechetASupprimer);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Supprimer dechet");
            alert.setContentText("dechet bien supprimé");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Impossible de supprimer le dechet");
            alert.showAndWait();
        }
    }



    public void vider() {
        id.clear();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


    }

}
