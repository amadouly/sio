/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Commandes;
import model.Product;

/**
 *
 * @author amadou
 */
@ManagedBean
@SessionScoped
public class CommandesManager implements java.io.Serializable{
    
    int idCommande,qtite,idProduit;
    Product prod;
    Product newProduct= new Product();
    String nomProduit;
    double prix;
    ArrayList<Commandes> lstCommandes;

    public CommandesManager() {
        lstCommandes = new ArrayList<>();
    }

    public CommandesManager(int idCommande, int qtite, Product prod) {
        this.idCommande = idCommande;
        this.qtite = qtite;
        this.prod = prod;
        lstCommandes = new ArrayList<>();
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
        return newProduct;
    }

    public void setProd(Product newProduct) {
        this.newProduct = newProduct;
    }
    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    /**
     *
     * Liste des accesseurs pour recuperer les donnes du formulaires catalogue 
     */
    public void setPrix(double prix) {    
        this.prix = prix;
    }

    public ArrayList<Commandes> getLstCommandes() {
        return lstCommandes;
    }

    public void setLstCommandes(ArrayList<Commandes> lstCommandes) {
        this.lstCommandes = lstCommandes;
    }
    
    /**
     * Quelques commandes pour tester la vue Commandes
     */
    
    @PostConstruct
    public void initCommandes(){
        Product prod1 = new Product(1,"Produit1",10.00);
        Product prod2 = new Product(2,"Produit1",20.00);
        Product prod3 = new Product(3,"Produit1",30.00);
        Commandes cd1 = new Commandes(1,prod1,10);
        Commandes cd2 = new Commandes(1,prod2,20);
        Commandes cd3 = new Commandes(1,prod3,30);
        lstCommandes.add(cd1);
        lstCommandes.add(cd2);
        lstCommandes.add(cd3);
        
    }
    public void ajouterProduit(){
       
        newProduct.setIdProduit(getIdProduit());
        newProduct.setNomProduit(getNomProduit());
        newProduct.setPrix(getPrix());
        Commandes newCde = new Commandes(4,newProduct,40);
        lstCommandes.add(newCde);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Nouvelle commande :");
        message.setDetail("Votre produit a été ajouté !");
        context.addMessage("formCatalog", message);
       
        //return "toCommandes"; pour afficher le message et rester sur la page catalog
    }
    
    
    
}
