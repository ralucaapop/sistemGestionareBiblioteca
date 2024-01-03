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
		
		etichetaTitlu=new JLabel("ACTIUNI POSIBILE");
		
		faRezervare = new JButton("REZERVA O CARTE");
		anuleazaRezervare = new JButton("ANULEAZA O REZERVARE");
		exit = new JButton("Exit");
		
		etichetaTitlu.setHorizontalAlignment(SwingUtilities.RIGHT);
		
		panelOptiuniCititor.add(faRezervare);
		panelOptiuniCititor.add(anuleazaRezervare);
		panelOptiuniCititor.add(exit);
		
		
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
		
		this.add(panelOptiuniCititor);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
