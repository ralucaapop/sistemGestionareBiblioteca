package ProiectP3Biblioteca;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesignAdaugCarte extends JFrame{

	JLabel titluPg;
	JLabel idCarte;
	JLabel titluCarte;
	JLabel genCarte;
	JLabel nrZileImpCarte;
	JLabel autorCarte;
	
	JTextField id;
	JTextField titlu;
	JTextField gen;
	JTextField autor;
	JTextField nrZile;
	
	JButton adauga;
	
	public DesignAdaugCarte() {
	
	JPanel panelAdaugaCarte = new JPanel();
	panelAdaugaCarte.setLayout(new BoxLayout(panelAdaugaCarte, BoxLayout.Y_AXIS));
	
	this.setTitle("Adauga carte noua in biblioteca");
	this.setSize(650, 500);
	Color maroonColor = new Color(128, 0, 0);
	Color whiteColor = new Color(248, 250, 229);
	
	getContentPane().setBackground(whiteColor); 
	panelAdaugaCarte.setBackground(whiteColor);

    Color maroonColor1 = new Color(128, 0, 0);
    
    Color darkGreenColor = new Color(0, 100, 0);

    Font titleFont = new Font("Arial", Font.BOLD, 20);
    Font labelFont = new Font("Arial", Font.PLAIN, 14);
	
   
	titluPg = new JLabel("Adauga o carte noua in biblioteca");
	
	 titluPg.setFont(titleFont);
	 titluPg.setForeground(maroonColor);
		
	
	idCarte=new JLabel("ID-ul cartii");
	idCarte.setPreferredSize(new Dimension(120, 20));
	idCarte.setFont(labelFont);
	idCarte.setAlignmentX(Component.CENTER_ALIGNMENT);
	idCarte.setForeground(darkGreenColor);
	
	titluCarte=new JLabel("Titlu cartii");
	titluCarte.setPreferredSize(new Dimension(120, 20));
	titluCarte.setFont(labelFont);
	titluCarte.setForeground(darkGreenColor);
	titluCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

	autorCarte = new JLabel("Autorul cartii");
	autorCarte.setPreferredSize(new Dimension(120, 20));
	 autorCarte.setFont(labelFont);
	 autorCarte.setForeground(darkGreenColor);
	 autorCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

	genCarte = new JLabel("Genul Cartii");
	genCarte.setPreferredSize(new Dimension(120, 20));
	genCarte.setFont(labelFont);
	genCarte.setForeground(darkGreenColor);
	genCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

	nrZileImpCarte= new JLabel("Numarul de zile de imprumut al cartii");
	nrZileImpCarte.setFont(labelFont);
	nrZileImpCarte.setForeground(darkGreenColor);
	nrZileImpCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

	
	id = new JTextField(20);
	titlu = new JTextField(20);
	gen = new JTextField(20);
	autor = new JTextField(20);
	nrZile= new JTextField(20);
	
	adauga = new JButton("AGAUGA O NOUA CARTE");
	
	panelAdaugaCarte.add(idCarte);
	panelAdaugaCarte.add(id);
	panelAdaugaCarte.add(titluCarte);
	panelAdaugaCarte.add(titlu);
	panelAdaugaCarte.add(genCarte);
	panelAdaugaCarte.add(gen);
	panelAdaugaCarte.add(autorCarte);
	panelAdaugaCarte.add(autor);
	panelAdaugaCarte.add(nrZileImpCarte);
	panelAdaugaCarte.add(nrZile);

	panelAdaugaCarte.add(adauga);
	
	ActionListener actAdd = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int idCar=Integer.parseInt(id.getText());
			
			boolean ac=FunctiiBibliotecar.verificaIdCarte(idCar);
			
			if(ac==false)
			{
				JOptionPane.showMessageDialog(DesignAdaugCarte.this,
                        "ID INVALID",
                        "EROARE ADAUGARE CARTEs",
                        JOptionPane.ERROR_MESSAGE);
					id.setText("");
			}
			else if(ac)
			{
				FunctiiBibliotecar.adaugaCarteNoua(idCar, titlu.getText(), autor.getText(), gen.getText(), Integer.parseInt(nrZile.getText()));
				JOptionPane.showMessageDialog(DesignAdaugCarte.this,
                        "Carte adaugata cu succes",
                        "Carte adaugata",
                        JOptionPane.INFORMATION_MESSAGE);
					id.setText("");
				DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
				setVisible(false);
				cit.setVisible(true);
			}
			
		}
	};
	
	setLayout(new GridBagLayout()); 
     GridBagConstraints gbc = new GridBagConstraints();
     gbc.gridx = 0;
     gbc.gridy = 0;
     gbc.fill = GridBagConstraints.CENTER;
     add(panelAdaugaCarte, gbc);

    adauga.setAlignmentX(Component.CENTER_ALIGNMENT);
    adauga.setBackground(maroonColor);
    adauga.setForeground(whiteColor);

	adauga.addActionListener(actAdd);
	this.add(panelAdaugaCarte);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);

	}
}
