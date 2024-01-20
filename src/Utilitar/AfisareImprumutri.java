package Utilitar;

public class AfisareImprumutri {
	private String titlu;
	private String autor;
	private int idE;
	
	public AfisareImprumutri(int idE,String titlu, String autor) {
		this.titlu=titlu;
		this.autor=autor;
		this.idE=idE;
	}
	
	public int getIdE() {
		return this.idE;
	}
	
	public String toString() {
		return this.idE+" "+this.titlu+" "+this.autor;
	}
}
