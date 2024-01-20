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

import Utilitar.Functii;

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
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
			
		getContentPane().setBackground(whiteColor); 
		panelAdaugaBibliotecar.setBackground(whiteColor);

	    Color maroonColor1 = new Color(128, 0, 0);
	        
	    Color darkGreenColor = new Color(0, 100, 0);

	        Font titleFont = new Font("Arial", Font.BOLD, 20);
	        Font labelFont = new Font("Arial", Font.PLAIN, 14);
		
		titluPg = new JLabel("Inregistreaza un nou bibliotecar");
		titluPg.setFont(titleFont);
		titluPg.setForeground(maroonColor);
		titluPg.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		idAngajat=new JLabel("ID-ul de angajat");
		idAngajat.setPreferredSize(new Dimension(120, 20));
		idAngajat.setFont(labelFont);
		idAngajat.setForeground(darkGreenColor);
		idAngajat.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		numeBibliotecar=new JLabel("Numele bibliotecarului");
		numeBibliotecar.setPreferredSize(new Dimension(120, 20));
		numeBibliotecar.setFont(labelFont);
		numeBibliotecar.setForeground(darkGreenColor);
		numeBibliotecar.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		nrTelefonBibliotecar = new JLabel("Nr de telefon");
		nrTelefonBibliotecar.setPreferredSize(new Dimension(120, 20));
		nrTelefonBibliotecar.setFont(labelFont);
		nrTelefonBibliotecar.setForeground(darkGreenColor);
		nrTelefonBibliotecar.setAlignmentX(Component.CENTER_ALIGNMENT);

		parolaBibliotecar = new JLabel("Parola");
		parolaBibliotecar.setPreferredSize(new Dimension(120, 20));
		parolaBibliotecar.setFont(labelFont);
		parolaBibliotecar.setForeground(darkGreenColor);
		parolaBibliotecar.setAlignmentX(Component.CENTER_ALIGNMENT);

		emailBibliotecar = new JLabel("E-mail");
		emailBibliotecar.setPreferredSize(new Dimension(120, 20));
		emailBibliotecar.setFont(labelFont);
		emailBibliotecar.setForeground(darkGreenColor);
		emailBibliotecar.setAlignmentX(Component.CENTER_ALIGNMENT);

		
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
		adauga.setBackground(darkGreenColor);
		adauga.setForeground(whiteColor);
		adauga.setAlignmentX(Component.CENTER_ALIGNMENT);

		setLayout(new GridBagLayout());
	     GridBagConstraints gbc = new GridBagConstraints();
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.fill = GridBagConstraints.CENTER;
	     add(panelAdaugaBibliotecar, gbc);
	     
		adauga.addActionListener(actAdd);
		
		this.add(panelAdaugaBibliotecar);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
