/**
 * Classe représentant une liste contigue
 */
public class ListeContigue implements Liste {

    private String[] tab;
    private int nbElements;
    
    public ListeContigue(int maxtab){

        this.tab = new String[maxtab];
        this.nbElements=0;
    }

    /**
	 * permet de supprimer un element d'une liste
	 * @param p place de l'element a supprimer 
	 */
	public void suplis(int p){

        for(int i=p;i<this.nbElements-1;i++){
            this.tab[i]=this.tab[i+1];
        }
        
        nbElements=nbElements-1;

    }
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element a ajouter en tete
	 */
	public void adjtlis(String s){
        String[] Ntab = new String[this.tab.length+1];

        for(int i=this.nbElements+1;i>0;i--){
            Ntab[i]=this.tab[i-1];
        }
        Ntab[0]=s;
        this.tab=Ntab;
        nbElements=nbElements+1;
    }
	
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element a inserer
	 */
	public void adjlis(int p, String s){
        String[] Ntab = new String[this.tab.length+1];

        for(int i=0;i<p+1;i++)
            Ntab[i]=this.tab[i];

        for(int i=this.nbElements;i>p+1;i--)
            Ntab[i]=this.tab[i-1];            
        
        Ntab[p+1]=s;
        this.tab=Ntab;
        nbElements=nbElements+1;
    
    }
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p){
        boolean fin=false;
        if(p==this.nbElements)
            fin=true;
        else
            fin=false;
        return fin;
    }
	
	/**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete(){
        int tete=0;
        return tete;
    }
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p){
        p=p+1;
        return p;
    }
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee a p
	 */
	public String val(int p){
        return this.tab[p];
    }

    public int getNbElement(){
        return this.nbElements;
    }

}