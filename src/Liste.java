/**
* interface qui represente une liste de sous-titre independamment
* de toute implementation
*/
public interface Liste {

    /**
    * methode tete d'une liste
    *
    * @return l'element en tete de liste 
    */
    public int tete();

    /** 
    * methode qui permet de recuperer la valeur a une place p
    * 
    * @param p 
    *       place dans la liste des elements a recuperer
    */

    public String val(int p);

    /**
    * methode qui permet a p de prendre la valeur de son sucesseur
    *
    * @param p
    *           place qui va prendre soon sucesseur */
    public int suc(int p);

    /**
    * methode qui permet de savoir si la liste this est vide
    *
    * @return un booleen qui vaut vrai si et seulement si la liste
    * ne contient aucun élément
    */
    public boolean finliste(int p);

    /**
    * methode qui ajoute un element en tete de la liste this
    *
    * @param st
    *       element a ajouter en tete de liste
    */
    public void adjtlis(String st);

    /**
    * methode qui ajoute un element a la liste this a une place p
    * 
    * @param st 
    *           element a ajouter dans la liste 
    */
    public void adjlis(int p, String st);

    /**
    * methode qui permet de supprimer un element de la liste this
    * a une place p
    * 
    * @param p
    *           place de l'element a supprimer
    */
    public void suplis(int p);

}