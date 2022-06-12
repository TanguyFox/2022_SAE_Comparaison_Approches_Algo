class ListeGenerer{

	/**
	 * Permet de récolter un nom dans une ligne
	 */
	private static String nom(String ligne){
		String s = "";
		for(int i =0;i<ligne.length();i++){
			if(ligne.charAt(i) == '\t')
				return s;
			else
				s+= ligne.charAt(i);
		}
		return s;
	}

	/**
	 *Permet de savoir si un nom est deja présent dans la liste
	 */
	private static boolean dans(String[] liste, String chaine,int l){
		for(int i =0;i<l;i++){
			if(liste[i].equals(chaine))
				return true;
		}
		return false;
	}
	
	/**
	 * Permet de générer une liste de noms aléatoirement pouvant aller jusqu'à 218982 noms
	 */
	public static void main(String[] args){

		LectureFichier fichier = new LectureFichier("noms2008nat_txt.txt");//création de l'object pour lire le fichier où sont stockés les noms

		String[] lignes = fichier.lireFichier();	//Lecture de toutes les lignes
		

		

		int[] l = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000,200000};

		for(int k:l){

			String[] listeNoms = new String[k];//création d'une liste de X longueur
			int i =0;
			/**
			 * Tant qu'on n'a pas X noms distincts on tire aléatoirement des noms
			 */
			while(i<k){

				double random =  Math.random(); 
				int number = (int) (218982*random) +1; //permet de séléctionner un nombre entre 1 et 218983

				String nom = ListeGenerer.nom(lignes[number]);//permet de récolter un nom dans une ligne

				if(!ListeGenerer.dans(listeNoms,nom,i)){//Si un nom tiré aléatoirement est déjà présent dans la liste on recomence sinon on l'affecte à ieme ligne du tableau
					listeNoms[i] = nom;
					i++;
				}
			}


			/**
			 * Permet de créer et d'écrire la liste dans le fichier de noms
			 */
			EcritureFichier fichierNom = new EcritureFichier("liste" + k + ".txt");
			fichierNom.ouvrirFichier();

			for (int j =0;j<k;j++){
				
				fichierNom.ecrireFichier(listeNoms[j]);
			}
			fichierNom.fermerFichier();
		}
		

	}
}
