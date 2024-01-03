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
import javax.swing.JTextField;

public class DesignAlegeCarteRetur extends JFrame{

	JList<AfisareImprumutri> elementList = null;
	JLabel label;
	JLabel alegeId;
	
	JTextField id;
	JButton selecteaza;
	
	public DesignAlegeCarteRetur(String cnp) {
		
		JPanel panelAlegeRetur = new JPanel();
		panelAlegeRetur.setLayout(new BoxLayout(panelAlegeRetur, BoxLayout.Y_AXIS));
		
		this.setSize(650, 500);
		this.setTitle("Alege retur");
		
		DefaultListModel<AfisareImprumutri> listModel;
		
		label = new JLabel("ID EXEMPLAR TITLU AUTOR");
	    alegeId = new JLabel("Alege id-ul exemplarului pentru care doresti sa il returnezi");
		id=new JTextField(20);
		
	    selecteaza=new JButton("Selecteaza");
	    
		listModel = new DefaultListModel<>();
		
		List<AfisareImprumutri> imprumutri=FunctiiBibliotecar.gasesteImprumuturileCititorului(cnp);
       
		for(AfisareImprumutri c: imprumutri)
        	listModel.addElement(c);
      
        elementList = new JList<>(listModel);
        
		panelAlegeRetur.add(label);
		panelAlegeRetur.add(elementList);
		panelAlegeRetur.add(alegeId);
		panelAlegeRetur.add(id);
		panelAlegeRetur.add(selecteaza);
		
		ActionListener actRez = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean idExemplarCorect=FunctiiBibliotecar.verificaIdExemplarAlesPtRetur(imprumutri,Integer.parseInt(id.getText()));
				if(idExemplarCorect==false)
				{
					JOptionPane.showMessageDialog(DesignAlegeCarteRetur.this,
                            "ID-ul nu este corect.Incearca iar",
                            "EROARE ID INVALID",
                            JOptionPane.ERROR_MESSAGE);
							id.setText("");
				}
				else {
				FunctiiBibliotecar.realizeazaRetur(cnp, Integer.parseInt(id.getText()));
				JOptionPane.showMessageDialog(DesignAlegeCarteRetur.this,
                        "Retur realizat cu succes",
                        "RETUR REALIZAT CU SUCCES",
                        JOptionPane.INFORMATION_MESSAGE);
				}
				DesignOptiuniBibliotecar cit = new DesignOptiuniBibliotecar();
				setVisible(false);
				cit.setVisible(true);
			}
		};
		
		selecteaza.addActionListener(actRez);
		this.setTitle("Realizeaza Retur");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panelAlegeRetur);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
}
