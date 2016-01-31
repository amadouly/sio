/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author amadou
 */
public class Commandes {
    
    int idCommande,qtite;
    Product prod;

    public Commandes() {
    }

    public Commandes(int idCommande, Product prod,int qtite) {
        this.idCommande = idCommande;
        this.qtite = qtite;
        this.prod = prod;
    }

    
    
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getQtite() {
        return qtite;
    }

    public void setQtite(int qtite) {
        this.qtite = qtite;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }
    
    
    
}
