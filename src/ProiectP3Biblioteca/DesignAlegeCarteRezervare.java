package ProiectP3Biblioteca;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class DesignAlegeCarteRezervare extends JFrame {

	
	JList<Carte> elementList = null;
	JLabel label;
	JLabel alegeId;
	
	JTextField id;
	JButton rezerva;
	
	public DesignAlegeCarteRezervare(List<Carte> carti, Cititor cititor) {
		
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
		this.setTitle("Alege carte pt rezervare");
		
		DefaultListModel<Carte> listModel;
		
		label = new JLabel("ID CARTE TITLU AUTOR");
		label.setFont(titleFont);
		label.setForeground(maroonColor);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	    alegeId = new JLabel("Alege id-ul cartii pe care doresti sa o rezervi");
	    alegeId.setFont(labelFont);
	    alegeId.setForeground(maroonColor);
	    alegeId.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
		id=new JTextField(20);
	    rezerva=new JButton("Rezerva");
	    
		listModel = new DefaultListModel<>();

        for(Carte c: carti)
        	listModel.addElement(c);
      
        elementList = new JList<>(listModel);
        
		panelAlegeRezervare.add(label);
		panelAlegeRezervare.add(elementList);
		panelAlegeRezervare.add(alegeId);
		panelAlegeRezervare.add(id);
		panelAlegeRezervare.add(rezerva);
		
		ActionListener actRez = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean idCarteCorect=Functii.verificaIdCarteAles(carti,Integer.parseInt(id.getText()));
				if(idCarteCorect==false)
				{
					JOptionPane.showMessageDialog(DesignAlegeCarteRezervare.this,
                            "ID-ul nu este corect sau nu exista exemplare disponibile pentru aceasta carte.",
                            "EROARE ID INVALID",
                            JOptionPane.ERROR_MESSAGE);
							id.setText("");
				}
				else {
				int idExemplar=Functii.alegeIdExemplarPtRezervare(Integer.parseInt(id.getText()));
				Functii.realizeazaRezervare(cititor, Integer.parseInt(id.getText()), idExemplar);
				JOptionPane.showMessageDialog(DesignAlegeCarteRezervare.this,
                        "Rezervare efectuata cu succes",
                        "REZERVARE EFECTUATA CU SUCCES",
                        JOptionPane.INFORMATION_MESSAGE);
				}
				DesignOptiuniCititor cit = new DesignOptiuniCititor(cititor);
				setVisible(false);
				cit.setVisible(true);
			}
		};
		
		rezerva.addActionListener(actRez);
		rezerva.setAlignmentX(Component.CENTER_ALIGNMENT);
		rezerva.setBackground(darkGreenColor);
		rezerva.setForeground(whiteColor);
			
		this.setTitle("Optiuni Cititor");
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
