package ProiectP3Biblioteca;

public class Carte {
	
	private int idCarte;
	private String titluCarte;
	private String gen;
	private String autor;
	private int nrExemplareImprumutate;
	private int nrExemplareDisponibile;
	private int nrExemplareRezervate;
	private int nrZileImprumut;

	public Carte()
	{
		this.idCarte=0;
		this.titluCarte="nec";
		this.gen="nec";
		this.autor="nec";
		this.nrExemplareImprumutate=0;
		this.nrExemplareDisponibile=0;
		this.nrExemplareRezervate=0;
		this.nrZileImprumut=0;
	}
	
	public Carte(int id, String titlu, String gen, String autor, int nrei, int nred, int nrer, int nrzi)
	{
		this.idCarte=id;
		this.titluCarte=titlu;
		this.gen=gen;
		this.autor=autor;
		this.nrExemplareImprumutate=nrei;
		this.nrExemplareDisponibile=nred;
		this.nrExemplareRezervate=nrer;
		this.nrZileImprumut=nrzi;
	}
	
	public String getTitlu() {
		return this.titluCarte;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getIdCarte() {
		return this.idCarte;
	}
	
	public String getGen()
	{
		return this.gen;
	}
	
	public int getNrZileImprumut() {
		return this.nrZileImprumut;
	}
	
	public int getNrExemplareImprumutate() {
		return this.nrExemplareImprumutate;
	}
	
	public int getNrExemplareDisponibile() {
		return this.nrExemplareDisponibile;
	}
	
	public int getNrExemplareRezervate() {
		return this.nrExemplareRezervate;
	}
	
	public void setNrExemplareImprumutate(int nr){
		this.nrExemplareImprumutate=nr;
	}
	public void setNrExemplareDisponibile(int nr){
		this.nrExemplareDisponibile=nr;
	}
	public void setNrExemplareRezervate(int nr){
		this.nrExemplareRezervate=nr;
	}
	
	public String toString() {
		return this.idCarte+" "+this.titluCarte+" "+this.autor;
	}
}
