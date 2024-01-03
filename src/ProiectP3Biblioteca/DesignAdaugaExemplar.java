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

public class DesignAdaugaExemplar extends JFrame{
	
	JLabel titluPg;
	JLabel idCarte;
	JLabel idExemplar;
	
	JTextField idC;
	JTextField idE;

	JButton adauga;
	
	public DesignAdaugaExemplar(){
		
		JPanel panelAdaugaExemplar = new JPanel();
		panelAdaugaExemplar.setLayout(new BoxLayout(panelAdaugaExemplar, BoxLayout.Y_AXIS));
		
		this.setTitle("Adauga un exemplar nou in biblioteca");
		this.setSize(650, 500);
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
		
		getContentPane().setBackground(whiteColor); 
		panelAdaugaExemplar.setBackground(whiteColor);

        Color maroonColor1 = new Color(128, 0, 0);
        
        Color darkGreenColor = new Color(0, 100, 0);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        
		titluPg = new JLabel("Adauga un exemplar nou in biblioteca");
		titluPg.setFont(titleFont);
		titluPg.setForeground(maroonColor);
		titluPg.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		idCarte=new JLabel("ID-ul cartii");
		idCarte.setPreferredSize(new Dimension(120, 20));
		idCarte.setFont(labelFont);
        idCarte.setForeground(darkGreenColor);
		idCarte.setAlignmentX(Component.CENTER_ALIGNMENT);

		idExemplar=new JLabel("ID-ul exemplarului");
		idExemplar.setPreferredSize(new Dimension(120, 20));
		idExemplar.setFont(labelFont);
		idExemplar.setForeground(darkGreenColor);
		idExemplar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		idC = new JTextField(20);
		idE = new JTextField(20);
		
		
		adauga = new JButton("AGAUGA UN NOU EXEMPLAR");
		adauga.setBackground(darkGreenColor);
		adauga.setForeground(whiteColor);
		adauga.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		panelAdaugaExemplar.add(titluPg);
		panelAdaugaExemplar.add(idCarte);
		panelAdaugaExemplar.add(idC);
		panelAdaugaExemplar.add(idExemplar);
		panelAdaugaExemplar.add(idE);
		panelAdaugaExemplar.add(adauga);


	
		ActionListener actAdd = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int idCart=Integer.parseInt(idC.getText());
				int idEx=Integer.parseInt(idE.getText());
				
				boolean idCV=FunctiiBibliotecar.verificaIdCartePtExemplar(idCart);
				boolean idEV=FunctiiBibliotecar.verificaIdExemplar(idEx);
				
				if(idEV==false)
				{
					JOptionPane.showMessageDialog(DesignAdaugaExemplar.this,
	                        "ID EXEMPLAR INVALID",
	                        "EROARE ADAUGARE EXEMPLAR",
	                        JOptionPane.ERROR_MESSAGE);
						idC.setText("");
						idE.setText("");

				}
				else if(idCV==false)
				{
					JOptionPane.showMessageDialog(DesignAdaugaExemplar.this,
	                        "ID CARTE INVALID",
	                        "EROARE ADAUGARE EXEMPLAR",
	                        JOptionPane.ERROR_MESSAGE);
						idC.setText("");
						idE.setText("");
				}
				else
				{
					FunctiiBibliotecar.adaugaExemplarNou(idEx,idCart);
					JOptionPane.showMessageDialog(DesignAdaugaExemplar.this,
	                        "Exemplar adaugat cu succes",
	                        "Exemplar adaugat cu succes",
	                        JOptionPane.INFORMATION_MESSAGE);
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
	        add(panelAdaugaExemplar, gbc);
		adauga.addActionListener(actAdd);
		this.add(panelAdaugaExemplar);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
