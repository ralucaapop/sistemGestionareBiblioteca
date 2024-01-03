package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesignCreareContBibliotecar extends JFrame {

	JLabel titluPg;
	JLabel idAngajat;
	JLabel numeBibliotecar;
	JLabel nrTelefonBibliotecar;
	JLabel parolaBibliotecar;
	JLabel emailBibliotecar;
	
	JTextField idA;
	JTextField numeA;
	JTextField nrTelefonA;
	JTextField parolaA;
	JTextField emailA;

	
	JButton adauga;
	
	public DesignCreareContBibliotecar(){
		
		JPanel panelAdaugaBibliotecar = new JPanel();
		panelAdaugaBibliotecar.setLayout(new BoxLayout(panelAdaugaBibliotecar, BoxLayout.Y_AXIS));
		
		this.setTitle("Adauga un nou bibliotecar");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		titluPg = new JLabel("Inregistreaza un nou bibliotecar");
		
		idAngajat=new JLabel("ID-ul de angajat");
		numeBibliotecar=new JLabel("Numele bibliotecarului");
		nrTelefonBibliotecar = new JLabel("Nr de telefon");
		parolaBibliotecar = new JLabel("Parola");
		emailBibliotecar = new JLabel("E-mail");

		
		idA = new JTextField(13);
		numeA = new JTextField(20);
		nrTelefonA = new JTextField(20);
		parolaA = new JTextField(20);
		emailA = new JTextField(20);

		adauga = new JButton("INREGISTREAZA BIBLIOTECARUL");
		
		panelAdaugaBibliotecar.add(titluPg);
		panelAdaugaBibliotecar.add(idAngajat);
		panelAdaugaBibliotecar.add(idA);
		panelAdaugaBibliotecar.add(numeBibliotecar);
		panelAdaugaBibliotecar.add(numeA);
		panelAdaugaBibliotecar.add(nrTelefonBibliotecar);
		panelAdaugaBibliotecar.add(nrTelefonA);
		panelAdaugaBibliotecar.add(emailBibliotecar);
		panelAdaugaBibliotecar.add(emailA);
		panelAdaugaBibliotecar.add(parolaBibliotecar);
		panelAdaugaBibliotecar.add(parolaA);
		panelAdaugaBibliotecar.add(adauga);
		
		ActionListener actAdd = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(idA.getText());
				String nume=numeA.getText();
				String nrTel=nrTelefonA.getText();
				String parola = parolaA.getText();
				String email = emailA.getText();

				boolean idValid=Functii.verificaIDAngajat(id);///returneaza true daca exista deja acel id
				if(idValid==true) {
					
					JOptionPane.showMessageDialog(DesignCreareContBibliotecar.this,
	                        "Acest id aparetine deja unui bibliotecar",
	                        "EROARE ADAUGARE BIBLIOTECAR",
	                        JOptionPane.ERROR_MESSAGE);
						idA.setText("");
				}
				else 
				{
					Functii.adaugaBibliotecarNou(id, nume, nrTel,email, parola);
					JOptionPane.showMessageDialog(DesignCreareContBibliotecar.this,
	                        "Bibliotecar inregistrat cu succes",
	                        "Bibliotecar inregistrat",
	                        JOptionPane.INFORMATION_MESSAGE);
						
					DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
					setVisible(false);
					cit.setVisible(true);
				}
				
			}
		};
		
		adauga.addActionListener(actAdd);
		this.add(panelAdaugaBibliotecar);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
