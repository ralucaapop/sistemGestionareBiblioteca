package Design;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class DesignMain extends JFrame {

	JLabel etichetaTitlu;
	
	
	JButton cititor;
	JButton bibliotecar;
	JButton exit;
	
	
	
	public DesignMain() {
		
		
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		panelMain.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		Component spatiuIntreComponente = Box.createVerticalStrut(20); 
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
        panelMain.setBackground(whiteColor);
 
		this.setTitle("Main");
		this.setSize(650, 500);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
        Font titleFont = new Font("Arial", Font.BOLD, 20);

		etichetaTitlu=new JLabel("ALEGE ROLUL TAU");
		etichetaTitlu.setFont(titleFont);
        etichetaTitlu.setForeground(maroonColor);
        etichetaTitlu.setAlignmentX(CENTER_ALIGNMENT);
		
		Font fontTitlu = new Font(etichetaTitlu.getFont().getName(), Font.TRUETYPE_FONT, 30);

       


		cititor = new JButton("Cititor");
		bibliotecar = new JButton("Bibliotecar");
		exit = new JButton("Exit");
		
        stylizeButton(cititor);
        stylizeButton(bibliotecar);
        stylizeButton(exit);


		panelMain.add(etichetaTitlu);
		//panelMain.add(spatiuIntreComponente);
		panelMain.add(cititor);
		//panelMain.add(spatiuIntreComponente);
		panelMain.add(bibliotecar);
		//panelMain.add(spatiuIntreComponente);
		panelMain.add(exit);
		
		 
	
		ActionListener actC = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesigLOGINCititor cit = new DesigLOGINCititor();
				setVisible(false);
				cit.setVisible(true);
			}
		};
		
		ActionListener actB = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DesignAlegeriBibliotecar1 cit = new DesignAlegeriBibliotecar1();
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
		
		cititor.addActionListener(actC);
		bibliotecar.addActionListener(actB);
		exit.addActionListener(actE);
		
        cititor.setMargin(new Insets(15,45,15,46));
        bibliotecar.setMargin(new Insets(15,35,15,23));
        exit.setMargin(new Insets(15,55,15,55));


		this.setLocationRelativeTo(null);
		
		
		this.add(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setLayout(new GridBagLayout()); 
	     GridBagConstraints gbc = new GridBagConstraints();
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.fill = GridBagConstraints.CENTER;
	     add(panelMain, gbc);
	
	}
	private void stylizeButton(JButton button) {
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 100, 0));
        button.setFocusPainted(false); // Remove focus border
        button.setFont(new Font(button.getFont().getName(), Font.BOLD, 16));
        button.setAlignmentX(CENTER_ALIGNMENT);

    }
}
