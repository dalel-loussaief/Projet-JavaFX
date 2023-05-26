package com.example.demoprojett;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField username ;
    @FXML  private PasswordField password ;
    @FXML  private Text labelname ;
    @FXML  private Text labelpassword ;
    @FXML private Button register;
    @FXML private Button annuler;
    @FXML
    public void login(ActionEvent event) throws SQLException {
        Connection con = connexion.getCn();
        PreparedStatement stat= null;
        ResultSet rs = null;
        String sql ="SELECT * FROM user WHERE nom=? and password=? ";
        try {
            stat=con.prepareStatement(sql);
            stat.setString(1,username.getText().toString());
            stat.setString(2,password.getText().toString());
            rs= stat.executeQuery();
            if(rs.next()) {
                System.out.println("Connexion Reuissite");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Page d'Accueil");
                stage.setScene(scene);
                stage.setScene(scene);
                stage.show();

            }
            else {
                Alert erreur = new Alert(Alert.AlertType.ERROR);
                erreur.setTitle("Alert d'erreur");
                erreur.setContentText("Connexion echou�e");
                erreur.show();
            }
        }catch(Exception e) {
            System.out.println("erreur");
        }

    }
    public void register(ActionEvent event) throws SQLException {
        String name = username.getText();
        //String pre = userlastname.getText();
        String pas = password.getText();

        try {
            register.getScene().getWindow().hide();
            Parent root= FXMLLoader.load(getClass().getResource("formulaireuser.fxml"));
            Stage registerStage =new Stage();
            //registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quitter(ActionEvent event)
    {
        try {
            annuler .getScene().getWindow().hide();
            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage registerStage =new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,634,459));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }


    }