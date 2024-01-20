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
import javax.swing.JTextField;

import ProiectP3Biblioteca.Cititor;
import Utilitar.AfisareRezervari;
import Utilitar.Functii;

public class DesignAnuleazaRezervare extends JFrame {

	JList<AfisareRezervari> elementList = null;
	JLabel label;
	JLabel alegeId;
	
	JTextField id;
	JButton selecteaza;
	
	public DesignAnuleazaRezervare(Cititor cititor) {
		
		JPanel panelAlegeRezervare = new JPanel();
		panelAlegeRezervare.setLayout(new BoxLayout(panelAlegeRezervare, BoxLayout.Y_AXIS));
		 Color maroonColor = new Color(128, 0, 0);
			Color whiteColor = new Color(248, 250, 229);
			
			getContentPane().setBackground(whiteColor); 
			panelAlegeRezervare.setBackground(whiteColor);

	        Color maroonColor1 = new Color(128, 0, 0);
	        
	        Color darkGreenColor = new Color(0, 100, 0);

	        Font titleFont = new Font("Arial", Font.BOLD, 20);
	        Font labelFont = new Font("Arial", Font.PLAIN, 14);
	        
		this.setSize(650, 500);
		this.setTitle("Alege rezervare");
		
		DefaultListModel<AfisareRezervari> listModel;
		
		label = new JLabel("ID EXEMPLAR TITLU AUTOR");
		label.setFont(titleFont);
		label.setForeground(maroonColor);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	    alegeId = new JLabel("Alege id-ul exemplarului pentru care doresti sa anuleri rezervarea");
	    alegeId.setFont(labelFont);
	    alegeId.setForeground(maroonColor);
	    alegeId.setAlignmentX(Component.CENTER_ALIGNMENT);
		id=new JTextField(20);
		
	    selecteaza=new JButton("Selecteaza");
	    selecteaza.setAlignmentX(Component.CENTER_ALIGNMENT);
	    selecteaza.setBackground(darkGreenColor);
	    selecteaza.setForeground(whiteColor);
			
	    
		listModel = new DefaultListModel<>();
		
		List<AfisareRezervari> rezervari=Functii.gasesteRezervarileCititorului(cititor);
       
		for(AfisareRezervari c: rezervari)
        	listModel.addElement(c);
      
        elementList = new JList<>(listModel);
        
		panelAlegeRezervare.add(label);
		panelAlegeRezervare.add(elementList);
		panelAlegeRezervare.add(alegeId);
		panelAlegeRezervare.add(id);
		panelAlegeRezervare.add(selecteaza);
		
		ActionListener actRez = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean idExemplarCorect=Functii.verificaIdExemplarAles(rezervari,Integer.parseInt(id.getText()));
				if(idExemplarCorect==false)
				{
					JOptionPane.showMessageDialog(DesignAnuleazaRezervare.this,
                            "ID-ul nu este corect.Incearca iar",
                            "EROARE ID INVALID",
                            JOptionPane.ERROR_MESSAGE);
							id.setText("");
				}
				else {
				Functii.anuleazaRezervare(cititor, Integer.parseInt(id.getText()));
				JOptionPane.showMessageDialog(DesignAnuleazaRezervare.this,
                        "Rezervare anulata cu succes",
                        "REZERVARE ANULATA CU SUCCES",
                        JOptionPane.INFORMATION_MESSAGE);
				}
				DesignOptiuniCititor cit = new DesignOptiuniCititor(cititor);
				setVisible(false);
				cit.setVisible(true);
			}
		};
		
		selecteaza.addActionListener(actRez);
		this.setTitle("Anuleaza Rezervare");
		setLayout(new GridBagLayout()); 
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(panelAlegeRezervare, gbc);
		this.add(panelAlegeRezervare);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
