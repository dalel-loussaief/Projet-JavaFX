package com.example.demoprojett;

public class categories {

    private int idCat;
    private String nomCat;
    private int  scoreCateg;
    private int idUser;
    private int idDechet;
    private int score ;

    public categories(int idCat, String nomCat, int scoreCateg, int idUser, int idDechet, int score) {
        this.idCat = idCat;
        this.nomCat = nomCat;
        this.scoreCateg = scoreCateg;
        this.idUser = idUser;
        this.idDechet = idDechet;
        this.score = score;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDechet() {
        return idDechet;
    }

    public void setIdDechet(int idDechet) {
        this.idDechet = idDechet;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "categories{" +
                "idCat=" + idCat +
                ", nomCat='" + nomCat + '\'' +
                ", scoreCateg=" + scoreCateg +
                '}';
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }


    public int getScoreCateg() {
        return scoreCateg;
    }

    public void setScoreCateg(int scoreCateg) {
        this.scoreCateg = scoreCateg;
    }
}
