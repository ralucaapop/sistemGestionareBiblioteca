package Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ProiectP3Biblioteca.Carte;
import Utilitar.Functii;

public class DesignRealizeazaImprumut extends JFrame{
	
	JLabel etichetaTitlu;
	JLabel etichetaAtentionare;
	
	JLabel titluCarte;
	JLabel autorCarte;
	
	JTextField autor;
	JTextField titlu;

	JButton cautaCarte;
	
	public DesignRealizeazaImprumut(){
		
		JPanel panelRezlizeazaImprumut = new JPanel();
		panelRezlizeazaImprumut.setLayout(new BoxLayout(panelRezlizeazaImprumut, BoxLayout.Y_AXIS));
		  
        Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		panelRezlizeazaImprumut.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);

		
		
		this.setTitle("Imprumuta o carte");
		this.setSize(650, 500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		etichetaTitlu=new JLabel("Imprumuta O CARTE");
		etichetaTitlu.setFont(titleFont);
	    etichetaTitlu.setForeground(maroonColor);
	    etichetaTitlu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		titluCarte=new JLabel("Titlul cartii:");
		titluCarte.setPreferredSize(new Dimension(120, 20));
		titluCarte.setFont(labelFont);
		titluCarte.setForeground(darkGreenColor);
		titluCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

		autorCarte=new JLabel("Autor carte:");
		autorCarte.setPreferredSize(new Dimension(120, 20));
		autorCarte.setFont(labelFont);
		autorCarte.setForeground(darkGreenColor);
		autorCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		autor = new JTextField(20);
		titlu = new JTextField(20);

		cautaCarte= new JButton("CAUTA CARTEA DORITA");
		cautaCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
		cautaCarte.setBackground(darkGreenColor);
		cautaCarte.setForeground(whiteColor);
		
		panelRezlizeazaImprumut.add(etichetaTitlu);
		panelRezlizeazaImprumut.add(titluCarte);
		panelRezlizeazaImprumut.add(titlu);
		panelRezlizeazaImprumut.add(autorCarte);
		panelRezlizeazaImprumut.add(autor);
		panelRezlizeazaImprumut.add(cautaCarte);
		
		ActionListener actC = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Carte>carti;
				carti=Functii.returneazaCartea(titlu.getText(), autor.getText());
				if(carti.size()==0)
				{
					JOptionPane.showMessageDialog(DesignRealizeazaImprumut.this,
                            "ACEASTA CARETE NU ESTE DISPONIBILA, ASIGURATI-VA CA ATI INTRODUS CORECT TITLUL SI AUTORUL",
                            "CARTEA NU E DISPONIBILA",
                            JOptionPane.ERROR_MESSAGE);
						titlu.setText("");
						autor.setText("");
				}
				else {
					DesignAlegeCarteImprumut d = new DesignAlegeCarteImprumut(carti);
					setVisible(false);
					d.setVisible(true);
				}
			}
		};

		setLayout(new GridBagLayout()); 
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(panelRezlizeazaImprumut, gbc);
        
		cautaCarte.addActionListener(actC);
		this.add(panelRezlizeazaImprumut);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
}
