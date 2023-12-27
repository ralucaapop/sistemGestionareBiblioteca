package ProiectP3Biblioteca;

import java.time.LocalDate;
/**
 * Clasa care defineste un obiect de tip imprumut
 */
public class Imprumut {
	private int idExemplar;
	private String CNPCititor;
	private LocalDate dataImprumut;
	
	/**
	 * Constructor fara parametrii
	 */
	public Imprumut() {
		this.CNPCititor="nec";
		this.idExemplar=0;
		this.dataImprumut=(LocalDate.of(0,0,0));
	}
	/**
	 * Constructor cu parametrii
	 * @param idExemplar - id-ul Exemplarului care se imprumuta
	 * @param CNP - CNP-ul cititorului care imprumuta
	 * @param di - data imprumutului
	 */
	public Imprumut(int idExemplar, String CNP, LocalDate di) {
		this.CNPCititor=CNP;
		this.idExemplar=idExemplar;
		this.dataImprumut=di;
	}
	
	public int getIdExemplar() {
		return this.idExemplar;
	}
	
	public String getCNPCititor() {
		return this.CNPCititor;
	}
	
	public LocalDate getDataImprumut() {
		return this.dataImprumut;
	}
}