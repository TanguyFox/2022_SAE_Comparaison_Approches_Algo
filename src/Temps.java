class Temps{
	
	long debut;
	long fin;

	public Temps(){

	}

	public void debut(){
		debut = System.nanoTime();
	}

	public void fin(){
		fin = System.nanoTime();
	}

	public long duree(){
		return fin - debut;
	}
}