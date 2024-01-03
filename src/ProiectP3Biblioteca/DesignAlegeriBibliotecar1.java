package ProiectP3Biblioteca;

import java.awt.FlowLayout;
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
	JButton inregistrare;
	JButton exit;
	
	public DesignAlegeriBibliotecar1() {
		
		JPanel panelAlegereBibliotecar = new JPanel();
		panelAlegereBibliotecar.setLayout(new BoxLayout(panelAlegereBibliotecar, BoxLayout.Y_AXIS));
		
		
		this.setTitle("Alegere bibliotecar");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		etichetaTitlu=new JLabel("ALEGE OPTIUNEA DORITA");
		
		autentificare = new JButton("INTRA IN CONT");
		inregistrare= new JButton("CREEAZA UN CONT NOU");
		exit = new JButton("Exit");
		
		etichetaTitlu.setHorizontalAlignment(SwingUtilities.RIGHT);
		

		
		panelAlegereBibliotecar.add(etichetaTitlu);
		panelAlegereBibliotecar.add(autentificare);
		panelAlegereBibliotecar.add(inregistrare);
		panelAlegereBibliotecar.add(exit);
		
		
		ActionListener actA = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignAutentificareBibliotecar d = new DesignAutentificareBibliotecar();
				setVisible(false);
				d.setVisible(true);
			}
		};
		
		ActionListener actI = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignCreareContBibliotecar d= new DesignCreareContBibliotecar();
			}
		};
		
		ActionListener actE = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		
		autentificare.addActionListener(actA);
		inregistrare.addActionListener(actI);
		exit.addActionListener(actE);
					
		this.add(panelAlegereBibliotecar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	
	}
	
	
}
