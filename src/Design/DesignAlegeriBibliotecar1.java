package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DesignAlegeriBibliotecar1 extends JFrame{

	JLabel etichetaTitlu;
	
	JButton autentificare;
	JButton exit;
	
	public DesignAlegeriBibliotecar1() {
		
		JPanel panelAlegereBibliotecar = new JPanel();
		panelAlegereBibliotecar.setLayout(new BoxLayout(panelAlegereBibliotecar, BoxLayout.Y_AXIS));
		
		
		this.setTitle("Alegere bibliotecar");
		this.setSize(650, 500);
		
		  
        Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		panelAlegereBibliotecar.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);

		
		etichetaTitlu=new JLabel("ALEGE OPTIUNEA DORITA");
		etichetaTitlu.setFont(titleFont);
	    etichetaTitlu.setForeground(maroonColor);
	    etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);

	    
		autentificare = new JButton("INTRA IN CONT");
		exit = new JButton("Exit");
		
		autentificare.setBackground(darkGreenColor);
		autentificare.setForeground(whiteColor);
		
		exit.setBackground(darkGreenColor);
		exit.setForeground(whiteColor);
		
		autentificare.setFocusPainted(false); 

		
		etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);
		autentificare.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panelAlegereBibliotecar.add(etichetaTitlu);
		panelAlegereBibliotecar.add(autentificare);
		
		panelAlegereBibliotecar.add(exit);
		
		
		ActionListener actA = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignAutentificareBibliotecar d = new DesignAutentificareBibliotecar();
				setVisible(false);
				d.setVisible(true);
			}
		};
		
		
		
		ActionListener actE = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		autentificare.addActionListener(actA);
		exit.addActionListener(actE);
		setLayout(new GridBagLayout());

	       
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(panelAlegereBibliotecar, gbc);
        
		this.add(panelAlegereBibliotecar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
	}
	
	
}
