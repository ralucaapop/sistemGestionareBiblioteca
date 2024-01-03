package ProiectP3Biblioteca;

import java.awt.FlowLayout;
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
		this.setSize(650, 500);
		this.setTitle("Alege carte pt rezervare");
		
		DefaultListModel<Carte> listModel;
		
		label = new JLabel("ID CARTE TITLU AUTOR");
	    alegeId = new JLabel("Alege id-ul cartii pe care doresti sa o rezervi");
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
		this.setTitle("Optiuni Cititor");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panelAlegeRezervare);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
