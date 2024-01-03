package ProiectP3Biblioteca;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DesignOptiuniCititor extends JFrame{

	JLabel etichetaTitlu;
	 
	JButton faRezervare;
	JButton anuleazaRezervare;
	JButton exit;
	
	public DesignOptiuniCititor(Cititor cititor) {
		
		JPanel panelOptiuniCititor = new JPanel();
		panelOptiuniCititor.setLayout(new BoxLayout(panelOptiuniCititor, BoxLayout.Y_AXIS));
		
		this.setTitle("Optiuni Cititor");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		panelOptiuniCititor.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
		
		etichetaTitlu=new JLabel("ACTIUNI POSIBILE");
		etichetaTitlu.setFont(titleFont);
	    etichetaTitlu.setForeground(maroonColor);
		
		faRezervare = new JButton("REZERVA O CARTE");
		anuleazaRezervare = new JButton("ANULEAZA O REZERVARE");
		exit = new JButton("Exit");
		faRezervare.setFocusPainted(false);
		
		
		panelOptiuniCititor.add(etichetaTitlu);
		panelOptiuniCititor.add(faRezervare);
		panelOptiuniCititor.add(anuleazaRezervare);
		panelOptiuniCititor.add(exit);
		
		etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);
		faRezervare.setAlignmentX(Component.CENTER_ALIGNMENT);
		anuleazaRezervare.setAlignmentX(Component.CENTER_ALIGNMENT);
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);

		faRezervare.setBackground(darkGreenColor);
		faRezervare.setForeground(whiteColor);
		anuleazaRezervare.setBackground(darkGreenColor);
		anuleazaRezervare.setForeground(whiteColor);

		exit.setBackground(darkGreenColor);
		exit.setForeground(whiteColor);


		
		ActionListener actE = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		ActionListener actR = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignFaRezervare cit = new DesignFaRezervare(cititor);
				setVisible(false);
				cit.setVisible(true);
			}
		};
		ActionListener actAR = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignAnuleazaRezervare cit = new DesignAnuleazaRezervare(cititor);
				setVisible(false);
				cit.setVisible(true);
			}
		};
		
		exit.addActionListener(actE);
		faRezervare.addActionListener(actR);
		anuleazaRezervare.addActionListener(actAR);
		
		 setLayout(new GridBagLayout());

	       
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.fill = GridBagConstraints.CENTER;
	        add(panelOptiuniCititor, gbc);

		
		this.add(panelOptiuniCititor);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
