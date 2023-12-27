package ProiectP3Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClasProiectP3Biblioteca {
	public static void main(String[] args)
	{
		
		boolean alegereCorecta=false;
		while(!alegereCorecta)
		{		
			Scanner sc = new Scanner(System.in);
			System.out.println("ALEGE ROLUL TAU:\n1.CITITOR\n2.BIBLIOTECAR\n3.EXIT(pentru a inchide aplicatia)\n");
			System.out.print("ALEGEREA TA:");
			int alegere=Integer.parseInt(sc.next());
			if(alegere==1)
				Functii.actiuniCititor(sc);
			else if(alegere==2)
				Functii.actiuniBibliotecar(sc);
			else if(alegere==3)
				System.exit(0);
			if(alegere==1||alegere==2||alegere==3)
				alegereCorecta=true;
			else System.out.println("Alegerea nu este corecta.Aceasta trebuie sa fie un numar din multimea {1,2,3}\n");
		}
	}
	
	
}
