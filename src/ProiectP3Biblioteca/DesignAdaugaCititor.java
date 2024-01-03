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

public class DesignAdaugaCititor extends JFrame {
	
	JLabel titluPg;
	JLabel CNPCititor;
	JLabel numeCititor;
	JLabel nrTelefonCititor;
	JLabel parolaCititor;
	
	
	JTextField cnp;
	JTextField nume;
	JTextField nrTelefon;
	JTextField parola;
	
	JButton adauga;
	
	public DesignAdaugaCititor() {
		JPanel panelAdaugaCititor = new JPanel();
		panelAdaugaCititor.setLayout(new BoxLayout(panelAdaugaCititor, BoxLayout.Y_AXIS));
		
		this.setTitle("Adauga un nou cititor");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		titluPg = new JLabel("Inregistreaza un nou cititor");
		
		CNPCititor=new JLabel("CNP-ul cititorului");
		numeCititor=new JLabel("Numele cititorului");
		nrTelefonCititor = new JLabel("Nr de telefon");
		parolaCititor = new JLabel("Parola");
		
		cnp = new JTextField(13);
		nume = new JTextField(20);
		nrTelefon = new JTextField(20);
		parola = new JTextField(20);
		
		adauga = new JButton("INREGISTREAZA CITITORUL");
		
		panelAdaugaCititor.add(titluPg);
		panelAdaugaCititor.add(CNPCititor);
		panelAdaugaCititor.add(cnp);
		panelAdaugaCititor.add(numeCititor);
		panelAdaugaCititor.add(nume);
		panelAdaugaCititor.add(nrTelefonCititor);
		panelAdaugaCititor.add(nrTelefon);
		panelAdaugaCititor.add(parolaCititor);
		panelAdaugaCititor.add(parola);
		panelAdaugaCititor.add(adauga);
		
		ActionListener actAdd = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cnpC=cnp.getText();
				String numeC=nume.getText();
				String nrTelC=nrTelefon.getText();
				String parolaC = parola.getText();
				
				boolean cnpLungimeCorecta=FunctiiBibliotecar.verLungimeCnp(cnpC);
				boolean cnpValid=FunctiiBibliotecar.cnpValidPtInregistrare(cnpC);
				if(cnpLungimeCorecta==false)
				{
					JOptionPane.showMessageDialog(DesignAdaugaCititor.this,
	                        "CNP-ul nu are lungimea corecta",
	                        "EROARE ADAUGARE CITITOR",
	                        JOptionPane.ERROR_MESSAGE);
						cnp.setText("");
				}
				else if(cnpValid==false) {
					
					JOptionPane.showMessageDialog(DesignAdaugaCititor.this,
	                        "Un utilizator este deja integistrat cu acest CNP",
	                        "EROARE ADAUGARE CITITOR",
	                        JOptionPane.ERROR_MESSAGE);
						cnp.setText("");
				}
				else 
				{
					FunctiiBibliotecar.adaugaCititorNou(cnpC, numeC, nrTelC, parolaC);
					JOptionPane.showMessageDialog(DesignAdaugaCititor.this,
	                        "Cititor inregistrat cu succes",
	                        "Cititor inregistrat",
	                        JOptionPane.INFORMATION_MESSAGE);
						
					DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
					setVisible(false);
					cit.setVisible(true);
				}
				
			}
		};
		
		adauga.addActionListener(actAdd);
		this.add(panelAdaugaCititor);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		
	}
	
}
