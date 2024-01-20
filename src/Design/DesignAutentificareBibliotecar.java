package Design;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingUtilities;

import Utilitar.Functii;

public class DesignAutentificareBibliotecar extends JFrame{
	
	JLabel etichetaTitlu1;
	JLabel etichetaID;
	JLabel etichetaParola;
	JTextField id;
	JTextField parola;
	JButton LOGIN;
	
	public DesignAutentificareBibliotecar() {
		
		JPanel panelLoginCititor = new JPanel();
		panelLoginCititor.setLayout(new BoxLayout(panelLoginCititor, BoxLayout.Y_AXIS));
	
		    Color maroonColor = new Color(128, 0, 0);
			Color whiteColor = new Color(248, 250, 229);
			
			getContentPane().setBackground(whiteColor); 
			panelLoginCititor.setBackground(whiteColor);

	        Color maroonColor1 = new Color(128, 0, 0);
	        
	        Color darkGreenColor = new Color(0, 100, 0);

	        Font titleFont = new Font("Arial", Font.BOLD, 20);
	        Font labelFont = new Font("Arial", Font.PLAIN, 14);
		
		etichetaTitlu1=new JLabel("INTRA IN CONTUL TAU");
		etichetaTitlu1.setFont(titleFont);
	    etichetaTitlu1.setForeground(maroonColor);

		etichetaID = new JLabel("Introdu ID-UL de angajat");
		etichetaID.setPreferredSize(new Dimension(120, 20));
	    etichetaID.setFont(labelFont);
	    etichetaID.setForeground(darkGreenColor);
		
		

		etichetaParola = new JLabel("IntroduParola");
		etichetaParola.setPreferredSize(new Dimension(120, 20));
	    etichetaParola.setFont(labelFont);
	    etichetaParola.setForeground(darkGreenColor);	
	    
		LOGIN = new JButton("LOGIN");
		LOGIN.setBackground(maroonColor);
	    LOGIN.setForeground(whiteColor);
	    
		id = new JTextField(13);
		parola = new JTextField(20);
		

		panelLoginCititor.add(etichetaTitlu1);
		panelLoginCititor.add(etichetaID);
		panelLoginCititor.add(id);
		panelLoginCititor.add(etichetaParola);
		panelLoginCititor.add(parola);
		panelLoginCititor.add(LOGIN);

		this.setTitle("OptiuniCititor");
		this.setSize(650, 500);
		
		
		ActionListener actLOGIN = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idA=Integer.parseInt(id.getText());
				String parolaBibliotecar = parola.getText();
				boolean ac=Functii.verificaAutentificareBibliotecar(idA, parolaBibliotecar);
				boolean idV=Functii.verificaIDAngajat(idA);
				
				if(idV==false)
				{
					JOptionPane.showMessageDialog(DesignAutentificareBibliotecar.this,
                            "ID INVALID",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
						id.setText("");
						parola.setText("");
				}
				else if(ac)
				{
					DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar(idA);
					setVisible(false);
					cit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(DesignAutentificareBibliotecar.this,
                            "Parola incorecta",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
					id.setText("");
					parola.setText("");
				}
			}
		};
		
		LOGIN.addActionListener(actLOGIN);
		  setLayout(new GridBagLayout());

	       
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.CENTER;
	        add(panelLoginCititor, gbc);
        this.add(panelLoginCititor);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
