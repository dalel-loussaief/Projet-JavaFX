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
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.demoprojett.BDService.con;

public class DetailsDechetController  implements Initializable {
    @FXML
    private TextField id ;
    @FXML private TextField nom ;
    @FXML private TextField quantite ;
    @FXML private TextField type ;
    @FXML private ComboBox  combo;
    @FXML private Label lblid ;
    @FXML private Label lblnom ;
    @FXML private Label lblquantite ;
    @FXML private Label lbltype ;
    private int idCat;
    private int idUser;
    private int idDechet;
    private int score;
    private String nomCat;

    private int scoreCateg;

    /*  public int calculerScore(Dechets dechet, categories categorie) {
          int quantite = dechet.getQuantite();
          String type = categorie.getNomCat();


          int score = quantite * Integer.parseInt(type);

          System.out.println(score);
          return score;

      }*/
    @FXML
    public void getdech(ActionEvent event) {
        int id = Integer.parseInt(this.id.getText());
        Dechets dechets = BDService.findById(id);
        if (dechets != null) {
            nom.setText(dechets.getNom());
            quantite.setText(String.valueOf(dechets.getQuantite()));
          //  String selectedType = combo.getValue().toString();
            //type.setText(selectedType);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Aucun déchet trouvé avec cet ID");
            alert.showAndWait();
        }
    }


    public void vider() {
        id.clear();
        nom.clear();
        quantite.clear();
        type.clear();

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ObservableList<String> cbe= FXCollections.observableArrayList("Métaux","Plastique","Papier","Verre","Bois","Carton");
        //combo.setItems(cbe);
        //TextField.getItems(cbe).addAll("Métaux","Plastique","Papier","Verre","Bois","Carton");

    }


   public void calculerScore(ActionEvent actionEvent) {
        String idText = this.id.getText();
        String quantiteText = this.quantite.getText();
        String type = this.type.getText();
        String nom = this.nom.getText();

        if (idText.isEmpty() || quantiteText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez remplir les champs ID et Quantité");
            alert.showAndWait();
            return;
        }

        int id = Integer.parseInt(idText);
        int quantite = Integer.parseInt(quantiteText);


        categories categories = new categories(idCat, nomCat, scoreCateg,idUser,idDechet,score);
        Dechets dechets = new Dechets(id,nom,quantite,type);

        int score = BDService.calculerScore(categories,dechets);

        if (score >= 0) {
            try {
                String sql = "UPDATE categories SET score = ? WHERE idDechet = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,1);
                ps.setInt(2, score);
               // ps.setInt(2, user.getId()); // Supposons que vous ayez une méthode getId() dans la classe User pour obtenir l'ID de l'utilisateur
                ps.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Score calculé");
                alert.setContentText("Score calculé avec succès");
                alert.showAndWait();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Impossible de calculer le score");
            alert.showAndWait();
        }
    }
  /* public void calculerScore(ActionEvent actionEvent) {
       String idText = this.id.getText();
       String quantiteText = this.quantite.getText();
       String type = this.type.getText();
       String nom = this.nom.getText();

       if (idText.isEmpty() || quantiteText.isEmpty()) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erreur");
           alert.setContentText("Veuillez remplir les champs ID et Quantité");
           alert.showAndWait();
           return;
       }

       int id = Integer.parseInt(idText);
       int quantite = Integer.parseInt(quantiteText);

       categories categories = new categories(idCat, nomCat, scoreCateg, idUser, idDechet, score);
       Dechets dechets = new Dechets(id, nom, quantite, type);

     score = BDService.calculerScore();



       if (score >= 0) {
           try {
               String sql = "UPDATE categories SET score = ? WHERE idDechet = ?";
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setInt(1, score);
               ps.setInt(2, dechets.getId());
               ps.executeUpdate();

               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Score calculé");
               alert.setContentText("Score calculé avec succès");
               alert.showAndWait();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       } else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erreur");
           alert.setContentText("Impossible de calculer le score");
           alert.showAndWait();
       }
   }*/


    }



