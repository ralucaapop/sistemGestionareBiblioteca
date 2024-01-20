package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Utilitar.FunctiiBibliotecar;

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
	
        Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		panelAdaugaCititor.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
		this.setTitle("Adauga un nou cititor");
		
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		titluPg = new JLabel("Inregistreaza un nou cititor");
		titluPg.setFont(titleFont);
		titluPg.setForeground(maroonColor);
		titluPg.setAlignmentX(Component.CENTER_ALIGNMENT);


		
		CNPCititor=new JLabel("CNP-ul cititorului");
		CNPCititor.setPreferredSize(new Dimension(120, 20));
		CNPCititor.setFont(labelFont);
		CNPCititor.setForeground(darkGreenColor);
		CNPCititor.setAlignmentX(Component.CENTER_ALIGNMENT);

		numeCititor=new JLabel("Numele cititorului");
		numeCititor.setPreferredSize(new Dimension(120, 20));
		numeCititor.setFont(labelFont);
		numeCititor.setForeground(darkGreenColor);
		numeCititor.setAlignmentX(Component.CENTER_ALIGNMENT);

		nrTelefonCititor = new JLabel("Nr de telefon");
		nrTelefonCititor.setPreferredSize(new Dimension(120, 20));
		nrTelefonCititor.setFont(labelFont);
		nrTelefonCititor.setForeground(darkGreenColor);
		nrTelefonCititor.setAlignmentX(Component.CENTER_ALIGNMENT);

		parolaCititor = new JLabel("Parola");
		parolaCititor.setPreferredSize(new Dimension(120, 20));
		parolaCititor.setFont(labelFont);
		parolaCititor.setForeground(darkGreenColor);
		parolaCititor.setAlignmentX(Component.CENTER_ALIGNMENT);

		
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

		setLayout(new GridBagLayout()); 
	     GridBagConstraints gbc = new GridBagConstraints();
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.fill = GridBagConstraints.CENTER;
	     add(panelAdaugaCititor, gbc);

	    adauga.setAlignmentX(Component.CENTER_ALIGNMENT);
	    adauga.setBackground(maroonColor);
	    adauga.setForeground(whiteColor);

		adauga.addActionListener(actAdd);
		this.add(panelAdaugaCititor);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		
	}
	
}
