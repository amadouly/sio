/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author amadou
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID")
    int idProduit;
    @Column(name="NAME")
    String nomProduit;   
    @Column(name="SELLING_PRICE")
    Double prix;

    public Product(int idProduit, String nomProduit, Double prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    public Product() {
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idproduit) {
        this.idProduit = idproduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
    public double getPrix(){
       return prix; 
    }
    public void setPrix (double prix){
        this.prix = prix;
        
    }
    
   
    
}
