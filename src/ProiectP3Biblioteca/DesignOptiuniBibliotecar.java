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

public class DesignOptiuniBibliotecar extends JFrame {

	JLabel etichetaTitlu;
	 
	JButton adaugaCarte;
	JButton adaugaExemplar;
	JButton adaugaCititor;
	JButton realizeazaImprumut;
	JButton realizeazaRetur;
	JButton revizuitesteRezervari;
	JButton exit;
	
	public DesignOptiuniBibliotecar() {
		
	JPanel panelOptiuniCititor = new JPanel();
	panelOptiuniCititor.setLayout(new BoxLayout(panelOptiuniCititor, BoxLayout.Y_AXIS));
	
	this.setTitle("Optiuni Bibliotecar");
	this.setSize(650, 500);
	this.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	etichetaTitlu=new JLabel("ACTIUNI POSIBILE");
	
	adaugaCarte = new JButton("ADAUGA O CARTE NOUA IN BIBLIOTECA");
	adaugaExemplar = new JButton("ADAUGA UN NOU EXEMPLAR IN BIBLIOTECA");
	adaugaCititor = new JButton("INREGISTREAZA UN NOU CITITOR");
	realizeazaImprumut = new JButton("REALIZEAZA UN IMPRUMUT");
	realizeazaRetur = new JButton("REALIZEAZA UN RETUR");
	revizuitesteRezervari = new JButton("REVIZUIESTE REZERVARILE");
	exit = new JButton("Exit");
	
	etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);	
	
	Color maroonColor = new Color(128, 0, 0);
	Color whiteColor = new Color(248, 250, 229);
	
	getContentPane().setBackground(whiteColor); 
	panelOptiuniCititor.setBackground(whiteColor);

    Color maroonColor1 = new Color(128, 0, 0);
    
    Color darkGreenColor = new Color(0, 100, 0);

    Font titleFont = new Font("Arial", Font.BOLD, 20);
    Font labelFont = new Font("Arial", Font.PLAIN, 14);
	
    etichetaTitlu.setFont(titleFont);
    etichetaTitlu.setForeground(maroonColor);
    
    adaugaCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
    adaugaExemplar.setAlignmentX(Component.CENTER_ALIGNMENT);
    adaugaCititor.setAlignmentX(Component.CENTER_ALIGNMENT);
    realizeazaImprumut.setAlignmentX(Component.CENTER_ALIGNMENT);
    realizeazaRetur.setAlignmentX(Component.CENTER_ALIGNMENT);
    revizuitesteRezervari.setAlignmentX(Component.CENTER_ALIGNMENT);
    exit.setAlignmentX(Component.CENTER_ALIGNMENT);

    adaugaCarte.setBackground(darkGreenColor);
    adaugaCarte.setForeground(whiteColor);
    adaugaExemplar.setBackground(darkGreenColor);
    adaugaExemplar.setForeground(whiteColor);
    adaugaCititor.setBackground(darkGreenColor);
    adaugaCititor.setForeground(whiteColor);
    realizeazaImprumut.setBackground(darkGreenColor);
    realizeazaImprumut.setForeground(whiteColor);
    realizeazaRetur.setBackground(darkGreenColor);
    realizeazaRetur.setForeground(whiteColor);
    revizuitesteRezervari.setBackground(darkGreenColor);
    revizuitesteRezervari.setForeground(whiteColor);
    exit.setBackground(darkGreenColor);
    exit.setForeground(whiteColor);
    
    adaugaCarte.setFocusPainted(false); 
    
    panelOptiuniCititor.add(etichetaTitlu);
	panelOptiuniCititor.add(adaugaCarte);
	panelOptiuniCititor.add(adaugaExemplar);
	panelOptiuniCititor.add(adaugaCititor);
	panelOptiuniCititor.add(realizeazaImprumut);
	panelOptiuniCititor.add(realizeazaRetur);
	panelOptiuniCititor.add(revizuitesteRezervari);
	panelOptiuniCititor.add(exit);
	
	
	ActionListener actAddEx = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignAdaugaExemplar cit = new DesignAdaugaExemplar();
			setVisible(false);
			cit.setVisible(true);
		}
	};

	ActionListener actAddCart = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignAdaugCarte cit = new DesignAdaugCarte();
			setVisible(false);
			cit.setVisible(true);
		}
	};

	ActionListener actAddCit = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignAdaugaCititor cit = new DesignAdaugaCititor();
			setVisible(false);
			cit.setVisible(true);
		}
	};

	ActionListener actRev = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignRevizuiesteRezervari cit = new DesignRevizuiesteRezervari();
			setVisible(false);
			cit.setVisible(true);
		}
	};

	
	ActionListener actE = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	
	ActionListener actRR = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignRealizeazaRetur cit = new DesignRealizeazaRetur();
			setVisible(false);
			cit.setVisible(true);
		}
	};
	
	ActionListener actRI = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			DesignRealizeazaImprumut cit = new DesignRealizeazaImprumut();
			setVisible(false);
			cit.setVisible(true);
		}
	};
	
	 setLayout(new GridBagLayout());

     
     GridBagConstraints gbc = new GridBagConstraints();
     gbc.gridx = 0;
     gbc.gridy = 0;
     gbc.fill = GridBagConstraints.CENTER;
     add(panelOptiuniCititor, gbc);

	
	exit.addActionListener(actE);
	adaugaCarte.addActionListener(actAddCart);
	adaugaCititor.addActionListener(actAddCit);
	adaugaExemplar.addActionListener(actAddEx);
	revizuitesteRezervari.addActionListener(actRev);
	realizeazaRetur.addActionListener(actRR);
	realizeazaImprumut.addActionListener(actRI);

	this.add(panelOptiuniCititor);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}
	
}

