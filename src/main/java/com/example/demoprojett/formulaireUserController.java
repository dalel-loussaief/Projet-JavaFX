package com.example.demoprojett;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.demoprojett.User;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class formulaireUserController implements Initializable {

    @FXML private TextField nom ;
    @FXML private TextField prenom ;
    @FXML private TextField password ;


    @FXML private Button annuler;
    @FXML private Label lblnom ;
    @FXML private Label lblprenom ;
    @FXML private Label lblpassword;


    //@FXML private ComboBox lblrole;
    //  @FXML private Label score;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


    }



    public void insertuser(ActionEvent event) {

        String name = this.nom.getText();
        String pre = this.prenom.getText();
        String pass = this.password.getText();



        User user = new User(name,pre,pass);

        boolean status = BDService.save(user);
        if(status==true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter user");
            alert.setContentText("user bien ajout�");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("user non ajout�");
            alert.showAndWait();
        }
    }
    /*public void register(ActionEvent event) throws SQLException {
        Connection con = connexion.getCn();
        PreparedStatement stat = null;
        ResultSet rs = null;
        String sql = "INSERT INTO user (nom,prenom, password) VALUES (?,?, ?)";
        try {
            stat = con.prepareStatement(sql);
            stat.setString(1, nom.getText().toString());
            stat.setString(2, prenom.getText().toString());
            stat.setString(3, password.getText().toString());
            stat.executeUpdate();

            System.out.println("Compte créé avec succès");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("formulaireuser.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Page d'Accueil");
            stage.setScene(scene);
            stage.show();
        } catch (SQLIntegrityConstraintViolationException e) {
            Alert erreur = new Alert(Alert.AlertType.ERROR);
            erreur.setTitle("Alerte d'erreur");
            erreur.setContentText("Nom d'utilisateur déjà utilisé");
            erreur.show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                stat.close();
            }
        }
    }*/
    public void vider(ActionEvent event)
    {
        try {
            annuler.getScene().getWindow().hide();
            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage registerStage =new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public void vider() {

        nom.clear();
        prenom.clear();
        password.clear();
    }*/
}
