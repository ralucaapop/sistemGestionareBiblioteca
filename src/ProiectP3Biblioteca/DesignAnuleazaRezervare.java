package ProiectP3Biblioteca;

import java.awt.FlowLayout;
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

public class DesignAnuleazaRezervare extends JFrame {

	JList<AfisareRezervari> elementList = null;
	JLabel label;
	JLabel alegeId;
	
	JTextField id;
	JButton selecteaza;
	
	public DesignAnuleazaRezervare(Cititor cititor) {
		
		JPanel panelAlegeRezervare = new JPanel();
		panelAlegeRezervare.setLayout(new BoxLayout(panelAlegeRezervare, BoxLayout.Y_AXIS));
		this.setSize(650, 500);
		this.setTitle("Alege rezervare");
		
		DefaultListModel<AfisareRezervari> listModel;
		
		label = new JLabel("ID EXEMPLAR TITLU AUTOR");
	    alegeId = new JLabel("Alege id-ul exemplarului pentru care doresti sa anuleri rezervarea");
		id=new JTextField(20);
		
	    selecteaza=new JButton("Selecteaza");
	    
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
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panelAlegeRezervare);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
