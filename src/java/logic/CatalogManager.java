/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ProductFacade;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Product;

/**
 *
 * @author amadou
 */
@ManagedBean
@ApplicationScoped
public class CatalogManager implements java.io.Serializable{
    /**
     * Les attributs déclarés ici serviront à alimenter créer des produits depuis une vue
     * depuis les formulaires
     */ 
    int idProduit;
    String nomProduit;
    double prix;
    Product newProd= new Product();
    
    ArrayList<Product> lstProd = new ArrayList<Product>();
    
    /**
     * tilisation des EJB sessions pour interagir avec la BDD
     */
    @EJB
    private ProductFacade productfacade;
    
    public CatalogManager() {
        this.lstProd = new ArrayList<Product>();
    }
  
    public CatalogManager(int idProduit, String nomProduit, double prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
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
    
    public double getPrix(){
        return prix;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }

    public Product getNewProd() {
        return newProd;
    }

    public void setNewProd(Product newProd) {
        this.newProd = newProd;
    }
    
    
    public ArrayList<Product> getLstProd() {
        return lstProd;
    }

    public void setLstProd(ArrayList<Product> lstProd) {
        this.lstProd = lstProd;
    }
    
   @PostConstruct 
   public void initCatalog(){
       
       /*Product p1 = new Product(1,"Prod1",10.00);
       Product p2 = new Product(2,"Prod2",20.00);
       lstProd.add(p1);
       lstProd.add(p2);
       */
       /**
        * Utilisation des EJB pour récupere la liste des prouits
        */
       lstProd.addAll(productfacade.findAll());
   }
   
   /**
    * la methode createProduct est appelée depuis le formulaire createProduct .
    * on récupère les valeurs saisies dans les champs des formulaires et on les utilise pour créer un nouveau produit
    */
    public String createProduct(){
        
        newProd.setIdProduit(getIdProduit());
        newProd.setNomProduit(getNomProduit());
        newProd.setPrix(getPrix());
        lstProd.add(newProd);       
        return "toCatalog";   
    }
    
}
