
package com.example.demoprojett;


import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Dechets {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleIntegerProperty quantite;
    private SimpleStringProperty type;




    //private SimpleStringProperty type;
 ;


    public Dechets(int id, String nom, int quantite, String type) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.quantite = new SimpleIntegerProperty(quantite);
        this.type = new SimpleStringProperty(type);
        //this.type = new ComboBox<>(FXCollections.observableArrayList(type));
       // this.type = new ComboBox<>(BDService.getCategories());
        //this.type.getSelectionModel().select(type); // Sélectionnez la valeur du ComboBox
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public int getQuantite() {
        return quantite.get();
    }

    public SimpleIntegerProperty quantiteProperty() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    @Override
    public String toString() {
        return "Dechets{" +
                "id=" + id +
                ", nom=" + nom +
                ", quantite=" + quantite +
                ", type=" + type.getValue() +
                '}';
    }}

    /*public ObservableValue<String> getTypeProperty() {
        return (ObservableValue<String>) (this.type = type);
    }*/

    //Calculer le salaire
   /* public double CalculeSalaire() {
        Integer score =0;
        if(categories.getScoreCateg()>=2005) {
            salaire=400;}
        else {
            salaire=280;
        }
        return salaire;

    }*/







