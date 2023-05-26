package com.example.demoprojett;

public class User {
private int id;
    private String nom;
    private String prenom;

    private String password;





    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String nom, String prenom, String password) {

        this.nom = nom;
        this.prenom = prenom;
        this.password = password;

    }

    public User() {
        super();
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", password='" + password + '\'' +

                '}';
    }



}
