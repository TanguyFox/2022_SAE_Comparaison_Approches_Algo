/**
* Classe representant une liste chainee
*/
public class ListeChainee implements Liste{

    private int tete;
	private MaillonEntier[] tab;
    

	/**
	* Constructeur permettant de creer une liste chainee
	* @param maxtab 
	*            permet de moduler la taille de tab */
	public ListeChainee(int maxtab){
		this.tete=-1;

		this.tab= new MaillonEntier[maxtab];
			for(int i = 0; i<maxtab;i++)
				this.tab[i]= new MaillonEntier(null,-2);
	}

    /**
	 * permet de suprrimer un element d'une liste
	 * @param p place de l'element  supprimer 
	 */
	public void suplis(int p){
		 int pl = 0;
		 if(p==this.tete){
		 	this.tete=this.tab[p].getSuc();
		 }else{ 
		 	pl = this.tete; 
		 	while (this.tab[pl].getSuc()!= p){
		 	pl = this.tab[pl].getSuc();
		 }
		 this.tab[pl].setSuc(this.tab[p].getSuc());
		 libererPlace(p);
		}
    }
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element  ajouter en tete
	 */
	public void adjtlis(String s){
         int i = retournerPlaceLibre();
		 this.tab[i].setVal(s);
		 this.tab[i].setSuc(this.tete);
		 this.tete = i;


    }
	
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element inserer
	 */
	public void adjlis(int p, String s){
         int i = retournerPlaceLibre();
		 this.tab[i].setVal(s);
		 this.tab[i].setSuc(this.tab[p].getSuc());
		 this.tab[p].setSuc(i);
    }
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p){
         boolean fin = false;
		 if (p==-1)
		 	fin=true;
		return fin;
    }
	
	/**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete(){
         return this.tete ;
    }
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p){
         return this.tab[p].getSuc();
    }
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee  p
	 */
	public String val(int p){
         return this.tab[p].getVal();
    }

	/**
	 * retourne la valeur de la premiere place libre disponible
	 * ou -3 s'il n'y en a pas 
	 * @return l'indice de la première place libre disponible
	 */

	private int retournerPlaceLibre(){
		int i = 0;
		int pl = 0;
		while(this.tab[i].getSuc() != -2)
			i++;
		if(this.tab[i].getSuc()== -2)
			pl = i;
		else
			pl=-3;
		return pl;
	}

	/**
	 * permet de transformer la place p en place libre
	 * @param p la place que l'on veut rendre libre
	 */
	private void libererPlace(int p){
		this.tab[p]= new MaillonEntier(null,-2);
	}


}