package ProiectP3Biblioteca;

import java.awt.FlowLayout;
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
	
	etichetaTitlu.setHorizontalAlignment(SwingUtilities.RIGHT);
	
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

