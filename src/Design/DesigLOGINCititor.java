package Design;

import java.awt.Color;
import java.awt.Component;
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

import ProiectP3Biblioteca.Cititor;
import Utilitar.Functii;

public class DesigLOGINCititor extends JFrame {

	JLabel etichetaTitlu1;
	JLabel etichetaCNP;
	JLabel etichetaParola;
	JTextField cnp;
	JTextField parola;
	JButton LOGIN;
	
	public DesigLOGINCititor() {
		
	       // Create a panel with BoxLayout
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

        etichetaTitlu1 = new JLabel("INTRA IN CONTUL TAU");
        etichetaTitlu1.setFont(titleFont);
        etichetaTitlu1.setForeground(maroonColor);
        etichetaTitlu1.setAlignmentX(Component.CENTER_ALIGNMENT);


        etichetaCNP = new JLabel("Introdu CNP-UL");
        etichetaCNP.setPreferredSize(new Dimension(120, 20));
        etichetaCNP.setFont(labelFont);
        etichetaCNP.setForeground(darkGreenColor);
        etichetaCNP.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        etichetaParola = new JLabel("Introdu Parola");
        etichetaParola.setPreferredSize(new Dimension(120, 20));
        etichetaParola.setFont(labelFont);
        etichetaParola.setForeground(darkGreenColor);
        etichetaParola.setAlignmentX(Component.CENTER_ALIGNMENT);


        LOGIN = new JButton("LOGIN");
        LOGIN.setBackground(maroonColor);
        LOGIN.setForeground(whiteColor);
        LOGIN.setAlignmentX(Component.CENTER_ALIGNMENT);


        cnp = new JTextField(13);
        parola = new JTextField(20);

        
        panelLoginCititor.add(etichetaTitlu1);
        panelLoginCititor.add(etichetaCNP);
        panelLoginCititor.add(cnp);
        panelLoginCititor.add(etichetaParola);
        panelLoginCititor.add(parola);
        panelLoginCititor.add(LOGIN);

       
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(panelLoginCititor, gbc);

        
        this.setTitle("OptiuniCititor");
        this.setSize(650, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
		
		
		ActionListener actLOGIN = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cnpCititor=cnp.getText();
				String parolaCititor = parola.getText();
				boolean ac=Functii.verificaAutentificare(cnpCititor, parolaCititor);
				boolean cnpV=Functii.verificaCNPAuth(cnpCititor);
				
				if(cnpV==false)
				{
					JOptionPane.showMessageDialog(DesigLOGINCititor.this,
                            "CNP INVALID",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
						cnp.setText("");
						parola.setText("");
				}
				else if(ac)
				{
					Cititor cititor = new Cititor(cnpCititor, parolaCititor);
					DesignOptiuniCititor cit = new DesignOptiuniCititor(cititor);
					setVisible(false);
					cit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(DesigLOGINCititor.this,
                            "Parola incorecta",
                            "EROARE AUTENTIFICARE",
                            JOptionPane.ERROR_MESSAGE);
					cnp.setText("");
					parola.setText("");
				}
			}
		};
		
		LOGIN.addActionListener(actLOGIN);
		LOGIN.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(panelLoginCititor);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
