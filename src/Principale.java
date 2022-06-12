public class Principale{
	
	
	public static void remplirListe(ListeTriee liste, String nom_fichier){
		LectureFichier lf = new LectureFichier(nom_fichier);
	
		String[] liste_noms = lf.lireFichier();
		for (String s : liste_noms) {
			liste.adjlisT(s);
		}
	}

	public static ListeTriee creationListe(int taille,boolean chainee){
		if(chainee){
			ListeChainee lch = new ListeChainee(taille+1000);
			ListeTriee lcht = new ListeTriee(lch);
			remplirListe(lcht, "liste"+taille+".txt");
			return lcht;
		}
		else{
			ListeContigue lc = new ListeContigue(taille+1000);
			ListeTriee lct = new ListeTriee(lc);
			remplirListe(lct, "liste"+taille+".txt");
			return lct;
		}
		
	}

	public static void ajoutListe(String[] element,ListeTriee liste){
		for(String ele : element){
			liste.adjlisT(ele);
		}
	}

	public static void memlisT(String[] element,ListeTriee liste){
		for(String ele:element){
			liste.memlisT(ele);
		}
	}

	public static void suppressionListe(String[] element, ListeTriee liste){
		for(String ele:element){
			liste.suplisT(ele);
		}
	}

	public static void main(String[] args){

		final String[] ELEMENTS_DE_DEBUT = { "AAAAAAAA", "AA", "AAA", "AAAAAAAAAA",
		"AAAA", "AAAAA", "AAAAAAA", "A", "AAAAAAAAA",
		"AAAAAA"};

		final String[] ELEMENTS_DE_FIN = {"ULLMAN","SHAMIR", "RABIN",
		"SIFAKIS", "TORVALDS", "TURING","YAO" , "VALIANT",
		"WIRTH", "RIVEST"};

		/**Mesure du temps d'execution d'ajout de 10 chaines de caracteres en debut et fin d'alphabet dans une liste chainee de 10 elements
		*test d'appartenance
		*puis suppression
		*/

		int tailleListe = Integer.parseInt(args[0]);
		int repetition = Integer.parseInt(args[1]);

		int[] sommeChainee = {0,0,0,0,0,0};
		int[] sommeContigue = {0,0,0,0,0,0};

		for(int i=0;i<repetition;i++){
			ListeTriee lct = creationListe(tailleListe,false);

			ListeTriee lcht = creationListe(tailleListe,true);

			Temps time = new Temps();

			time.debut();

			ajoutListe(ELEMENTS_DE_DEBUT,lcht);

			time.fin();

			sommeChainee[0] += time.duree();

			time = new Temps();	
			time.debut();

			ajoutListe(ELEMENTS_DE_DEBUT,lct);

			time.fin();

			sommeContigue[0] += time.duree();



			time = new Temps();
			time.debut();

			ajoutListe(ELEMENTS_DE_FIN,lcht);

			time.fin();

			sommeChainee[1] += time.duree();

			time = new Temps();	
			time.debut();

			ajoutListe(ELEMENTS_DE_FIN,lct);

			time.fin();

			sommeContigue[1] += time.duree();






			time = new Temps();

			time.debut();

			memlisT(ELEMENTS_DE_DEBUT,lcht);

			time.fin();

			sommeChainee[2] += time.duree();

			time = new Temps();	
			time.debut();

			memlisT(ELEMENTS_DE_DEBUT,lct);

			time.fin();

			sommeContigue[2] += time.duree();



			time = new Temps();
			time.debut();

			memlisT(ELEMENTS_DE_FIN,lcht);

			time.fin();

			sommeChainee[3] += time.duree();

			time = new Temps();	
			time.debut();

			memlisT(ELEMENTS_DE_FIN,lct);

			time.fin();

			sommeContigue[3] += time.duree();






			time = new Temps();

			time.debut();

			suppressionListe(ELEMENTS_DE_DEBUT,lcht);

			time.fin();

			sommeChainee[4] += time.duree();

			time = new Temps();	
			time.debut();

			suppressionListe(ELEMENTS_DE_DEBUT,lct);

			time.fin();

			sommeContigue[4] += time.duree();



			time = new Temps();
			time.debut();

			suppressionListe(ELEMENTS_DE_FIN,lcht);

			time.fin();

			sommeChainee[5] += time.duree();

			time = new Temps();	
			time.debut();

			suppressionListe(ELEMENTS_DE_FIN,lct);

			time.fin();

			sommeContigue[5] += time.duree();

		}

		for(int som:sommeChainee){
			System.out.println((double) som/repetition);
		}

		for(int som:sommeContigue){
			System.out.println((double) som/repetition);
		}
	}

}