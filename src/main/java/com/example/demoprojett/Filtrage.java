package com.example.demoprojett;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Filtrage {
    private SimpleIntegerProperty idF;
    private SimpleIntegerProperty score;
    private SimpleStringProperty nom;
    private  Filtrage filtrage= new Filtrage();

    public Filtrage(SimpleIntegerProperty idF, SimpleIntegerProperty score, SimpleStringProperty nom) {
        this.idF = idF;
        this.score = score;
        this.nom = nom;

    }

    public Filtrage() {
        super();
    }



    public int getId() {
        return idF.get();
    }

    public SimpleIntegerProperty idProperty() {
        return idF;
    }

    public void setId(int id) {
        this.idF.set(id);
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
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

    @Override
    public String toString() {
        return "Filtrage{" +
                "id=" + idF +
                ", score=" + score +
                '}';
    }
}
