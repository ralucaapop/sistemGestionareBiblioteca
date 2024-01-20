package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ProiectP3Biblioteca.Carte;
import ProiectP3Biblioteca.Cititor;
import Utilitar.Functii;

public class DesignFaRezervare extends JFrame{

	JLabel etichetaTitlu;
	JLabel etichetaAtentionare;
	
	JLabel titluCarte;
	JLabel autorCarte;
	
	JTextField autor;
	JTextField titlu;

	JButton cautaCarte;
	
	public DesignFaRezervare(Cititor cititor) {
		JPanel panelFaRezervare = new JPanel();
		panelFaRezervare.setLayout(new BoxLayout(panelFaRezervare, BoxLayout.Y_AXIS));
		
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
			
		getContentPane().setBackground(whiteColor); 
		panelFaRezervare.setBackground(whiteColor);

	    Color maroonColor1 = new Color(128, 0, 0);
	        
	    Color darkGreenColor = new Color(0, 100, 0);

	        Font titleFont = new Font("Arial", Font.BOLD, 20);
	        Font labelFont = new Font("Arial", Font.PLAIN, 14);
		
		this.setTitle("Optiuni Cititor");
		this.setSize(650, 500);
		
		etichetaTitlu=new JLabel("REZERVA O CARTE");
		etichetaTitlu.setFont(titleFont);
	    etichetaTitlu.setForeground(maroonColor);
	    etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
		etichetaAtentionare = new JLabel("ATENTIE, REZERVARILE SUNT DISPONIBILE TIMP DE DOUA ZILE!!");
		etichetaAtentionare.setFont(labelFont);
		etichetaAtentionare.setForeground( maroonColor1);
		etichetaAtentionare.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		titluCarte=new JLabel("Titlul cartii:");
		titluCarte.setFont(labelFont);
		titluCarte.setForeground(darkGreenColor);
		titluCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		autorCarte=new JLabel("Autor carte:");
		autorCarte.setFont(labelFont);
		autorCarte.setForeground(darkGreenColor);
		autorCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		autor = new JTextField(20);
		titlu = new JTextField(20);

		cautaCarte= new JButton("CAUTA CARTEA DORITA");
		
		panelFaRezervare.add(etichetaTitlu);
		panelFaRezervare.add(etichetaAtentionare);
		panelFaRezervare.add(titluCarte);
		panelFaRezervare.add(titlu);
		panelFaRezervare.add(autorCarte);
		panelFaRezervare.add(autor);
		panelFaRezervare.add(cautaCarte);
		
		

		ActionListener actC = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carte>carti;
				carti=Functii.returneazaCartea(titlu.getText(), autor.getText());
				if(carti.size()==0)
				{
					JOptionPane.showMessageDialog(DesignFaRezervare.this,
                            "ACEASTA CARETE NU ESTE DISPONIBILA, ASIGURATI-VA CA ATI INTRODUS CORECT TITLUL SI AUTORUL",
                            "CARTEA NU E DISPONIBILA",
                            JOptionPane.ERROR_MESSAGE);
						titlu.setText("");
						autor.setText("");
				}
				else {
					DesignAlegeCarteRezervare cit = new DesignAlegeCarteRezervare(carti, cititor);
					setVisible(false);
					cit.setVisible(true);
				}
			}
		};
		cautaCarte.setBackground(darkGreenColor);
		cautaCarte.setForeground(whiteColor);
		cautaCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

		setLayout(new GridBagLayout());
	     GridBagConstraints gbc = new GridBagConstraints();
	     gbc.gridx = 0;
	     gbc.gridy = 0;
	     gbc.fill = GridBagConstraints.CENTER;
	     add(panelFaRezervare, gbc);
	     
		cautaCarte.addActionListener(actC);
		this.add(panelFaRezervare);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
