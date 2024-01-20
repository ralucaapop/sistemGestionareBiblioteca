package ProiectP3Biblioteca;

import Design.DesignMain;
import Utilitar.CreareTabele;

public class MainClasProiectP3Biblioteca {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";
	
	public static void main(String[] args)
	{
		DesignMain d1 = new DesignMain();
		d1.setVisible(true);
		CreareTabele.createTableCititori();
		CreareTabele.createTableBibliotecari();
		CreareTabele.createTableCarti();
		CreareTabele.createTableExemplare();
		CreareTabele.createTableImprumuturi();
		CreareTabele.createTableRezervari();
	}
}
