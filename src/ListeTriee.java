public class ListeTriee{

	// Attribut de liste sous-jacente
	private Liste liste;
	
	public ListeTriee(Liste listevide){
		// Affectation de la liste vide a l'attribut prive
		liste = listevide;
	}
	
	/** 
	 * Constructeur d'une liste a partir d'un fichier
	*/
	public ListeTriee (Liste listevide, String nom){

		this.liste=listevide;
		ListeTriee lt= new ListeTriee(this.liste);
		LectureFichier lf = new LectureFichier(nom);
		String[] lignes = lf.lireFichier();
		for(String s : lignes)
			this.adjlisT(s);
	}
	
	/**
	 * ajoute un element au bon endroit dans la liste triee
	 * @param chaine element a inserer
	 */
	public void adjlisT(String chaine){
	   

	   int p = liste.tete();
	   if(liste.finliste(p)){
		liste.adjtlis(chaine);
	   }else{
		boolean trouve = false;
	   	int placePre = p;
		while(!liste.finliste(p) && !trouve){
			String ch = liste.val(p);
			if(ch.compareTo(chaine)>=1){
				trouve=true;
			}else{
			        placePre=p;
				p=liste.suc(p);
			}
		}
		if(p==placePre)
			liste.adjtlis(chaine);
		else
			liste.adjlis(placePre,chaine);
		}
	}
	
	/**
	 * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
	 * @param chaine l'element a supprimer 
	 */
	public void suplisT(String chaine){
		int p = liste.tete();
		boolean arret = false;

		while(!liste.finliste(p) && !arret){
			String val = liste.val(p);
			if(val.compareTo(chaine) <= -1){
				p = liste.suc(p);
			}
			else if(val.compareTo(chaine) >= 1){
				arret = true;
			}
			else{
				liste.suplis(p);
				arret = true;
			}
		}
	}
	
	/**
	 * Retourne vrai si au moins un element de la liste a une valeur egale a "chaine", et retourne faux sinon.
	 * @param chaine l'element que l'on recherche
	 */
	public boolean memlisT(String chaine){
	  boolean trouve = false;
	  int p = 0;

	  while(!liste.finliste(p) && !trouve){
		String ch = liste.val(p);
		if(ch.equals(chaine)){
			trouve=true;
		}else{
			p=liste.suc(p);
			if(liste.finliste(p))
			trouve = false;
		}
	  }
	return trouve;
	}

	public String toString(){
		int p = liste.tete();
		String s ="";
		while(!liste.finliste(p)){
			s += liste.val(p) + " ";
			p = liste.suc(p);
		}
		return s;
	}
}
