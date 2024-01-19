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
		
		Color maroonColor = new Color(128, 0, 0);
		Color whiteColor = new Color(248, 250, 229);
			
			getContentPane().setBackground(whiteColor); 
			panelAlegeImprumut.setBackground(whiteColor);

	        Color maroonColor1 = new Color(128, 0, 0);
	        
	        Color darkGreenColor = new Color(0, 100, 0);

	        Font titleFont = new Font("Arial", Font.BOLD, 20);
	        Font labelFont = new Font("Arial", Font.PLAIN, 14);

		
		DefaultListModel<Carte> listModel;
		
		label = new JLabel("ID CARTE TITLU AUTOR");
		label.setFont(titleFont);
		label.setForeground(maroonColor);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    alegeId = new JLabel("Alege id-ul cartii pe care doresti sa o imprumuti");
	    //alegeId.setPreferredSize(new Dimension(120, 20));
	    alegeId.setFont(labelFont);
	    alegeId.setForeground(darkGreenColor);
	    alegeId.setAlignmentX(Component.CENTER_ALIGNMENT);

		id=new JTextField(20);
	    imprumuta=new JButton("Imprumut");
	    
	    cnpCititor=new JLabel("CNP-ul cititorului care imprumuta cartea");
	   
	    cnpCititor.setFont(labelFont);
	    cnpCititor.setForeground(darkGreenColor);
	    cnpCititor.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
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
		imprumuta.setAlignmentX(Component.CENTER_ALIGNMENT);
		imprumuta.setBackground(darkGreenColor);
		imprumuta.setForeground(whiteColor);
		
		setLayout(new GridBagLayout()); 
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        add(panelAlegeImprumut, gbc);
        
		
		this.add(panelAlegeImprumut);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
