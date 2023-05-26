package com.example.demoprojett;
import java.sql.Statement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.*;

import static com.example.demoprojett.connexion.getCn;

public class BDService {
    private static ComboBox combobox;
    static Connection con = connexion.getCn();


    public static boolean save(User user) {

        try {
            String sql = "INSERT INTO user (nom, prenom, password) VALUES (?, ?, ?)";


            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();


        }catch(Exception e){
            e.printStackTrace();
        }
        return true;

    }
    public static boolean save(Dechets dechets) {

        try {
            String sql = "INSERT INTO dechets (id, nom, quantite, type) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dechets.getId());
            ps.setString(2, dechets.getNom());
            ps.setInt(3, dechets.getQuantite());
            ps.setString(4, dechets.getType());
            //ps.setDate(5,dechets.getDate());

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
   /* public static boolean save(Dechets dechets) {
        try {
            Connection con = connexion.getCn();
            String sql = "INSERT INTO dechets (nom, quantite, type) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dechets.getNom());
            ps.setInt(2, dechets.getQuantite());
           ps.setString(3, dechets.getType(combobox.getValue().toString()).getValue()); // Récupérer la valeur sélectionnée du ComboBox
            //ps.setString( 3, String.valueOf(dechets.getType(combobox.getValue().toString())));
            //ps.setString(3, dechets.getType(combobox.getValue().toString()).getValue()); // Récupérer la valeur sélectionnée du ComboBox

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/

    public static boolean update(Dechets dechets) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE dechets SET id=?, nom=?, quantite=?, type=? WHERE id=?");
        ps.setInt(1, dechets.getId());
        ps.setString(2, dechets.getNom());
        ps.setInt(3, dechets.getQuantite());
        //  ps.setString(4, dechets.getType(combobox.getValue().toString()).getValue());
        ps.setString(4, dechets.getType());
        ps.setInt(5, dechets.getId());
        ps.executeUpdate();
        return true;
    }

    public static boolean delete(int id) {
        try {


            PreparedStatement ps = con.prepareStatement("DELETE  FROM dechets WHERE  id=? ");
            ps.setInt(1, id);
            ps.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Error creating SQL statement: "
                    + e.getMessage());
        }
        return true;
    }

    public static Dechets findById(int id) {
        try {


            PreparedStatement ps = con.prepareStatement("SELECT * FROM dechets  WHERE id=? ");
            ps.setInt(1, id);
            ResultSet Rs = ps.executeQuery();
            if (Rs.next())
                return new Dechets(Rs.getInt(1), Rs.getString(2), Rs.getInt(3), Rs.getString(4));


        } catch (SQLException e) {
            System.err.println("Error creating SQL statement: "
                    + e.getMessage());
        }
        return null;


    }
    /*public static Categories findCategorieByType(String type) {
        try {


            PreparedStatement ps =con.prepareStatement("SELECT ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if ( rs.next())
                return new Categories(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getInt(7), rs.getDouble(11), rs.getDouble(9), rs.getDouble(10), rs.getInt(8));


        }
        catch (SQLException e) {
            System.err.println("Error creating SQL statement: "
                    +e.getMessage());
        }
        return null;


    }*/
  /*  public static Vendeur findById3(int id) {
        try {


            PreparedStatement ps =con.prepareStatement("SELECT s.categorie,s.matricule, s.nom_Sal,s.email_Sal,s.salaire,s.recrutement,v.id_m,v.idCatge,v.commision,v.pct,v.vente  from  vendeur v , salarier s where ((s.matricule=v.id_m) and (s.categorie=v.idCatge)and(v.id_m=?))");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if ( rs.next())
                return new Vendeur(rs.getInt(2), rs.getDouble(5),rs.getString(3), rs.getString(4), rs.getDouble(6), rs.getInt(1), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(7),rs.getInt(8));


        }
        catch (SQLException e) {
            System.err.println("Error creating SQL statement: "
                    +e.getMessage());
        }
        return null;


    }*/

    public static ObservableList<String> getCategories() {
        ObservableList<String> categories = FXCollections.observableArrayList();
        try {
            Connection con = connexion.getCn();
            String sql = "SELECT nomCat FROM categories";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("nomCat"));
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
        return categories;
    }



 public static int calculerScore(categories categories,Dechets dechets) {
        int score = 0;
//int s= dechets.getQuantite()*categories.getScoreCateg();
int c=1;
int q= dechets.getQuantite();
int s=c*q;
System.out.println(s);
        try {
           // String sql = "SELECT d.quantite * c.scoreCateg AS score FROM dechets d JOIN categories c ON c.idDechet = d.id WHERE idDechet= ?";
            //String sql = "SELECT d.quantite * c.scoreCateg AS score FROM dechets d JOIN categories c ON c.idDechet = d.id WHERE idDechet = ? AND d.quantite = ? AND d.type = ?";
String sql= "SELECT d.quantite FROM dechets into q";
String sq= "SELECT c.scoreCateg FROM categories into c";




            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement p = con.prepareStatement(sq);
            ps.setInt(1, categories.getIdDechet());
            ps.setInt(2,dechets.getQuantite() );
            p.setInt(3, categories.getScoreCateg());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = rs.getInt("score");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return score;
    }
/*public static int calculerScore() {

     try {
         Statement statement = getCn().createStatement();

         ResultSet resultSet = statement.executeQuery("SELECT id, quantite FROM dechets");

         // Parcourez chaque déchet et calculez le score
        while (resultSet.next()) {
             int id = resultSet.getInt("id");
             int quantite = resultSet.getInt("quantite");
             int scoreCateg = resultSet.getInt("scoreCateg");
            int score = quantite * scoreCateg;
             // Mettez à jour le score dans la table "categorie"
             PreparedStatement updateStatement = getCn().prepareStatement("UPDATE categories SET scoreCateg = ? WHERE idDechet = ?");
             updateStatement.setInt(1, score);
             updateStatement.setInt(2, id);
             updateStatement.executeUpdate();
         }

         // Fermez les ressources
       //  resultSet.close();
        // statement.close();
       //  getCn().close();

         System.out.println("Scores mis à jour avec succès !");
     } catch (SQLException e) {
         e.printStackTrace();
     }

    return new calculScore().calculerScore();
}*/
/* public static int calculerScore() {
     int scoreTotal = 0;
     PreparedStatement updateStatement ;
     Connection connection ;


     try {
         connection = getCn();
         Statement statement = connection.createStatement();
         ResultSet result = statement.executeQuery("SELECT id, quantite FROM dechets");
         // Parcourez chaque déchet et calculez le score
         while (result.next()) {
             int id = result.getInt("id");
             int quantite = result.getInt("quantite");
             int scoreCateg = 1;  // Mettez ici la valeur du scoreCateg correspondant au type de déchet

             int score = quantite * scoreCateg;
             scoreTotal += score;


             ResultSet resultSet = statement.executeQuery("SELECT id, quantite FROM dechets");
             updateStatement.setInt(1, score);
             updateStatement.setInt(2, id);
             updateStatement.executeUpdate();
         }

         // Fermez les ressources
         result.close();
         statement.close();
         getCn().close();

         System.out.println("Scores mis à jour avec succès !");
     } catch (SQLException e) {
         e.printStackTrace();
     }
return scoreTotal;
 }*/





}


