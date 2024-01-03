package ProiectP3Biblioteca;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DesignRealizeazaRetur extends JFrame {
	
	JLabel cnpCititor;
	JLabel label;
	
	JTextField cnpC;
	
	JButton cautaCititor;
	
	public DesignRealizeazaRetur() {
		
		JPanel panelCautaCititor = new JPanel();
		panelCautaCititor.setLayout(new BoxLayout(panelCautaCititor, BoxLayout.Y_AXIS));
		this.setSize(650, 500);
		this.setTitle("Cauta cititorul pentru care doresti sa faci retur");
		
		label = new JLabel("Cauta cititorul pentru care doresti sa faci retur");
		cnpCititor = new JLabel("CNP-ul cititorului");
		cnpC=new JTextField(20);
		cautaCititor=new JButton("CAUTA IMPRUMUTURILE");
		
		panelCautaCititor.add(label);
		panelCautaCititor.add(cnpCititor);
		panelCautaCititor.add(cnpC);
		panelCautaCititor.add(cautaCititor);
		
		ActionListener actC= new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cnp=cnpC.getText();
				
				boolean cnpLungimeCorecta=FunctiiBibliotecar.verLungimeCnp(cnp);
				boolean cnpValid=FunctiiBibliotecar.cnpValidPtInregistrare(cnp);//functia returneaza true daca nu exista cnp-ul
				if(cnpLungimeCorecta==false)
				{
					JOptionPane.showMessageDialog(DesignRealizeazaRetur.this,
	                        "CNP-ul nu are lungimea corecta",
	                        "EROARE CAUTARE CITITOR",
	                        JOptionPane.ERROR_MESSAGE);
						cnpC.setText("");
				}
				else if(cnpValid==true) {
					
					JOptionPane.showMessageDialog(DesignRealizeazaRetur.this,
	                        "Acest CNP nu corespunde nici unui cititor",
	                        "EROARE CAUTARE CITITOR",
	                        JOptionPane.ERROR_MESSAGE);
						cnpC.setText("");
				}
				else 
				{
					DesignAlegeCarteRetur d = new DesignAlegeCarteRetur(cnpC.getText());
					setVisible(false);
					d.setVisible(true);
				}
				
			}
		};
		
		
		cautaCititor.addActionListener(actC);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(panelCautaCititor);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
