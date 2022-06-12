import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe ListeTriee
 * fonctionne correctement
 */
public class TestListeTriee {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestListeTriee(), args);
	}

	/**
	 * Test d'ajout dans une liste contigue triee
	 */
	public void test_01_adjlisT_ListeContigue_OK(){
		//Creation de la liste
		Liste lc = new ListeContigue(100);
		ListeTriee lt = new ListeTriee(lc);

		//la liste doit etre vide
		int tete=lc.tete();
		assertEquals("la liste est vide", true, lc.finliste(tete));

		//Ajout des elements dans la liste
		lt.adjlisT("Lapin");
		lt.adjlisT("Elephant");
		lt.adjlisT("Tulipe");
		lt.adjlisT("Cailloux");

		//verification liste non vide et triee
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",lt.toString());
	}

	/**
	 * Test d'ajout dans une liste chainee triee
	 */
	public void test_02_adjlisT_ListeChainee_OK(){
		//Creation de la liste
		Liste lch = new ListeChainee(100);
		ListeTriee ltch = new ListeTriee(lch);

		//la liste doit etre vide
		int tete=lch.tete();
		assertEquals("la liste est vide", true, lch.finliste(tete));

		//Ajout des elements dans la liste
		ltch.adjlisT("Lapin");
		ltch.adjlisT("Elephant");
		ltch.adjlisT("Tulipe");
		ltch.adjlisT("Cailloux");

		//verification liste non vide et triee
		tete = lch.tete();
		assertEquals("liste ne devrait pas etre vide", false, lch.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",ltch.toString());
	}

	/**
	 * Test normal de suppression d'un élément de la liste chainee
	 */
	public void test_03_suppression_listeChainee(){
		String[] a = {"ldf","abcd","zferf","pzcs",};
		Liste l = new ListeChainee(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("ldf");
		String s = "abcd pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à "+ s,s,lt.toString());
	}

	/**
	 * Test normal de suppression d'un élément de la liste contigue
	 */
	public void test_04_suppression_listeContigue(){
		String[] a = {"ldf","abcd","zferf","pzcs"};
		Liste l = new ListeContigue(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("ldf");
		String s = "abcd pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à" + s,s,lt.toString());
	}


	/**
	 * Test de suppression d'un élément de la liste chainee si l y a 2 mêmes éléments, doit supprimer le 1er element trouve
	 */
	public void test_05_suppression_listeChainee_2_meme_chaine(){
		String[] a = {"ldf","abcd","zferf","ldf","pzcs",};
		Liste l = new ListeChainee(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("ldf");
		String s = "abcd ldf pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à "+ s,s,lt.toString());
	}

	/**
	 * Test de suppression d'un élément de la liste contigue si l y a 2 mêmes éléments, doit supprimer le 1er element trouve
	 */
	public void test_06_suppression_listeContigue_2_meme_chaine(){
		String[] a = {"ldf","abcd","zferf","ldf","pzcs"};
		Liste l = new ListeContigue(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("ldf");
		String s = "abcd ldf pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à "+s,s,lt.toString());
	}

	/**
	 * Test liste chainee vide
	 */
	public void test_07_suppression_listeChainee_vide(){
		Liste l = new ListeChainee(100);
		ListeTriee lt = new ListeTriee(l);
		lt.suplisT("ldf");
		String s = "";
		int tete = l.tete();
		assertEquals("La liste doit etre vide",true,l.finliste(tete));
		assertEquals("La liste devrait être égale à une liste vide ",s,lt.toString());
	}

	/**
	 * Test liste contigue vide
	 */
	public void test_08_suppression_listeContigue_vide(){
		Liste l = new ListeContigue(100);
		ListeTriee lt = new ListeTriee(l);
		lt.suplisT("ldf");
		String s = "";
		int tete = l.tete();
		assertEquals("La liste doit etre vide",true,l.finliste(tete));
		assertEquals("La liste devrait être égale à une liste vide ",s,lt.toString());
	}


	/**
	 * Test normal de suppression d'un élément qui n'appartient pas à la liste chainee
	 */
	public void test_09_suppression_listeChainee_chaine_n_appartient_pas(){
		String[] a = {"ldf","abcd","zferf","pzcs",};
		Liste l = new ListeChainee(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("medf");
		String s = "abcd ldf pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à "+ s,s,lt.toString());
	}

	/**
	 * Test normal de suppression d'un élément qui n'appartient pas à la liste contigue
	 */
	public void test_10_suppression_listeChainee_contigue_n_appartient_pas(){
		String[] a = {"ldf","abcd","zferf","pzcs",};
		Liste l = new ListeContigue(100);
		ListeTriee lt = new ListeTriee(l);
		for(String c:a){
			lt.adjlisT(c);
		}

		lt.suplisT("medf");
		String s = "abcd ldf pzcs zferf ";
		int tete = l.tete();
		assertEquals("La liste doit etre non vide",false,l.finliste(tete));
		assertEquals("La liste devrait être égale à "+ s,s,lt.toString());
	}

	/**
	 * Test normaml d'appartenance d'un élément dans une liste chainee 
	 */
	public void test_11_memlisT_ListeChainee_OK(){

		//Creation des listes
		Liste lch = new ListeChainee(100);
		ListeTriee lcht = new ListeTriee(lch);

		//la liste doit etre vide
		int tete=lch.tete();
		assertEquals("la liste est vide", true, lch.finliste(tete));

		//Ajout des elements dans la liste
		lcht.adjlisT("Lapin");
		lcht.adjlisT("Elephant");
		lcht.adjlisT("Tulipe");
		lcht.adjlisT("Cailloux");

		//verification liste non vide et triee
		tete=lch.tete();
		assertEquals("liste ne devrait pas etre vide", false, lch.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",lcht.toString());

		// Test d'appartenance d'un élément

		boolean pres = lcht.memlisT("Tulipe");
		assertEquals("Tulipe est present dans la liste",true,pres);
	}

	/**
	 * Test normaml d'appartenance d'un élément dans une liste contigue 
	 */
	public void test_12_memlisT_ListeContigue_OK(){

		//Creation des listes
		Liste lc = new ListeContigue(100);
		ListeTriee lct = new ListeTriee(lc);

		//la liste doit etre vide
		int tete=lc.tete();
		assertEquals("la liste est vide", true, lc.finliste(tete));

		//Ajout des elements dans la liste
		lct.adjlisT("Lapin");
		lct.adjlisT("Elephant");
		lct.adjlisT("Tulipe");
		lct.adjlisT("Cailloux");

		//verification liste non vide et triee
		tete=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",lct.toString());

		// Test d'appartenance d'un élément

		boolean pres = lct.memlisT("Cailloux");
		assertEquals("Cailloux est present dans la liste",true,pres);
	}

	/**
	 * Test d'appartenance d'un élément non present dans une liste chainee 
	 */
	public void test_13_memlisT_ListeChainee_Non_Present(){

		//Creation des listes
		Liste lch = new ListeChainee(100);
		ListeTriee lcht = new ListeTriee(lch);

		//la liste doit etre vide
		int tete=lch.tete();
		assertEquals("la liste est vide", true, lch.finliste(tete));

		//Ajout des elements dans la liste
		lcht.adjlisT("Lapin");
		lcht.adjlisT("Elephant");
		lcht.adjlisT("Tulipe");
		lcht.adjlisT("Cailloux");

		//verification liste non vide et triee
		tete=lch.tete();
		assertEquals("liste ne devrait pas etre vide", false, lch.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",lcht.toString());

		// Test d'appartenance d'un élément

		boolean pres = lcht.memlisT("Banane");
		assertEquals("Banane n'est pas present dans la liste",false,pres);
	}

	/**
	 * Test d'appartenance d'un élément non present dans une liste contigue 
	 */
	public void test_14_memlisT_ListeContigue_Non_Present(){

		//Creation des listes
		Liste lc = new ListeContigue(100);
		ListeTriee lct = new ListeTriee(lc);

		//la liste doit etre vide
		int tete=lc.tete();
		assertEquals("la liste est vide", true, lc.finliste(tete));

		//Ajout des elements dans la liste
		lct.adjlisT("Lapin");
		lct.adjlisT("Elephant");
		lct.adjlisT("Tulipe");
		lct.adjlisT("Cailloux");

		//verification liste non vide et triee
		tete=lc.tete();
		assertEquals("liste ne devrait pas etre vide", false, lc.finliste(tete));
		assertEquals("la liste doit etre triee","Cailloux Elephant Lapin Tulipe ",lct.toString());

		// Test d'appartenance d'un élément

		boolean pres = lct.memlisT("Souris");
		assertEquals("Souris n'est pas present dans la liste",false,pres);
	}

}
