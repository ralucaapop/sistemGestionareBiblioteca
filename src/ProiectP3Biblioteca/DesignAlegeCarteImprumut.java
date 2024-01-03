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

public class DesignAlegeCarteImprumut extends JFrame{

	JList<Carte> elementList = null;
	JLabel label;
	JLabel alegeId;
	JLabel cnpCititor;
	
	JTextField id;
	JButton imprumuta;
	JTextField cnpC;
	
	DesignAlegeCarteImprumut(List<Carte> carti){
		
		JPanel panelAlegeImprumut = new JPanel();
		panelAlegeImprumut.setLayout(new BoxLayout(panelAlegeImprumut, BoxLayout.Y_AXIS));
		this.setSize(650, 500);
		this.setTitle("Alege carte pentru imprumut");
		
		DefaultListModel<Carte> listModel;
		
		label = new JLabel("ID CARTE TITLU AUTOR");
	    alegeId = new JLabel("Alege id-ul cartii pe care doresti sa o imprumuti");
		id=new JTextField(20);
	    imprumuta=new JButton("Imprumut");
	    
	    cnpCititor=new JLabel("CNP-ul cititorului care imprumuta cartea");
	    cnpC=new JTextField(20);
	    
		listModel = new DefaultListModel<>();

        for(Carte c: carti)
        	listModel.addElement(c);
      
        elementList = new JList<>(listModel);
        
		panelAlegeImprumut.add(label);
		panelAlegeImprumut.add(elementList);
		panelAlegeImprumut.add(alegeId);
		panelAlegeImprumut.add(id);
		panelAlegeImprumut.add(cnpCititor);
		panelAlegeImprumut.add(cnpC);
		panelAlegeImprumut.add(imprumuta);
		
		ActionListener actRez = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean idCarteCorect=Functii.verificaIdCarteAles(carti,Integer.parseInt(id.getText()));
				boolean cnpValid=FunctiiBibliotecar.verificaCnpPtImprumut(cnpC.getText());
				
				if(idCarteCorect==false)
				{
					JOptionPane.showMessageDialog(DesignAlegeCarteImprumut.this,
                            "ID-ul nu este corect sau nu exista exemplare disponibile pentru aceasta carte.",
                            "EROARE ID INVALID",
                            JOptionPane.ERROR_MESSAGE);
							id.setText("");
				}
				else if(cnpValid==false) {
					JOptionPane.showMessageDialog(DesignAlegeCarteImprumut.this,
                            "Acest CNP nu corespunde nici unui cititor",
                            "EROARE CNP INVALID",
                            JOptionPane.ERROR_MESSAGE);
							cnpC.setText("");
				}
				else {
				int idExemplar=FunctiiBibliotecar.alegeIdExemplarPtImprumut(Integer.parseInt(id.getText()));
				
				FunctiiBibliotecar.realizeazaImprumutP2(cnpC.getText(), Integer.parseInt(id.getText()),idExemplar);
				JOptionPane.showMessageDialog(DesignAlegeCarteImprumut.this,
                        "Imprumut efectuat cu succes",
                        "IMPRUMUT EFECTUAT CU SUCCES",
                        JOptionPane.INFORMATION_MESSAGE);
				}
				DesignOptiuniBibliotecar d = new DesignOptiuniBibliotecar();
				setVisible(false);
				d.setVisible(true);
			}
		};
		
		imprumuta.addActionListener(actRez);
		this.setTitle("Imprumuta Carte");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panelAlegeImprumut);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
