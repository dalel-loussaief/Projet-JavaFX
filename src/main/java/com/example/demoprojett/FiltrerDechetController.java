package com.example.demoprojett;

//import com.sun.glass.ui.Clipboard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class FiltrerDechetController implements Initializable {

    public void RemplirList(){
        try {
            Connection con =connexion.getCn();
            String sql = "SELECT  idF ,score ,nom, type ,quantite  from  Filtrage order by nom";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            while(rs.next()) {

              //  data.add(new Filtrage(rs.getInt(1),rs.getInt(4),rs.getString(5)));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

}
