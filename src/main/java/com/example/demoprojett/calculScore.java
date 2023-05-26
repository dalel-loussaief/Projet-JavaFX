package com.example.demoprojett;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class calculScore implements Initializable {

    private static String login = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost/projet_java";

    private Connection connection;
    public ObservableList<Dechets> data = FXCollections.observableArrayList();

   /* public calculScore() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour calculer le score automatiquement et l'insérer dans la table "score"
    public void calculerScore(int idUser, int idDechet) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO score (idUser, idDechet, score) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idDechet);

            // Récupérez la quantité du déchet correspondant à l'idDechet
            PreparedStatement dechetStatement = connection.prepareStatement("SELECT quantite FROM dechets WHERE idDechet = ?");
            dechetStatement.setInt(1, idDechet);
            ResultSet dechetResult = dechetStatement.executeQuery();

            if (dechetResult.next()) {
                int quantite = dechetResult.getInt("quantite");

                // Calculez le score
                int score = quantite * 1;

                preparedStatement.setInt(3, score);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet filtrerScores(int valeur) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM score WHERE score <= ?");
            preparedStatement.setInt(1, valeur);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Méthodes supplémentaires pour effectuer d'autres opérations sur les tables

    public static void main(String[] args) {
        calculScore Score = new calculScore();
        Score.calculerScore(1, 2); // Exemple d'appel pour calculer le score
    }
*/

    public int calculerScore() {
        int scoreTotal = 0;

        // Parcourir la liste des déchets de l'utilisateur
        for (Dechets dechet : data) {
            // Récupérer la quantité de déchet et le score de la catégorie
            int quantiteDechet = dechet.getQuantite();
            //int scoreCategorie = dechet.getType().getSelectedItem().getScoreCateg();

            // Calculer le score pour ce déchet
            //int scoreDechet = quantiteDechet * scoreCategorie;

            // Ajouter le score du déchet au score total de l'utilisateur
           // scoreTotal += scoreDechet;
        }

        return scoreTotal;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
