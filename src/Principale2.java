public class Principale2{
	
	
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

		
		int repetition = 100;
		String[] listeResultat = {"ajoutListeDebut","ajoutListeFin","memlisTDebut","memlisTFin","suppressionListeDebut","suppressionListeFin"};
		double[][] sommeChainee = new double[6][10];
		double[][] sommeContigue = new double[6][10];

		int[] tailleListe = {10,50,100,500,1000,5000,10000,50000,100000,200000};
		int k;
		for(int j=0;j<10;j++){

			k = tailleListe[j];

			ListeTriee lct = creationListe(k,false);

			ListeTriee lcht = creationListe(k,true);

			for(int i=0;i<repetition;i++){

				

				Temps time = new Temps();

				time.debut();

				ajoutListe(ELEMENTS_DE_DEBUT,lcht);

				time.fin();

				sommeChainee[0][j] += time.duree();

				time = new Temps();	
				time.debut();

				ajoutListe(ELEMENTS_DE_DEBUT,lct);

				time.fin();

				sommeContigue[0][j] += time.duree();



				time = new Temps();
				time.debut();

				ajoutListe(ELEMENTS_DE_FIN,lcht);

				time.fin();

				sommeChainee[1][j] += time.duree();

				time = new Temps();	
				time.debut();

				ajoutListe(ELEMENTS_DE_FIN,lct);

				time.fin();

				sommeContigue[1][j] += time.duree();






				time = new Temps();

				time.debut();

				memlisT(ELEMENTS_DE_DEBUT,lcht);

				time.fin();

				sommeChainee[2][j] += time.duree();

				time = new Temps();	
				time.debut();

				memlisT(ELEMENTS_DE_DEBUT,lct);

				time.fin();

				sommeContigue[2][j] += time.duree();



				time = new Temps();
				time.debut();

				memlisT(ELEMENTS_DE_FIN,lcht);

				time.fin();

				sommeChainee[3][j] += time.duree();

				time = new Temps();	
				time.debut();

				memlisT(ELEMENTS_DE_FIN,lct);

				time.fin();

				sommeContigue[3][j] += time.duree();






				time = new Temps();

				time.debut();

				suppressionListe(ELEMENTS_DE_DEBUT,lcht);

				time.fin();

				sommeChainee[4][j] += time.duree();

				time = new Temps();	
				time.debut();

				suppressionListe(ELEMENTS_DE_DEBUT,lct);

				time.fin();

				sommeContigue[4][j] += time.duree();



				time = new Temps();
				time.debut();

				suppressionListe(ELEMENTS_DE_FIN,lcht);

				time.fin();

				sommeChainee[5][j] += time.duree();

				time = new Temps();	
				time.debut();

				suppressionListe(ELEMENTS_DE_FIN,lct);

				time.fin();

				sommeContigue[5][j] += time.duree();
				System.out.println(tailleListe[j]);
				

			}

		}
		System.out.println("Liste chainee");
		for(int g =0;g<6;g++){
			
			System.out.print(listeResultat[g] + " : " + "\n");
			for(int f = 0;f<10;f++){
				System.out.println((double) sommeChainee[g][f]/repetition);
				

			}
		}
		System.out.println("\nListe contigue");
		for(int g =0;g<6;g++){
			
			System.out.print(listeResultat[g] + " : " + "\n");
			for(int f = 0;f<10;f++){
				System.out.println((double) sommeContigue[g][f]/repetition);
				

			}
		}
	}

}