package ProiectP3Biblioteca;
/**
 * Aceasta clasa defineste un obect de tipul unei carti
 */
public class Carte {
	
	private int idCarte;
	private String titluCarte;
	private String gen;
	private String autor;
	private int nrExemplareImprumutate;
	private int nrExemplareDisponibile;
	private int nrExemplareRezervate;
	private int nrZileImprumut;

	/**
	 * Constructor fara parametrii
	 */
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
	/**
	 * Construnctrul cu parametrii
	 * @param id - identificatroul unic al unei carti
	 * @param titlu - titlul cartii
	 * @param gen - genul cartii
	 * @param autor - autorul cartii
	 * @param nrei - numarul de exemplare imprumutate
	 * @param nred - numarul de exemplare disponibile
	 * @param nrer - numarul de exemplare rezervate
	 * @param nrzi - numarul de zile pentru care poate fi imprumutat un exemplar al cartii respective
	 */
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
	
	/**
	 * Metoda pentru modificarea numarului de exemplare imprumutate
	 * @param nr - numarul nou  de exemplare imprumutate
	 */
	public void setNrExemplareImprumutate(int nr){
		this.nrExemplareImprumutate=nr;
	}
	/**
	 * Metoda pentru modificarea numarului de exemplare disponibile
	 * @param nr - numarul nou  de exemplare disponibile
	 */
	public void setNrExemplareDisponibile(int nr){
		this.nrExemplareDisponibile=nr;
	}
	/**
	 * Metoda pentru modificarea numarului de exemplare returnate
	 * @param nr - numarul nou  de exemplare returnate
	 */
	public void setNrExemplareRezervate(int nr){
		this.nrExemplareRezervate=nr;
	}
	
	public String toString() {
		return this.idCarte+" "+this.titluCarte+" "+this.autor;
	}
	
	public String afiseazaTitluAutro() {
		return this.titluCarte+' '+this.autor;
	}
}
